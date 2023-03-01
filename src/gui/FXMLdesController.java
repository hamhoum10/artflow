/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Article;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLdesController implements Initializable {

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
        type.setText(article.getType());
        Artiste.setText(article.getArtiste().getNom_artiste());
        quantity.setText(String.valueOf(article.getQuantity()));
        
}
    
    @FXML
    private void ajouter_panner(ActionEvent event) {
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
    

    
}