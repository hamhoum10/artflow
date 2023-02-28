package com.example.testjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Commande;
import services.CommandeService;

import java.io.IOException;
import java.util.List;

public class ComfirmerCommandeController {
    @FXML
    private Button AnullerCommande;

    @FXML
    private Button payerCommande;

    @FXML
    private Button showCommande;

    @FXML
    private ListView<Commande> listviewcommande;

    @FXML
    void showCommandeAction(ActionEvent event) {
        CommandeService cs =new CommandeService();
        List<Commande> commandeList =cs.readCommandesbyPanier(4);
        ObservableList<Commande> e= FXCollections.observableArrayList(commandeList);
        listviewcommande.setItems(e);
    }
    @FXML
    void AnullerCommandeAction(ActionEvent event) {
        CommandeService commandeService =new CommandeService();
        commandeService.deleteCommande(4);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("panierView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) AnullerCommande.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void payerCommandeAction(ActionEvent event) {
        alertDialog("NOT Yet");

    }
    void alertDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }




}



