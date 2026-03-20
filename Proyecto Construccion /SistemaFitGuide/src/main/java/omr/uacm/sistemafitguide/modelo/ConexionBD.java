package omr.uacm.sistemafitguide.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Si el archivo no existe en la raíz del proyecto, SQLite lo creará automáticamente.
    private static final String URL_BD = "jdbc:sqlite:fitguide.db";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL_BD);
            System.out.println("Conexión a SQLite establecida correctamente.");
        } catch (SQLException e) {
            System.err.println("Error crítico: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }
}