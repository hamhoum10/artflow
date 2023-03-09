/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class descriptionController implements Initializable {

    @FXML
    private ImageView image_view;
    @FXML
    private Label datel;
    @FXML
    private Label title;
    @FXML
    private Label desc;
    @FXML
    private Label lastamount;
    @FXML
    private TextField mont;
    @FXML
    private Button downloadPDF;
    @FXML
    private ComboBox<?> titre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exit(ActionEvent event) {
    }

    @FXML
    private void addParticipation(ActionEvent event) {
    }

    @FXML
    private void downloadPDF(ActionEvent event) {
    }

    @FXML
    private void listeEnchere(ActionEvent event) {
    }
    
}
