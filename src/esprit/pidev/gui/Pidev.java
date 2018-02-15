
package esprit.pidev.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ousse
 */
public class Pidev extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Produit.fxml"));
        Scene scene= new Scene(root);
        primaryStage.setTitle("produit");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}