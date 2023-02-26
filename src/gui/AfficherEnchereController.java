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
import models.Enchere;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class AfficherEnchereController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    EnchereService es = new EnchereService();
    @FXML
    private ListView<Enchere> listEnchere;
    @FXML
    private Button id_afficher;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
// TODO




    }    

    @FXML
    private void afficherEnchere(ActionEvent event) {
    
 
    ObservableList<Enchere> e= FXCollections.observableArrayList(es.fetchEnchere());
    listEnchere.setItems(e);
    }

    @FXML
    private void deleteEnchere(ActionEvent event) {
        
    
    int selectedId =listEnchere.getSelectionModel().getSelectedItem().getIde();
    es.deleteEnchere(selectedId);
    afficherEnchere(event);
    
    }
    

    @FXML
    private void addEnchere(ActionEvent event) throws IOException {
    
      FXMLLoader loader= new FXMLLoader(getClass().getResource("./addEnchere.fxml"));
               Parent view_2=loader.load();
               Scene scene = new Scene(view_2);
               Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
    
    }
    
   
    
    
      @FXML
    private void modifyEnch(ActionEvent event) throws IOException {
    
    try {
        Enchere selectedarticle=listEnchere.getSelectionModel().getSelectedItem();
        
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./modif.fxml"));
        Parent view_2=loader.load();
        ModifController ModifController=loader.getController();
        ModifController.getEnchere(selectedarticle);
        ModifController.e=selectedarticle;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AfficherEnchereController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }

  
    
    
    
    
    
    
    }
    
    
    
    
    

