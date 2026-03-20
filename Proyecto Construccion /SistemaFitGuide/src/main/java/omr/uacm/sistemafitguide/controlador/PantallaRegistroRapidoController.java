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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import omr.uacm.sistemafitguide.App;

/**
 * FXML Controller class
 *
 * @author MiguelDiaz
 */
public class PantallaRegistroRapidoController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContrasenna;
    @FXML
    private DatePicker dpFechaNaCimiento;
    @FXML
    private Button btnAceptarRegistro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accionAceptarRegistro() throws IOException {
        App.setRoot("PantallaCargandoRe");
    }
    
}
