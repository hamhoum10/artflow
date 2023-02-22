package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.stock;
import services.stockService;

import java.io.IOException;

public class ModifierStockControler {
    stockService ss = new stockService();
    @FXML
    private TextField ad;

    @FXML
    private TextField ar;

    @FXML
    private TextField ic;

    @FXML
    private TextField np;

    @FXML
    private Button re;

    @FXML
    private Label titre;

    @FXML
    private TextField un;
    stock s;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void getStock(stock s){



        np.setText(s.getName());
        ar.setText(s.getArtiste());
        ad.setText(s.getAddres());
        ic.setText(String.valueOf(s.getId_commende()));
        un.setText(s.getUser_name());


    }

    @FXML
    void ModifierStock(ActionEvent event) {


        s.setName(np.getText());
        s.setArtiste(ar.getText());
        s.setAddres(ad.getText());
        s.setId_commende(Integer.parseInt(ic.getText()));
        s.setUser_name(un.getText());
        ss.updateAllstock(s);
        alert.setTitle("reuissi");
        alert.setHeaderText(null);
        alert.setContentText("modifier est reussite !");
        alert.show();


    }

    @FXML
    void returnonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/newartflow/Stock/AfficherStock.fxml"));
        Stage window = (Stage) re.getScene().getWindow();
        window.setScene(new Scene(root));

    }
}
