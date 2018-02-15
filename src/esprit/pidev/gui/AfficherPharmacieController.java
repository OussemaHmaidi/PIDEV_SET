/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import esprit.pidev.models.Adresse;
import esprit.pidev.models.Pharmacie;
import esprit.pidev.service.imp.PharmacieService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LACRIM
 */
public class AfficherPharmacieController implements Initializable {

    @FXML
    private TableView<Pharmacie> table;
    @FXML
    private TableColumn<Pharmacie,String> nom;
    @FXML
    private TableColumn<Pharmacie,String> type;
//    @FXML
//    private TableColumn<Adresse> adr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PharmacieService bs =new PharmacieService();
              ObservableList ok=FXCollections.observableArrayList(bs.getAll());
              //System.out.println(ok);
                table.setItems(null);
        table.setItems(ok);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        //adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
    }    
    
}
