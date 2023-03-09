/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rymgui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Enchere;
import pidevAuth.LoginFXMLController;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class ShowAllItemsController implements Initializable {

    
    
         EnchereService es = new EnchereService();
    private List<Enchere> enchere;
    @FXML
    private GridPane gridench;
    @FXML
    private VBox vboxadd;
    @FXML
    private ImageView id_adddd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(LoginFXMLController.usernamewelcome!=null){
           
                      vboxadd.getChildren().remove(id_adddd);
                            
            }
     afficherEnchere();
        
    }    
    
       public void afficherEnchere() {
    gridench.getChildren().clear();
        enchere = es.fetchEnchere();
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<enchere.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("EnchereItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
           EnchereItemController itemController = fxmlLoader.getController();
            itemController.setData(enchere.get(i));
            
            if(columns == 2){
                columns = 0 ;
                ++rows;
            }
            
            gridench.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                  
               Logger.getLogger(ShowAllItemsController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
}

     
       
      
//       
//   private void recherche_avance() throws IOException {
//        
//       afficher_Articles(h.fetchArticle());
//        ObservableList<Article> Articles=FXCollections.observableArrayList(h.fetchArticle());
//        FilteredList<Article> filtreddata=new FilteredList<>(Articles,r->true);
//        id_rech.textProperty().addListener((observable,oldValue,newValue)->{
//           try {
//               filtreddata.setPredicate(art->{
//                   if(newValue==null||newValue.isEmpty()){
//                       return true;
//                   }
//                   String newValuelowercase=newValue.toLowerCase();
//                   if(art.getNom_article().toLowerCase().indexOf(newValuelowercase)!=-1){
//                       return true;
//                   }
//                   else if(art.getDescription().toLowerCase().indexOf(newValuelowercase)!=-1){
//                       return true;
//                   }
//                   else if(String.valueOf(art.getPrice()).toLowerCase().indexOf(newValuelowercase)!=-1){
//                       return true;
//                   }
//                   else if(String.valueOf(art.getQuantity()).toLowerCase().indexOf(newValuelowercase)!=-1){
//                       return true;
//                   }
//                   else{
//                       return false;
//                   }
//               });
//               afficher_Articles(filtreddata);
//           } catch (IOException ex) {
//               Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
//           }
//        });
//    }
//
//    

    @FXML
    private void Artistlist(ActionEvent event) {
    }

    @FXML
    private void Clientlist(ActionEvent event) {
    }

    @FXML
    private void Settings(ActionEvent event) {
    }

    @FXML
    private void Logout(ActionEvent event) {
    }

    @FXML
    private void addencher(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./addEnchere.fxml"));
               Parent view_2=loader.load();
               Scene scene = new Scene(view_2);
               Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show();
             
    }
        
    }     
       
       
       
       
       
       
    
    
