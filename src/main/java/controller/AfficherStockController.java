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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.stock;
import services.stockService;


import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import static javafx.beans.binding.Bindings.isEmpty;

public class AfficherStockController implements Initializable  {
    stockService ss = new stockService();


    @FXML
    private AnchorPane rootPane;
        @FXML
        private Button button;

        @FXML
        private TextField id;



        @FXML
        private ListView<stock> lst;
    ObservableList<stock> e= FXCollections.observableArrayList(ss.fetchstock());
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void afficher(ActionEvent event) {


        if (id.getText().isEmpty())
        { e= FXCollections.observableArrayList(ss.fetchstock());

        lst.setItems(e);}


        else
            e= FXCollections.observableArrayList(ss.SelectById(Integer.parseInt( id.getText())));
            lst.setItems(e);


    }
    @FXML
    public void ajouter(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AjouterStock.fxml"));
//         loader= new FXMLLoader(getClass().getResource("AjouterStock.fxml"));
        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    void modifier(ActionEvent event) throws IOException {
        stock selectedStock = lst.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/ModifierStock.fxml"));

        Parent view_2=loader.load();
        ModifierStockControler ModifyStockController=loader.getController();
        ModifyStockController.getStock(selectedStock);
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

        ss.deleatstockById(Integer.parseInt(id.getText()));



        alert.setTitle("Information ");

        alert.setHeaderText(null);

        alert.setContentText("Stock supprimer avec succés!");

        alert.show();
        e= FXCollections.observableArrayList(ss.fetchstock());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
