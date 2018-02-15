/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author danml
 */
public class MainController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane menuCompany;
    @FXML
    private AnchorPane menuSynch;
    @FXML
    private VBox groupCompany;
    public static AnchorPane staticPane;
    public static StackPane mainRootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    private void setStage(String fxml) {
        try {
            //dim overlay on new stage opening

            Stage newStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource(fxml));
            
            Scene scene = new Scene(parent);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajouter(MouseEvent event) {
                setStage("AjouterBabysitterFXML.fxml");
    }

    @FXML
    private void afficher(MouseEvent event) {
                setStage("AfficherBabysitterFXML.fxml");        
    }


}
