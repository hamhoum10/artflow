package com.example.testjavafx;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.Ligne_panier;
import services.Ligne_PanierService;
import services.PanierService;

import java.util.List;

public class PanierController {



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
    private ListView<Ligne_panier> listView ;
    @FXML
    void ShowcartAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        PanierService p =new PanierService();
        List<Ligne_panier> pa = lps.readelementPanierbyiduser(3);
        System.out.println(pa.toString());
        ObservableList<Ligne_panier> e= FXCollections.observableArrayList(pa);
        listView.setItems(e);
        total.setText(String.valueOf(p.totalmontantPanier(3)));


    }

    @FXML
    void deleteLignePanierAction(ActionEvent event) {
        PanierService p =new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        System.out.println(selectedidpanier+ ""+ selectedidarticle);
        lps.deleteFromLigne_panierByArticle(selectedidpanier,selectedidarticle);
        ShowcartAction(event);


    }
    @FXML
    void ViderPanierActionforuser(ActionEvent event) {
        PanierService p =new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();
        lps.deleteAllFromLigne_panier(4);
        ShowcartAction(event);
    }
    @FXML
    void commandeAction(ActionEvent event) {

    }


}
