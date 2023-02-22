package com.example.newartflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class mainApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Parent root =  FXMLLoader.load(getClass().getResource("/com/example/newartflow/Stock/AfficherStock.fxml"));
        System.out.println(root);
        stage.setTitle("csd");
        stage.setScene(new Scene(root));
        stage.show();
    }
//        @Override
//        public void start(Stage stage) throws Exception {
//
//            Parent root =  FXMLLoader.load(getClass().getResource("AjouterStock.fxml"));
//            System.out.println(root);
//            stage.setTitle("csd");
//            stage.setScene(new Scene(root));
//            stage.show();
//        }
//
//
//
    public static void main(String[] args) {        launch();    }}
