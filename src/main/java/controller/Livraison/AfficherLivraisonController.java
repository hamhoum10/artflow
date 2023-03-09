package controller.Livraison;

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
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.livraison;

import services.livraisonService;
import services.retourService;
import services.stockService;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherLivraisonController implements Initializable  {
    livraisonService ss = new livraisonService();
    retourService r = new retourService();
    stockService sss = new stockService();
    livraison l = new livraison();


    @FXML
    private AnchorPane rootPane;
        @FXML
        private Button button;

        @FXML
        private TextField id;

    @FXML
    private VBox ic;




        @FXML
        private ListView<livraison> lst;
    ObservableList<livraison> e= FXCollections.observableArrayList(ss.fetchlivraison());
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    void afficher(ActionEvent event) {

            e= FXCollections.observableArrayList(ss.SelectByUserliv( id.getText()));
        lst.setItems(e);
    }
    @FXML
    public void ajouter(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/AjouterLivraison.fxml"));
        Parent view_2=loader.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
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
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void afficheruser(KeyEvent event) {
        id.getText();
        ss.SelectByUserliv(id.getText());

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
        ss.deleatlivraisonById(selectedid);
        afficher(event);

//        ss.deleatlivraisonById(Integer.parseInt(id.getText()));



        alert.setTitle("Information ");

        alert.setHeaderText(null);

        alert.setContentText("livraison supprimer avec succés!");

        alert.show();
        e= FXCollections.observableArrayList(ss.fetchlivraison());
    }
    @FXML
    void mvToRetour(ActionEvent event) {


        l.setId(lst.getSelectionModel().getSelectedItem().getId())  ;
        l.setId_commende(lst.getSelectionModel().getSelectedItem().getId_commende()) ;
        l.setUser_name(lst.getSelectionModel().getSelectedItem().getUser_name());
        l.setName(lst.getSelectionModel().getSelectedItem().getName());
        l.setAddres(lst.getSelectionModel().getSelectedItem().getAddres());
        l.setArtiste(lst.getSelectionModel().getSelectedItem().getArtiste());
                    ss.moveToretour(l);
                    afficher(event);

                    r.SmsNotification(l.getId_commende());
    }

    @FXML
    void mvToStock(ActionEvent event) {
        l.setId(lst.getSelectionModel().getSelectedItem().getId())  ;
        l.setId_commende(lst.getSelectionModel().getSelectedItem().getId_commende()) ;
        l.setUser_name(lst.getSelectionModel().getSelectedItem().getUser_name());
        l.setName(lst.getSelectionModel().getSelectedItem().getName());
        l.setAddres(lst.getSelectionModel().getSelectedItem().getAddres());
        l.setArtiste(lst.getSelectionModel().getSelectedItem().getArtiste());
        l.setDate_entr(lst.getSelectionModel().getSelectedItem().getDate_sort());
        ss.moveToStock(l);
        afficher(event);
        sss.SmsNotification(l.getId_commende());

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
        e= FXCollections.observableArrayList(ss.fetchlivraison());
        lst.setItems(e);
    }

    @FXML
    void tt(ContextMenuEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/Dashbord.fxmll"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void allergh(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/example/newartflow/Stock/Dashbord.fxmll"));

        Parent view_2=loader.load();

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();

    }
}
