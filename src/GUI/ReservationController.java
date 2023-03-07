/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.ClientInterface;
import Models.Evenement;
import Models.Reservation;
import Service.ClientService;
import Service.ReservationService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ReservationController implements Initializable {
    
    ReservationService Rs = new ReservationService();
    ClientInterface ci = new ClientService();
    

    @FXML
    private TextField nb_place;
   // private TextField Dateres;
    
    //private TextField price;
    private ComboBox<String> client;
    
    
    
    
        ObservableList list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
            Reservation r = new Reservation();
           
    private TextField name;
    @FXML
    private Label nameid;
    @FXML
    private Label descriptionid;
    @FXML
    private Label prixid;
    @FXML
    private Label start_hourid;
    @FXML
    private Label finish_hourid;
    @FXML
    private Label locationid;
    @FXML
    private Label capacityid;
    @FXML
    private Label imageid;
    @FXML
    private Label dateid;
    @FXML
    private Label totalprix;
    @FXML
    private DatePicker dateres;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         nameid.setText(ListeReservationController.name);
        descriptionid.setText(ListeReservationController.description);
        prixid.setText(String.valueOf(ListeReservationController.prix));
       start_hourid.setText(ListeReservationController.start_hour);
       finish_hourid.setText(ListeReservationController.finish_hour);
       locationid.setText(ListeReservationController.location);
       capacityid.setText(ListeReservationController.capacity);
       imageid.setText(ListeReservationController.image);
       dateid.setText(String.valueOf(ListeReservationController.datesta));
       //totalprix.setText(String.valueOf((Rs.totalMontalReservation(7))));
      // r.setClient(ci.fetchClientByName(client.getValue().toString()));
       nb_place.getText();
        // TODO
               // total.setText();
        
        list.removeAll(list);
        
        ci.fetchClients().stream().forEach(e->list.add(e.getFirstname()));
        //client.getItems().addAll(list);
    }    

    @FXML
    private void valider(ActionEvent event) {
        
        int nb_place1 = Integer.valueOf(nb_place.getText()) ;
        //String prixtoootalst=totalprix.getText();
       // int prixtootal= (int)prixtoootalst;
       
            //Reservation m1 = new Reservation(nb_place1, Rs.totalMontalReservation(7) , , name);
            
        LocalDate currentDate = LocalDate.now();
        LocalDate selectedDate = dateres.getValue();
        
       
        
       
                    if (selectedDate.compareTo(currentDate) < 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Date sélectionnée invalide");
                alert.setContentText("La date sélectionnée doit être supérieure ou égale à la date actuelle.");
                alert.showAndWait();
            }
        
         if (nb_place.getText().length()==0||   dateres.getValue()==null){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez  remplir tous les champs"+ "");
            alert.show();
            return;
    }else{
        
//        r.setNb_place(Integer.parseInt(nb_place.getText()));
//        LocalDate date = dateres.getValue();
//        r.setDateres(java.sql.Date.valueOf(date));
       // r.setPrice(Double.parseDouble(price.getText()));
        //on a ajoute ce code pour modifier
      //  r.setClient(ci.fetchClientByName(client.getValue().toString()));
      LocalDate date = dateres.getValue();
      r.setDateres(java.sql.Date.valueOf(date));
      Evenement e = new Evenement();
      e.setId(60);
      String nb1=nb_place.getText();
      int nb2=  Integer.valueOf(nb1);
      
      r.setEvent(e);
      r.setNb_place(nb2);
      r.setId_client(7);
      Rs.addReservation(r);
      totalprix.setText(String.valueOf((Rs.totalMontalReservation(7))));
     // r.setEvent();
        System.out.println(r);
        
         }
    }

    @FXML
    private void afficher(ActionEvent event) {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./View_Reservatiob.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();     
        } catch (IOException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void client(ActionEvent event) {
      //  r.setClient(ci.fetchClientByName(client.getValue()));
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("./ListeReservation.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }
    
}
