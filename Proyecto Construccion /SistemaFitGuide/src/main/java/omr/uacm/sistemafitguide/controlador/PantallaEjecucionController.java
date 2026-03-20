package omr.uacm.sistemafitguide.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import omr.uacm.sistemafitguide.App;
import omr.uacm.sistemafitguide.modelo.Ejercicio;
import omr.uacm.sistemafitguide.modelo.EjercicioDAO;

public class PantallaEjecucionController implements Initializable {

    @FXML private Label lblTitulo;
    @FXML private Label lblNombreEjercicio;
    @FXML private Label lblDescripcion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // La pantalla inicia vacía. Espera a que le inyecten los datos.
    }

    // EL MÉTODO MÁS IMPORTANTE DEL SISTEMA
    public void recibirDatos(String musculo, String nivel) {
        lblTitulo.setText("Rutina de " + musculo + " (" + nivel + ")");

        // ¡Aquí despertamos a la Base de Datos!
        EjercicioDAO dao = new EjercicioDAO();
        List<Ejercicio> rutinas = dao.obtenerRutina(musculo, nivel);

        if (!rutinas.isEmpty()) {
            Ejercicio ej = rutinas.get(0); // Mostramos el primer ejercicio que encuentre
            lblNombreEjercicio.setText(ej.getNombre());
            lblDescripcion.setText(ej.getDescripcion());
        } else {
            lblNombreEjercicio.setText("Sin ejercicios");
            lblDescripcion.setText("Aún no hay ejercicios guardados para " + musculo + " en nivel " + nivel + ".");
        }
    }

    @FXML
    private void regresarInicio() {
        try {
            App.setRoot("PantallaBienvenidoUsuario");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}