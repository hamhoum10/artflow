/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import models.Article;

/**
 *
 * @author MediaStudio
 */
public class ProjectFx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
         
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//
//       try {
//            Parent root = FXMLLoader.load(getClass().getResource("./gui/FXML.fxml"));
//            Scene scene = new Scene(root);
//            primaryStage.setTitle("workshopJavaFx");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(ProjectFx.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
          
   
//   try {
//            Parent root = FXMLLoader.load(getClass().getResource("./gui/FXMLafficher.fxml"));
//            Scene scene = new Scene(root,1000,700);
//            primaryStage.setTitle("workshopJavaFx");
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(ProjectFx.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
     try {
            Parent root = FXMLLoader.load(getClass().getResource("./gui/FXMLafficher.fxml"));
//            Parent root = FXMLLoader.load(getClass().getResource("./gui/FXMLstat.fxml"));        
            Scene scene = new Scene(root,1000,700);
            primaryStage.setTitle("workshopJavaFx");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProjectFx.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
        
        
        
        
    }        
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
