package omr.uacm.sistemafitguide.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import omr.uacm.sistemafitguide.App;
import omr.uacm.sistemafitguide.modelo.UsuarioDAO;

public class PantallaInicioController implements Initializable {

    @FXML private TextField txtNombre;
    @FXML private PasswordField txtContrasena; // ¡Libre de la letra Ñ!

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización vacía
    }

    @FXML
    private void accionIniciarSeccion() throws IOException {
        String nombre = txtNombre.getText();
        String contrasena = txtContrasena.getText();

        // 1. Validamos que no intenten entrar con los campos vacíos
        if (nombre == null || nombre.trim().isEmpty() || contrasena == null || contrasena.trim().isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Por favor, ingresa tu usuario y contraseña.");
            alerta.showAndWait();
            return;
        }

        // 2. Vamos a la Base de Datos a preguntar por este usuario
        UsuarioDAO dao = new UsuarioDAO();
        boolean accesoConcedido = dao.validarLogin(nombre, contrasena);

        // 3. Decidimos si lo dejamos pasar o le cerramos la puerta
        if (accesoConcedido) {
            System.out.println("Acceso concedido para: " + nombre);
            App.setRoot("PantallaCargando");
        } else {
            System.out.println("Intento de acceso fallido para: " + nombre);
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos. Si no tienes cuenta, regístrate primero.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void accionRegistrarme() throws IOException {
        App.setRoot("PantallaRegistroRapido");
    }
}