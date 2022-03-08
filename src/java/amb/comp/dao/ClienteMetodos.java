package amb.comp.dao;

import amb.comp.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteMetodos implements ICliente {

    private Connection conn;

    public ClienteMetodos() {
            if (conn == null) {
            conn = ConexionJDBC.getConnetion();
        }
    }

    private void closeConecction() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerra la conexión ... !!!");
        }
    }

    @Override
    public List<Cliente> buscarClientes() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        String sqlPersonal = "SELECT * FROM personal";
        Statement stPersonal = null;
        Cliente objCliente = null;

        try {
            stPersonal = conn.createStatement();
            ResultSet rsPersonal = stPersonal.executeQuery(sqlPersonal);

            while (rsPersonal.next()) {
                int idP = rsPersonal.getInt("idpersona"); //NOMBRE CAMPO DE LA TABLA
                String cedulaP = rsPersonal.getString("cedula");
                String direccionP = rsPersonal.getString("direccion");
                String nombreP = rsPersonal.getString("nombre");
                String apellidoP = rsPersonal.getString("apellido");
                String telefonoP = rsPersonal.getString("telefono");
                String correoP = rsPersonal.getString("correo");
                double salarioP = rsPersonal.getDouble("salario");
                Date fechaNaciemiento = rsPersonal.getDate("fechaNac");
                
                objCliente = new Cliente(idP, cedulaP, nombreP, apellidoP, direccionP, telefonoP, correoP, salarioP, fechaNaciemiento);
                listaClientes.add(objCliente);
            }
            stPersonal.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConecction();
        }
        return listaClientes;
    }

    @Override
    public Cliente buscarPorId(int idCliente) {        
        String sqlCliente = " SELECT * FROM personal WHERE idpersona = ?";
        Cliente cliente = null;
        PreparedStatement psCliente = null;
        
        try {
            psCliente = conn.prepareStatement(sqlCliente);
            psCliente.setInt(1, idCliente);
            ResultSet rsCliente = psCliente.executeQuery();
            //diferencia entre executeQuery y executeUpdate
            while (rsCliente.next()) {
                String ced = rsCliente.getString("cedula");
                String nom = rsCliente.getString("nombre");
                String ape = rsCliente.getString("apellido");
                String dir = rsCliente.getString("direccion");
                String fono = rsCliente.getString("telefono");
                String email = rsCliente.getString("correo");
                double sueldo = rsCliente.getDouble("salario");
                Date fecha = rsCliente.getDate("fechaNac");
                
                cliente = new Cliente(idCliente, ced, nom, ape, dir, fono, email, sueldo, fecha);
                
            }
            rsCliente.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            closeConecction();
        }
        return cliente;
    }

    @Override
    public boolean insertarCliente(Cliente client) {
        boolean bandera = true;
        
        String sqlCliente = " INSERT INTO personal (cedula, nombre, apellido, direccion, telefono, correo, fechaNac, salario) VALUES( ?, ?, ?, ?, ?, ?, ?, ? )";
        
        PreparedStatement psCliente = null;
        
        try {
            psCliente = conn.prepareStatement(sqlCliente);
            
            //asigno valores
            psCliente.setString(1, client.getCedula());
            psCliente.setString(2, client.getNombre());
            psCliente.setString(3, client.getApellido());
            psCliente.setString(4, client.getDireccion());
            psCliente.setString(5, client.getTelefono());
            psCliente.setString(6, client.getCorreo());
            psCliente.setDate(7, new java.sql.Date(client.getFecha().getTime()));
            psCliente.setDouble(8, client.getSalario());
            
            psCliente.executeUpdate();
            psCliente.close();

            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        }finally{
            closeConecction();
        }
        
        return bandera;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        boolean bandera = true;
        //Los PK no se actualizan
        String sqlCliente = " UPDATE personal SET cedula = ?, nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ?, fechaNac = ?, salario = ? WHERE idpersona = ? ";
        
        PreparedStatement psCliente = null;
        try {          
            psCliente = conn.prepareStatement(sqlCliente);
            psCliente.setString(1, cliente.getCedula());
            psCliente.setString(2, cliente.getNombre());
            psCliente.setString(3, cliente.getApellido());
            psCliente.setString(4, cliente.getDireccion());
            psCliente.setString(5, cliente.getTelefono());
            psCliente.setString(6, cliente.getCorreo());
            psCliente.setDate(7, new java.sql.Date(cliente.getFecha().getTime()));
            psCliente.setDouble(8, cliente.getSalario());
            psCliente.setInt(9, cliente.getId());
            
            psCliente.executeUpdate();
            psCliente.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
         }finally{
            closeConecction();
        }  
        
        return bandera;
    }

    @Override
    public boolean eliminarCliente(int identificador) {
        boolean bandera = true;
        
        String sqlCliente = " DELETE FROM personal WHERE idpersona = ?";
        PreparedStatement psCliente = null;
        try {
            psCliente = conn.prepareStatement(sqlCliente);
            psCliente.setInt(1, identificador);
            
            psCliente.executeUpdate();
            psCliente.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        }finally{
            closeConecction();
        }
        
        return bandera;
    }

}
