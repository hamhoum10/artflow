/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rymgui;

import interfaces.EnchereParticipantInterface;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Enchere;
import models.Participant;
import pidevAuth.LoginFXMLController;
import services.ClientService;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class EnchereItemController implements Initializable {

  
   
    Participant p = new Participant();
    
    @FXML
    private ImageView articleImg;
    @FXML
    private Label name;
    
    
    
    Enchere e = new Enchere();
    EnchereParticipantInterface es = new EnchereService();
    private Enchere enchere;
    @FXML
    private VBox vboxmod;
    @FXML
    private VBox vboxdele;
    @FXML
    private ImageView modifff;
    @FXML
    private ImageView deleeeee;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
      public void setData(Enchere e) {
        enchere=e;
        this.e=e;
        name.setText(e.getTitre());
                        // price.setText(String.valueOf(e.getPrixdepart()));
     
        /*
        Image imageg = new Image(getClass().getResourceAsStream(a.getImage()));
        System.out.println(a);
        articleImg.setImage(imageg);*/
        File file=new File("C:\\xampp\\htdocs\\img\\"+e.getImg());
        Image img=new Image(file.toURI().toString());
        
         articleImg.setImage(img);
         if(LoginFXMLController.usernamewelcome!=null){
            //if(!LoginArtisteController.usernameArtiste.equals(a.getArtiste().getUsername())){
                            vboxmod.getChildren().remove(modifff);
                            vboxdele.getChildren().remove(deleeeee);
            }
        
    }
    
    
    
    @FXML
    private void modifyEnchere(MouseEvent event) throws IOException {
       FXMLLoader loader= new FXMLLoader(getClass().getResource("./modif.fxml"));
        Parent view_2=loader.load();
        ModifController ModifController=loader.getController();
        ModifController.setEnchere(e);
       
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void deleteEnchere(MouseEvent event) throws IOException {
         es.deleteEnchere(e.getIde());
//         es.fetchEnchere();
         
         
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./ShowAllItems.fxml"));
        Parent view_2=loader.load();
        Scene scene = new Scene(view_2);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
// int selectedId =listEnchere.getSelectionModel().getSelectedItem().getIde();
//    es.deleteEnchere(selectedId);
//    afficherEnchere(event);
    }

    @FXML
    private void view_description(MouseEvent event) throws IOException, SQLException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("descirption.fxml"));
        Parent view_2=loader.load();
        descriptionController descriptionController=loader.getController();
        System.out.println(enchere);
        descriptionController.setEnchere(e);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
        
}  
}


// try {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("description.fxml"));
//        Parent root = loader.load();
//
//        descriptionController controller = loader.getController();
//        controller.setEnchere(e);
//
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.show();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    }


