package com.example.testjavafx;



import com.stripe.Stripe;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.Ligne_panier;
import services.Ligne_PanierService;
import services.PanierService;
import services.PromoCodeService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PanierController implements Initializable {

    static  boolean promocodeEtat; // na3rfou si el utilisateur sta3mel code (true) sinon false , wmesh nest7a9ouh baed fi view commande mesh nafshiw total en fonction de ce variable (discount ou non)

    static int id_panierlistview ;
    @FXML
    private Button addOne;

    @FXML
    private Button MinusOne;

    @FXML
    private Button comamanderbut;

    @FXML
    private Button showmycartBut;

    @FXML
    private Button delete;
    @FXML
    private TextField total;

    @FXML
    private Button viderPanier;

    @FXML
    private ImageView logo;


    @FXML
    private ListView<Ligne_panier> listView ;

    @FXML
    private TextField Promocodetext;

    @FXML
    private Label totaltext;

    @FXML
    private Label totalamounttext;

    @FXML
    private Label discounttext;

    private ObservableList<Ligne_panier> e;



    @FXML
    void ShowcartAction(ActionEvent event) {
        //System.out.println(promocodeEtat);
        Ligne_PanierService lps =new Ligne_PanierService();
        PanierService p =new PanierService();
        List<Ligne_panier> pa = lps.readelementPanierbyiduser(3);//normally el id eli tebda andd nada mta authentification
        e= FXCollections.observableArrayList(pa);
        listView.setItems(e);
        totaltext.setText(String.valueOf(p.totalmontantPanier(3)) + " DT"); // total sans discount & normally el id eli tebda andd nada mta authentification
        totalamounttext.setText(String.valueOf(p.totalmontantPanier(3)) + " DT");// total avec discount & normally el id eli tebda andd nada mta authentification

        //System.out.println(id_panierlistview);
        if (listView.getItems().isEmpty()){
            //System.out.println("it's empty");
        }else{
            id_panierlistview = listView.getFocusModel().getFocusedItem().getId(); //static idpanier mesh najm n5ou value men class okhra
            System.out.println(id_panierlistview);
        }
        if (promocodeEtat==true){
            discounttext.setText("20%");
            totalamounttext.setText(String.valueOf(p.totalmontantPanierWith20Discount(3)) + " DT");
        }else{
            discounttext.setText("0%");
            totaltext.setText(String.valueOf(p.totalmontantPanier(3)) + " DT");
        }
        listView.setCellFactory(param -> new ListCell<Ligne_panier>() {
            private final ImageView imageViewArticle = new ImageView();
            //private final Button buttonDelete = new Button("Delete");
            //private final Button buttonPlus = new Button("+1");
            //private final Button buttonMinus = new Button("-1");
            @Override
            protected void updateItem(Ligne_panier item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);

                } else {

                    Image img =new Image("C:/Users/medya/IdeaProjects/artflow_javafx_Pidev/src/main/resources/images/artflowlogoo.png");
                    imageViewArticle.setFitHeight(200);
                    imageViewArticle.setFitWidth(200);
                    imageViewArticle.setImage(img);

                    //tostring
                    Label contenu =new Label(item.toString());
                    contenu.setStyle("-fx-font-family: Arial; -fx-font-size: 16;");

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

    @FXML
    void deleteLignePanierAction(ActionEvent event) {
        Ligne_PanierService lps = new Ligne_PanierService();
        int id_panier = listView.getSelectionModel().getSelectedItem().getId(); //ken getId_panier() eli kent fi fetch l9dima
        int id_article = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        lps.deleteFromLigne_panierByArticle(id_panier,id_article);
        ShowcartAction(event);
        alertDialog("Article supprimer avec sucess!");
    }
    @FXML
    void ViderPanierActionforuser(ActionEvent event){
        PanierService p =new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();
        int id_panier = listView.getFocusModel().getFocusedItem().getId(); //bel get focus mesh najmo nfaskho sans selectionne w select tebda auto ala awel index w tantque id panier kolhom kifi fi list view
        lps.deleteAllFromLigne_panier(id_panier);
        ShowcartAction(event);
        alertDialog("Panier vidé !");
    }
    @FXML
    void addOnetoarticleAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId();//ken getId_panier() eli kent fi fetch l9dima
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        try {
            lps.updatequantitywith1Plus(selectedidpanier,selectedidarticle);
            System.out.println("Quantity add by one");
            ShowcartAction(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void minusOnetoarticleAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        // """"""
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        try {
            lps.updatequantitywith1Minus(selectedidpanier,selectedidarticle);
            System.out.println("Quantity decreased by one");
            ShowcartAction(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void commandeAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        int selectidpanierfocus = listView.getFocusModel().getFocusedItem().getId(); //me8ir manselectionni
        System.out.println(listView.getFocusModel().getFocusedItem().getId());
        //len panier vide
        if(lps.readelementPanierbyidpanier(selectidpanierfocus).isEmpty()){
            System.out.println("Panier est vide");
            alertDialog("Votre Panier est vide !");
        //ken panier fiha elements net3adew lel formulaire commande
        }else{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("commandeView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) comamanderbut.getScene().getWindow();
        stage.setScene(scene);
        stage.show();}

    }

    //button promocode
    @FXML
    void PromocodeOnAction(ActionEvent event) {
        PromoCodeService pcs =new PromoCodeService();
        String codetyped = (String) Promocodetext.getText();
        //nshofo ken eli code eli ketbo utilisateur fi testfield mawjoud fi bd wala le.
        //si mawjoud
        if(pcs.verifierPromocode(codetyped)==true){
            promocodeEtat =true;
            //System.out.println(promocodeEtat);
            System.out.println("Congratzulation you have 20% discount");
            alertDialog("Congratzulation you have 20% discount");
            //nfas5o code mel bd
            pcs.deletepromocode(codetyped);
            pcs.generatenewCode();
            ShowcartAction(event);


        }else{
            System.out.println("Wrong PromoCode ! Try again");
            alertDialog("Wrong PromoCode ! Try again");
        }
    }

    void alertDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ShowcartAction(null);
    }
    /*static class XCell extends ListCell<String> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Button button = new Button("(>)");
        String lastItem;

        public XCell() {
            super();
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(lastItem + " : " + event);
                }
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item;
                label.setText(item!=null ? item : "<null>");
                setGraphic(button);
            }
        }
    }*/





}
