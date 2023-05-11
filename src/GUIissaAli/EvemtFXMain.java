/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;


/**
 *
 * @author Lenovo
 */
//public class EvemtFXMain extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//       Parent root = FXMLLoader.load(getClass().getResource("../GUI/View_Evemt.fxml"));
//       Scene scene = new Scene(root, 700,500);
//       primaryStage.setTitle("Afficher un evenement");
//       primaryStage.setScene(scene);
//       primaryStage.show();
//    }
    public class EvemtFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("Evenement.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("testMap.fxml"));
       Scene scene = new Scene(root, 1000,766);
       primaryStage.setTitle("Ajouter un evenement");
       primaryStage.setScene(scene);
       //Scene scene = new Scene(root, 1100,600);
       primaryStage.show();
    }
    
  //  public class EvemtFXMain extends Application {
    
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//       Parent root = FXMLLoader.load(getClass().getResource("../GUI/ModifiEvemt.fxml"));
//       Scene scene = new Scene(root, 700,500);
//       primaryStage.setTitle("Veuillez les informations de l'evenement");
//       primaryStage.setScene(scene);
//       primaryStage.show();
//    }


//public class EvemtFXMain extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//       Parent root = FXMLLoader.load(getClass().getResource(""));
//       Scene scene = new Scene(root, 700,500);
//       primaryStage.setTitle("Supprimer un evenement");
//       primaryStage.setScene(scene);
//       primaryStage.show();
//    }
//    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
