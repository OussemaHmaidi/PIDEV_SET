/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import esprit.pidev.models.Adresse;
import esprit.pidev.models.BonPlan;
import esprit.pidev.models.Evenement;
import esprit.pidev.models.Jeu;
import esprit.pidev.models.Parc;
import esprit.pidev.models.Ville;
import esprit.pidev.service.imp.AdresseService;
import esprit.pidev.service.imp.BonPlanService;
import esprit.pidev.service.imp.EvenementService;
import esprit.pidev.service.imp.JeuxService;
import esprit.pidev.service.imp.ParcService;
import esprit.pidev.service.imp.VilleService;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Abdennadher Mohamed
 */
public class EvenementController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtdesc;
    @FXML
    private TextField txtprix;
    @FXML
    private ComboBox<String> cmbad;
    @FXML
    private ComboBox<String> txtbp;
    @FXML
    private DatePicker txtdate;
    @FXML
    private Button btnajouter;
 private ObservableList <String> ob ;
     ObservableList option = FXCollections.observableArrayList();
 AdresseService ad = new AdresseService();
    BonPlanService bps=new BonPlanService();
        VilleService vs = new VilleService();
        List<Adresse> la = ad.getAll();
        List<BonPlan> lp=bps.getAll();
    /**
     * Initializes the controller class.
     */
                
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        remplir();
        remplir2();
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
        
         Window owner = btnajouter.getScene().getWindow();
        if(txtnom.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter  name"); return;
        }else
        if(txtdesc.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Description"); return;
        }else
        if(txtdate.getValue()==null) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please select date"); return;
        }else{
            EvenementService ps = new EvenementService();
        AdresseService as = new AdresseService();
        BonPlanService bs = new BonPlanService();
        String nom = txtnom.getText();
        String desc = txtdesc.getText();
        String prix = txtprix.getText();
        Date date=java.sql.Date.valueOf(txtdate.getValue());
        
        
        Adresse a = new Adresse();
      String id = cmbad.getValue();
        for (int i = 0; i < la.size(); i++) {
            if( id.startsWith(la.get(i).getRue()))
            {
                a = la.get(i);
            }
        }
        BonPlan b = new BonPlan();
        String id2 = txtbp.getValue();
        
        for (int i = 0; i < lp.size(); i++) {
            if( id.startsWith(lp.get(i).getTitre()))
            {
                b = lp.get(i);
            }
        }
        
        
        
        Evenement ph=new Evenement();
        ph.setAdresse(a);
        ph.setBonPlan(b);
        ph.setNom(nom);
        ph.setDate(date);
        ph.setPrix(Float.parseFloat(prix));
        ph.setDescription(desc);
        
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
             cmbad.setItems(ob);
             
       
        
        
    
}

    private void remplir2() {

 List<String> l=new ArrayList();
         
        for (int i = 0; i < lp.size(); i++) {    

            l.add(lp.get(i).getTitre());
           
        }
            ob= FXCollections.observableArrayList(l);
             txtbp.setItems(ob);
             

    }
    
}
