package controller.Livraison;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

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
import models.livraison;
import services.CommandeService;
import services.livraisonService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AjouterLivraisonController implements  Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button re;

    @FXML
    private TextField ad;

    @FXML
    private TextField ar;


    @FXML
    private TextField np;

    @FXML
    private TextField un;

    @FXML
    private Label titre;
    @FXML
    private ComboBox<String> commende;

    ObservableList<String> list2= FXCollections.observableArrayList();
    ObservableList <String> list = FXCollections.observableArrayList();
    livraisonService ss = new livraisonService();
    CommandeService cs = new CommandeService();




    @FXML
     public void returnonClick(ActionEvent event) throws  Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/newartflow/Stock/AfficherLivraison.fxml"));
        Stage window = (Stage) re.getScene().getWindow();
        window.setScene(new Scene(root,1000,1000));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(cs.readAllCommandes());
        System.out.println(list);
     
        cs.readAllCommandes().stream().forEach(e-> list.add(e.getNomClientCommande()));
        commende.getItems().addAll(list);

    }
    @FXML
//
    public void ajouterStock(ActionEvent event) throws IOException, SQLException {
        String name = np.getText().trim();
        String artiste = ar.getText().trim();
        String addres = ad.getText().trim();
//        String idCommendeStr = ic.getText().trim();
        String userName = un.getText().trim();

        if (name.isEmpty() || artiste.isEmpty() || addres.isEmpty() ||  userName.isEmpty()) {
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


        livraison s = new livraison();
        s.setName(name);
        s.setArtiste(artiste);
        s.setAddres(addres);


        s.setId_commende(cs.getCommendeIdByName( commende.getValue()));
        s.setUser_name(userName);
        ss.SmsNotification(commende.getValue());
        ss.addlivraison(s);



        titre.setText("Livraison Added Successfully!");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/FXMLafficher.fxml"));
        Parent view_2 = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2,1000,1000);
        stage.setScene(scene);
        stage.show();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Livraison insérée avec succès!");
        alert.showAndWait();
    }
    @FXML
    void mame_commende(ActionEvent event) {
       

    }









    }

