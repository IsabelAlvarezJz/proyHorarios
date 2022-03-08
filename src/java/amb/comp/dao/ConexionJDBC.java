package amb.comp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionJDBC {

    public static Connection conn;
    private static final String USER = "jhostin";
    private static final String CLAVE = "jhostin123";
    private static final String URL = "jdbc:mysql://localhost:3306/bdd_ambientes?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String CLASS_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnetion() {
        try {
            //VOID --> SIN RETORNO
            //TIENE UN TIPO DE DATO A DEVOLVER y RETURN --A CON RETORNO
            Class.forName(CLASS_DRIVER).newInstance();
            conn = DriverManager.getConnection(URL, USER, CLAVE);
        } catch (Exception ex) {
            System.out.println("Error al abrir la conexión ");
            ex.printStackTrace();
        }
        return conn;
    }
}
