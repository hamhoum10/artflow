/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaces.ClientInterface;
import models.Client;
import services.ClientService;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class DispalyClientController implements Initializable {
    
    ClientInterface client =new ClientService();

    
    @FXML
    private TextField id_Firstname;
    @FXML
    private TextField id_password;
    @FXML
    private TextField id_Username;
    @FXML
    private TextField id_Email;
    @FXML
    private TextField id_adress;
    @FXML
    private TextField id_Phonenumber;
    @FXML
    private TextField id_Lastname;
    @FXML
        private Button submitButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveClient(ActionEvent event)  throws SQLException{
            Window owner = submitButton.getScene().getWindow();
                System.out.println(id_Firstname.getText());
               System.out.println(id_Lastname.getText());
               System.out.println(id_adress.getText());
               System.out.println(id_Phonenumber.getText());
               System.out.println(id_Email.getText());
               System.out.println(id_Username.getText());
               System.out.println(id_password.getText());
               if (id_Firstname.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }

        if (id_Lastname.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your email id");
            return;
        }
        if (id_adress.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            return;
        }
        if (id_Phonenumber.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }if (id_Email.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }if (id_Username.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }if (id_password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }
        ClientService client= new ClientService();

       Client c =new Client();
            c.setFirstname(id_Firstname.getText());
            c.setLastname(id_Lastname.getText());
            c.setAddress(id_adress.getText());
            c.setPhonenumber(id_Phonenumber.getText());
            c.setEmail(id_Email.getText());
            c.setUsername(id_Username.getText());
            c.setPassword(id_password.getText());
            client.saveClient(c);
            showAlert(Alert.AlertType.CONFIRMATION,owner, "success", "welcome" + id_Firstname.getText() );
            

//        try{
//            Client c =new Client();
//            c.setFirstname(id_Firstname.getText());
//            c.setLastname(id_Lastname.getText());
//            c.setAddress(id_adress.getText());
//            c.setPhonenumber(id_Phonenumber.getText());
//            c.setEmail(id_Email.getText());
//            c.setUsername(id_Username.getText());
//            c.setPassword(id_password.getText());
//            client.saveClient(c);
//            FXMLLoader loader =new FXMLLoader(getClass().getResource("./DisplayCLientFXML.fxml"));
//            Parent view_2=loader.load();
//
//            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(view_2);
//            stage.setScene(scene);
//            stage.show();
//
//        
//        } catch (IOException ex) {
//            Logger.getLogger(DispalyClientController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
        
        
        }
    
}
