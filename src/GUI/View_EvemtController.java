/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Evenement;
import Service.EvenementService;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class View_EvemtController implements Initializable {
    EvenementService Es = new EvenementService();

    @FXML
    private ListView<Evenement> affiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
   
    
     @FXML
    void aff(ActionEvent event) {
         ObservableList<Evenement> e =FXCollections.observableArrayList(Es.fetchEvenements());
        
        affiche.setItems(e);
    }
    }
    

