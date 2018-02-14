/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import esprit.pidev.models.Babysitter;
import esprit.pidev.service.imp.BabysitterService;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ousse
 */
public class AjouterBabysitterFXMLController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField login;
    @FXML
    private TextField mp;
    @FXML
    private TextField tel;
    @FXML
    private TextField salaire;
    @FXML
    private DatePicker dn;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
    private void ajouter(ActionEvent event) throws SQLException {
            Babysitter p=new Babysitter();
            p.setNom(nom.getText());
            p.setPrenom(prenom.getText());
            p.setCin(cin.getText());
            Date date = java.sql.Date.valueOf(dn.getValue());
            p.setDateNaissance(date);
            p.setLogin(login.getText());
            p.setMp(mp.getText());
            p.setSalaire(Float.parseFloat(salaire.getText()));
            p.setTel(tel.getText());
            BabysitterService bs=new BabysitterService();
            bs.save(p);
    }

    
}
