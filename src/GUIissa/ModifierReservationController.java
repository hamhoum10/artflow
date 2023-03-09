/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIissa;

import interfaces.ClientInterface;
import models.Artiste;
import models.Reservation;
import services.ClientService;
import services.ReservationService;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ModifierReservationController implements Initializable {
    ReservationService Rs = new ReservationService();
    Reservation r=new Reservation();
    @FXML
    private TextField nb_place;
    @FXML
    private TextField price;
    @FXML
    private ComboBox<String> client;
    ObservableList list = FXCollections.observableArrayList();
    // ReservationService Rs = new ReservationService()
    ClientInterface ci = new ClientService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
    }  
    
    void getEvent(Reservation r){
//            Nom.setText(e.getNom_event());
//            lieu.setText(e.getLieu_event());
//            type.setText(e.getType_event());
//            dated.setValue(e.getDate_debut().toLocalDate());
//         datef.setValue(e.getDate_fin().toLocalDate());
//            prix.setText(e.getPrix().toString());

           //name.setText(e.getName());
        
          // a.setId_artiste(Integer.parseInt(artiste.getText()));
          
          nb_place.setText(Integer.toString(r.getNb_place()));
          
        // price.setText(Double.toString(r.getPrice()));
 


//          
    }

  
    @FXML
    private void modifier(ActionEvent event) {
        try {
            Reservation a = new Reservation();
            //a.setNb_place(Integer.parseInt(nb_place.getText()));
            a.setNb_place(Integer.parseInt(nb_place.getText()));
           // a.setPrice(Double.parseDouble(price.getText()));
          //  a.setClient(ci.fetchClientByName(client.getValue().toString()));
         // a.setEvent(Integer.parseInt(id_event.getText()));
            
            Rs. modReservation(a);
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./View_Reservatiob.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
                 
         
         
        
    }
    
    

    @FXML
    private void nb_place(ActionEvent event) {
    }

    @FXML
    private void price(ActionEvent event) {
    }

    @FXML
    private void client(ActionEvent event) {
        //r.setClient(ci.fetchClientByName(client.getValue()));
    }
     
    
    
}
