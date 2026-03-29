package omr.uacm.sistemafitguide;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("PantallaInicio"), 900, 600);
        stage.setScene(scene);
        stage.show();
    }    

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static <T> T setRootYObtenerControlador(String nombreVista) {
        try {
            // Usamos la nueva ruta limpia que creaste en el Paso 2
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/views/" + nombreVista + ".fxml"));
            Parent root = loader.load();
            scene.setRoot(root);

            return loader.getController();
        } catch (IOException e) {
            System.err.println("Error crítico al cargar la vista: " + nombreVista);
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        launch();
    }

}