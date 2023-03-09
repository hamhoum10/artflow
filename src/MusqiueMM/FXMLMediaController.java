/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusqiueMM;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLMediaController implements Initializable {
    private String path;
    private MediaPlayer mediaPlayer;
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider progressBar;
    @FXML
    private Slider volumeSlider;
    
    @FXML
    public void chooseFileMethode(ActionEvent event){
        FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(null);
        path = file.toURI().toString();
        
        if(path != null){
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            
            DoubleProperty widthProp = mediaView.fitWidthProperty();
             DoubleProperty heightProp = mediaView.fitHeightProperty();
             
             widthProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
              heightProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
              
              mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                    progressBar.setValue(newValue.toSeconds());
                    
                }
            });
              
              
              
              
              progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    
                    mediaPlayer.seek(Duration.seconds(progressBar.getValue()));
                  
                }
            });
              
               progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    
                    mediaPlayer.seek(Duration.seconds(progressBar.getValue()));
                  
                }
            });
              
            
              mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    Duration total = media.getDuration();
                    progressBar.setMax(total.toSeconds());
                }
            });
              
              
              volumeSlider.setValue(mediaPlayer.getVolume() * 100);
              volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                   mediaPlayer.setVolume(volumeSlider.getValue()/100);
                }
            });
              
            
            mediaPlayer.play();
            
        
        
            
        }
    
    
    }
    
    @FXML
    public void play(ActionEvent event){
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    
    
    }
    @FXML
      public void pause(ActionEvent event){
        mediaPlayer.pause();
    
    
    }
    @FXML
        public void stop(ActionEvent event){
        mediaPlayer.stop();
    
    
    }
    @FXML
          public void slowRate(ActionEvent event){
        mediaPlayer.setRate(0.5);
    
    
    }
    @FXML
           public void fastForward(ActionEvent event){
        mediaPlayer.setRate(2);
    
    
    }
    @FXML
           public void skip10(ActionEvent event){
               mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
           
           }
           
    @FXML
            public void back10(ActionEvent event){
               mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(-10)));
           
           }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exit(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("../GUI/ListeReservation.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        
        
        
    }
    
}
