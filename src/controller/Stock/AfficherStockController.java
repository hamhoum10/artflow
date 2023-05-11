package controller.Stock;

import controller.Stock.ModifierStockControler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.stock;
import services.livraisonService;
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
    livraisonService ll = new livraisonService();


    @FXML
    private AnchorPane rootPane;
        @FXML
        private Button button;

        @FXML
        private TextField id;
        stock l = new stock();



        @FXML
        private ListView<stock> lst;
    ObservableList<stock> e= FXCollections.observableArrayList(ss.fetchstock());
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void afficher(ActionEvent event) {





            e= FXCollections.observableArrayList(ss.SelectByUser( id.getText()));
            lst.setItems(e);


    }
    @FXML
    public void ajouter(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AjouterStock.fxml"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
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
        Scene scene = new Scene(view_2,1000,1000);
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
        int selectedid = lst.getSelectionModel().getSelectedItem().getId();
        ss.deleatstockById(selectedid);
        afficher(event);



        alert.setTitle("Information ");

        alert.setHeaderText(null);

        alert.setContentText("Stock supprimer avec succés!");

        alert.show();
        e= FXCollections.observableArrayList(ss.fetchstock());
    }
    @FXML
    void mvlivraison(ActionEvent event) {l.setId(lst.getSelectionModel().getSelectedItem().getId())  ;
        l.setId_commende(lst.getSelectionModel().getSelectedItem().getId_commende()) ;
        l.setUser_name(lst.getSelectionModel().getSelectedItem().getUser_name());
        l.setName(lst.getSelectionModel().getSelectedItem().getName());
        l.setAddres(lst.getSelectionModel().getSelectedItem().getAddres());
        l.setArtiste(lst.getSelectionModel().getSelectedItem().getArtiste());
        l.setDate_entr(lst.getSelectionModel().getSelectedItem().getDate_entr());
       ll.SmsNotification(l.getId_commende()); 
        ss.moveToLivraison(l);
        afficher(event);

    }
    @FXML
    void allerLivraison(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AfficherLivraison.fxml"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void allerRetour(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AfficherRetour.fxml"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        e= FXCollections.observableArrayList(ss.fetchstock());
        lst.setItems(e);

    }
    @FXML
    private void stat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/Dashbord.fxml"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();
        
    }
}
