package omr.uacm.sistemafitguide.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import omr.uacm.sistemafitguide.App;

public class PantallaListaEjerciciosController implements Initializable {

    @FXML private ComboBox<String> comboNivel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboNivel.getItems().addAll("Básico", "Intermedio", "Avanzado");
        comboNivel.setValue("Básico"); // Valor por defecto
    }

    @FXML
    public void iniciarBrazo(ActionEvent event) { ejecutarRutina("Brazo"); }

    @FXML
    public void iniciarAbdomen(ActionEvent event) { ejecutarRutina("Abdomen"); }

    @FXML
    public void iniciarPierna(ActionEvent event) { ejecutarRutina("Pierna"); }

    private void ejecutarRutina(String musculo) {
        String nivel = comboNivel.getValue();

        if (nivel == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Por favor selecciona un nivel en la parte superior.");
            alerta.showAndWait();
            return;
        }

        System.out.println("Preparando datos para inyectar: " + musculo + " - " + nivel);
        // Obtenemos el controlador de la siguiente pantalla usando el Caballo de Troya
        PantallaEjecucionController controladorFinal = App.setRootYObtenerControlador("PantallaEjecucion");

        // Le inyectamos los datos ANTES de que el usuario la vea
        if (controladorFinal != null) {
            controladorFinal.recibirDatos(musculo, nivel);
        }
    }
}