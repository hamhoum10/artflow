package com.example.testjavafx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Client;
import models.Commande;
import models.Ligne_panier;
import services.ClientService;
import services.CommandeService;
import services.Ligne_PanierService;
import services.PanierService;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {

    boolean isPromo =PanierController.promocodeEtat; //narfou si fama promtion ou non mesh narfou n7oto methode total with or without dsicount

    //static values eli mesh n7othom fi recu commande
    static int id_paniersta;
    static String prenomsta;
    static String nomsta;
    static String numerosta;
    static String adressesta;
    static int codepostalsta;
    static String createdsta;
    static String statussta;
    static double totalsta;


    LocalDate currentDate = LocalDate.now();

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
    private ListView<Ligne_panier> myitemslist;
    @FXML
    private TextField total;

    private ObservableList<Ligne_panier> e;


    //formulaire mesh tkaml tamel commande
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
            //services
            PanierService p = new PanierService();
            CommandeService cs = new CommandeService();

            //input mta textfield commande
            String prenom = Prénomtext.getText();
            String nom = Nomtext.getText();
            int numero = Integer.parseInt(Numerotext.getText());
            int codepostal = Integer.parseInt(CodepostalText.getText());
            String adresse = Adressetext.getText();
            int id_panierselectionner = myitemslist.getFocusModel().getFocusedItem().getId();

            //ken 3mal promocode namlou commande fiha discount
            if(PanierController.promocodeEtat==true){
                Commande c = new Commande(id_panierselectionner, prenom, nom, numero, "en attente", p.totalmontantPanierWith20Discount(3), codepostal, adresse); //id_client nada authen
                cs.create(c);
               // if (cs.create(c).booleanValue() == false) {//ken commaande mesh mawjouda
                    //fill the static values so i can use them in the next views commande ect
                    id_paniersta =id_panierselectionner;
                    prenomsta=prenom;
                    nomsta=nom;
                    statussta="en attente";
                    numerosta= String.valueOf(numero);
                    totalsta=p.totalmontantPanierWith20Discount(3);
                    codepostalsta=codepostal;
                    adressesta=adresse;
                    createdsta= String.valueOf(currentDate);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("paymentView.fxml"));
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
                    alertDialog("you've created an Order ! ");
               // } else {//ken mawjouda
               //     alertDialog("You already passed an Order");
              //  }
            }else{//pas de promocode ywali ttoal yet7seb aadi
                Commande c = new Commande(id_panierselectionner, prenom, nom, numero, "en attente", p.totalmontantPanier(3), codepostal, adresse); //id_client nada authen
                cs.create(c);
               // if (cs.create(c).booleanValue() == false) {
                    //fill the static values so i can use them in the next views commande ect
                    prenomsta=prenom;
                    nomsta=nom;
                    statussta="en attente";
                    numerosta= String.valueOf(numero);
                    totalsta=p.totalmontantPanier(3);
                    codepostalsta=codepostal;
                    adressesta=adresse;
                    createdsta= String.valueOf(currentDate);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("paymentView.fxml"));
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
                    alertDialog("you've created an Order ! ");
                //} else {
                    //alertDialog("You already passed an Order");
               // }
            }


        }
    }
    // terja3 lel panier
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

    }

    //alert window
    void alertDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }

    //controle de saisae
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

    //afficher el contenu mta panier wel total bel wala blesh el discount
    @FXML
    void ShowmyItems(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        PanierService p =new PanierService();
        ClientService clientService =new ClientService();
        //int id_panierselectionner = myitemslist.getFocusModel().getFocusedItem().getId();

        //int id_clientselectionner = clientService.getId_client(myitemslist.getFocusModel().getFocusedItem().getPanier().getClient());
        List<Ligne_panier> pa = lps.readelementPanierbyiduser(3);
        e= FXCollections.observableArrayList(pa);
        myitemslist.setItems(e);
        if (isPromo==true){
            total.setText(String.valueOf(p.totalmontantPanierWith20Discount(3)) + " DT");
        }else{
            total.setText(String.valueOf(p.totalmontantPanier(3)) + " DT");//id_client nada baed aithentification
        }


        myitemslist.setCellFactory(param -> new ListCell<Ligne_panier>() {
            private final ImageView imageViewArticle = new ImageView();
            @Override
            protected void updateItem(Ligne_panier item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {



                    Image img =new Image("C:/xampp/htdocs/img/"+item.getArticle().getImage());
                    imageViewArticle.setFitHeight(150);
                    imageViewArticle.setFitWidth(150);
                    imageViewArticle.setImage(img);

                    //tostring
                    Label contenu =new Label(item.toString());
                    contenu.setStyle("-fx-font-family: Arial; -fx-font-size: 14;");

                    //BORDERPANE
                    BorderPane borderPane = new BorderPane();
                    borderPane.setCenter(contenu);

                    //contenu el ToString()
                    HBox centerBox = new HBox(contenu);
                    centerBox.setAlignment(Pos.CENTER_LEFT);
                    centerBox.setSpacing(5);
                    borderPane.setCenter(centerBox);

                    //Image
                    HBox centerleftBox = new HBox(imageViewArticle);
                    centerleftBox.setAlignment(Pos.BASELINE_LEFT);
                    centerleftBox.setSpacing(5);
                    borderPane.setLeft(centerleftBox);


                    setGraphic(borderPane);

                }
            }
        });



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ShowmyItems(null);
    }


}

