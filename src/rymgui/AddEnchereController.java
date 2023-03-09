/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rymgui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Enchere;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class AddEnchereController implements Initializable {

       EnchereService es = new  EnchereService ();

    @FXML
    private TextField titre;
    @FXML
    private TextField desc;
    @FXML
    private DatePicker dateLimite;
    @FXML
    private TextField prixDepart;
    @FXML
    private Button submitButton;
    @FXML
    private Button image;
    @FXML
    private TextField imagefield;
    @FXML
    private ImageView image_view;

    private File selectedFile;
 @FXML
    private AnchorPane anchore;
    /**
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addEnchere(ActionEvent event) throws IOException {
LocalDate currentDate = LocalDate.now();
 LocalDate selectedDate = dateLimite.getValue();
    
        if (titre.getText().length() == 0||desc.getText().length() == 0|| dateLimite.getValue() == null ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText(" veuillez remplir tous les champs"+ "");
            alert.show();

        } 
        
       
        if (selectedDate.compareTo(currentDate) < 0) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Date sélectionnée invalide");
    alert.setContentText("La date sélectionnée doit être supérieure ou égale à la date actuelle.");
    alert.showAndWait();
}
        
//        else if(!prixDepart.getText().matches("\\d")){
//              Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("error");
//            alert.setHeaderText("input error !");
//            alert.setContentText("ce champs doit contenir des chiffres"+ "");
//            alert.show();
//          }
        
        
        // Vérifier que le prix est un nombre valide
    float prixf;
        try {
        prixf = Float.parseFloat(prixDepart.getText());
        if (prixf <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le prix doit être supérieur à zéro.");
            alert.showAndWait();
            return;
        } 
        
        else  {
            
        
        
     Enchere en = new Enchere();
    en.setTitre(titre.getText());
    en.setDescription(desc.getText());
    en.setPrixdepart(Double.parseDouble(prixDepart.getText()));
        LocalDate date = dateLimite.getValue();
    en.setDate_limite(java.sql.Date.valueOf(date));
    
    en.setImg(imagefield.getText());
    
    
//   String htdocsPath = "C:\\xampp\\htdocs\\img";
//                 File destinationFile = new File(htdocsPath + imagefield.getText());
//            if(selectedFile!=null){
//                try (InputStream in = new FileInputStream(selectedFile);
//                 OutputStream out = new FileOutputStream(destinationFile)) {
//                byte[] buf = new byte[8192];
//                int length;
//                while ((length = in.read(buf)) > 0) {
//                    out.write(buf, 0, length);
//                }
//                    System.out.println(en);
            es.AddEnchere(en);
            // return to the main 
//                FXMLLoader loader= new FXMLLoader(getClass().getResource("./AfficherEnchere.fxml"));
//                Parent view_2=loader.load();
//                Scene scene = new Scene(view_2);
//                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
            
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            }else{
//                System.out.println("selected file is null "+selectedFile);
//            }
//            
        }
    
    
    
    
    
    
   
    
 
    
    
    } catch (NumberFormatException e) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Erreur");
//        alert.setHeaderText(null);
//        alert.setContentText("Le prix doit être un nombre");
//        alert.showAndWait();
        return;
    }
   
    
     
               FXMLLoader loader= new FXMLLoader(getClass().getResource("./AfficherEnchere.fxml"));
               Parent view_2=loader.load();
               Scene scene = new Scene(view_2);
               Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
    
    
    
    }

    @FXML
    private void takeImage(ActionEvent event) throws IOException {
        
       FileChooser open=new FileChooser();
        Stage stage=(Stage)anchore.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null){
            String filename=file.getName();
            imagefield.setText(filename);
            Image img=new Image(file.toURI().toString());
            image_view.setImage(img);
             Path destDir;
           destDir = Paths.get("C:\\xampp\\htdocs\\img");
            Files.copy(file.toPath(),destDir.resolve(filename),StandardCopyOption.REPLACE_EXISTING);
        }
        

    }
    

    @FXML
    private void exitPage(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("./ShowAllItems.fxml"));
               Parent view_2=loader.load();
               Scene scene = new Scene(view_2);
               Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
    
    }

}

