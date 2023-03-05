package com.example.testjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.stripe.Stripe;
public class HelloApplication extends Application {
    @Override
     public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("panierView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1550,800); //1550 -800
        stage.setTitle("Artflow");
        stage.setScene(scene);
        stage.show();

    }
   /* public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ComfirmerCommandeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1000,700);
        stage.setTitle("Artflow");
        stage.setScene(scene);
        stage.show();

    }*/

    public static void main(String[] args) {
        launch();

    }
}