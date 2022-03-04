package amb.comp.dao;

import amb.comp.modelo.Cliente;
import java.sql.Connection;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertarCliente(Cliente client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarCliente(int identificador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
