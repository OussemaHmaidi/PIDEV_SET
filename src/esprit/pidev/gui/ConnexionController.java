/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import com.gluonhq.charm.glisten.control.TextField;
import esprit.pidev.models.Parent;
import esprit.pidev.service.imp.ParentService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField compte;
    @FXML
    private Button connexion;
    @FXML
    private Button nouveauparents;
    @FXML
    private PasswordField motdepasse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {    
        Parent p=null;
        ParentService ps = new ParentService();
        
        p = ps.getLoginAccount(compte.getText(), motdepasse.getText());
        
        if (p != null) {
        
            ((Node) (event.getSource())).getScene().getWindow().hide();
            
            Stage stage = new Stage();            
            stage.setTitle("All4Kids");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("IndexParent.fxml"))));
            stage.show();
            

        }
        else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("non connecté");
		alert.setHeaderText(null);
		alert.setContentText("compte inexistant");
		alert.showAndWait();

        }
    
    }

    @FXML
    private void signin(ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
            
            Stage stage = new Stage();            
            stage.setTitle("All4Kids");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("InscriptionParent.fxml"))));
            stage.show();
    }
    
}
