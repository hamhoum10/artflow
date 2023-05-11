/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIissaAli;


import models.Artiste;
import models.Evenement;
import services.ArtisteService;
import services.EvenementService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class View_EvemtController implements Initializable {
    EvenementService Es = new EvenementService();
    ArtisteService Ar = new ArtisteService();
     List<Evenement> list ;

    @FXML
    private ListView<Evenement> affiche;
    @FXML
    private Button BOUTTONMOD;

        List<Evenement> ev =Es.fetchEvenements();
        // TODO
          ObservableList<Evenement> e =FXCollections.observableArrayList(ev);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aff(null);
         Es.fetchEvenements();
        
        
          
       
    } 
    
   
    
     void aff(ActionEvent event) {
          FXCollections.observableArrayList(Es.fetchEvenements());
         //String ar = (String)FXCollections.observableArrayList(Ar.fetchArtiste()).toString();
         
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
    private void modifier(ActionEvent event) throws IOException {
                  try {
               Evenement selectedEvent=affiche.getSelectionModel().getSelectedItem();
                FXMLLoader loader= new FXMLLoader(getClass().getResource("./ModifiEvemt.fxml"));
                Parent view_2=loader.load();
                ModifiEvemtController ModifierEventController=loader.getController();
                ModifierEventController.getEvent(selectedEvent);
                ModifierEventController.e=selectedEvent;
                Scene scene = new Scene(view_2);
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
               
            }


        
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int selectedId= affiche.getSelectionModel().getSelectedItem().getId();
        Es.suppEvenement(selectedId);
        affiche.getItems().remove(affiche.getSelectionModel().getSelectedItem());
        aff(event);
        
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../gui/FXMLafficher.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("./Evenement.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
    }

    }
    

