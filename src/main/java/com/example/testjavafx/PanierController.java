package com.example.testjavafx;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.Ligne_panier;
import services.Ligne_PanierService;
import services.PanierService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PanierController {

    @FXML
    private Button addOne;

    @FXML
    private Button MinusOne;

    @FXML
    private Button comamanderbut;

    @FXML
    private Button showmycartBut;

    @FXML
    private Button delete;
    @FXML
    private TextField total;

    @FXML
    private Button viderPanier;

    @FXML
    private ImageView logo;


    @FXML
    private ListView<Ligne_panier> listView ;

    @FXML
    void ShowcartAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        PanierService p =new PanierService();
        List<Ligne_panier> pa = lps.readelementPanierbyiduser(3);
        //System.out.println(pa.toString());
        ObservableList<Ligne_panier> e= FXCollections.observableArrayList(pa);
        listView.setItems(e);
        total.setText(String.valueOf(p.totalmontantPanier(3)) + " DT");


    }

    @FXML
    void deleteLignePanierAction(ActionEvent event) {
        PanierService p =new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        //System.out.println(selectedidpanier+ ""+ selectedidarticle);
        lps.deleteFromLigne_panierByArticle(selectedidpanier,selectedidarticle);
        ShowcartAction(event);

        alertDialog("Article supprimer avec sucess!");

    }
    @FXML
    void ViderPanierActionforuser(ActionEvent event) {
        PanierService p =new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();
        lps.deleteAllFromLigne_panier(4);
        ShowcartAction(event);
    }
    @FXML
    void addOnetoarticleAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        try {
            lps.updatequantitywith1Plus(selectedidpanier,selectedidarticle);
            System.out.println("Quantity add by one");
            ShowcartAction(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void minusOnetoarticleAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        try {
            lps.updatequantitywith1Minus(selectedidpanier,selectedidarticle);
            System.out.println("Quantity decreased by one");
            ShowcartAction(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void commandeAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("commandeView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) comamanderbut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    void alertDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }


}
