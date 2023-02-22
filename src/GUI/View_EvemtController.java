/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Evenement;
import Service.EvenementService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
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

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class View_EvemtController implements Initializable {
    EvenementService Es = new EvenementService();

    @FXML
    private ListView<Evenement> affiche;
    @FXML
    private Button BOUTTONMOD;

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
    
     @FXML
    private void modifier(ActionEvent event) throws IOException {
                  try {
               Evenement selectedEvent=affiche.getSelectionModel().getSelectedItem();
                FXMLLoader loader= new FXMLLoader(getClass().getResource("./ModifiEvemt.fxml"));
                Parent view_2=loader.load();
                ModifiEvemtController ModifierEventController=loader.getController();
        ModifierEventController.getEvent(selectedEvent);
        ModifierEventController.e=selectedEvent;
                Scene scene = new Scene(view_2);
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(View_ReservatiobController.class.getName()).log(Level.SEVERE, null, ex);
            }


        
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int selectedId= affiche.getSelectionModel().getSelectedItem().getId();
        Es.suppEvenement(selectedId);
        aff(event);
        
    }
    }
    

