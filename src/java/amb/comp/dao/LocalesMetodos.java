/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amb.comp.dao;

import amb.comp.modelo.Locales;
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
public class LocalesMetodos implements ILocales {

    private Connection conn;

    public LocalesMetodos() {
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
    public List<Locales> buscarLocales() {
        List<Locales> listaLocales = new ArrayList<Locales>();
        String sqlLocal = "SELECT * FROM locales";
        Statement stLocal = null;
        Locales objLocal = null;

        try {
            stLocal = conn.createStatement();
            ResultSet rsLocal = stLocal.executeQuery(sqlLocal);

            while (rsLocal.next()) {
                String codL = rsLocal.getString("codlocal"); //NOMBRE CAMPO DE LA TABLA
                String nombreL = rsLocal.getString("nombrelocal");
                String direccionL = rsLocal.getString("direccionlocal");
                String fonoL = rsLocal.getString("telflocal");

                objLocal = new Locales(codL, nombreL, direccionL, fonoL);
                listaLocales.add(objLocal);
            }
            stLocal.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConecction();
        }
        return listaLocales;
    }

    @Override
    public Locales buscarPorId(String codLocal) {
        String sqlLocal = " SELECT * FROM locales WHERE codlocal = ?";
        Locales locales = null;
        PreparedStatement psLocal = null;

        try {
            psLocal = conn.prepareStatement(sqlLocal);
            psLocal.setString(1, codLocal);
            ResultSet rsLocal = psLocal.executeQuery();
            //diferencia entre executeQuery y executeUpdate
            while (rsLocal.next()) {
                String nomL = rsLocal.getString("nombrelocal");
                String dirL = rsLocal.getString("direccionlocal");
                String telfL = rsLocal.getString("telflocal");

                locales = new Locales(codLocal, nomL, dirL, telfL);

            }
            rsLocal.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConecction();
        }
        return locales;
    }

    @Override
    public boolean insertarLocales(Locales local) {
        boolean bandera = true;

        String sqlLista = " INSERT INTO locales VALUES( ?, ?, ?, ? )";

        PreparedStatement psLista = null;

        try {
            psLista = conn.prepareStatement(sqlLista);

            //asigno valores
            psLista.setString(1, local.getCodlocal());
            psLista.setString(2, local.getNombreLocal());
            psLista.setString(3, local.getDireccionLocal());
            psLista.setString(4, local.getTelflocal());

            psLista.executeUpdate();
            psLista.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        } finally {
            closeConecction();
        }

        return bandera;
    }

    @Override
    public boolean actualizarLocales(Locales local) {
        boolean bandera = true;

        String sqlLista = " UPDATE locales SET nombrelocal = ?, direccionlocal = ?, telflocal = ? WHERE codlocal = ?";

        PreparedStatement psLista = null;

        try {
            psLista = conn.prepareStatement(sqlLista);

            //asigno valores
            psLista.setString(1, local.getNombreLocal());
            psLista.setString(2, local.getDireccionLocal());
            psLista.setString(3, local.getTelflocal());
            psLista.setString(4, local.getCodlocal());

            psLista.executeUpdate();
            psLista.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        } finally {
            closeConecction();
        }

        return bandera;
    }

    @Override
    public boolean eliminarLocales(String codlocal) {
        boolean bandera = true;

        String sqlLocal = " DELETE FROM locales WHERE codlocal = ?";
        PreparedStatement psLocal = null;
        try {
            psLocal = conn.prepareStatement(sqlLocal);
            psLocal.setString(1, codlocal);

            psLocal.executeUpdate();
            psLocal.close();

        } catch (SQLException ex) {
            Logger.getLogger(LocalesMetodos.class.getName()).log(Level.SEVERE, null, ex);
            bandera = false;
        } finally {
            closeConecction();
        }

        return bandera;
    }

}
