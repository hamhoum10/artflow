package com.example.newartflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//public class mainApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(mainApplication.class.getResource("AjouterStock.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("ArtFlow");
//        stage.setScene(scene);
//        stage.show();
//    }
    public class mainApplication extends Application {
//        @Override
//        public void start(Stage stage) throws IOException {
//            FXMLLoader fxmlLoader = new FXMLLoader(com.example.newartflow.mainApplication.class.getResource("AfficherStock.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            stage.setTitle("ArtFlow");
//            stage.setScene(scene);
//            stage.show();
//        }
//    public class mainApplication extends Application {
//        @Override
//        public void start(Stage stage) throws IOException {
//            FXMLLoader fxmlLoader = new FXMLLoader(com.example.newartflow.mainApplication.class.getResource("AjouterStock.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            stage.setTitle("ArtFlow");
//            stage.setScene(scene);
//            stage.show();
//        }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainApplication.class.getResource("AfficherStock.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}