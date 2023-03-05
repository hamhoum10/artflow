/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Article;
import services.ArticleService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLclientController implements Initializable {
    ArticleService h = new ArticleService();

    private ListView<Article> listaf;
    @FXML
    private GridPane articleGrid;
//    @FXML
//    private TextField prix;
//    
//    @FXML
//    private TextField caracter;
    
    private List<Article> articles;
    @FXML
    private TextField car;
    private TextField prix;
    @FXML
    private TextField prix_max;
    @FXML
    private TextField prix_min;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher_Articles();
        } catch (IOException ex) {
            Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
    
    public void afficher_Articles() throws IOException {
        articleGrid.getChildren().clear();
        articles = h.fetchArticle();
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<articles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            AnchorPane item;
            
            
                fxmlLoader.setLocation(getClass().getResource("FXMLafficherclient.fxml"));
            
             item = fxmlLoader.load();
           
            
            FXMLafficherclientController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));
            
            
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            articleGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


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

//    @FXML
//    private void rechprix(MouseEvent event) {
////        articleGrid.getChildren().clear();
////        articles = h.fetchArticleByPrice(Double.parseDouble(prix.getText()),500.0);
////        int columns=0;
////        int rows=0;
////        try {
////        for(int i=0;i<articles.size();i++){
////            FXMLLoader fxmlLoader = new FXMLLoader();
////            fxmlLoader.setLocation(getClass().getResource("ArticleItem.fxml"));
////            
////            AnchorPane item = fxmlLoader.load();
////           
////            
////            ArticleItemController itemController = fxmlLoader.getController();
////            System.out.println(articles.get(i));
////            itemController.setData(articles.get(i));
////            
////            if(columns == 4){
////                columns = 0 ;
////                ++rows;
//            }
////            
////            articleGrid.add(item, columns++, rows);
////        }}
////              catch (IOException ex) {
////                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
////            }
//    }
//
//    @FXML
//    private void recherCa(MouseEvent event) {
//    }

    @FXML
    private void rechercheprix(MouseEvent event) {
        articleGrid.getChildren().clear();
        articles = h.fetchArticleByPrice(Double.parseDouble(prix_min.getText()),Double.parseDouble(prix_max.getText()));
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<articles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ArticleItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            ArticleItemController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));
            
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            articleGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void recherchcara(MouseEvent event) {
                articleGrid.getChildren().clear();
        articles = h.fetchArticleByCaracter(car.getText());
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<articles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ArticleItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            ArticleItemController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));
            
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            articleGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void stat_art(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLstat.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    }
    
}
