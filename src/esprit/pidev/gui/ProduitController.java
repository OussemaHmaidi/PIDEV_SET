/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import esprit.pidev.models.Produit;
import esprit.pidev.service.imp.ProduitService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author user
 */
public class ProduitController implements Initializable {

    @FXML
    private Button valider;
    @FXML
    private TextField description;
    @FXML
    private TextField categorie;
    @FXML
    private TextField nom;
    @FXML
    private TableView<Produit> tableview;
    @FXML
    private TableColumn<Produit, String> affichenom;
    @FXML
    private TableColumn<Produit, String> affichedescription;
    @FXML
    private TableColumn<Produit, String> affichecategorie;
    @FXML
    private Button afficher;
    @FXML
    private TableColumn<?, ?> edit;
    @FXML
    private Button modifier;
    @FXML
    private TextField modifnom;
    @FXML
    private TextField modifdescription;
    @FXML
    private TextField modifcategorie;
    @FXML
    private TextField modifid;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       afficher();
       
       
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Produit p = new Produit(nom.getText(),description.getText(),categorie.getText());
        ProduitService ps=new ProduitService();
        ps.save(p);
    }

    @FXML
    private void afficher() {
        ProduitService ps =new ProduitService();
        ObservableList ok=FXCollections.observableArrayList(ps.getAll());
        System.out.println(ok);
        tableview.setItems(null);
        tableview.setItems(ok);
        affichenom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        edit.setCellValueFactory(new PropertyValueFactory<>("id"));
       
        affichedescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        affichecategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        
        tableview.setEditable(true);
        affichenom.setCellFactory(TextFieldTableCell.forTableColumn());
        affichedescription.setCellFactory(TextFieldTableCell.forTableColumn());
        affichecategorie.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        
        
        
    }

    @FXML
    private void modifier() {
             
        Produit p = new Produit();
        ProduitService ps =new ProduitService();
        
        p.setId(Integer.parseInt(modifid.getText()));
        p.setNom(modifnom.getText());
        p.setDescription(modifdescription.getText());
        p.setCategorie(modifcategorie.getText());
        
        ps.set(p);
        
        afficher();
      
    }

    @FXML
    private void editerr(MouseEvent event) {
        System.out.println(affichenom.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()));
        System.out.println(affichedescription.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()));
        System.out.println(affichecategorie.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()));
        System.out.println(edit.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()));
        
        modifnom.setText(affichenom.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()));
        modifdescription.setText(affichedescription.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()));
        modifcategorie.setText(affichecategorie.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()));
        modifid.setText(edit.getCellData(tableview.getSelectionModel().getSelectedCells().get(0).getRow()).toString());
   
    }

    @FXML
    private void supprimer() {
        
  
        ProduitService ps =new ProduitService();
      
        
        ps.delete(Integer.parseInt(modifid.getText()));
        
        afficher();
      
    }

   
    
    
}
