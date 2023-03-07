/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Evenement;
import Models.Reservation;
import Service.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class View_ReservatiobController implements Initializable {
    ReservationService  Rs = new ReservationService() ;
    Reservation r=new Reservation();
    
    private List<Reservation> listres;
    
    @FXML
    private ListView<Reservation> afficheres;
    
    @FXML
    ObservableList<Reservation > e;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         //ObservableList<Reservation > e =FXCollections.observableArrayList();
        
         //afficheres.setItems(e);
          listres=Rs.fetchReservations(44);
        e =  FXCollections.observableArrayList(listres);
        afficheres.setItems(e);
    }    

    private void afficher(ActionEvent event) {
        
         //ObservableList<Reservation > e =FXCollections.observableArrayList();
         listres=Rs.fetchReservations(44);
        e =  FXCollections.observableArrayList(listres);
        afficheres.setItems(e);
        //afficheres.setItems(e);
    }

    private void modifier(ActionEvent event) {
        
         try {
             Reservation selectedEvent=afficheres.getSelectionModel().getSelectedItem();
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./ModifierReservation.fxml"));
            Parent view_2=loader.load();
            ModifierReservationController ModifierEventController=loader.getController();
        ModifierEventController.getEvent(selectedEvent);
        ModifierEventController.r=selectedEvent;

            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();     
        } catch (IOException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    @FXML
    private void supprimer(ActionEvent event) {
         int selectedId= afficheres.getSelectionModel().getSelectedItem().getId();
        Rs.suppReservation(selectedId);
        afficher(event);
        
        
       
    
    }

    @FXML
    private void reour(ActionEvent event) throws IOException {
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./Reservation.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }
    
}
