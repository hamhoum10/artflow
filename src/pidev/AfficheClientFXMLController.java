/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import models.Client;
import services.ClientService;
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

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class AfficheClientFXMLController implements Initializable {

    ClientService client = new ClientService();
    
    @FXML
    private ListView<Client> listClient;
    @FXML
    private Button afficheClient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void AfficheClient(ActionEvent event) {
        ObservableList<Client> e= FXCollections.observableArrayList(client.fetchClient());
    listClient.setItems(e);
        
    }

    @FXML
    private void deleteClient(ActionEvent event) {
//        int selectedId =listClient.getSelectionModel().getSelectedItem().getId();
//    client.deleteClient(selectedId);
//    AfficheClient(event);
    }

    @FXML
    private void updateClient(ActionEvent event) {
         FXMLLoader loader;

    try {
        Client selectedClient=listClient.getSelectionModel().getSelectedItem();
        
        
        loader= new FXMLLoader(getClass().getResource("./UpdateClientFXML.fxml"));
        Parent view_2=loader.load();
       UpdateClientFXMLController UpdateClientFXMLController=loader.getController();
        UpdateClientFXMLController.getClient(selectedClient);
        UpdateClientFXMLController.c=selectedClient;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AfficheClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    
    
    
}
