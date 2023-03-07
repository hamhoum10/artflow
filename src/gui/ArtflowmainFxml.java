/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import interfaces.ClientInterface;
import models.Client;
import services.ClientService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sun.applet.Main;


/**
 *
 * @author kanza
 */
public class ArtflowmainFxml extends Application{
    
    
//    public static void main(String[] args) {
////Maconnexion mac=new Maconnexion();
//        ClientInterface sg = new ClientService();
//        
//         
//         
//         ///////////garage//////////////////
//        //initialisation d'un garage
//       /* GarageC g=new GarageC();
//        g.setNom_garage("Garage Auto Mohsen");
//        g.setAdresse("Ariana rue salem n°2");
//        g.setNumero(98665235);
//        g.setPanne_moteur(500);*/
//
//        //ajout garage methode 1
//        //sg.saveClient(g);
//               Client m1=new Client();
//               sg.saveClient(m1);
//
//       // GarageC g1=new GarageC("Garage hela","tunis ",98214541,1000,500,600,200,500,300,500,400,1000,2000,500,600,400,100," ",10,"image");
//      //sg.insert(g1);
//        
//       //supprimer garage
//       // sg.delete(9);
//       
//       //update garage
//       /*g1.setId_garage(11);
//       g1.setAdresse("menzah 9");
//        sg.update(g1);*/
//      
//       
//       //affichage
//       //sg.afficherGarage(); //hedhi affichage bel void
//       // System.out.println(sg.readAll());
//       
//       ///recherche par id 
//   //System.out.println(sg.readById(11));
//
//
// //trier 
//      // System.out.println(sg.sortBy("panne_moteur","ASC"));
//       
//      
//      /////////////////Maintenance///////////////////
//      //InterfaceCRUD sm = new ServiceMaintenance();
//      
//      ////demander maintenance
//       //Maintenance m1=new Maintenance(2,false,false,false,false,false,true,false,false,true,false,false,false,false,false,"");
//      // sm.insert(m1);
//       
//     //supprimer maintenance
//       //sm.delete(5);
//        
//         //update maintenance
//     /*m1.setId_user(2);
//       m1.setPompe_a_eau(true);
//        sm.update(m1);*/
//    
//    
//     //affichage
//       //System.out.println(sm.readAll());
//      
//      ///recherche par id 
//    // System.out.println(sm.readById(5));
//     
//     
//     //trier 
//      //System.out.println(sm.sortBy("id_user","DESC"));
//      
//    }

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println(getClass());
        //Parent root =FXMLLoader.load(getClass().getResource("DisplayCLient.fxml"));
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("./pidev/DisplayClientFXMLController.fxml"));
        Parent root =  loader.load();
        System.out.println("nooooooooooo");
         Scene scene = new Scene(root);
           
            
            stage.setTitle("Hello World!");
            stage.setScene(scene);
            stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    }
 
//           <?import javafx.scene.layout.GridPane?>
//<?import javafx.geometry.Insets?>
//<?import javafx.scene.layout.ColumnConstraints?>
//<?import javafx.scene.control.Label?>
//<?import javafx.scene.text.Font?>
//<?import javafx.scene.control.TextField?>
//<?import javafx.scene.control.PasswordField?>
//<?import javafx.scene.control.Button?>
//<GridPane fx:controller="com.javaguides.javafx.registration.RegisterController"
//    xmlns:fx="http://javafx.com/fxml" alignment="center"
//          hgap="10" vgap="10">
//    <padding>
//        <Insets top="40" right="40" bottom="40" left="40"/>
//    </padding>
//    <columnConstraints>
//        <ColumnConstraints minWidth="100" prefWidth="100"
//                           maxWidth="Infinity" halignment="RIGHT"></ColumnConstraints>
//        <ColumnConstraints minWidth="200" prefWidth="200"
//                           maxWidth="Infinity" hgrow="ALWAYS"></ColumnConstraints>
//    </columnConstraints>
//    <!-- Add Header Label -->
//    <Label text="Registration Form (FXML)" GridPane.columnIndex="0" 
//           GridPane.rowIndex="0" GridPane.columnSpan="2" 
//           GridPane.rowSpan="1" GridPane.halignment="CENTER" >
//        <font>
//            <Font name="Arial" size="24" ></Font>
//        </font>
//        <GridPane.margin>
//            <Insets top="20" right="0" bottom="20" left="0"></Insets>
//        </GridPane.margin>
//    </Label>
//    <!-- Add Name Label -->
//    <Label text="Full Name : " GridPane.columnIndex="0" 
//           GridPane.rowIndex="1" ></Label>
//    <!-- Add Name Text Field -->
//    <TextField fx:id="fullNameField" prefHeight="40" 
//               GridPane.columnIndex="1" GridPane.rowIndex="1"/>
//    <!-- Add Email Label -->
//    <Label text="Email ID : " GridPane.columnIndex="0" 
//           GridPane.rowIndex="2" ></Label>
//    <!-- Add Email Text Field -->
//    <TextField fx:id="emailIdField" prefHeight="40" 
//               GridPane.columnIndex="1" GridPane.rowIndex="2"/>
//    <!-- Add Password Label -->
//    <Label text="Password : " GridPane.columnIndex="0" 
//           GridPane.rowIndex="3" ></Label>
//    <!-- Add Password Field -->
//    <PasswordField fx:id="passwordField" prefHeight="40" 
//                   GridPane.columnIndex="1" GridPane.rowIndex="3"/>
//    <!-- Add Submit Button -->
//    <Button fx:id="submitButton" text="Submit"
//            prefWidth="100" prefHeight="40" defaultButton="true"
//            GridPane.columnIndex="0" GridPane.rowIndex="4"
//            GridPane.columnSpan="2" GridPane.rowSpan="1"
//            GridPane.halignment="CENTER"
//            onAction="#register">
//        <GridPane.margin>
//            <Insets top="20" right="0" bottom="20" left="0"></Insets>
//        </GridPane.margin>
//    </Button>
//</GridPane>
