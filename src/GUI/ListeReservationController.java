/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Evenement;
import Service.ArtisteSerice;
import Service.EvenementService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ListeReservationController implements Initializable {
    EvenementService Es = new EvenementService();
    ArtisteSerice Ar = new ArtisteSerice();
    @FXML
    private ListView<Evenement> affiche;
    
    public static Date datesta;
    public static String description;
    public static String finish_hour;
     public static String start_hour;
    public static String location;
    public static String capacity;
   public  static String image;
   public  static String name;
   public  static int id_artiste;
    public static Double prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Evenement> ev =Es.fetchEvenements();
        // TODO
          ObservableList<Evenement> e =FXCollections.observableArrayList(ev);
          
       
        affiche.setItems(e);   
        affiche.setCellFactory(param -> new ListCell<Evenement>() {
            private final ImageView imageViewEvenement = new ImageView();
            
            @Override
            protected void updateItem(Evenement item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    /*buttonDelete.setOnAction(event -> {
                        //int index = getIndex();
                        //if (index >= 0 && index < listView.getItems().size()) {}
                        //System.out.println(e.indexOf(getItem().getId_panier()));
                        //System.out.println(listView.getItems().indexOf(getItem()));
                        deleteLignePanierAction(event);
                        listView.getItems().indexOf(getItem());
                        ShowcartAction(event);
                    });
                    buttonPlus.setOnAction(event -> {
                        addOnetoarticleAction(event);
                        listView.getItems().remove(getItem());
                        ShowcartAction(event);
                    });
                    buttonMinus.setOnAction(event -> {
                        minusOnetoarticleAction(event);
                        listView.getItems().remove(getItem());
                        ShowcartAction(event);
                    });*/
                    File file=new File("C:\\xampp\\htdocs\\img\\"+item.getImage());
                   
                     Image img=new Image(file.toURI().toString());
                    imageViewEvenement.setFitHeight(200);
                    imageViewEvenement.setFitWidth(200);
                    imageViewEvenement.setImage(img);

                    //tostring
                    Label contenu =new Label(item.toString());
                    contenu.setStyle("-fx-font-family: Arial; -fx-font-size: 16;");

                    //BORDERPANE
                    BorderPane borderPane = new BorderPane();
                    borderPane.setCenter(contenu);

                    //contenu el ToString()
                    HBox centerBox = new HBox(contenu);
                    centerBox.setAlignment(Pos.CENTER_LEFT);
                    centerBox.setSpacing(5);
                    borderPane.setCenter(centerBox);
                    /*
                    //button delete
                    HBox bottomRightBox = new HBox(buttonDelete);
                    bottomRightBox.setAlignment(Pos.BOTTOM_RIGHT);
                    bottomRightBox.setSpacing(50);
                    borderPane.setRight(bottomRightBox);
                    //button + et -
                    HBox bottomLeftBox = new HBox(buttonPlus, buttonMinus);
                    bottomLeftBox.setAlignment(Pos.BOTTOM_LEFT);
                    bottomLeftBox.setSpacing(5);
                    borderPane.setBottom(bottomLeftBox);*/

                    //Image
                    HBox centerleftBox = new HBox(imageViewEvenement);
                    centerleftBox.setAlignment(Pos.BASELINE_LEFT);
                    centerleftBox.setSpacing(5);
                    borderPane.setLeft(centerleftBox);


                    setGraphic(borderPane);

                }
            }
        });
       // affiche1.setItems(a);
    } 

    @FXML
    private void reserver(ActionEvent event) throws IOException {
        
        datesta =affiche.getSelectionModel().getSelectedItem().getDate_evemt();
    description = affiche.getSelectionModel().getSelectedItem().getDescription();
     finish_hour= affiche.getSelectionModel().getSelectedItem().getFinish_hour();
     start_hour = affiche.getSelectionModel().getSelectedItem().getStart_hour();
     location = affiche.getSelectionModel().getSelectedItem().getLocation();
     capacity =affiche.getSelectionModel().getSelectedItem().getCapacity();
     image = affiche.getSelectionModel().getSelectedItem().getImage();
     name = affiche.getSelectionModel().getSelectedItem().getName();
     id_artiste = affiche.getSelectionModel().getSelectedItem().getArtiste().getId_artiste();
     prix =affiche.getSelectionModel().getSelectedItem().getPrix();
        
          System.out.println(datesta+description);
         
         FXMLLoader loader= new FXMLLoader(getClass().getResource("./Reservation.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        
        
    }

    @FXML
    private void video(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("../MusqiueMM/FXMLMedia.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }
    }    
    

