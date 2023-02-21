/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Artiste;
import Models.Evenement;
import Service.EvenementService;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EvenementController implements Initializable {
    
    EvenementService Es = new EvenementService();

    @FXML
    private TextField name;
    @FXML
    private TextField date;
    @FXML
    private TextField start_hour;
    @FXML
    private TextField finish_hour;
    @FXML
    private TextField capacity;
    @FXML
    private TextField description;
    @FXML
    private Button image;
    @FXML
    private TextField location;
    @FXML
    private TextField imagee;
    @FXML
    private TextField artiste;
     
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enregistrer(ActionEvent event) {
        
        Evenement e = new Evenement();
        Artiste a = new Artiste();
         e.setName(name.getText());
        e.setDate(date.getText());
        e.setStart_hour(start_hour.getText());
        e.setFinish_hour(finish_hour.getText());
        e.setCapacity(capacity.getText());
        e.setDescription(description.getText());
        e.setImage(imagee.getText());
        e.setLocation(location.getText());
        a.setId_artiste(Integer.parseInt(artiste.getText()));
         e.setArtiste(a);
        
        Es.addEvenement(e);
    }

    @FXML
    private void image(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("image Files"," *.png"));
                File selectedFile = fc.showOpenDialog(null);
                if(selectedFile !=null){
        imagee.setText(selectedFile.getAbsolutePath());
        
    
                    }
                else{
                        System.out.println("Image invaides");
                        
                        }
                
        
        
    }
    @FXML
    private void afficher(ActionEvent event) {}
    @FXML
     private void modifier(ActionEvent event) {}

    
    
}
