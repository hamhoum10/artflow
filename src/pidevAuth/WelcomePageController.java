/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuth;

import models.Client;
import models.User;
import services.ClientService;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.AfficheClientFXMLController;
import pidev.UpdateClientFXMLController;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class WelcomePageController implements Initializable {
 ClientService u =new ClientService();
     Connection cnx = MyConnection.getInstance().getCnx();

        Client c=new Client();
    @FXML
    private Label userwelcome;
private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField adress;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
   
    public static Label static_userwelcome;
    @FXML
    private TextField password;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //static_userwelcome=userwelcome;
       // Client a =   u.getClientbyusername(static_userwelcome.getText());
     //firstname.setText(a.getFirstname());
//     getClientbyusername(static_userwelcome.getText());
    }
       
    public void statique(){
    static_userwelcome=userwelcome;
    }
    public String displayId(String Username){
        //userwelcome.setText(Username);
        return Username;
    }
    
    @FXML
    private void seeprofile(ActionEvent event) {
        userwelcome.setText(LoginFXMLController.usernamewelcome);
         getClientbyusername(LoginFXMLController.usernamewelcome);
    }

    @FXML
    private void goUpdate(ActionEvent event) {
       FXMLLoader loader;

    try {
        List<Client> listClient = new ArrayList<>();
        Client C= new Client();
        C.setFirstname(firstname.getText());
        C.setLastname(lastname.getText());
        C.setAddress(adress.getText());
        C.setPhonenumber(phonenumber.getText());
        C.setEmail(email.getText());
        C.setUsername(username.getText());
        C.setPassword(password.getText());
        
        
        listClient.add(C);
       
       // List<String> selectedClient=listClient.getSelectedItem();
       
        loader= new FXMLLoader(getClass().getResource("./UpdateClient.fxml"));
        Parent view_2=loader.load();
       UpdateClientController UpdateClientController=loader.getController();
        UpdateClientController.getClient(C);
        UpdateClientController.c=C;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AfficheClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
//        try {
//        c.setFirstname(firstname.getText());
//        c.setLastname(lastname.getText());
//        c.setAddress(adress.getText());
//        c.setPhonenumber(phonenumber.getText());
//        c.setEmail(email.getText());
//        c.setUsername(username.getText());
//        
//        u.updateClient(c);
//        
//        FXMLLoader loader= new FXMLLoader(getClass().getResource("./AfficheClientFXML.fxml"));
//            Parent view_2=loader.load();
//            Scene scene = new Scene(view_2);
//            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(UpdateClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void Settings(ActionEvent event) throws IOException {
//        ClientService u =new ClientService();
//        
//        if(displayId(userwelcome.getText())=="nada"){
//        
      
        
      
//        FXMLLoader loader =new FXMLLoader(getClass().getResource("Welcome page.fxml"));
//                  root  =loader.load();
////                  WelcomePageController wpc= loader.getController();
////                  wpc.displayId(Username);
//                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
//                  scene = new Scene(root);
//                  stage.setScene(scene);
//                  stage.show();
    }

    
  
     public void getClientbyusername(String Username) {
               
        
        try {
            String req = "SELECT * FROM `client` WHERE username=?";
               PreparedStatement ste = cnx.prepareStatement(req);
               ste.setString(1, Username);
               ResultSet rs = ste.executeQuery();

            while (rs.next()) {
                
               c.setId(rs.getInt("id"));
               firstname.setText(rs.getString("firstname"));
                lastname.setText(rs.getString("lastname"));
                adress.setText(rs.getString("address"));
                phonenumber.setText(rs.getString("phonenumber"));
                email.setText(rs.getString("email"));                
                username.setText(rs.getString("username"));
                password.setText(rs.getString("password"));
                 
                
                
            }
                          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //return u;
}

    @FXML
    private void deleteprofile(ActionEvent event) {
        //ClientService client = new ClientService();
       // int selectedId =listClient.getSelectionModel().getSelectedItem().getId();
   
    
    FXMLLoader loader;

    try {
        List<Client> listClient = new ArrayList<>();
        Client C= new Client();
        C.setFirstname(firstname.getText());
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
        
        
        u.deleteClient(username.getText());
       // List<String> selectedClient=listClient.getSelectedItem();
       
        loader= new FXMLLoader(getClass().getResource("./loginFXML.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AfficheClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }

    @FXML
    private void goHome(MouseEvent event) throws IOException {
         FXMLLoader loader =new FXMLLoader(getClass().getResource("../gui/FXMLafficher.fxml"));
            Parent view_2=loader.load();

            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }

   

   
    @FXML
    private void goEventb(ActionEvent event) throws IOException {
       FXMLLoader loader =new FXMLLoader(getClass().getResource("../GUIissaAli/ListeReservation.fxml"));
            Parent view_2=loader.load();

            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();

    }

    
      
    }

