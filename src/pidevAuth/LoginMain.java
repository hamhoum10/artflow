/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuth;

import GUI.NewFXMain;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author kanza
 */
public class LoginMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         try{
        System.out.println(getClass());
         Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
            Scene scene = new Scene(root,1100,700);
           
           
            
            primaryStage.setTitle("LOGIN");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
        }catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
            
        }
//         String path = "C:/Users/kanza/Downloads/interface-welcome-131917.mp3";  
//          
//        //Instantiating Media class  
//        Media media = new Media(new File(path).toURI().toString());  
//          
//        //Instantiating MediaPlayer class   
//        MediaPlayer mediaPlayer = new MediaPlayer(media);  
//          
//        //by setting this property to true, the audio will be played   
//        mediaPlayer.setAutoPlay(true);
//        primaryStage.setTitle("Playing Audio");  
//        primaryStage.show(); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
