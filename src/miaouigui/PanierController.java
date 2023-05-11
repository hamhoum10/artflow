package miaouigui;

import GUIissaAli.EvenementController;
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
import javafx.scene.input.MouseEvent;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import pidevAuth.LoginFXMLController;
import services.ClientService;

public class PanierController implements Initializable {

    static boolean promocodeEtat; // na3rfou si el utilisateur sta3mel code (true) sinon false , wmesh nest7a9ouh baed fi view commande mesh nafshiw total en fonction de ce variable (discount ou non)

    static int id_panierlistview;
    @FXML
    private Button addOne;

    @FXML
    private Button MinusOne;

    @FXML
    private Button comamanderbut;


    @FXML
    private Button delete;

    @FXML
    private Button viderPanier;

    @FXML
    private ImageView logo;

    @FXML
    private ListView<Ligne_panier> listView;

    @FXML
    private TextField Promocodetext;

    @FXML
    private Label totaltext;

    @FXML
    private Label totalamounttext;

    @FXML
    private Label discounttext;

    private ObservableList<Ligne_panier> e;
    Ligne_PanierService lps = new Ligne_PanierService();
     ClientService clientService = new ClientService();
    @FXML
    private Button donepromo;
    PanierService p = new PanierService();

    void ShowcartAction(ActionEvent event) throws SQLException {
        
        //System.out.println(promocodeEtat);
        ClientService clientService = new ClientService();
        Ligne_PanierService lps = new Ligne_PanierService();
        PanierService p = new PanierService();
        

        List<Ligne_panier> pa = lps.readelementPanierbyiduser(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome));//normally el id eli tebda andd nada mta authentification wnafishiw el contenu mta panier mta user heka w najmou nrecupriw ay 7ja mawjoud fi model ligne panier mta kol ligne fi list view ki namloulo selection
        System.out.println(pa);
                
        e = FXCollections.observableArrayList(pa);
        listView.setItems(e);
        System.out.print(e);
        totaltext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT"); // total sans discount & normally el id eli tebda andd nada mta authentification
        totalamounttext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT");// total avec discount & normally el id eli tebda andd nada mta authentification

        //System.out.println(id_panierlistview);
        if (listView.getItems().isEmpty()) {
            //System.out.println("it's empty");
        } else {
            
            id_panierlistview = listView.getFocusModel().getFocusedItem().getId(); //static idpanier mesh najm n5ou value men class okhra
            System.out.print(id_panierlistview);
            System.out.println("ZZZZZZZZZZZZZZZZZZZZZZ : "+id_panierlistview);
        }
        if (promocodeEtat == true) {
            discounttext.setText("20%");
            totalamounttext.setText(String.valueOf(p.totalmontantPanierWith20Discount(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT");
        } else {
            discounttext.setText("0%");
            totaltext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT");
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

                    //System.out.println(item.getArticle().getImage());
                    Image img = new Image("C:/xampp/htdocs/img/" + item.getArticle().getImage());
                    System.out.println(item.getArticle().getImage()+" ------------------------------------------------------------------------------------------");
                    imageViewArticle.setFitHeight(300);
                    imageViewArticle.setFitWidth(300);
                    imageViewArticle.setImage(img);

                    //tostring
                    Label contenu = new Label(item.toString());
                    contenu.setStyle("-fx-font-family: Arial; -fx-font-size: 18;");

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
                    centerleftBox.setSpacing(50);
                    borderPane.setLeft(centerleftBox);

                    setGraphic(borderPane);

                }
            }
        });

    }

    @FXML
    void deleteLignePanierAction(ActionEvent event) throws SQLException {
        Ligne_PanierService lps = new Ligne_PanierService();
        int id_panier = listView.getSelectionModel().getSelectedItem().getId(); //ken getId_panier() eli kent fi fetch l9dima
        int id_article = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        lps.deleteFromLigne_panierByArticle(id_panier, id_article);
         List<Ligne_panier> pa = lps.readelementPanierbyiduser(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome));//normally el id eli tebda andd nada mta authentification wnafishiw el contenu mta panier mta user heka w najmou nrecupriw ay 7ja mawjoud fi model ligne panier mta kol ligne fi list view ki namloulo selection
            System.out.println(pa);
            
            e = FXCollections.observableArrayList(pa);
            listView.setItems(e);
        alertDialog("Article supprimer avec sucess!");
    }

    @FXML
    void ViderPanierActionforuser(ActionEvent event) throws SQLException {
        PanierService p = new PanierService();
        Ligne_PanierService lps = new Ligne_PanierService();
        int id_user = clientService.getidclientbyusername(LoginFXMLController.usernamewelcome);
        int id_panieruser= p.getPanierIdByIDUser(id_user);
        //int id_panier = listView.getFocusModel().getFocusedItem().getId(); //bel get focus mesh najmo nfaskho sans selectionne w select tebda auto ala awel index w tantque id panier kolhom kifi fi list view
        lps.deleteAllFromLigne_panier(id_panieruser);
        ShowcartAction(event);
        alertDialog("Panier vidé !");
    }

    @FXML
    void addOnetoarticleAction(ActionEvent event) {
        Ligne_PanierService lps = new Ligne_PanierService();
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId();//ken getId_panier() eli kent fi fetch l9dima
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        try {
            lps.updatequantitywith1Plus(selectedidpanier, selectedidarticle);
            System.out.println("Quantity add by one");
             List<Ligne_panier> pa = lps.readelementPanierbyiduser(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome));//normally el id eli tebda andd nada mta authentification wnafishiw el contenu mta panier mta user heka w najmou nrecupriw ay 7ja mawjoud fi model ligne panier mta kol ligne fi list view ki namloulo selection
            System.out.println(pa);
            
            e = FXCollections.observableArrayList(pa);
            listView.setItems(e);
            totaltext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT"); // total sans discount & normally el id eli tebda andd nada mta authentification
            totalamounttext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT");// total avec discount & normally el id eli tebda andd nada mta authentification
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void minusOnetoarticleAction(ActionEvent event) {
        Ligne_PanierService lps = new Ligne_PanierService();
        // """"""
        int selectedidpanier = listView.getSelectionModel().getSelectedItem().getId();
        int selectedidarticle = listView.getSelectionModel().getSelectedItem().getArticle().getId_article();
        try {
            lps.updatequantitywith1Minus(selectedidpanier, selectedidarticle);
            System.out.println("Quantity decreased by one");
            List<Ligne_panier> pa = lps.readelementPanierbyiduser(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome));//normally el id eli tebda andd nada mta authentification wnafishiw el contenu mta panier mta user heka w najmou nrecupriw ay 7ja mawjoud fi model ligne panier mta kol ligne fi list view ki namloulo selection
            System.out.println(pa);
            
            e = FXCollections.observableArrayList(pa);
            listView.setItems(e);
            totaltext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT"); // total sans discount & normally el id eli tebda andd nada mta authentification
            totalamounttext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT");// total avec discount & normally el id eli tebda andd nada mta authentification
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void commandeAction(ActionEvent event) throws SQLException {
        
      
        
        Ligne_PanierService lps = new Ligne_PanierService();
        
        //int selectidpanierfocus = listView.getFocusModel().getFocusedItem().getId(); //me8ir manselectionni
       int id_user = clientService.getidclientbyusername(LoginFXMLController.usernamewelcome);
       int id_panieruser= p.getPanierIdByIDUser(id_user);
        //len panier vide
        if (lps.readelementPanierbyidpanier(id_panieruser).isEmpty()) {
            System.out.println("Panier est vide");
            alertDialog("Votre Panier est vide !");
            //ken panier fiha elements net3adew lel formulaire commande
        } else {
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
            stage.show();
        }

    }

    //button promocode
    @FXML
    void PromocodeOnAction(ActionEvent event) throws SQLException {
        PromoCodeService pcs = new PromoCodeService();
        String codetyped = (String) Promocodetext.getText();
        //nshofo ken eli code eli ketbo utilisateur fi testfield mawjoud fi bd wala le.
        //si mawjoud
        if (pcs.verifierPromocode(codetyped) == true) {
            promocodeEtat = true;
            //System.out.println(promocodeEtat);
            System.out.println("Congratzulation you have 20% discount");
            alertDialog("Congratzulation you have 20% discount");
            //nfas5o code mel bd
            pcs.deletepromocode(codetyped);
            pcs.generatenewCode();
             totalamounttext.setText(String.valueOf(p.totalmontantPanierWith20Discount(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT");
             discounttext.setText("%20");
             
                        

        } else {
            System.out.println("Wrong PromoCode ! Try again");
            alertDialog("Wrong PromoCode ! Try again");
        }
    }

    @FXML
    void HomeAction(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../GUIissaAli/View_Evemt.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
       
        

    }

    void alertDialog(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            try {
                List<Ligne_panier> pa = lps.readelementPanierbyiduser(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome));//normally el id eli tebda andd nada mta authentification wnafishiw el contenu mta panier mta user heka w najmou nrecupriw ay 7ja mawjoud fi model ligne panier mta kol ligne fi list view ki namloulo selection
                System.out.println(pa);
                
                e = FXCollections.observableArrayList(pa);
                listView.setItems(e);
            } catch (SQLException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            totaltext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT"); // total sans discount & normally el id eli tebda andd nada mta authentification
            totalamounttext.setText(String.valueOf(p.totalmontantPanier(clientService.getidclientbyusername(LoginFXMLController.usernamewelcome))) + " DT");// total avec discount & normally el id eli tebda andd nada mta authentification
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }
    
        
   

    @FXML
    private void gotoenchere(MouseEvent event) {
    }

    @FXML
    private void gotoevent(MouseEvent event) {
         try {
            //bonPlanService.update(bonPlanService.readById(selectedId));
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./View_Evemt.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
