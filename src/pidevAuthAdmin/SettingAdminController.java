/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthAdmin;

import models.Admin;
import models.Artiste;
import models.Client;
import services.AdminService;
import services.ArtisteService;
import util.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.AfficheClientFXMLController;
import pidevAuth.UpdateClientController;
import static pidevAuth.WelcomePageController.static_userwelcome;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class SettingAdminController implements Initializable {
Connection cnx = MyConnection.getInstance().getCnx();
AdminService u =new AdminService();
Admin c=new Admin();
    @FXML
    private Label userwelcome;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
public static Label static_userwelcome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
              static_userwelcome=userwelcome;

        // TODOx    
    }    

    @FXML
    private void Settings(ActionEvent event) {
    }

    @FXML
    private void seeprofile(ActionEvent event) {
        userwelcome.setText(LoginAdminController.usernameAdmin);
        getAdminbyusername(LoginAdminController.usernameAdmin);
    }

    @FXML
    private void goUpdate(ActionEvent event) {
         FXMLLoader loader;

    try {
        List<Admin> listAdmin = new ArrayList<>();
        Admin C= new Admin();
        C.setFirstname(firstname.getText());
        C.setLastname(lastname.getText());
        C.setPhoneNumber(phonenumber.getText());
        C.setEmail(email.getText());
        C.setUsername(username.getText());
        C.setPassword(password.getText());
        
        
        listAdmin.add(C);
       
       // List<String> selectedClient=listClient.getSelectedItem();
       
        loader= new FXMLLoader(getClass().getResource("./UpdateAdmin.fxml"));
        Parent view_2=loader.load();
       UpdateAdminController UpdateAdminController=loader.getController();
        UpdateAdminController.getAdmin(C);
        UpdateAdminController.c=C;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AfficheClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }

    @FXML
    private void deleteprofile(ActionEvent event) {
        FXMLLoader loader;

    try {
        List<Admin> listAdmin = new ArrayList<>();
        Admin C= new Admin();
        C.setFirstname(firstname.getText());
        C.setLastname(lastname.getText());
        C.setPhoneNumber(phonenumber.getText());
        C.setEmail(email.getText());
        C.setUsername(username.getText());
        C.setPassword(password.getText());
        listAdmin.add(C);
        
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `user` WHERE username=?");
            
            a.setString(1, username.getText());
            a.executeUpdate();
            System.out.println("user deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        u.deleteAdmin(username.getText());
       // List<String> selectedClient=listClient.getSelectedItem();
       
        loader= new FXMLLoader(getClass().getResource("LoginAdmin.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AfficheClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void getAdminbyusername(String Username) {
               
        
        try {
            String req = "SELECT * FROM `admin` WHERE username=?";
               PreparedStatement ste = cnx.prepareStatement(req);
               ste.setString(1, Username);
               ResultSet rs = ste.executeQuery();

            while (rs.next()) {
                
               c.setId(rs.getInt("id"));
               firstname.setText(rs.getString("firstname"));
                lastname.setText(rs.getString("lastname"));
                phonenumber.setText(rs.getString("phonenumber"));
                email.setText(rs.getString("email"));                
                username.setText(rs.getString("username"));
                password.setText(rs.getString("password"));
                 
                
                
            }
                          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
}

    @FXML
    private void goHome(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../gui/FXMLafficher.fxml"));
            Parent view_2=loader.load();

            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }
    
}
