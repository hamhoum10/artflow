/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAdmin;

import pidevAuthAdmin.MailSender;
import java.util.Properties;
import interfaces.AdminInterface;
import models.Admin;
import models.User;
import services.AdminService;
import services.UserService;
import util.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidevAuth.WelcomePageController;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class AddAdminController implements Initializable {
    Connection cnx = MyConnection.getInstance().getCnx();

    AdminInterface admin =new AdminService();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField firstname;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private TextField lastname;
    @FXML
    private TextField id_type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveAdmin(ActionEvent event) throws IOException {
        Admin c = new Admin();
         UserService user = new UserService();
        User u=new User();
         if (firstname.getText().length() == 0||lastname.getText().length() == 0||phoneNumber.getText()==null||email.getText()==null||username.getText()==null||password.getText()==null) {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("Please check your empty fields"+ "");
            alert.show();

        } else if(!phoneNumber.getText().matches("\\d{8}")){
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("your phone number has to contain 8 caracter"+ "");
            alert.show();
          
          }else {
        c.setFirstname(firstname.getText());
        c.setLastname(lastname.getText());
        c.setPhoneNumber(phoneNumber.getText());
        c.setEmail(email.getText());
        c.setUsername(username.getText());
        c.setPassword(password.getText());
        
        try {
    PreparedStatement a1 = cnx.prepareStatement("INSERT INTO `user`(`username`, `password`,`type`) VALUES (?,?,?)");
    a1.setString(1, username.getText());
    a1.setString(2, password.getText());
    a1.setString(3, id_type.getText());
    a1.executeUpdate();
        System.out.println("ok");
     } catch (SQLException ex) {
        ex.printStackTrace();
      }
        
//        
//        MailSender emailSender = new MailSender();
//        String from = "kanzarinadak@gmail.com";
//            String to = "kanzarinadak@gmail.com";
//            String subject = "pidev";
//            String message = "success";
//        
//         emailSender.sendEmail(from, "Nadanadak1.", to, subject, message);
//         MailSender test=new MailSender();
//         test.send();
//        Syste m.out.println("Email sent successfully!");
        admin.saveAdmin(c);
        String Email= email.getText();
        MailSender m =new MailSender();
        m.sendVerificationCode(Email, "you're registered succesfully");
         FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidevAuth/loginFXML.fxml"));
                  root  =loader.load();
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
        }
    }
    
}
