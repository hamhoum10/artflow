/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevArtiste;

import models.Admin;
import models.Artiste;
import services.ArtisteService;
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
import pidevAdmin.DisplayAdminController;
import pidevAdmin.UpdateAdminController;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class DisplayArtisteController implements Initializable {
    
    ArtisteService artiste= new ArtisteService();
    
    @FXML
    private ListView<Artiste> artistelist;
    @FXML
    private Button displayArtiste;
    @FXML
    private Button updateartiste;
    @FXML
    private Button deleteartiste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   

    @FXML
    private void displayArtiste(ActionEvent event) {
        
         ObservableList<Artiste> e= FXCollections.observableArrayList(artiste.fetchArtiste());
        artistelist.setItems(e);
 }

    @FXML
    private void updateartiste(ActionEvent event) {
//         FXMLLoader loader;
//
//    try {
//        Artiste selectedArtiste=artistelist.getSelectionModel().getSelectedItem();
//        
//        
//        loader= new FXMLLoader(getClass().getResource("UpdateArtiste.fxml"));
//        Parent view_2=loader.load();
//       UpdateArtisteController UpdateArtisteController=loader.getController();
//        UpdateArtisteController.getArtiste(selectedArtiste);
//        UpdateArtisteController.a=selectedArtiste;
//        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(view_2);
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException ex) {
//        Logger.getLogger(DisplayAdminController.class.getName()).log(Level.SEVERE, null, ex);
//    }
        
    }

    @FXML
    private void deleteartiste(ActionEvent event) {
//        int selectedId =artistelist.getSelectionModel().getSelectedItem().getId();
//    artiste.deleteArtiste(selectedId);
//    displayArtiste(event);
//        
    }
    
    
    
}
