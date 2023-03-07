/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAdmin;

import interfaces.AdminInterface;
import models.Admin;
import services.AdminService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.UpdateClientFXMLController;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class UpdateAdminController implements Initializable {

    Admin a;
    AdminInterface admin= new AdminService();
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField lastname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     public void getAdmin(Admin e){
        firstname.setText(e.getFirstname());
        lastname.setText(e.getLastname());
        phoneNumber.setText(e.getPhoneNumber());
        email.setText(e.getEmail());
        username.setText(e.getUsername());
        password.setText(e.getPassword());}
        
    @FXML
    private void updateAdmin(ActionEvent event) {
         try {
        a.setFirstname(firstname.getText());
        a.setLastname(lastname.getText());
        a.setPhoneNumber(phoneNumber.getText());
        a.setEmail(email.getText());
        a.setUsername(username.getText());
        a.setPassword(password.getText());
        admin.updateAdmin(a);
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("DisplayAdmin.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    }
    

