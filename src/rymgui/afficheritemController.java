/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rymgui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Enchere;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class afficheritemController implements Initializable {

    EnchereService es = new EnchereService();
    private List<Enchere> enchere;
    @FXML
    private TextField car;
    @FXML
    private TextField prix_max;
    @FXML
    private TextField prix_min;
    @FXML
    private GridPane enchereGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherEnchere();
        // TODO
    }    
    
    
    public void afficherEnchere() {
    enchereGrid.getChildren().clear();
        enchere = es.fetchEnchere();
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<enchere.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("./gui/EnchereItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
           EnchereItemController itemController = fxmlLoader.getController();
            itemController.setData(enchere.get(i));
            
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            enchereGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(afficheritemController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
}
    
    
//
//    @FXML
//    private void ajouterArticle(ActionEvent event) {
//    }
//
//    @FXML
//    private void rechercheprix(MouseEvent event) {
//    }

    
}
