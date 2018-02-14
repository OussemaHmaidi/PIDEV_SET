/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import esprit.pidev.models.Adresse;
import esprit.pidev.models.Parc;
import esprit.pidev.models.Ville;
import esprit.pidev.service.imp.AdresseService;
import esprit.pidev.service.imp.ParcService;
import esprit.pidev.service.imp.VilleService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Abdennadher Mohamed
 */
public class ParcController implements Initializable {
 @FXML
    private Label labek;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtdesc;
    @FXML
    private Button bntajouter;
    @FXML
    private ComboBox<String> comboadresse;
     private ObservableList <String> ob ;
     ObservableList option = FXCollections.observableArrayList();
 AdresseService ad = new AdresseService();
        VilleService vs = new VilleService();
        List<Adresse> la = ad.getAll();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          remplir();
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
        
         Window owner = bntajouter.getScene().getWindow();
        if(txtnom.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter  name"); return;
        }else
        if(txtdesc.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Description"); return;
        }else
        if(comboadresse.getValue()==null) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please select adresse"); return;
        }else{
       
        ParcService ps = new ParcService();
        AdresseService as = new AdresseService();
        String nom = txtnom.getText();
        String desc = txtdesc.getText();
        Adresse a = new Adresse();

      String id = comboadresse.getValue();
        for (int i = 0; i < la.size(); i++) {
            if( id.startsWith(la.get(i).getRue()))
            {
                a = la.get(i);
            }
        }
        Parc ph=new Parc();
        ph.setAdresse(a);
        ph.setNom(nom);
        ph.setDecription(desc);
        if(ps.save(ph)!= null)
        {      
              AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                    "A new Parc was inserted successfully!"); return;
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
             comboadresse.setItems(ob);
             
       
        
        
    
}
    


    
}
