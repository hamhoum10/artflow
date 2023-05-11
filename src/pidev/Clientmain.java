/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import GUI.NewFXMain;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
public class Clientmain extends Application {
    
     @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            
        System.out.println(getClass());
         Parent root = FXMLLoader.load(getClass().getResource("DisplayClientFXML.fxml"));
            Scene scene = new Scene(root,1107,700);
            primaryStage.setTitle("REGISTER AS A CLIENT");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
     

    public static void main(String[] args) {
        launch(args);
    }
    
    
}