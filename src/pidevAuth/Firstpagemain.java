/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuth;

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
import javafx.stage.Stage;

/**
 *
 * @author MediaStudio
 */
public class Firstpagemain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         try{
        System.out.println(getClass());
         Parent root = FXMLLoader.load(getClass().getResource("Firstpage.fxml"));
            Scene scene = new Scene(root,1000,600);
           
           
            
            primaryStage.setTitle("Welcome");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
        }catch (IOException ex) {
            Logger.getLogger(Firstpagemain.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
