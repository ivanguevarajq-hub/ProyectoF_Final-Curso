package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;
    private Connection conexion;

    private static final String URL = "jdbc:mysql://localhost:3306/bd_clinica";
    private static final String USER = "root";
    private static final String PASSWORD = "guevarita0611205";

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el Driver: " + e.getMessage());
        }
    }

    public static synchronized Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection realizarConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conexion;
    }
}