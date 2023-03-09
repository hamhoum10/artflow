package controller.Livraison;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.livraison;
import models.stock;
import services.CommandeService;
import services.livraisonService;
import services.stockService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifierLivraisonControler  implements Initializable {
    livraisonService ss = new livraisonService();
    CommandeService cs = new CommandeService();
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> commende;
    @FXML
    private TextField ad;


    @FXML
    private TextField ar;



    @FXML
    private TextField np;

    @FXML
    private Button re;

    @FXML
    private Label titre;


    @FXML
    private TextField un;
    livraison s;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void getLivraison(livraison s){



        np.setText(s.getName());
        ar.setText(s.getArtiste());
        ad.setText(s.getAddres());
//        ic.setText(String.valueOf(s.getId_commende()));
        un.setText(s.getUser_name());


    }

    @FXML
    void ModifierLivraison(ActionEvent event) throws IOException, SQLException {



        s.setName(np.getText());
        s.setArtiste(ar.getText());
        s.setAddres(ad.getText());
        s.setId_commende(cs.getCommendeIdByName( commende.getValue()));
//        s.setId_commende(Integer.parseInt(ic.getText()));
        s.setUser_name(un.getText());
        if (s.getName().isEmpty() || s.getArtiste().isEmpty() || s.getAddres().isEmpty() || String.valueOf(s.getId_commende()).isEmpty() || s.getUser_name().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all the fields.");
            alert.showAndWait();
            return;
        }

        // Check for special characters in name and artiste fields
        if (!s.getName().matches("[a-zA-Z_ ]+") || !s.getArtiste().matches("[a-zA-Z_ ]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Name and artiste fields can only contain letters, numbers, spaces, and underscores.");
            alert.showAndWait();
            return;
        }

        int idCommende = 0;
        try {
            idCommende = s.getId_commende();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid integer value for id_commende.");
            alert.showAndWait();
            return;
        }


        ss.updateAlllivraison(s);
        alert.setTitle("reuissi");
        alert.setHeaderText(null);
        alert.setContentText("modifier est reussite !");
        alert.show();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/newartflow/Stock/AfficherLivraison.fxml"));
        Stage window = (Stage) re.getScene().getWindow();
        window.setScene(new Scene(root,1000,1000));


    }

    @FXML
    void returnonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/newartflow/Stock/AfficherLivraison.fxml"));
        Stage window = (Stage) re.getScene().getWindow();
        window.setScene(new Scene(root,1000,1000));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.remove(list);
        cs.readAllCommandes().stream().forEach(e -> list.add(e.getNomClientCommande()));
        commende.getItems().addAll(list);
    }
}
