/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import com.gluonhq.charm.glisten.control.TextField;
import esprit.pidev.models.Parent;
import esprit.pidev.service.imp.ParentService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;

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
    private void login(ActionEvent event) {
        
        Parent p;
        ParentService ps = new ParentService();
        
        p = ps.getLoginAccount(compte.getText(), motdepasse.getText());
        
        if (p != null) { System.out.println( p.getLogin()+ p.getMp());}
        else {System.out.println(p);}
    }
    
}
