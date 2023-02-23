package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.livraison;

import services.livraisonService;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherLivraisonController implements Initializable  {
    livraisonService ss = new livraisonService();


    @FXML
    private AnchorPane rootPane;
        @FXML
        private Button button;

        @FXML
        private TextField id;



        @FXML
        private ListView<livraison> lst;
    ObservableList<livraison> e= FXCollections.observableArrayList(ss.fetchlivraison());
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void afficher(ActionEvent event) {


        if (id.getText().isEmpty())
        { e= FXCollections.observableArrayList(ss.fetchlivraison());

        lst.setItems(e);}


        else
            e= FXCollections.observableArrayList(ss.SelectByIdliv(Integer.parseInt( id.getText())));
            lst.setItems(e);


    }
    @FXML
    public void ajouter(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AjouterLivraison.fxml"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    void modifier(ActionEvent event) throws IOException {
        livraison selectedStock = lst.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/ModifierLivraison.fxml"));

        Parent view_2=loader.load();
        ModifierLivraisonControler ModifyStockController=loader.getController();
        ModifyStockController.getLivraison(selectedStock);
        ModifyStockController.s=selectedStock;

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void supprimer(ActionEvent event) {
        if (id.getText().isEmpty()){
            alert.setTitle("ERREUR");

            alert.setHeaderText(null);

            alert.setContentText("id est vide");

            alert.show();
        }

        ss.deleatlivraisonById(Integer.parseInt(id.getText()));



        alert.setTitle("Information ");

        alert.setHeaderText(null);

        alert.setContentText("livraison supprimer avec succés!");

        alert.show();
        e= FXCollections.observableArrayList(ss.fetchlivraison());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
