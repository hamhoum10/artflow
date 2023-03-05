/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.ArticleInterface;
import interfaces.RateInterface;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Article;
import models.Rate;
import services.ArticleService;
import services.RateService;


/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class ArticleItemController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label price;
    @FXML
    private ImageView articleImg;
    @FXML
    private ImageView qrcodeimg;
        private Article article;

    Article a = new Article();
    ArticleInterface ai = new ArticleService();
    @FXML
    private Label avg;
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Article a) {
        RateInterface ri = new RateService();
        article=a;
        this.a=a;
        name.setText(a.getNom_article());
        price.setText(String.valueOf(a.getPrice()));
        /*
        Image imageg = new Image(getClass().getResourceAsStream(a.getImage()));
        System.out.println(a);
        articleImg.setImage(imageg);*/
        File file=new File("C:\\xampp\\htdocs\\img\\"+a.getImage());
        Image img=new Image(file.toURI().toString());
        
         articleImg.setImage(img);
         /*articleImg.setFitWidth(350);
         articleImg.setFitHeight(250);*/
         File file2=new File("C:\\xampp\\htdocs\\qrcode\\Article"+a.getId_article()+".png");
        Image img2=new Image(file2.toURI().toString());
        qrcodeimg.setImage(img2);
        if(String.valueOf(ri.afficherRateavg(a)).length()>2){
        avg.setText(String.valueOf(ri.afficherRateavg(a)).substring(0,3));
        
        }
        
        
        

    }

    @FXML
    private void addToCart(MouseEvent event) {
    }

    @FXML
    private void deleteArticle(MouseEvent event) throws IOException {
        ai.deleteArticle(a.getId_article());
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLafficher.fxml"));
        Parent view_2=loader.load();
        Scene scene = new Scene(view_2);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void modifyArticle(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML1.fxml"));
        Parent view_2=loader.load();
        FXML1Controller modifier_article=loader.getController();
        modifier_article.setArticle(a);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void view_description(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLdes.fxml"));
        Parent view_2=loader.load();
        FXMLdesController FXMLdesController=loader.getController();
        System.out.println("hello");
        System.out.println(article);
        FXMLdesController.setArticle(article);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }
    
}
