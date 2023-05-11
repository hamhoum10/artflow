/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.RateInterface;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Article;
import models.Artiste;
import models.Ligne_panier;
import models.Panier;
import models.Rate;
import org.controlsfx.control.Rating;
import pidevAuth.LoginFXMLController;
import pidevAuthAdmin.LoginAdminController;
import pidevAuthArtiste.LoginArtisteController;
import services.ClientService;
import services.Ligne_PanierService;
import services.RateService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLdesController implements Initializable {
    RateInterface ra = new RateService();
    @FXML
    private ImageView image_view;
    @FXML
    private Label desc;
    @FXML
    private Label type;
    @FXML
    private Label Artiste;
    @FXML
    private Label quantity;
    @FXML
    private Rating stars;
    Rate rate= new Rate();
    @FXML
    private HBox hbox;
    @FXML
    private Button rate_id;
    @FXML
    private ImageView market_id;
    @FXML
    private Button ajout_id;
    Article a = new Article();
   
        Ligne_PanierService lp = new Ligne_PanierService();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setArticle(Article article){
       
        System.out.println(article);
        File file=new File("C:\\xampp\\htdocs\\img\\"+article.getImage());
        Image img=new Image(file.toURI().toString());
        image_view.setImage(img);
        desc.setText(article.getDescription());
        System.out.println(article);
        type.setText(article.getType());
        Artiste.setText(article.getArtiste().getFirstname());
        quantity.setText(String.valueOf(article.getQuantity()));
        Artiste rater=new Artiste();
        rater.setId(7);
        rate.setRater(rater);
        rate.setArticle(article);
        rate.setRating(ra.afficherRating(rate));
        stars.setRating(ra.afficherRating(rate));
         if(LoginArtisteController.usernameArtiste!=null || LoginAdminController.usernameAdmin!=null){
             hbox.getChildren().remove(rate_id);
             hbox.getChildren().remove(market_id);
             hbox.getChildren().remove(ajout_id);
             hbox.getChildren().remove(stars);
         }
        a=article;
}
    
    @FXML
    private void ajouter_panner(ActionEvent event) {
        
//        Artiste ar = new Artiste();
         
//         p.setArticle(a);
//System.out.println(LoginFXMLController.usernamewelcome+"5555555");
        
        Ligne_panier p = new Ligne_panier();
        Ligne_PanierService lp = new Ligne_PanierService();
        ClientService cs = new ClientService();
        Panier panier = new Panier();
        
        panier.setClient(cs.getClientbyusername(LoginFXMLController.usernamewelcome));
        
        p.setArticle(a);
        
        
        p.setQuantity(1);
        p.setPanier(panier);
        lp.AjouterDansTableligne_Panier(p);
//        System.out.println(p +"-----------------------------------------------------");
        
        
        
        
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLafficher.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    
    }

    @FXML
    private void rating(ActionEvent event) {
     rate.setRating(stars.getRating());
     ra.updateRating(rate);
    }
    

    
}
