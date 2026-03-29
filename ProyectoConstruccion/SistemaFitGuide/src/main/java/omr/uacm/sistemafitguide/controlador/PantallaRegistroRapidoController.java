package omr.uacm.sistemafitguide.controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import omr.uacm.sistemafitguide.App;
import omr.uacm.sistemafitguide.modelo.UsuarioDAO;

public class PantallaRegistroRapidoController implements Initializable {

    @FXML private TextField txtNombre;
    @FXML private TextField txtContrasena; // ¡Corregido sin Ñ!
    @FXML private DatePicker dpFechaNaCimiento;
    @FXML private Button btnAceptarRegistro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización vacía por ahora
    }

    @FXML
    private void accionAceptarRegistro() throws IOException {
        // 1. Extraemos lo que el usuario escribió
        String nombre = txtNombre.getText();
        String contrasena = txtContrasena.getText();
        LocalDate fecha = dpFechaNaCimiento.getValue();

        // 2. Regla de negocio: No aceptar campos vacíos
        if (nombre == null || nombre.trim().isEmpty() ||
                contrasena == null || contrasena.trim().isEmpty() ||
                fecha == null) {

            Alert alerta = new Alert(Alert.AlertType.WARNING, "Por favor, llena todos los campos antes de continuar.");
            alerta.showAndWait();
            return; // Cortamos la ejecución aquí, no avanza.
        }

        // 3. Llamamos al Modelo para guardar en la Base de Datos
        UsuarioDAO dao = new UsuarioDAO();
        boolean guardadoExitoso = dao.registrarUsuario(nombre, contrasena, fecha.toString());

        // 4. Si se guardó en SQLite, lo dejamos pasar a la siguiente pantalla
        if (guardadoExitoso) {
            App.setRoot("PantallaCargando");
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Hubo un error al guardar en la base de datos.");
            alerta.showAndWait();
        }
    }
}