/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import esprit.pidev.models.Adresse;
import esprit.pidev.models.Pharmacie;
import esprit.pidev.models.Ville;
import esprit.pidev.service.imp.AdresseService;
import esprit.pidev.service.imp.PharmacieService;
import esprit.pidev.service.imp.VilleService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author LACRIM
 */
public class PharmacieFXMLController implements Initializable {

    @FXML
    private JFXButton btn;
    @FXML
    private JFXComboBox<String> cmb;
    @FXML
    private JFXTextField txt1;
    @FXML
    private JFXTextField txt2;
 private ObservableList <String> ob ;
 
        AdresseService ad = new AdresseService();
        VilleService vs = new VilleService();
        List<Adresse> la = ad.getAll();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        remplir();
    }    

    @FXML
    private void ajouterP(ActionEvent event) {
       
        
         Window owner = btn.getScene().getWindow();
        if(txt1.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter  name"); return;
        }else
        if(txt2.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter type"); return;
        }else
        if(cmb.getValue()==null) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please select adresse"); return;
        }else{
       
        PharmacieService ps = new PharmacieService();
        AdresseService as = new AdresseService();
        String nom = txt1.getText();
        String type = txt2.getText();
        Adresse a = new Adresse();

      String id = cmb.getValue();
        for (int i = 0; i < la.size(); i++) {
            if( id.startsWith(la.get(i).getRue()))
            {
                a = la.get(i);
            }
        }
        Pharmacie ph=new Pharmacie();
        ph.setAdresse(a);
        ph.setNom(nom);
        ph.setType(type);
        if(ps.save(ph)!= null)
        {      
              AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                    "A new Pharmacie was inserted successfully!"); return;
        }
        } 
        
        
        
    }

    private void remplir() {
              List<String> l=new ArrayList();
         List<Integer> l2=new ArrayList();
        for (int i = 0; i < la.size(); i++) {    
             Ville v = vs.getOne(la.get(i).getVille().getId());
            l.add(la.get(i).getRue()+" ,"+v.getNom());
           
        }
            ob= FXCollections.observableArrayList(l);
             cmb.setItems(ob);
             
       
        
        
    
}
}