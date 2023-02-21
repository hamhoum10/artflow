/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.EnchereParticipantInterface;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Enchere;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class ModifyEnchereController implements Initializable {
    EnchereParticipantInterface es = new EnchereService();

    Enchere e;
    @FXML
    private TextField titre;
    @FXML
    private TextField desc;
    @FXML
    private TextField prixDepart;
    @FXML
    private DatePicker dateLimite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    public void getEnchere(Enchere e){
        titre.setText(e.getTitre());
        desc.setText(e.getDescription());
        prixDepart.setText(String.valueOf(e.getPrixdepart()));
        dateLimite.setValue(e.getDate_limite().toLocalDate());
        
    }
    
    
    @FXML
    private void modifyEnchere(ActionEvent event) {
        try {
        e.setTitre(titre.getText());
        e.setDescription(desc.getText());
        e.setPrixdepart(Integer.parseInt(prixDepart.getText()));
        LocalDate date = dateLimite.getValue();
        e.setDate_limite(java.sql.Date.valueOf(date));
        
        es.updateEnchere(e);
        
FXMLLoader loader= new FXMLLoader(getClass().getResource("./AfficherEnchere.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifyEnchereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
