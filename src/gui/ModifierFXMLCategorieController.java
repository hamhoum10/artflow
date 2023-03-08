/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.CategorieInterface;
import interfaces.StockInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Categorie;
import models.stock;
import services.CategorieService;
import services.StockService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class ModifierFXMLCategorieController implements Initializable {
    StockInterface st = new StockService(); 
        stock h = new stock();
        
        CategorieInterface V = new CategorieService();
      
       Categorie C = new Categorie();
    Categorie ca;
    @FXML
    private TextField name;
    @FXML
    private TextField des;
    private ComboBox<String> listq;
    ObservableList list = FXCollections.observableArrayList();
    private TextField nom_artiste;
    @FXML
    private Button exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
    }


    public void getCategorie(Categorie ca){
        System.out.println(ca.getName_categorie());
    name.setText(ca.getName_categorie());
    des.setText(ca.getDescription());
    
    
    }




    

    
    @FXML
    private void modifier_categorie(ActionEvent event) throws IOException  {
                ca.setDescription(des.getText());
                ca.setName_categorie(name.getText());
                V.ModifyCategorie(ca);
                
                
                 
             FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLAfficherCategorie.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
           

    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("FXMLAfficherCategorie.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
}
