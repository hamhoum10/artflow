/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.ArticleInterface;
import interfaces.ArtisteInterface;
import interfaces.CategorieInterface;
import interfaces.ClientInterface;
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.Article;
import models.Categorie;
import models.Client;
import services.ArticleService;
import services.ArtisteService;
import services.CategorieService;
import services.ClientService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLController implements Initializable {
    //var
    ArticleInterface ps = new ArticleService();
    CategorieInterface ci = new CategorieService();
    
    ArtisteInterface ui = new ArtisteService();
          Article  p = new Article();
      Categorie c = new Categorie();
    //widgets 

    @FXML
    private TextField name_article;
    @FXML
    private TextField description;
    @FXML
    private TextField type;
    @FXML
    private TextField price;
    @FXML
    private TextField image;
    @FXML
    private AnchorPane name_categorie;
    @FXML
    private ComboBox<String> categorie;
    ObservableList list1 = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> artiste;
    @FXML
    private TextField quantity;
    @FXML
    private ImageView image_view;
    private File selectedFile;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        image.setDisable(true);
        
        list1.removeAll(list1);
        list2.removeAll(list2);
        System.out.println(ci.fetchCategorie());
        ci.fetchCategorie().stream().forEach(e->list1.add(e.getName_categorie()));
        categorie.getItems().addAll(list1);
        System.out.println(ui.fetchArtiste());
        ui.fetchArtiste().stream().forEach(e->list2.add(e.getNom_artiste()));
        artiste.getItems().addAll(list2);
        
//        ui.fetchArtiste().stream().forEach(e->System.out.println(e.toString()));
           
    }    

    @FXML
    private void ajoute_article(ActionEvent event) throws IOException {

       if (name_article.getText().length() == 0||description.getText().length() == 0||type.getText().length() == 0||price.getText().length() == 0||image.getText().length() == 0||quantity.getText().length() == 0||categorie.getValue().length() == 0||artiste.getValue().length() == 0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez remplir tous les champs  "+ "");
            alert.show();

        }  else if( !price.getText().matches("\\d+")){
                   
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Le price doit être un nombre "+ "");
            alert.show();
             
        
        } else if(  !quantity.getText().matches("\\d+")){
                   
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("quantity doit être un nombre "+ "");
            alert.show();
             
        
        }else{
        
        
        p.setNom_article(name_article.getText());
        //System.out.println(p);

        p.setType(type.getText());
                //System.out.println(p);

        p.setDescription(description.getText());
                //System.out.println(p);

        p.setPrice(Double.parseDouble(price.getText()));
                //System.out.println(p);
        p.setQuantity(Integer.parseInt(quantity.getText()));
        p.setImage(image.getText());
        
        ps.addArticle(p);}
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLafficher.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
//        } catch (IOException ex) {
//            Logger.getLogger(Ajout_GarageController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        c.setName_categorie(name_categorie.getText());
//System.out.println(p);
    }

    @FXML
    private void ImportImage(ActionEvent event) throws IOException {
        FileChooser open=new FileChooser();
        Stage stage=(Stage)name_categorie.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null){
            String filename=file.getName();
            image.setText(filename);
            Image img=new Image(file.toURI().toString());
            image_view.setImage(img);
            Path destDir=Paths.get("C:\\xampp\\htdocs\\img");
            Files.copy(file.toPath(),destDir.resolve(filename),StandardCopyOption.REPLACE_EXISTING);
        }
        /*
        
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.JPG", "*.gif"));
          fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);
         if (selectedFile != null) {
                String src = selectedFile.getPath();
                String dest = "C:\\Users\\MediaStudio\\Documents\\NetBeansProjects\\Project_malek\\src\\img\\"+selectedFile.getName();
                Path tmp = Files.move(Paths.get(src), Paths.get(dest));
                p.setImage("/img/"+selectedFile.getName());
                image.setText(selectedFile.getName());
                 try {
                Image images = new Image("file:"+selectedFile.getPath().toString());
                image_view.setImage(images);
                System.out.println(selectedFile.getPath().toString());
        } catch (Exception ex) {
                     System.out.println(ex);
        }
                
            }
//         FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open File");
//        
//        // Set the initial directory of the file chooser dialog
//        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
//        
//        // Add filters to the file chooser dialog
//        fileChooser.getExtensionFilters().addAll(
//            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
//            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//            new FileChooser.ExtensionFilter("All Files", "*.*")
//        );
//        
//        // Show the file chooser dialog
//        File selectedFile = fileChooser.showOpenDialog(primaryStage);
//        
//        if (selectedFile != null) {
//            // Do something with the selected file
//            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//        }*/
    
    }

    @FXML
    private void setCat(ActionEvent event) {
        p.setCategorie(ci.fetchCategorieByName(categorie.getValue()));
    }

    

    @FXML
    private void setartiste(ActionEvent event) {
        p.setArtiste(ui.fetchArtisteByName(artiste.getValue()));
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
          FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLafficher.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    

}
}
    

