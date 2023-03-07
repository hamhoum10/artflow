/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthAdmin;

import interfaces.AdminInterface;
import interfaces.ClientInterface;
import interfaces.UserInterface;
import models.Admin;
import models.Client;
import models.User;
import services.AdminService;
import services.ClientService;
import services.UserService;
import util.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import static pidevAuth.WelcomePageController.static_userwelcome;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class UpdateAdminController implements Initializable {
AdminInterface cl=new AdminService();
 UserInterface u1=new UserService();
 User u;
 Connection cnx = MyConnection.getInstance().getCnx();
 private Stage stage;
    private Scene scene;
    private Parent root;

    Admin c;
    @FXML
    private TextField firstname;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField lastname;
    @FXML
    private TextField password;

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
            phonenumber.setText(e.getPhoneNumber());
            email.setText(e.getEmail());
            username.setText(e.getUsername());
            password.setText(e.getPassword());

        }
    
    @FXML
    private void saveUpdate(ActionEvent event) {
         try {
        c.setFirstname(firstname.getText());
        c.setLastname(lastname.getText());
        c.setPhoneNumber(phonenumber.getText());
        c.setEmail(email.getText());
        c.setUsername(username.getText());
        c.setPassword(password.getText());
          try {
            String req =  "UPDATE `user` SET `username`=?,`password`=? WHERE `username`=?";
            PreparedStatement a = cnx.prepareStatement(req);
//            String password = p.getPassword();
//            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());            
           
            a.setString(1, username.getText());
            a.setString(2, password.getText());
           // a.setString(3, p.getType());
            a.setString(3, username.getText());
            a.executeUpdate();
            System.out.println("user modified successfully!");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
        cl.updateAdmin(c);
        
      
        
        FXMLLoader loader =new FXMLLoader(getClass().getResource("SettingAdmin.fxml"));
                  root  =loader.load();
                  //static_userwelcome.setText(username.getText());
//                  WelcomePageController wpc= loader.getController();
//                  wpc.displayId(Username);
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
