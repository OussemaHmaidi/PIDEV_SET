/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import esprit.pidev.models.Jeu;
import esprit.pidev.service.imp.JeuxService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Abdennadher Mohamed
 */
public class JeuController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txturl;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtDescription;
    @FXML
    private Button btnAjouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
         Window owner = btnAjouter.getScene().getWindow();
        if(txtnom.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter  name"); return;
        }else
        if(txturl.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Description"); return;
        }else
        if(txtType.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please select adresse"); return;
        }else{
            
            JeuxService js=new JeuxService();
        Jeu j = new Jeu();
        j.setNom(txtnom.getText());
        j.setUrl(txturl.getText());
        j.setType(txtType.getText());
        j.setDescription(txtDescription.getText());
        if(js.save(j)!=null)
        {
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                    "A new Jeu was inserted successfully!"); return;
        }
        }
        }
        
        
        
    }
    

