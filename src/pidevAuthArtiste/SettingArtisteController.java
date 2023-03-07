/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthArtiste;
import javafx.scene.control.TextField;
import models.Artiste;
import models.Client;
import models.User;
import services.ArtisteService;
import services.UserService;
import util.MyConnection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import gui.*;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.AfficheClientFXMLController;
import pidevAuth.UpdateClientController;
import static pidevAuth.WelcomePageController.static_userwelcome;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class SettingArtisteController implements Initializable {
Connection cnx = MyConnection.getInstance().getCnx();
ArtisteService u =new ArtisteService();
Artiste c=new Artiste();
    @FXML
    private TextField lastname;
    @FXML
    private TextField adress;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Label userwelcome;
    @FXML
    private TextField firstname;
    @FXML
    private TextField username;
    @FXML
    private TextField birthplace;
    @FXML
    private TextField description;
    @FXML
    private TextField phonenumber;
    @FXML
    private DatePicker birthdate;

public static Label static_userwelcome;
    @FXML
    private TextField imagefield;
    @FXML
    private ImageView image_view;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       static_userwelcome=userwelcome;
    }    

    @FXML
    private void Settings(ActionEvent event) {
    }

    @FXML
    private void seeprofile(ActionEvent event) {
        userwelcome.setText(LoginArtisteController.usernameArtiste);
         getClientbyusername(LoginArtisteController.usernameArtiste);
    }
    

    @FXML
    private void goUpdate(ActionEvent event) {
//        
        FXMLLoader loader;

    try {
        List<Artiste> listArtiste = new ArrayList<>();
        Artiste C= new Artiste();
        C.setFirstname(firstname.getText());
        C.setLastname(lastname.getText());
        C.setBirthplace(birthplace.getText());
        LocalDate date = birthdate.getValue();
        C.setBirthdate(java.sql.Date.valueOf(date));
        C.setImage(imagefield.getText());
        C.setDescription(description.getText());
        C.setAddress(adress.getText());
        C.setPhonenumber(phonenumber.getText());
        C.setEmail(email.getText());
        C.setUsername(username.getText());
        C.setPassword(password.getText());
        
        
        listArtiste.add(C);
       
       // List<String> selectedClient=listClient.getSelectedItem();
       
        loader= new FXMLLoader(getClass().getResource("UpdateArtiste.fxml"));
        Parent view_2=loader.load();
       UpdateArtisteController UpdateArtisteController=loader.getController();
        UpdateArtisteController.getArtiste(C);
        UpdateArtisteController.c=C;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(SettingArtisteController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @FXML
    private void deleteprofile(ActionEvent event) {
         FXMLLoader loader;

    try {
        List<Artiste> listClient = new ArrayList<>();
        Artiste C= new Artiste();
        C.setFirstname(firstname.getText());
        C.setLastname(lastname.getText());
        C.setBirthplace(birthplace.getText());
        
        LocalDate datevalue = birthdate.getValue();
        C.setBirthdate(java.sql.Date.valueOf(datevalue));
        //C.setBirthdate(LocalDate.parse(birthdate.getValue().toString()));
        C.setLastname(lastname.getText());
        C.setAddress(adress.getText());
        C.setPhonenumber(phonenumber.getText());
        C.setEmail(email.getText());
        C.setUsername(username.getText());
        C.setPassword(password.getText());
        listClient.add(C);
        
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `user` WHERE username=?");
            
            a.setString(1, username.getText());
            a.executeUpdate();
            System.out.println("user deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        u.deleteArtiste(username.getText());
       // List<String> selectedClient=listClient.getSelectedItem();
       
        loader= new FXMLLoader(getClass().getResource("LoginArtiste.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AfficheClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    }
   

    public void getClientbyusername(String Username) {
               
        
        try {
            String req = "SELECT * FROM `artiste` WHERE username=?";
               PreparedStatement ste = cnx.prepareStatement(req);
               ste.setString(1, Username);
               ResultSet rs = ste.executeQuery();

            while (rs.next()) {
                
               c.setId(rs.getInt("id_artiste"));
               firstname.setText(rs.getString("firstname"));
                lastname.setText(rs.getString("lastname"));
                birthplace.setText(rs.getString("birthplace"));
                LocalDate datevalue =rs.getDate("birthdate").toLocalDate();
                birthdate.setValue(datevalue);
                description.setText(rs.getString("description"));
                adress.setText(rs.getString("address"));
                phonenumber.setText(rs.getString("phonenumber"));
                email.setText(rs.getString("email"));                
                username.setText(rs.getString("username"));
                password.setText(rs.getString("password"));
                imagefield.setText(rs.getString("image"));
                
                String imagePath = "C:/xampp/htdocs/img/" + rs.getString("image");
                System.out.println(imagePath);
                File file = new File(imagePath);
                if (file.exists()) {
                    Image img = new Image(file.toURI().toString());
                    image_view.setImage(img);
                } else {
                    // Display a default image or show an error message
                    System.out.println("Image not found: " + imagePath);
                }
                
//                File file=new File("C:/xampp/htdocs/img/"+c.getImage());
//                Image img=new Image(file.toURI().toString());
//                image.setImage(img);
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
