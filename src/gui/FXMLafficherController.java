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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Article;
import services.ArticleService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLafficherController implements Initializable {
    ArticleService h = new ArticleService();

    @FXML
    private ListView<Article> listaf;
    @FXML
    private Button afficherlist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }  
    

    @FXML
    private void afficherlist(ActionEvent event) {
        ObservableList<Article> e= FXCollections.observableArrayList(h.fetchArticle());
    listaf.setItems(e);
    }

    @FXML
    private void supprimer_article(ActionEvent event) {
        int selectedId= listaf.getSelectionModel().getSelectedItem().getId_article();
        h.deleteArticle(selectedId);
       afficherlist(event);
    }

    @FXML
    private void modify_list(ActionEvent event) {
        try {
        Article selectedarticle=listaf.getSelectionModel().getSelectedItem();
        
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML1.fxml"));
        Parent view_2=loader.load();
        FXML1Controller FXML1Controller=loader.getController();
        FXML1Controller.getArticlee(selectedarticle);
        FXML1Controller.a=selectedarticle;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void ajouterArticle(ActionEvent event) {
        try {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
