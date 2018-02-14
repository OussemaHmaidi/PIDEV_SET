/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui.controllers;

import esprit.pidev.models.Babysitter;
import esprit.pidev.service.imp.BabysitterService;
import java.awt.Image;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ousse
 */

public class AfficherBabysitterFXMLController implements Initializable {

    
    
    @FXML
    private TableView<Babysitter> tableview;
    @FXML
    private TableColumn<Babysitter,String> nom;
    @FXML
    private TableColumn<Babysitter,String> prenom;
    @FXML
    private TableColumn<Babysitter,Date> dn;
    @FXML
    private TableColumn<Babysitter,String> cin;
    @FXML
    private TableColumn<Babysitter,String> tel;
    @FXML
    private TableColumn<Babysitter,Double> salaire;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button reset;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            load();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherBabysitterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    private void load() throws SQLException {
        BabysitterService bs =new BabysitterService();
              ObservableList ok=FXCollections.observableArrayList(bs.getAll());
              System.out.println(ok);
                tableview.setItems(null);
        tableview.setItems(ok);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        dn.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
    }
    
}
