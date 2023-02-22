/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Client;
import models.Enchere;
import models.Participant;
import services.ClientService;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class ParticipationController implements Initializable {
     
    EnchereService es = new  EnchereService ();
    ClientService c = new ClientService();
    Enchere en = new Enchere();
    Participant p = new Participant();
    
    @FXML
    private TextField mont;
    @FXML
    private Label iden;
    @FXML
    private ComboBox<String> titre;
    
    ObservableList list1 = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> nom_client;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list1.removeAll(list1);
        list2.removeAll(list2);
        es.fetchEnchere().stream().forEach(e->list1.add(e.getTitre()));
        titre.getItems().addAll(list1);
        c.fetchClient().stream().forEach(e->list2.add(e.getNom()));
        nom_client.getItems().addAll(list2);
    }    

    @FXML
    private void addParticipation(ActionEvent event) {
        p.setMontant(Double.parseDouble(mont.getText()));
        es.addParticipant(p);
        
        
    }

    @FXML
    private void listeEnchere(ActionEvent event) {
        p.setEnchere(es.fetchEnchereByname(titre.getValue()));
        
    }

    @FXML
    private void listeClient(ActionEvent event) {
        p.setClient(c.fetchClientByName(nom_client.getValue()));
    }
    
}
