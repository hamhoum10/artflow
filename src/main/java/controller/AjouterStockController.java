package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.stock;
import services.stockService;

public class AjouterStockController {
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
    private TextField un;

    @FXML
    private Label titre;


    @FXML
    void ajouterStock(ActionEvent event) {
        stock s = new stock();
        s.setName(np.getText());
        s.setArtiste(ar.getText());
        s.setAddres(ad.getText());
        s.setId_commende(Integer.parseInt(ic.getText()));
        s.setUser_name(un.getText());
        ss.addstock(s);
        titre.setText("Stock Added Successfully! ");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information Dialog");

        alert.setHeaderText(null);

        alert.setContentText("Stock insérée avec succés!");

        alert.show();


    }

}
