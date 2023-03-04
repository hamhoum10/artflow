/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.ClientInterface;
import Models.Reservation;
import Service.ClientService;
import Service.ReservationService;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    @FXML
    private TextField price;
    @FXML
    private Text id_client;
    @FXML
    private ComboBox<String> client;
    
    
    
    
        ObservableList list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
            Reservation r = new Reservation();
    @FXML
    private TextField name;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list.removeAll(list);
        
        ci.fetchClients().stream().forEach(e->list.add(e.getFirstname()));
        client.getItems().addAll(list);
    }    

    @FXML
    private void valider(ActionEvent event) {
         if (nb_place.getText().length()==0||
                 
                 price.getText().length()==0||
                  name.getText().length()==0)
                    
         {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez  remplir tous les champs"+ "");
            alert.show();
            return;
    }
        
        r.setNb_place(Integer.parseInt(nb_place.getText()));
        r.setPrice(Double.parseDouble(price.getText()));
        //on a ajoute ce code pour modifier
        r.setClient(ci.fetchClientByName(client.getValue().toString()));
        System.out.println(r);
        Rs.addReservation(r);
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

    @FXML
    private void client(ActionEvent event) {
        r.setClient(ci.fetchClientByName(client.getValue()));
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
