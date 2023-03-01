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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
public class FXMLAjouteCategorieController implements Initializable {
    
    StockInterface st = new StockService(); 
        stock h = new stock();
        
        CategorieInterface V = new CategorieService();
      
       Categorie C = new Categorie();

    @FXML
    private Label name_categorie;
    @FXML
    private Label description;
    @FXML
    private Label choisir_stock;
    @FXML
    private ComboBox<String> stockkkkk;
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private TextField des;
    @FXML
    private TextField nom;
    @FXML
    private Button exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list.removeAll(list);
        System.out.println(st.fetchStock());
        st.fetchStock().stream().forEach(e->list.add(e.getName()));
        stockkkkk.getItems().addAll(list);
    }    


    @FXML
    private void ajouter_categorie(ActionEvent event) throws IOException {
       
        if (des.getText().length() == 0||nom.getText().length() == 0||stockkkkk.getValue().length() == 0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez remplir tous les champs"+ "");
            alert.show();

        } else{
        
        
        
        C.setDescription(des.getText());
        C.setName_categorie(nom.getText());
        
        V.addCategorie(C);}
        
        
         FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLAfficherCategorie.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    }

    @FXML
    private void List_stock(ActionEvent event) {
        C.setStock(st.fetchStockByName(stockkkkk.getValue()));
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLAfficherCategorie.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }

    
}
