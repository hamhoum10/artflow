package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.livraison;
import models.stock;
import services.livraisonService;
import services.stockService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AjouterLivraisonController implements  Initializable {
    livraisonService ss = new livraisonService();
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
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/newartflow/Stock/AfficherLivraison.fxml"));
        Stage window = (Stage) re.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
//    void ajouterStock(ActionEvent event) throws IOException {
//        livraison s = new livraison();
//
//        s.setName(np.getText());
//        s.setArtiste(ar.getText());
//        s.setAddres(ad.getText());
//        s.setId_commende(Integer.parseInt(ic.getText()));
//        s.setUser_name(un.getText());
//        ss.addlivraison(s);
//        titre.setText("Livraison Added Successfully! ");
//
//
//        FXMLLoader loader= new FXMLLoader(getClass().getResource("/com/example/newartflow/Stock/AfficherLivraison.fxml"));
//        Parent view_2=loader.load();
//
//        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(view_2);
//        stage.setScene(scene);
//        stage.show();
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//        alert.setTitle("Information Dialog");
//
//        alert.setHeaderText(null);
//
//        alert.setContentText("livraison insérée avec succés!");
//
//        alert.show();
    public void ajouterStock(ActionEvent event) throws IOException {
        String name = np.getText().trim();
        String artiste = ar.getText().trim();
        String addres = ad.getText().trim();
        String idCommendeStr = ic.getText().trim();
        String userName = un.getText().trim();

        if (name.isEmpty() || artiste.isEmpty() || addres.isEmpty() || idCommendeStr.isEmpty() || userName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all the fields.");
            alert.showAndWait();
            return;
        }

        // Check for special characters in name and artiste fields
        if (!name.matches("[a-zA-Z_ ]+") || !artiste.matches("[a-zA-Z_ ]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Name and artiste fields can only contain letters, numbers, spaces, and underscores.");
            alert.showAndWait();
            return;
        }

        int idCommende = 0;
        try {
            idCommende = Integer.parseInt(idCommendeStr);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid integer value for id_commende.");
            alert.showAndWait();
            return;
        }

        livraison s = new livraison();
        s.setName(name);
        s.setArtiste(artiste);
        s.setAddres(addres);
        s.setId_commende(idCommende);
        s.setUser_name(userName);

        ss.addlivraison(s);

        titre.setText("Livraison Added Successfully!");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/newartflow/Stock/AfficherLivraison.fxml"));
        Parent view_2 = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Livraison insérée avec succès!");
        alert.showAndWait();
    }









    }

