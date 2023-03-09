package controller.Retour;

import controller.Retour.ModifierRetourControler;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.retour;
import services.livraisonService;
import services.retourService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherRetourController implements Initializable  {
    retourService ss = new  retourService();
    livraisonService ll = new livraisonService();


    @FXML
    private AnchorPane rootPane;
        @FXML
        private Button button;

        @FXML
        private TextField id;



        @FXML
        private ListView<retour> lst;
         retour l = new retour();
    ObservableList<retour> e= FXCollections.observableArrayList(ss.fetchretour());
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void afficher(ActionEvent event) {



            e= FXCollections.observableArrayList(ss.SelectByUserret( id.getText()));
            lst.setItems(e);


    }
    @FXML
    public void ajouter(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AjouterRetour.fxml"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();
//        ss.SmsNotification();

    }



    @FXML
    void modifier(ActionEvent event) throws IOException {
        retour selectedStock = lst.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/ModifierRetour.fxml"));

        Parent view_2=loader.load();
        ModifierRetourControler ModifyStockController=loader.getController();
        ModifyStockController.getLivraison(selectedStock);
        ModifyStockController.s=selectedStock;

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,700,700);
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
        ss.deleatretourById(selectedid);
        afficher(event);



        alert.setTitle("Information ");

        alert.setHeaderText(null);

        alert.setContentText("retour supprimer avec succés!");

        alert.show();
        e= FXCollections.observableArrayList(ss.fetchretour());
    }
    @FXML
    void mvLivraison(ActionEvent event) { l.setId(lst.getSelectionModel().getSelectedItem().getId())  ;
        l.setId_commende(lst.getSelectionModel().getSelectedItem().getId_commende()) ;
        l.setUser_name(lst.getSelectionModel().getSelectedItem().getUser_name());
        l.setName(lst.getSelectionModel().getSelectedItem().getName());
        l.setAddres(lst.getSelectionModel().getSelectedItem().getAddres());
        l.setArtiste(lst.getSelectionModel().getSelectedItem().getArtiste());
        l.setDate_retour(lst.getSelectionModel().getSelectedItem().getDate_sort());
        ll.SmsNotification(l.getId_commende());
        ss.mouveToLivraison(l);
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
    void allerStock(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AfficherStock.fxml"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        e= FXCollections.observableArrayList(ss.fetchretour());
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
