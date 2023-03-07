/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevArtiste;

import interfaces.ArtisteInterface;
import models.Artiste;
import services.ArtisteService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.UpdateClientFXMLController;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class UpdateArtisteController implements Initializable {
    ArtisteInterface artiste=new ArtisteService();
    Artiste a;
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
    private TextField imagefield;
    @FXML
    private TextField description;
    @FXML
    private DatePicker birthdate;
    @FXML
    private TextField birthplace;
    @FXML
    private TextField lastname;
    @FXML
    private TextField password;
    @FXML
    private Button image;
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
        birthplace.setText(e.getAddress());
        birthdate.setValue(e.getBirthdate().toLocalDate());
        description.setText(e.getEmail());
        imagefield.setText(e.getEmail());
        adress.setText(e.getEmail());
        phonenumber.setText(e.getEmail());
        email.setText(e.getEmail());
        username.setText(e.getUsername());
        password.setText(e.getPassword());
        
    }
 
    @FXML
    private void takeimage(ActionEvent event) {
        FileChooser fc = new FileChooser();
           fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files","*.png"));
           File selectedFile = fc.showOpenDialog(null);
           if(selectedFile != null) {
               imagefield.setText(selectedFile.getAbsolutePath());
           } else {
               System.err.println("file is not valid");
           }
    }

    @FXML
    private void updateArtiste(ActionEvent event) {
        if (firstname.getText().length() == 0||lastname.getText().length() == 0||birthplace.getText() == null||description.getText().length() == 0||imagefield.getText()==null||adress.getText()==null||phonenumber.getText()==null||email.getText()==null||username.getText()==null||password.getText()==null) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("Please check your empty fields"+ "");
            alert.show();

        } else if(!phonenumber.getText().matches("\\d{8}")){
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("your phone number has to contain 8 caracter"+ "");
            alert.show();
          
          }else {
                try {
                a.setFirstname(firstname.getText());
                a.setLastname(lastname.getText());
                a.setBirthplace(birthplace.getText());
                LocalDate date = birthdate.getValue();
                a.setBirthdate(java.sql.Date.valueOf(date));
                a.setDescription(description.getText());
                a.setImage(imagefield.getText());
                a.setAddress(adress.getText());
                a.setPhonenumber(phonenumber.getText());
                a.setEmail(email.getText());
                a.setUsername(username.getText());
                a.setPassword(password.getText());
                
                artiste.updateArtiste(a);

                FXMLLoader loader= new FXMLLoader(getClass().getResource("UpdateArtiste.fxml"));
                    Parent view_2=loader.load();
                    Scene scene = new Scene(view_2);
                    Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(UpdateClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
      }
    
}
