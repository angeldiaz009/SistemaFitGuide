package omr.uacm.sistemafitguide.modelo;

import java.sql.*;

public class UsuarioDAO {

    public UsuarioDAO() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "contrasena TEXT NOT NULL," +
                "fecha_nacimiento TEXT NOT NULL)";
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla de usuarios.");
            e.printStackTrace();
        }
    }

    // Método que recibe los datos desde la interfaz gráfica y los inyecta en SQLite
    public boolean registrarUsuario(String nombre, String contrasena, String fechaNacimiento) {
        String sql = "INSERT INTO usuarios(nombre, contrasena, fecha_nacimiento) VALUES(?,?,?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);
            pstmt.setString(3, fechaNacimiento);

            pstmt.executeUpdate();
            System.out.println("Usuario guardado en la base de datos: " + nombre);
            return true; // Se guardó con éxito

        } catch (SQLException e) {
            System.err.println("Error al guardar el usuario.");
            e.printStackTrace();
            return false; // Falló el guardado
        }
    }
    // Metodo para verificar si las credenciales coinciden en la BD
    public boolean validarLogin(String nombre, String contrasena) {
        String sql = "SELECT id FROM usuarios WHERE nombre = ? AND contrasena = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);

            ResultSet rs = pstmt.executeQuery();

            // Si rs.next() es true, significa que encontró al menos un registro que coincide
            return rs.next();

        } catch (SQLException e) {
            System.err.println("Error al validar login.");
            e.printStackTrace();
            return false;
        }
    }
}