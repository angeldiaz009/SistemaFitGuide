package omr.uacm.sistemafitguide.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EjercicioDAO {

    // Cuando se crea el DAO, automáticamente verifica y siembra la base de datos
    public EjercicioDAO() {
        inicializarBaseDeDatos();
    }

    private void inicializarBaseDeDatos() {
        String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS ejercicios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "musculo TEXT NOT NULL," +
                "nivel TEXT NOT NULL)";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement()) {

            // 1. Crea la tabla si no existe
            stmt.execute(sqlCrearTabla);

            // 2. Verifica si la tabla está vacía
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM ejercicios");
            if (rs.next() && rs.getInt(1) == 0) {
                System.out.println("Base de datos vacía. Inyectando ejercicios de prueba...");

                String sqlInsert = "INSERT INTO ejercicios (nombre, descripcion, musculo, nivel) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                    // Semilla 1: Brazo Avanzado
                    pstmt.setString(1, "Lagartijas Diamante");
                    pstmt.setString(2, "4 series de 12 repeticiones. Codos pegados al torso.");
                    pstmt.setString(3, "Brazo");
                    pstmt.setString(4, "Avanzado");
                    pstmt.executeUpdate();

                    // Semilla 2: Pierna Básico
                    pstmt.setString(1, "Sentadillas Libres");
                    pstmt.setString(2, "4 series de 15 repeticiones. Rompe el paralelo a 90 grados.");
                    pstmt.setString(3, "Pierna");
                    pstmt.setString(4, "Básico");
                    pstmt.executeUpdate();

                    // Semilla 3: Abdomen Intermedio
                    pstmt.setString(1, "Plancha Estática");
                    pstmt.setString(2, "4 series de 1 minuto. Mantén la cadera alineada.");
                    pstmt.setString(3, "Abdomen");
                    pstmt.setString(4, "Intermedio");
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al inicializar la base de datos.");
            e.printStackTrace();
        }
    }

    // Este es el metodo que usará tu Controlador Final para buscar la rutina
    public List<Ejercicio> obtenerRutina(String musculo, String nivel) {
        List<Ejercicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM ejercicios WHERE musculo = ? AND nivel = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Reemplazamos los signos de interrogación por los datos que eligió el usuario
            pstmt.setString(1, musculo);
            pstmt.setString(2, nivel);

            ResultSet rs = pstmt.executeQuery();

            // Convertimos las filas de SQLite a objetos de Java
            while (rs.next()) {
                Ejercicio ej = new Ejercicio(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("musculo"),
                        rs.getString("nivel")
                );
                lista.add(ej);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la rutina.");
            e.printStackTrace();
        }
        return lista;
    }
}