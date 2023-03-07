/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthArtiste;

import GUI.NewFXMain;
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
 * @author kanza
 */
public class SettingArtisteMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         try{
        System.out.println(getClass());
         Parent root = FXMLLoader.load(getClass().getResource("SettingArtiste.fxml"));
            Scene scene = new Scene(root,1324,955);
           
           
            
            primaryStage.setTitle("Profile Settings");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
