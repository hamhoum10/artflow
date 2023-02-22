/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.EnchereParticipantInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
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
    @FXML
    private Button image;
    @FXML
    private ImageView image_view;
    @FXML
    private TextField imagefield;
        private File selectedFile;


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
       e.setTitre(titre.getText());
       e.setDescription(desc.getText());
       e.setPrixdepart(Double.parseDouble(prixDepart.getText()));
       LocalDate date = dateLimite.getValue();
       e.setDate_limite(java.sql.Date.valueOf(date));
       String htdocsPath = "";
       File destinationFile = new File(htdocsPath + imagefield.getText());
       if(selectedFile!=null){
           try (InputStream in = new FileInputStream(selectedFile);
                   OutputStream out = new FileOutputStream(destinationFile)) {
               byte[] buf = new byte[8192];
               int length;
               while ((length = in.read(buf)) > 0) {
                   out.write(buf, 0, length);
               }
               
               
               es.updateEnchere(e);
               
               FXMLLoader loader= new FXMLLoader(getClass().getResource("./AfficherEnchere.fxml"));
               Parent view_2=loader.load();
               Scene scene = new Scene(view_2);
               Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
               
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }
    }

    @FXML
    private void takeImage(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.JPG", "*.gif"));
          fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);
         if (selectedFile != null) {
                imagefield.setText(selectedFile.getName());
                 try {
                Image images = new Image("file:"+selectedFile.getPath().toString());
                image_view.setImage(images);
                System.out.println(selectedFile.getPath().toString());
        } catch (Exception ex) {
                     System.out.println(ex);
        }
                
            } 
        
        
        
    }


    
}
