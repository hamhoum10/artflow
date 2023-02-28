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
        List<Ligne_panier> pa = lps.readelementPanierbyiduser(3);
        e= FXCollections.observableArrayList(pa);
        listView.setItems(e);
        totaltext.setText(String.valueOf(p.totalmontantPanier(3)) + " DT"); // total sans discount
        totalamounttext.setText(String.valueOf(p.totalmontantPanier(3)) + " DT");// total avec discount
        if (promocodeEtat==true){
            discounttext.setText("20%");
            totalamounttext.setText(String.valueOf(p.totalmontantPanierWith20Discount(3)) + " DT");
        }else{
            discounttext.setText("0%");
            totaltext.setText(String.valueOf(p.totalmontantPanier(3)) + " DT");
        }
        listView.setCellFactory(param -> new ListCell<Ligne_panier>() {
            private final ImageView imageViewArticle = new ImageView();
            private final Button buttonDelete = new Button("Delete");
            private final Button buttonPlus = new Button("+1");
            private final Button buttonMinus = new Button("-1");
            @Override
            protected void updateItem(Ligne_panier item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    /*buttonDelete.setOnAction(event -> {
                        //int index = getIndex();
                        //if (index >= 0 && index < listView.getItems().size()) {}
                        //System.out.println(e.indexOf(getItem().getId_panier()));
                        //System.out.println(listView.getItems().indexOf(getItem()));
                        deleteLignePanierAction(event);
                        listView.getItems().indexOf(getItem());
                        ShowcartAction(event);



                    });
                    buttonPlus.setOnAction(event -> {
                        addOnetoarticleAction(event);
                        listView.getItems().remove(getItem());
                        ShowcartAction(event);
                    });
                    buttonMinus.setOnAction(event -> {
                        minusOnetoarticleAction(event);
                        listView.getItems().remove(getItem());
                        ShowcartAction(event);
                    });*/
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
                    /*
                    //button delete
                    HBox bottomRightBox = new HBox(buttonDelete);
                    bottomRightBox.setAlignment(Pos.BOTTOM_RIGHT);
                    bottomRightBox.setSpacing(50);
                    borderPane.setRight(bottomRightBox);

                    //button + et -
                    HBox bottomLeftBox = new HBox(buttonPlus, buttonMinus);
                    bottomLeftBox.setAlignment(Pos.BOTTOM_LEFT);
                    bottomLeftBox.setSpacing(5);
                    borderPane.setBottom(bottomLeftBox);*/

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
        PanierService p =new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();

        // Delete by selecting el ligne(article eli fi panier) w baed tclick ala button delete eli hwa mesh fi list aslan
        /*int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        //System.out.println(selectedidpanier+ ""+ selectedidarticle);
        lps.deleteFromLigne_panierByArticle(selectedidpanier,selectedidarticle);
        ShowcartAction(event);
        alertDialog("Article supprimer avec sucess!");*/

        //hethi just tenzel al button tfas5 ligne apparament Focuseditem yani winn ybda cursor fi ligne mel list naml extraction mta donnes eli mesh nestamlhom fi delete
        //int id_panier  = listView.getFocusModel().focusedItemProperty().get().getId_panier();
        //int id_article  = listView.getFocusModel().focusedItemProperty().get().getArticle().getId_article();
        int id_panier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int id_article = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        //System.out.println(id_panier +"   "+id_article);
        //lps.deleteFromLigne_panierByArticle(id__panier,id__article);
        lps.deleteFromLigne_panierByArticle(id_panier,id_article);
        ShowcartAction(event);
        alertDialog("Article supprimer avec sucess!");
    }
    @FXML
    void ViderPanierActionforuser(ActionEvent event){
        PanierService p =new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();
        lps.deleteAllFromLigne_panier(4);
        ShowcartAction(event);
    }
    @FXML
    void addOnetoarticleAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        //methode 9dima ama heya eli mesh n(aliha apparament
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();

        //methode  o5ra meh
        //int id_panier  = listView.getFocusModel().focusedItemProperty().get().getId_panier();
        //int id_article  = listView.getFocusModel().focusedItemProperty().get().getArticle().getId_article();
        //System.out.println(selectedidpanier +"   "+selectedidarticle);
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
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId_panier();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();

        //new
        //int id_panier  = listView.getFocusModel().focusedItemProperty().get().getId_panier();
        //int id_article  = listView.getFocusModel().focusedItemProperty().get().getArticle().getId_article();
        //System.out.println(selectedidpanier +"   "+selectedidarticle);
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
        //len panier vide
        if(lps.readelementPanierbyidpanier(4).isEmpty()){
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
