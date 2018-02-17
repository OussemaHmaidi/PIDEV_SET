/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class IndexParentController implements Initializable {

    @FXML
    private AnchorPane topbar;
    @FXML
    private ImageView setting;
    @FXML
    private Pane settingpane;
    @FXML
    private Label settinglabel;
    @FXML
    private Label logoutlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setting(MouseEvent event) {
        
        if(settingpane.isVisible()){ settingpane.setVisible(false);}
        else {settingpane.setVisible(true);}
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
            
            Stage stage = new Stage();            
            stage.setTitle("All4Kids");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Connexion.fxml"))));
            stage.show();
    }
    
}
