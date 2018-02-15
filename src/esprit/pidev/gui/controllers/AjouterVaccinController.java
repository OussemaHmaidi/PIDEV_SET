/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import esprit.pidev.models.Vaccin;
import esprit.pidev.service.imp.VaccinService;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author LACRIM
 */
public class AjouterVaccinController implements Initializable {

    @FXML
    private TextField description;
    @FXML
    private TextField nom;
    @FXML
    private DatePicker date;
    @FXML
    private Button btn;
    @FXML
    private TableView<Vaccin> table;
    @FXML
    private TableColumn<Vaccin,String> nomt;
    @FXML
    private TableColumn<Vaccin,Date> datet;
    @FXML
    private TableColumn<Vaccin,String> desct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
        }    

    @FXML
    private void ajouterVaccin(ActionEvent event) {
        
        Window owner = btn.getScene().getWindow();
        if(nom.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter  name"); return;
        }else
        if(description.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Description"); return;
        }else
        if(date.getValue()==null) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please select date"); return;
        }else{
            VaccinService ps = new VaccinService();
        String nom = this.nom.getText();
        String desc = this.description.getText();
       
        Date date=java.sql.Date.valueOf(this.date.getValue());
         
        Vaccin v = new Vaccin(nom, desc, date);
        
      
        
        if(ps.save(v)!= null)
        {      
              AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Form Confirmation!",
                    "A new Vaccin was inserted successfully!");
        afficher();
        }
       
        } 
           
        
        
        
    }
    
    
    private void afficher()
    {  VaccinService vs = new VaccinService();
      ObservableList ok=FXCollections.observableArrayList(vs.getAll());
              //System.out.println(ok);
                table.setItems(null);
        table.setItems(ok);
        nomt.setCellValueFactory(new PropertyValueFactory<>("nom"));
        desct.setCellValueFactory(new PropertyValueFactory<>("description"));
        datet.setCellValueFactory(new PropertyValueFactory<>("date"));
    
    }
    
}
