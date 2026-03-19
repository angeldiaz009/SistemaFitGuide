/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package omr.uacm.sistemafitguide;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MiguelDiaz
 */
public class PantallaInicioController implements Initializable {

    @FXML
    private Button btnEmpezar;
    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnIniciarSeccion;
    @FXML
    private Button btnRegistrarme;
    @FXML
    private PasswordField txtfielContraseña;

    /**
     * Initializes the controller class.
     */
    
  @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void accionIniciarSeccion() throws IOException{
        App.setRoot("PantallaCargando");
    } 

    @FXML
    private void accionEmpezar() throws IOException {
        App.setRoot("PantallaListaEjercicios"); 
    }

    @FXML
    private void accionRegistrarme() throws IOException {
        App.setRoot("PantallaRegistroRapido");
    }
}
