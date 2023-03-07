/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthArtiste;

import interfaces.ArtisteInterface;
import interfaces.ClientInterface;
import interfaces.UserInterface;
import models.Artiste;
import models.User;
import services.ArtisteService;
import services.ClientService;
import services.UserService;
import util.MyConnection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCrypt;
import pidev.UpdateClientFXMLController;
import static pidevAuth.WelcomePageController.static_userwelcome;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class UpdateArtisteController implements Initializable {
 ArtisteInterface cl=new ArtisteService();
 UserInterface u1=new UserService();
 User u;
 Connection cnx = MyConnection.getInstance().getCnx();
 Artiste c;
 private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField firstname;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField adress;
    @FXML
    private TextField lastname;
    @FXML
    private TextField password;
    @FXML
    private TextField birthplace;
    @FXML
    private DatePicker birthdate;
    @FXML
    private TextField description;
    @FXML
    private TextField imagefield;
    @FXML
    private ImageView image_view;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void getArtiste(Artiste e){
        firstname.setText(e.getFirstname());
        lastname.setText(e.getLastname());
        birthplace.setText(e.getBirthplace());
        birthdate.setValue(e.getBirthdate().toLocalDate());
        description.setText(e.getDescription());
        imagefield.setText(e.getImage());
        adress.setText(e.getAddress());
        phonenumber.setText(e.getPhonenumber());
        email.setText(e.getEmail());
        username.setText(e.getUsername());
        password.setText(e.getPassword());

        }

    @FXML
    private void saveUpdate(ActionEvent event) {
        try {
        c.setFirstname(firstname.getText());
        c.setLastname(lastname.getText());
        c.setBirthplace(birthplace.getText());
        LocalDate date = birthdate.getValue();
        c.setBirthdate(java.sql.Date.valueOf(date));
        c.setDescription(description.getText());
        c.setImage(imagefield.getText());
        c.setAddress(adress.getText());
        c.setPhonenumber(phonenumber.getText());
        c.setEmail(email.getText());
        c.setUsername(username.getText());
        c.setPassword(password.getText());
          try {
               String pwd = password.getText();
    String encryptedPassword = BCrypt.hashpw(pwd, BCrypt.gensalt());
            String req =  "UPDATE `user` SET `username`=?,`password`=? WHERE `username`=?";
            PreparedStatement a = cnx.prepareStatement(req);
//            String password = p.getPassword();
//            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());            
            a.setString(1, username.getText());
            a.setString(2, password.getText());
           // a.setString(3, p.getType());
            a.setString(3, encryptedPassword);
            a.executeUpdate();
            System.out.println("user modified successfully!");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
        cl.updateArtiste(c);
        
      
        
        FXMLLoader loader =new FXMLLoader(getClass().getResource("SettingArtiste.fxml"));
                  root  =loader.load();
                  //static_userwelcome.setText(username.getText());
//                  WelcomePageController wpc= loader.getController();
//                  wpc.displayId(Username);
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
        } catch (IOException ex) {
            Logger.getLogger(UpdateArtisteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void takeimage(ActionEvent event) {
        FileChooser fc = new FileChooser();
           fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files","*.png", "*.JPG", "*.gif"));
           File selectedFile = fc.showOpenDialog(null);
           if(selectedFile != null) {
               imagefield.setText(selectedFile.getAbsolutePath());
           } else {
               System.err.println("file is not valid");
           }
    }
    
}
