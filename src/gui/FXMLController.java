/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Enchere;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class FXMLController implements Initializable {

       EnchereService es = new  EnchereService ();

    @FXML
    private TextField titre;
    @FXML
    private TextField desc;
    @FXML
    private DatePicker dateLimite;
    @FXML
    private TextField prixDepart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add_enchere(ActionEvent event) {
    
     Enchere en = new Enchere();
    en.setTitre(titre.getText());
    en.setDescription(desc.getText());
    en.setPrixdepart(Double.parseDouble(prixDepart.getText()));
        LocalDate date = dateLimite.getValue();
    en.setDate_limite(java.sql.Date.valueOf(date));
    es.AddEnchere(en);
    
    }
   
    
    
    
    
    
    
    
}
