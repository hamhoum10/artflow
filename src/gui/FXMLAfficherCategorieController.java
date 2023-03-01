/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Article;
import models.Categorie;
import services.CategorieService;
import services.StockService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLAfficherCategorieController implements Initializable {
        StockService h = new StockService();
        CategorieService ch = new CategorieService();

    @FXML
    private ListView<Categorie> listc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Categorie> k= FXCollections.observableArrayList(ch.fetchCategorie());
    listc.setItems(k);
    }    

    

    @FXML
    private void afficherca(ActionEvent event) {
    ObservableList<Categorie> k= FXCollections.observableArrayList(ch.fetchCategorie());
    listc.setItems(k);
    }

    @FXML
    private void supprimerca(ActionEvent event) {
        int selectedId= listc.getSelectionModel().getSelectedItem().getId_categorie();
        ch.deleteCategorie(selectedId);
       afficherca(event);
    }

    @FXML
    private void modify_categorie(ActionEvent event) {
       
        FXMLLoader loader;
        try {
        Categorie selectedCAT=listc.getSelectionModel().getSelectedItem();
        
        
        loader= new FXMLLoader(getClass().getResource("./ModifierFXMLCategorie.fxml"));
        Parent view_2=loader.load();
        ModifierFXMLCategorieController ModifierFXMLCategorieController=loader.getController();
        ModifierFXMLCategorieController.getCategorie(selectedCAT);
        ModifierFXMLCategorieController.ca=selectedCAT;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLAfficherCategorieController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void ajouterlist(ActionEvent event) {
        try {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLAjouteCategorie.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLAfficherCategorieController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
}
