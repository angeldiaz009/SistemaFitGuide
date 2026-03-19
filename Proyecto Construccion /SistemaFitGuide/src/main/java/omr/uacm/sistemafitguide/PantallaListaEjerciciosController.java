/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package omr.uacm.sistemafitguide;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class PantallaListaEjerciciosController implements Initializable {

    
    @FXML private ComboBox<String> comboNiveles;
    @FXML private Button btnEmpezar;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       comboNiveles.getItems().addAll("Básico", "Intermedio", "Avanzado");
    }

    
    @FXML
    private void accionMostrarNiveles() {
        comboNiveles.setVisible(true);
        btnEmpezar.setVisible(true);
    }

    
    @FXML
    private void accionIrAEjercicio() throws IOException {
        App.setRoot("PantallaEjecucion"); 
    }
}