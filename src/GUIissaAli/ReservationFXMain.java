/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
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
import javafx.application.Application;


/**
 *
 * @author Lenovo
 */
public class ReservationFXMain extends Application {
private MediaPlayer mediaPlayer;    
     
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("../GUI/ListeReservation.fxml"));

        Scene scene = new Scene(root, 1000,766);
       //Scene scene = new Scene(root);
       primaryStage.setTitle("Ajouter une reservation d'un evenement");
       primaryStage.setScene(scene);
       primaryStage.show();
       music();
       
       
       
       
    }
    
     public void music() {

    File musicDir = new File("src/Music");
    File[] musicFiles = musicDir.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return name.endsWith(".mp3");
        }
    });

    if (musicFiles != null && musicFiles.length > 0) {
        mediaPlayer = new MediaPlayer(new Media(musicFiles[0].toURI().toString()));
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                int currentIndex = -1;
                for (int i = 0; i < musicFiles.length; i++) {
                    if (mediaPlayer.getMedia().getSource().equals(musicFiles[i].toURI().toString())) {
                        currentIndex = i;
                        break;
                    }
                }
                if (currentIndex != -1 && currentIndex + 1 < musicFiles.length) {
                    Media nextMedia = new Media(musicFiles[currentIndex + 1].toURI().toString());
                    mediaPlayer = new MediaPlayer(nextMedia);
                    mediaPlayer.play();
                     mediaPlayer.setVolume(5);
                }
            }
        });
        mediaPlayer.play();
        mediaPlayer.setVolume(0.05);

    
    
    }
     }
    
    
    
    
    
//    public class ReservationFXMain extends Application {
//    
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("../GUI/View_Reservation.fxml"));
//       Scene scene = new Scene(root, 600,400);
//       primaryStage.setTitle("Ajouter une reservation d'un evenement");
//       primaryStage.setScene(scene);
//       primaryStage.show();
//    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
