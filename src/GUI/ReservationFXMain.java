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

/**
 *
 * @author Lenovo
 */
public class ReservationFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Reservation.fxml"));
       Scene scene = new Scene(root, 600,400);
       primaryStage.setTitle("Ajouter une reservation d'un evenement");
       primaryStage.setScene(scene);
       primaryStage.show();
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
