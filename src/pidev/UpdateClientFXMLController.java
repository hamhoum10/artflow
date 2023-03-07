/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import interfaces.ClientInterface;
import models.Client;
import services.ClientService;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class UpdateClientFXMLController implements Initializable {
    ClientInterface cl=new ClientService();
    Client c;
    
    @FXML
    private TextField id_Firstname;
    @FXML
    private TextField id_Lastname;
    @FXML
    private TextField id_adress;
    @FXML
    private TextField id_Phonenumber;
    @FXML
    private TextField id_Email;
    @FXML
    private TextField username;
    @FXML
    private TextField id_password;
    @FXML
    private AnchorPane id_Username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        public void getClient(Client e){
            id_Firstname.setText(e.getFirstname());
            id_Lastname.setText(e.getLastname());
            id_adress.setText(e.getAddress());
            id_Phonenumber.setText(e.getPhonenumber());
            id_Email.setText(e.getEmail());
            username.setText(e.getUsername());
            id_password.setText(e.getPassword());

        }
    
    @FXML
    private void updateClient(ActionEvent event) {
         try {
        c.setFirstname(id_Firstname.getText());
        c.setLastname(id_Lastname.getText());
        c.setAddress(id_adress.getText());
        c.setPhonenumber(id_Phonenumber.getText());
        c.setEmail(id_Email.getText());
        c.setUsername(username.getText());
        c.setPassword(id_password.getText());
        cl.updateClient(c);
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./AfficheClientFXML.fxml"));
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
