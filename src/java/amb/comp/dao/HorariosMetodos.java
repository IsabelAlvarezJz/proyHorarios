/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.dao;

import amb.comp.modelo.Horarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class HorariosMetodos implements IHorarios {

    private Connection conn;

    public HorariosMetodos() {
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
    public List<Horarios> consultarHorarios() {

        //retrorna una lista
        List<Horarios> horarios = new ArrayList<Horarios>();

        String sqlHorarios = "SELECT * FROM horarios, locales, personal WHERE horarios.id_persona = personal.idpersona \n"
                + "AND horarios.cod_local = locales.codlocal ORDER BY apellido";

        Horarios ho = null;
        Statement stm = null;

        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlHorarios);

            while (rs.next()) {
                int id = rs.getInt("idHorario");
                int entrada = rs.getInt("entrada");
                int salida = rs.getInt("salida");
                String dia = rs.getString("dia");
                String nombre = rs.getString("nombrelocal");
                String telefono = rs.getString("telflocal");
                String cedula = rs.getString("cedula");
                String nombrePersonal = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                //añadimos los atributos al objeto
                ho = new Horarios(id, entrada, salida, dia, nombre, telefono, cedula, nombrePersonal, apellido);
                horarios.add(ho);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(HorariosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConecction();
        }

        return horarios;
    }

    @Override
    public Horarios consultarHorariosId(int idHora) {

        String sqlHorarios = "SELECT * FROM horarios, locales, personal WHERE horarios.id_persona = personal.idpersona \n"
                + "AND horarios.cod_local = locales.codlocal AND idHorario = ? ORDER BY apellido ";

        Horarios ho = null;
        //cuando tenemos parametros ocupamos el prepared statemen
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement(sqlHorarios);
            stm.setInt(1, idHora);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                int entrada = rs.getInt("entrada");
                int salida = rs.getInt("salida");
                String dia = rs.getString("dia");
                String codigoLocal = rs.getString("codlocal");
                String nombreLocal = rs.getString("nombrelocal");
                int idPersona = rs.getInt("idpersona");
                String nombrePersonal = rs.getString("nombre");
                String apellido = rs.getString("apellido");

                //añadimos los atributos al objeto
                //int entrada, int salida, String dia, int idPersona, String codigoLocal, String nombreLocal, String nombre, String apellido
                ho = new Horarios(entrada, salida, dia, idPersona, codigoLocal, nombreLocal, nombrePersonal, apellido);

            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(HorariosMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConecction();
        }

        return ho;
    }

    @Override
    public boolean insertarHorario(Horarios horarios) {
        boolean bandera = true;

        String sqlCliente = " INSERT INTO horarios( entrada, salida, dia, id_persona, cod_local) VALUES ( ?, ?, ?, ?, ? )";

        PreparedStatement psHorarios = null;

        try {
            psHorarios = conn.prepareStatement(sqlCliente);

            psHorarios.setInt(1, horarios.getEntrada());
            psHorarios.setInt(2, horarios.getSalida());
            psHorarios.setString(3, horarios.getDia());
            psHorarios.setInt(4, horarios.getIdPersona());
            psHorarios.setString(5, horarios.getCodigoLocal());

            psHorarios.executeUpdate();
            psHorarios.close();

        } catch (SQLException ex) {
            Logger.getLogger(HorariosMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        } finally {
            closeConecction();
        }

        return bandera;
    }

    @Override
    public boolean actualizarHorario(Horarios horarios) {

        boolean bandera = true;

        String sqlCliente = " UPDATE horarios SET entrada = ?, salida = ?, dia = ?, id_persona = ?, cod_local = ? WHERE horarios.idHorario = ? ";

        PreparedStatement psHorarios = null;

        try {
            psHorarios = conn.prepareStatement(sqlCliente);

            psHorarios.setInt(1, horarios.getEntrada());
            psHorarios.setInt(2, horarios.getSalida());
            psHorarios.setString(3, horarios.getDia());
            psHorarios.setInt(4, horarios.getIdPersona());
            psHorarios.setString(5, horarios.getCodigoLocal());
            psHorarios.setInt(6, horarios.getIdHora());

            psHorarios.executeUpdate();
            psHorarios.close();

        } catch (SQLException ex) {
            Logger.getLogger(HorariosMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        } finally {
            closeConecction();
        }
        
        return bandera;
    }

    @Override
    public boolean eliminarHorarios(int idHora) {
        boolean bandera = true;

        String sqlCliente = " DELETE FROM horarios WHERE idHorario = ?";
        PreparedStatement psCliente = null;
        try {
            psCliente = conn.prepareStatement(sqlCliente);
            psCliente.setInt(1, idHora);

            psCliente.executeUpdate();
            psCliente.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        } finally {
            closeConecction();
        }

        return bandera;
    }
}


