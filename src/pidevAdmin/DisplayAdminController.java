/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAdmin;

import models.Admin;
import models.Client;
import services.AdminService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pidev.AfficheClientFXMLController;
import pidev.UpdateClientFXMLController;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class DisplayAdminController implements Initializable {

    AdminService admin = new AdminService();
    
    @FXML
    private ListView<Admin> listAdmin;
    @FXML
    private Button displayAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void displayAdmin(ActionEvent event) {
        
         ObservableList<Admin> e= FXCollections.observableArrayList(admin.fetchAdmin());
    listAdmin.setItems(e);
    }

    @FXML
    private void deleteAdmin(ActionEvent event) {
//        int selectedId =listAdmin.getSelectionModel().getSelectedItem().getId();
//    admin.deleteAdmin(selectedId);
//    displayAdmin(event);
    }

    @FXML
    private void updateAdmin(ActionEvent event) {
        FXMLLoader loader;

    try {
        Admin selectedAdmin=listAdmin.getSelectionModel().getSelectedItem();
        
        
        loader= new FXMLLoader(getClass().getResource("UpdateAdmin.fxml"));
        Parent view_2=loader.load();
       UpdateAdminController UpdateAdminController=loader.getController();
        UpdateAdminController.getAdmin(selectedAdmin);
        UpdateAdminController.a=selectedAdmin;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(DisplayAdminController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    
    
}
