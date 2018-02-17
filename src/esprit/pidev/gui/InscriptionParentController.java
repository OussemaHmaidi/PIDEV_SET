/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import com.gluonhq.impl.charm.a.b.b.e;

import esprit.pidev.service.imp.ParentService;
import esprit.pidev.models.Parent;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import esprit.pidev.gui.AlertHelper;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Abdennadher Mohamed
 */
public class InscriptionParentController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField cin;
    @FXML
    private TextField tel;
    @FXML
    private TextField adresse;
    @FXML
    private TextField login;
    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField confirmermdp;
    @FXML
    private DatePicker date;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        
        Window owner = ajouter.getScene().getWindow();
        ParentService ps=new ParentService();
        Parent p= new Parent();
        if(nom.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre name"); return;
        }
        else if(prenom.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  prenom"); return;
        }
        else if(adresse.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  adresse"); return;
        }
        else if(cin.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  cin"); return;
        }
        else if(email.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  email"); return;
        }else if(tel.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  tel"); return;
        }else if(login.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  login"); return;
        }
        else if(mdp.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  mdp"); return;
        }
        else if(confirmermdp.getText().isEmpty() && !confirmermdp.getText().equals(mdp.getText())) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  mdp"); return;
        }
         else if(date.getValue() ==null) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Verifier votre  mdp"); return;}
        else
        {
        p.setNom(nom.getText());
        p.setPrenom(prenom.getText());
        p.setAdresse(adresse.getText());
        p.setCin(cin.getText());
        p.setDateNaissance(java.sql.Date.valueOf(date.getValue()));
        p.setEmail(email.getText());
        p.setTel(tel.getText());
        p.setLogin(login.getText());
        
            p.setMp(mdp.getText());
            if(ps.save(p)!=null)
            {
                 Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Confirmation");
                 alert.setHeaderText("Look, a Confirmation Dialog");
                 alert.setContentText("Validation des champs !");
                 Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                  Stage stage = new Stage();   
       ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Connexion.fxml"))));
       
 
                 
        stage.setTitle("Signup");
        
        
        stage.show();
    
                    
                }
                }
                    
       
        
            }
        }
       
        
        
        
        
    }
    

