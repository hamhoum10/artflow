/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIissa;

import interfaces.ArtisteInterface;
import models.Artiste;
import models.Evenement;
import services.ArtisteService;
import services.EvenementService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.sql.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class EvenementController implements Initializable {
    
    EvenementService Rs = new EvenementService();
     ArtisteInterface ci = new ArtisteService();
    

    @FXML
    private TextField name;
    
    @FXML
    private TextField start_hour;
    @FXML
    private TextField finish_hour;
    @FXML
    private TextField capacity;
    @FXML
    private TextField description;
    @FXML
    private TextField location;
    @FXML
    private TextField imagee;
    private ComboBox<String> artiste;
    ObservableList list = FXCollections.observableArrayList();
    
    @FXML
    private DatePicker date_evemt;
    @FXML
    private ImageView imageview;
     private File selectedFile;
    

    /**
     * Initializes the controller class.
     */
     
      Evenement e = new Evenement();
       // Artiste a = new Artiste();
    @FXML
    private TextField prix;
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
       // list.removeAll(list);
        //ci.fetchArtiste().stream().forEach(e->list.add(e.getFirstname()));
       // artiste.getItems().addAll(list);
        
        
        
    }    

    @FXML
    private void enregistrer(ActionEvent event) throws FileNotFoundException, IOException {
        
        
        
        LocalDate currentDate = LocalDate.now();
        LocalDate selectedDate = date_evemt.getValue();
        
       
        
       
                    if (selectedDate.compareTo(currentDate) < 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText("Date sélectionnée invalide");
                alert.setContentText("La date choisie doit être postérieure ou égale à la date d'aujourd'hui");
                alert.showAndWait();
            }
        
         if (name.getText().length()==0||
                // DatePicker.get
                 date_evemt.getValue()==null||
                 start_hour.getText().length()==0||
                 finish_hour.getText().length()==0||
                 capacity.getText().length()==0||
                 description.getText().length()==0||
                 capacity.getText().length()==0||
                 imagee.getText().length()==0||
                 location.getText().length()==0||
                  prix.getText().length()==0){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez  saisie tous les champs"+ "");
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
        
       
         e.setName(name.getText());
       // e.setDate(date.getText());
        LocalDate date = date_evemt.getValue();
        e.setDate_evemt(java.sql.Date.valueOf(date));
       
       // LocalDate date = date_evemt.getValue();
        
        e.setStart_hour(start_hour.getText());
        e.setFinish_hour(finish_hour.getText());
        e.setCapacity(capacity.getText());
        e.setDescription(description.getText());
        e.setImage(imagee.getText());
        e.setLocation(location.getText());
        e.setPrix(Double.parseDouble(prix.getText()));
        //a.setId_artiste(Integer.parseInt(artiste.getText()));
        // e.setArtiste(ci.fetchClientByName("Ayoub"));
         // e.setArtiste(ci.fetchClientByName("Ayoub"));
         String imagehtdocs =imagee.getText();
        
        
       // e.setId_artiste(1);
        String htdocsPath = "C:/xampp/htdocs/img/";
                 File destinationFile = new File(htdocsPath + imagee.getText());
            if(selectedFile!=null){
                try (InputStream in = new FileInputStream(selectedFile);
                 OutputStream out = new FileOutputStream(destinationFile)) {
                byte[] buf = new byte[8192];
                int length;
                while ((length = in.read(buf)) > 0) {
                    out.write(buf, 0, length);
                }
        
        Rs.addEvenement(e);
       
    }
            }
    }

    @FXML
    private void image(ActionEvent event) {
           FileChooser fileChooser = new FileChooser();
           
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.JPG", "*.gif"));
          fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);
         if (selectedFile != null) {
                imagee.setText(selectedFile.getName());
                 try {
                Image images = new Image("file:"+selectedFile.getPath().toString());
                imageview.setImage(images);
                System.out.println(selectedFile.getPath().toString());
        } catch (Exception ex) {
                     System.out.println(ex);
        }
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

    private void artiste(ActionEvent event) {
       // e.setArtiste(ci.fetchClientByName(artiste.getValue()));
    }

   
        
    
    }
    
    
    

