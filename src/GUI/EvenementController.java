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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
         if (name.getText().length()==0||
                 date.getText().length()==0||
                 start_hour.getText().length()==0||
                 finish_hour.getText().length()==0||
                 capacity.getText().length()==0||
                 description.getText().length()==0||
                 capacity.getText().length()==0||
                 image.getText().length()==0||
                 location.getText().length()==0){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez  remplir tous les champs"+ "");
            alert.show();
            return;
    }
        // Vérifier que le prix est un nombre valide
//    float prixf;
//        try {
//        prixf = Float.parseFloat(prix.getText());
//        if (prixf <= 0) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Erreur");
//            alert.setHeaderText(null);
//            alert.setContentText("L'evenement doit être supérieur à zéro.");
//            alert.showAndWait();
//            return;
//        }
//    } catch (NumberFormatException e) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Erreur");
//        alert.setHeaderText(null);
//        alert.setContentText("Le prix doit être un nombre");
//        alert.showAndWait();
//        return;
//    }
        
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
    private void afficher(ActionEvent event) {
      
        try {
            //bonPlanService.update(bonPlanService.readById(selectedId));
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./View_Evemt.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
        
    
    }
    
    
    

