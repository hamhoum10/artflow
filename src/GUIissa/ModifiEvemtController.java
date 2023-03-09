/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIissa;

import interfaces.ArtisteInterface;
import interfaces.EvenementInterface;
import models.Artiste;
import models.Evenement;
import services.EvenementService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import services.ArtisteService;
import models.Artiste;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import pidevAuthArtiste.LoginArtisteController;



/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ModifiEvemtController implements Initializable {
    EvenementService Es = new EvenementService();

    @FXML
    private TextField name;
  
    @FXML
    private TextField start_hour;
    @FXML
    private TextField finish_hour;
    @FXML
    private TextField capacity;
    @FXML
    private TextField location;
    private TextField image;
    @FXML
    private TextField description;
    @FXML
    private TextField imagee;
    Evenement e ;
    
    @FXML
    private DatePicker date_evemt;
    @FXML
    private ComboBox<String> artiste;
    ObservableList list = FXCollections.observableArrayList();
    
    ArtisteService ci = new ArtisteService();
    Evenement r = new Evenement();
    @FXML
    private TextField prix;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 
    
     void getEvent(Evenement e){
//            Nom.setText(e.getNom_event());
//            lieu.setText(e.getLieu_event());
//            type.setText(e.getType_event());
//            dated.setValue(e.getDate_debut().toLocalDate());
//         datef.setValue(e.getDate_fin().toLocalDate());
//            prix.setText(e.getPrix().toString());

           name.setText(e.getName());
           date_evemt.setValue(e.getDate_evemt().toLocalDate());
           
         
           start_hour.setText(e.getStart_hour());
           finish_hour.setText(e.getFinish_hour());
           capacity.setText(e.getCapacity());
           description.setText(e.getDescription());
           imagee.setText(e.getImage());
           location.setText(e.getLocation());
           prix.setText(Double.toString(e.getPrix()));
           
           
        }

    @FXML
    private void modifier(ActionEvent event) {
     //  ArtisteSerice Z = new ArtisteSerice();
       Artiste P = new Artiste();
       

        
       
        try {
            e.setName(name.getText());
             LocalDate date = date_evemt.getValue();
           e.setDate_evemt(java.sql.Date.valueOf(date));
           // e.setDate(date.getText());
            e.setStart_hour(start_hour.getText());
            e.setFinish_hour(finish_hour.getText());
            e.setCapacity(capacity.getText());
            e.setDescription(description.getText());
            e.setImage(imagee.getText());
            e.setLocation(location.getText());
            e.setPrix(Double.parseDouble(prix.getText()));
           
           //e.setId_artiste(P); 
           //e.setId_artiste(1);
            //a.setId_artiste(Integer.parseInt(artiste.getText()));
            //a.setId(Integer.parseInt(evemt.getText()));
             e.setId(19);
            
            Es.modEvenement(e);
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./View_Evemt.fxml"));
            Parent view_2=loader.load();
            Scene scene = new Scene(view_2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifiEvemtController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
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
    private void artiste(ActionEvent event) {
    }

    
           
    
}
