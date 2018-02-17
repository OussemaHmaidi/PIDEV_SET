/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.pidev.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import esprit.pidev.models.Admin;
import esprit.pidev.service.imp.AdminService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author LACRIM
 */
public class AdminController implements Initializable {

    @FXML
    private JFXTextField txtlogin;
    @FXML
    private JFXButton btn;
    @FXML
    private JFXPasswordField pswd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void connect(ActionEvent event) {
        
       
       AdminService as = new AdminService();
                Admin a = as.getOne(1);
       
                
                 Window owner = btn.getScene().getWindow();
        if(txtlogin.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Login"); return;
        }else
        if(pswd.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Password"); return;
        }else
            if(a.getLogin().equals(txtlogin.getText()) && a.getMp().equals(pswd.getText()) )
            {System.out.println("1");
             btn.getScene().getWindow().hide();
        try {
           // imgProgress.setVisible(false);
            Stage dashboardStage = new Stage();
            dashboardStage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);
            dashboardStage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            
            
            
            }
        
                
                
    }
    
}
