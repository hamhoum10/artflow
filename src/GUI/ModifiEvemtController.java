/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.EvenementInterface;
import Models.Artiste;
import Models.Evenement;
import Service.EvenementService;
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
    private TextField date;
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
    @FXML
    private TextField id;
    @FXML
    private TextField evemt;
    Evenement e ;
   

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
           date.setText(e.getDate());
           start_hour.setText(e.getStart_hour());
           finish_hour.setText(e.getFinish_hour());
           capacity.setText(e.getCapacity());
           description.setText(e.getDescription());
           imagee.setText(e.getImage());
           location.setText(e.getLocation());
           
           
        }

    @FXML
    private void modifier(ActionEvent event) {

        
       
        try {
            e.setName(name.getText());
            e.setDate(date.getText());
            e.setStart_hour(start_hour.getText());
            e.setFinish_hour(finish_hour.getText());
            e.setCapacity(capacity.getText());
            e.setDescription(description.getText());
            e.setImage(imagee.getText());
            e.setLocation(location.getText());
            //a.setId_artiste(Integer.parseInt(artiste.getText()));
            //a.setId_artiste(Integer.parseInt(artiste.getText()));
            //a.setId(Integer.parseInt(evemt.getText()));
            // e.setArtiste(a);
            
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
           
    
}
