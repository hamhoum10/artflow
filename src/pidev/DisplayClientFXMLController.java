/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import pidevAuthAdmin.MailSender;
import GUI.DispalyClientController;
import interfaces.ClientInterface;
import models.Client;
import models.User;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.mail.MessagingException;
import models.Panier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import static pidevAuth.LoginFXMLController.usernamewelcome;
import services.PanierService;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class DisplayClientFXMLController implements Initializable {
    
    ClientInterface client =new ClientService();
Connection cnx = MyConnection.getInstance().getCnx();
               UserService user = new UserService();
               public static String user1 ;
     private MailSender emailSender;
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
    private Button buttonsave;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public String displayId(String Client){
        //labelartist.setText("hello  "+ Artiste);
        return "client";
    }
    @FXML
    private void saveClient(ActionEvent event) throws IOException, SQLException {
        emailSender = new MailSender();
      if (id_Firstname.getText().length() == 0||id_Lastname.getText().length() == 0||id_adress.getText()==null||id_Phonenumber.getText()==null||id_Email.getText()==null||id_Username.getText()==null||id_password.getText()==null) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("Please check your empty fields"+ "");
            alert.show();

        } else if(!id_Phonenumber.getText().matches("\\d{8}")){
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("your phone number has to contain 8 caracter"+ "");
            alert.show();
          
          }else {
                ClientService client= new ClientService();
                UserService user = new UserService();
        Client c = new Client();
        User u=new User();
        c.setFirstname(id_Firstname.getText());
        c.setLastname(id_Lastname.getText());
        c.setAddress(id_adress.getText());
        c.setPhonenumber(id_Phonenumber.getText());
        c.setEmail(id_Email.getText());
        c.setUsername(id_Username.getText());
        c.setPassword(id_password.getText());
        //u.setUsername(id_Username.getText());
        //u.setPassword(id_password.getText());
        //u.setType("clien");
        //user.Userinsert(u);
        try {
             
       
        
            String password = id_password.getText();
    String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    PreparedStatement a1 = cnx.prepareStatement("INSERT INTO `user`(`username`, `password`,`type`) VALUES (?,?,?)");
    a1.setString(1, id_Username.getText());
    a1.setString(2, encryptedPassword);
    a1.setString(3, displayId("client"));
    a1.executeUpdate();
    
        System.out.println("0000");
     } catch (SQLException ex) {
        ex.printStackTrace();
      }
       
        
        client.saveClient(c);
         
                
                  System.out.println(id_Username.getText());
                  user1=id_Username.getText();
//                   int  id=cl.getidclientbyusername(id_Username.getText());
//                   Panier p = new Panier();
//                   c.setId(id);
//                   p.setClient(c);
//                   ps.createPanier(p);
        String Email= id_Email.getText();
        
        
        pidevAuthAdmin.MailSender m =new pidevAuthAdmin.MailSender();
        m.sendVerificationCode(Email, "you're registered succesfully");
        
            FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidevAuth/loginFXML.fxml"));
            Parent view_2=loader.load();

            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
            ClientService cl = new ClientService();
                  PanierService ps = new PanierService();
                  System.out.println(id_Username.getText());
                   int  id=cl.getidclientbyusername(id_Username.getText());
                   Panier p = new Panier();
                   c.setId(id);
                   p.setClient(c);
                   ps.createPanier(p);
            
             
    }
    }
//    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.initOwner(owner);
//        alert.show();
//        
//        
//        }

    @FXML
    private void gotologin(MouseEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidevAuth/loginFXML.fxml"));
            Parent view_2=loader.load();

            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }
}

