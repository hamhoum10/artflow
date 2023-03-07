/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuth;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.DisplayClientFXMLController;
import pidevArtiste.AddArtisteController;

/**
 * FXML Controller class
 *
 * @author kanza
 */
public class FirstpageController implements Initializable {
private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView client;
    @FXML
    private ImageView artiste;
    @FXML
    private Button imclient;
    @FXML
    private Button imartist;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Gotoclient(ActionEvent event) throws IOException {
        String Client= "client";
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidev/DisplayClientFXML.fxml"));
                  root  =loader.load();
                  DisplayClientFXMLController wpc= loader.getController();
                  wpc.displayId(Client);
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
    }

    @FXML
    private void Gotoartist(ActionEvent event) throws IOException {
        String Artiste= "artiste";
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../pidevArtiste/AddArtiste.fxml"));
                  root  =loader.load();
                  AddArtisteController wpc= loader.getController();
                  wpc.displayId(Artiste);
                  stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();
        
    }
    
}
