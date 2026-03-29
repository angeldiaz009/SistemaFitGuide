/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package omr.uacm.sistemafitguide.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import omr.uacm.sistemafitguide.App;

/**
 * FXML Controller class
 *
 * @author MiguelDiaz
 */
public class PantallaBienvenidoUsuarioController implements Initializable {

    @FXML
    private Button btnEmpezar;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionEmpezarRutina() throws IOException {
        App.setRoot("PantallaListaEjercicios");
    }

    @FXML
    private void accionSalir() {
        System.exit(0);
    }
    
}
