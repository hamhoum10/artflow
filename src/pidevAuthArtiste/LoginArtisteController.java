/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthArtiste;

import models.User;
import services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static pidevAuth.WelcomePageController.static_userwelcome;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class LoginArtisteController implements Initializable {
private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button login;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    public static String usernameArtiste; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
          UserService us =new UserService();
        User u =new User();
        String Username = username.getText();

        String Password = password.getText();        
        User a = us.getUserbyusername(Username);
       if (Username.isEmpty() || Password.isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("Please check your empty fields"+ "");
            alert.show();
       }else{
           
           
           if(us.test(Username, Password) == 1){
               
              
              
              //ID = a.getId();
              //System.out.println(ID); 
              //System.out.println(u.getType());
              if(a.getRoles().equals("[\"client\"]")){
                   FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidevAuth/Welcome page.fxml"));
                  root  =loader.load();
                  static_userwelcome.setText(username.getText());
//                  WelcomePageController wpc= loader.getController();
//                  wpc.displayId(Username);
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
                  
              
              }else if(a.getRoles().equals("[\"admin\"]")){
                  // Parent loader = FXMLLoader.load(getClass().getResource("Welcome page.fxml"));
                  //Scene scene = new Scene(loader, 600, 400);
                  //Stage stage= new Stage();
                  //stage.setScene(scene);
                  //stage.show();
                  FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidevAuthAdmin/SettingAdmin.fxml"));
                  root  =loader.load();
                  static_userwelcome.setText(username.getText());
//                  WelcomePageController wpc= loader.getController();
//                  wpc.displayId(Username);
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
                  
              
              }else if(a.getRoles().equals("[\"artiste\"]")){
                  // Parent loader = FXMLLoader.load(getClass().getResource("Welcome page.fxml"));
                  //Scene scene = new Scene(loader, 600, 400);
                  //Stage stage= new Stage();
                  //stage.setScene(scene);
                  //stage.show();
                  FXMLLoader loader =new FXMLLoader(getClass().getResource("SettingArtiste.fxml"));
                  root  =loader.load();
                  usernameArtiste=username.getText();
                  //static_userwelcome.setText(username.getText());
//                  WelcomePageController wpc= loader.getController();
//                  wpc.displayId(Username);
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
                  
              
              }
              
           }
           else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("input error !");
            alert.setContentText("user does not exist"+ "");
            alert.show();
           }
       }
      
        
    }
    
    }
    

