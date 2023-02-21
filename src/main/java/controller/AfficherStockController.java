package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.stockService;

import static javafx.beans.binding.Bindings.isEmpty;

public class AfficherStockController {
    stockService ss = new stockService();


    @FXML
    private TextField id;
    @FXML
    private Label aff;


    @FXML
    void go(ActionEvent event) {


        if (id.getText().isEmpty())

            aff.setText(ss.fetchstock().toString());
        else

        aff.setText(ss.SelectById(Integer.parseInt(id.getText())).toString());


    }

}
