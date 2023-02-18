/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.Article;
import services.ArticleService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLController implements Initializable {
    //var
    ArticleService ps = new ArticleService();
    //widgets 

    @FXML
    private TextField name;
    @FXML
    private TextField prenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insertpersonne(ActionEvent event) {
      Article  p = new Article();
        p.setNom_article(name.getText());
        ps.addArticle(p);
    }
    
}
