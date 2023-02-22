package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.stock;
import services.stockService;

import java.net.URL;

import java.util.ResourceBundle;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AjouterStockController   implements  Initializable {
    stockService ss = new stockService();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button re;

    @FXML
    private TextField ad;

    @FXML
    private TextField ar;

    @FXML
    private TextField ic;

    @FXML
    private TextField np;

    @FXML
    private TextField un;

    @FXML
    private Label titre;




    @FXML
     public void returnonClick(ActionEvent event) throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/newartflow/Stock/AfficherStock.fxml"));
        Stage window = (Stage) re.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void ajouterStock(ActionEvent event) throws IOException {
        stock s = new stock();
        s.setName(np.getText());
        s.setArtiste(ar.getText());
        s.setAddres(ad.getText());
        s.setId_commende(Integer.parseInt(ic.getText()));
        s.setUser_name(un.getText());
        ss.addstock(s);
        titre.setText("Stock Added Successfully! ");
        //FXMLLoader loader= new FXMLLoader(getClass().getResource("FXMLafficher.fxml"));
        //Parent view_2=loader.load();

        //Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        //Scene scene = new Scene(view_2);
        //stage.setScene(scene);
        //stage.show();

        FXMLLoader loader= new FXMLLoader(getClass().getResource("AfficherStock.fxml"));
        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information Dialog");

        alert.setHeaderText(null);

        alert.setContentText("Stock insérée avec succés!");

        alert.show();


    }



}
