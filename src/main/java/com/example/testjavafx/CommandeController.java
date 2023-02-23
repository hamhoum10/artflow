package com.example.testjavafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Commande;
import services.CommandeService;
import services.PanierService;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CommandeController {

    @FXML
    private TextField Adressetext;

    @FXML
    private TextField CodepostalText;

    @FXML
    private TextField Nomtext;

    @FXML
    private TextField Numerotext;

    @FXML
    private TextField Prénomtext;

    @FXML
    private Button comfirmerCommande;

    @FXML
    private Button backtopanier;


    @FXML
    void ConfirmerCommandeAction(ActionEvent event) {
        if (Nomtext.getText().length() == 0 ||Prénomtext.getText().length() == 0||Adressetext.getText().length() == 0||Numerotext.getText().length() == 0||CodepostalText.getText().length()==0){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Please remplir tous les champs"+ "");
            alert.show();

        } else if (isValidName(Nomtext.getText())==false||isValidName(Prénomtext.getText())==false||isValidName(Adressetext.getText())==false||isValidName(Numerotext.getText())==false||isValidName(CodepostalText.getText())==false)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Please don't use special caracteres "+ "");
            alert.show();
        } else if (Numerotext.getText().length()!= 8 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Please Phone number must contain 8 numbers "+ "");
            alert.show();
        } else if (CodepostalText.getText().length()!=4) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Please Code postal must contain 4 numbers "+ "");
            alert.show();

        } else {


            PanierService p = new PanierService();
            CommandeService cs = new CommandeService();

            String prenom = Prénomtext.getText();
            String nom = Nomtext.getText();
            int numero = Integer.parseInt(Numerotext.getText());
            int codepostal = Integer.parseInt(CodepostalText.getText());
            String adresse = Adressetext.getText();
            Commande c = new Commande(4, prenom, nom, numero, "en attente", p.totalmontantPanier(3), codepostal, adresse);
            if (cs.create(c).booleanValue() == false) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("payerView.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene scene = new Scene(root);
                Stage stage = (Stage) comfirmerCommande.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                alertDialog("You already passed an Order");
            }

        }
    }

    @FXML
    void backtopanierAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("panierView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) backtopanier.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        System.out.println("hi");
    }
    void alertDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }
    public class SpecialCharacters {

        public static final List<Character> specialCharacters = Arrays.asList(
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '{', '}', '[', ']', '\\', '|', ';', ':', '\'', '\"', ',', '.', '/', '?', '<', '>', '~', '`'
        );
    }
    public static boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (SpecialCharacters.specialCharacters.contains(c)) {
                return false;
            }
        }
        return true;
    }


}
