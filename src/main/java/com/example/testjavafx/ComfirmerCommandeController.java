package com.example.testjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Commande;
import models.Ligne_panier;
import services.CommandeService;
import services.Ligne_PanierService;
import services.PanierService;
import util.Stripeapi;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ComfirmerCommandeController implements Initializable {

    @FXML
    private Button AnullerCommande;

    @FXML
    private Button payerCommande;

    @FXML
    private Button showCommande;

    @FXML
    private Label adresselabel;

    @FXML
    private Label codepostallabel;

    @FXML
    private Label creelabel;

    @FXML
    private Label numerilabel;

    @FXML
    private Label prenomlabel;

    @FXML
    private Label statuslabel;

    @FXML
    private Label totallabel;

    @FXML
    private Label nomlabel;

    @FXML
    private ListView<Commande> listviewcommande;

    @FXML
    void showCommandeAction(ActionEvent event) {
        CommandeService cs =new CommandeService();
        List<Commande> commandeList =cs.readCommandesbyPanier(4);
        ObservableList<Commande> e= FXCollections.observableArrayList(commandeList);
        listviewcommande.setItems(e);

        listviewcommande.setCellFactory(param -> new ListCell<Commande>() {
            @Override
            protected void updateItem(Commande item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);

                } else {
                prenomlabel.setText(item.getPrénomClientCommande());
                nomlabel.setText(item.getNomClientCommande());
                codepostallabel.setText(String.valueOf(item.getCodepostal()));
                statuslabel.setText(item.getStatus());
                creelabel.setText(item.getCreatedAt());
                numerilabel.setText(String.valueOf(item.getNumeroPhoneclient()));
                totallabel.setText(String.valueOf(item.getTotalAmount())+ "DT");
                adresselabel.setText(item.getAdresse());



                    //tostring
                    Label contenu =new Label(item.toString());
                    contenu.setStyle("-fx-font-family: Arial; -fx-font-size: 12;");

                    //BORDERPANE
                    BorderPane borderPane = new BorderPane();
                    borderPane.setCenter(contenu);

                    //contenu el ToString()
                    HBox centerBox = new HBox(contenu);
                    centerBox.setAlignment(Pos.CENTER_LEFT);
                    centerBox.setSpacing(5);
                    borderPane.setCenter(centerBox);




                    setGraphic(borderPane);

                }
            }
        });
    }
    @FXML
    void AnullerCommandeAction(ActionEvent event) {
        CommandeService commandeService =new CommandeService();
        commandeService.deleteCommande(4);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("panierView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) AnullerCommande.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void payerCommandeAction(ActionEvent event) {
        /*Stripeapi stripeapi =new Stripeapi();
        PanierService ps =new PanierService();




        CommandeService commandeService =new CommandeService();
        commandeService.deleteCommande(4);

        Ligne_PanierService lps =new Ligne_PanierService();
        System.out.println((int)ps.totalmontantPanier(3));
        stripeapi.Payer(String.valueOf((int)ps.totalmontantPanier(3)*100));

        lps.deleteAllFromLigne_panier(4);

        alertDialog(" transaction done ! ");*/

        FXMLLoader loader = new FXMLLoader(getClass().getResource("paymentView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) AnullerCommande.getScene().getWindow();
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showCommandeAction(null);
    }
}



