/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Reservation;
import Service.ReservationService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ReservationController implements Initializable {
    
    ReservationService Rs = new ReservationService();
    

    @FXML
    private TextField nb_place;
    @FXML
    private TextField price;
    @FXML
    private Text id_client;
    @FXML
    private TextField client;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valider(ActionEvent event) {
        Reservation r = new Reservation();
        
        r.setNb_place(Integer.parseInt(nb_place.getText()));
        r.setPrice(Double.parseDouble(price.getText()));
        r.setClient(Integer.parseInt(client.getText()));
        Rs.addReservation(r);
    }
    
}
