/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.ArticleInterface;
import interfaces.ArtisteInterface;
import interfaces.CategorieInterface;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Article;
import models.Categorie;
import services.ArticleService;
import services.ArtisteService;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXML1Controller implements Initializable {

    ArticleInterface ps = new ArticleService();
    CategorieInterface ci = new CategorieService();

    ArtisteInterface ui = new ArtisteService();
    Article p = new Article();
    Categorie c = new Categorie();
    Article a;
    @FXML
    private TextField name_article;
    @FXML
    private TextField description;
    @FXML
    private TextField price;
    @FXML
    private TextField type;
    @FXML
    private TextField quantity;
    @FXML
    private TextField image;
    @FXML
    private ComboBox<String> artiste;

    ObservableList list2 = FXCollections.observableArrayList();
    Article article = new Article();

    @FXML
    private ComboBox<String> categorie;
    ObservableList list1 = FXCollections.observableArrayList();

    private File selectedFile;
    @FXML
    private ImageView image_view;
    @FXML
    private AnchorPane anchore;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        image.setDisable(true);
        list1.removeAll(list1);
        list2.removeAll(list2);
        System.out.println(ci.fetchCategorie());
        ci.fetchCategorie().stream().forEach(e -> list1.add(e.getName_categorie()));
        categorie.getItems().addAll(list1);
        System.out.println(ui.fetchArtiste());
        ui.fetchArtiste().stream().forEach(e -> list2.add(e.getNom_artiste()));
        artiste.getItems().addAll(list2);
    }

    public void getArticlee(Article a) {
        name_article.setText(a.getNom_article());
        description.setText(a.getDescription());
        price.setText(String.valueOf(a.getPrice()));
        quantity.setText(String.valueOf(a.getQuantity()));
        image.setText(a.getImage());
        artiste.setValue(a.getArtiste().getNom_artiste());
        categorie.setValue(a.getCategorie().getName_categorie());
        type.setText(a.getType());
        File file=new File("C:\\xampp\\htdocs\\img\\"+a.getImage());
        Image img=new Image(file.toURI().toString());
        image_view.setImage(img);
    }

    @FXML
    private void import_image(ActionEvent event) throws IOException {
        FileChooser open=new FileChooser();
        Stage stage=(Stage)anchore.getScene().getWindow();
        File file=open.showOpenDialog(stage);
        if(file!=null){
            String filename=file.getName();
            image.setText(filename);
            Image img=new Image(file.toURI().toString());
            image_view.setImage(img);
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
            String dest = "C:\\xampp\\htdocs\\img\\" + selectedFile.getName();
            Path tmp = Files.move(Paths.get(src), Paths.get(dest));
            a.setImage("/img/" + selectedFile.getName());
//            image.setText(selectedFile.getName());
//                image.setText(selectedFile.getName());
//                 try {
//                Image images = new Image("file:"+selectedFile.getPath().toString());
//                image_view.setImage(images);
//                System.out.println(selectedFile.getPath().toString());
//        } catch (Exception ex) {
//                     System.out.println(ex);
//        }
        }*/
    }

    @FXML
    private void ModifyArticle(ActionEvent event) throws IOException {
        a.setNom_article(name_article.getText());
        a.setDescription(description.getText());
        a.setType(type.getText());
//        a.setImage(image.getText());
        a.setPrice(Double.parseDouble(price.getText()));
        String art = artiste.getValue();
        String cat = categorie.getValue();
        a.setQuantity(Integer.parseInt(quantity.getText()));
        a.setArtiste(ui.fetchArtisteByName(artiste.getValue()));
        a.setCategorie(ci.fetchCategorieByName(categorie.getValue()));
        a.setImage(image.getText());
//        String htdocsPath = "C:/xampp/htdocs/img/";
//                 File destinationFile = new File(htdocsPath + image.getText());
//            if(selectedFile!=null){
//                try (InputStream in = new FileInputStream(selectedFile);
//                 OutputStream out = new FileOutputStream(destinationFile)) {
//                byte[] buf = new byte[8192];
//                int length;
//                while ((length = in.read(buf)) > 0) {
//                    out.write(buf, 0, length);
//                }
        ps.ModifyArticle(a);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXMLafficher.fxml"));
        Parent view_2 = loader.load();
        Scene scene = new Scene(view_2);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

//       
//          catch (IOException ex) {
//            Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void setartiste(ActionEvent event) {
        p.setArtiste(ui.fetchArtisteByName(artiste.getValue()));

    }

    @FXML
    private void setcat(ActionEvent event) {
        p.setCategorie(ci.fetchCategorieByName(categorie.getValue()));

    }

    @FXML
    private void exit(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("./FXMLafficher.fxml"));
        Parent view_2 = loader.load();
        Scene scene = new Scene(view_2);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    void setArticle(Article a) {
        name_article.setText(a.getNom_article());
        description.setText(a.getDescription());
        price.setText(String.valueOf(a.getPrice()));
        quantity.setText(String.valueOf(a.getQuantity()));
        image.setText(a.getImage());
        artiste.setValue(a.getArtiste().getNom_artiste());
        categorie.setValue(a.getCategorie().getName_categorie());
        type.setText(a.getType());
        this.a = a;
    }

}
