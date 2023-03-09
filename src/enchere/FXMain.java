/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Enchere;

/**
 *
 * @author 
 */
public class FXMain extends Application {
    
 
    //AFFICHER MODIFIER ET SUPPRIMER UNE ENCHERE

  
    
    /////show all items i need to create new enchere with picture 
    @Override
   
   public void start(Stage primaryStage) {
       Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/rymgui/showAllItems.fxml"));
            Scene scene = new Scene(root,1700,1000);
           
            
            primaryStage.setTitle("home page");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
//    
//    
//    
    
    
     //////aaficher  les descriptions 
//      @Override
//   
//   public void start(Stage primaryStage) {
//       Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("/gui/descirption.fxml"));
//            Scene scene = new Scene(root,1700,1000);
//           
//            
//            primaryStage.setTitle("home page");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
//    }
//    
   
    
    
    ////item enchere
//    @Override
//   
//   public void start(Stage primaryStage) {
//       Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("/gui/EnchereItem.fxml"));
//            Scene scene = new Scene(root,1700,1000);
//           
//            
//            primaryStage.setTitle("home page");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
//    }
////   
//    
//    
    
    

   
//    @Override
//   
//   public void start(Stage primaryStage) {
//       Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("/gui/AfficherEnchere.fxml"));
//            Scene scene = new Scene(root,1700,1000);
//           
//            
//            primaryStage.setTitle("home page");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
//    }
//
//    
    
    

   
    // PARTICIPER AUX ENCHERES 
//     @Override
//    public void start(Stage primaryStage) {
//       Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getResource("/gui/Participation.fxml"));
//            Scene scene = new Scene(root,1700,1000);
//           
//            
//            primaryStage.setTitle("bienvenue aux ventes des encheres");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
//    }

   
  
  
    
  
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
