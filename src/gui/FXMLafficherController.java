/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Article;
import services.ArticleService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import models.User;
import pidevAuth.LoginFXMLController;
import pidevAuthArtiste.LoginArtisteController;
import services.ArtisteService;
import services.UserService;


/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLafficherController implements Initializable {
    ArticleService h = new ArticleService();
Article ai=new Article();
    private ListView<Article> listaf;
    @FXML
    private GridPane articleGrid;
//    @FXML
//    private TextField prix;
//    
//    @FXML
//    private TextField caracter;
    
    private List<Article> articles;
    private TextField car;
    private TextField prix;
    @FXML
    private TextField prix_max;
    @FXML
    private TextField prix_min;
    @FXML
    private TextField id_rech;
     private ObservableList<Article> allArticles;
    private FilteredList<Article> filteredArticles;
    @FXML
    private VBox vbox;
    @FXML
    private ImageView add_article_id;
    @FXML
    private ImageView statistic_id;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String uuu=LoginArtisteController.usernameArtiste;
        System.out.println(uuu);
        try {
            recherche_avance();
        } catch (IOException ex) {
            Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }  
    
    
    public void afficher_Articles(List<Article> articles) throws IOException {
        articleGrid.getChildren().clear();
        //articles = h.fetchArticle();
        UserService us =new UserService();
        if(LoginArtisteController.usernameArtiste!=null){
            vbox.getChildren().remove(statistic_id);
        }
        if(LoginFXMLController.usernamewelcome!=null){
            vbox.getChildren().remove(statistic_id);
             vbox.getChildren().remove(add_article_id);
        }
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<articles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            AnchorPane item;
            if(articles.get(i).getArtiste().getId()==10 ||true){
                    fxmlLoader.setLocation(getClass().getResource("ArticleItem.fxml"));
            
             item = fxmlLoader.load();
           
            
            ArticleItemController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));}
            else {
                fxmlLoader.setLocation(getClass().getResource("FXMLafficherclient.fxml"));
            
             item = fxmlLoader.load();
           
            
            FXMLafficherclientController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));}
            
                
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            articleGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    private void modify_list(ActionEvent event) {
        try {
        Article selectedarticle=listaf.getSelectionModel().getSelectedItem();
        
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML1.fxml"));
        Parent view_2=loader.load();
        FXML1Controller FXML1Controller=loader.getController();
        FXML1Controller.getArticlee(selectedarticle);
        FXML1Controller.a=selectedarticle;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void ajouterArticle(ActionEvent event) {
        try {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void rechprix(MouseEvent event) {
        Double min,max=0.0;
        if(prix_min.getText()==""){
            min=0.0;
        }else min=Double.parseDouble(prix_min.getText());
        
        
        
        if(prix_min.getText()==""){
            max=100000.0;
        }else min=Double.parseDouble(prix_max.getText());
        articleGrid.getChildren().clear();
        articles = h.fetchArticleByPrice(min,max);
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<articles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ArticleItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            ArticleItemController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));
            
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            articleGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    @FXML
    private void rechercheprix(MouseEvent event) {
//         Double min=0.0;Double max=100000.0;
//            if(prix_min.getText().length()==0){
//            }else min=Double.parseDouble(prix_min.getText());
//            System.out.println(Double.parseDouble(prix_min.getText()));
//        
//        
//        
//        if(prix_max.getText().length()==0){
//            max=100000.0;System.out.println("no max");
//        }else min=Double.parseDouble(prix_max.getText());
        
        if(prix_min.getText().length()==0)
            prix_min.setText("0.0");
        if(prix_max.getText().length()==0)
            prix_max.setText("100000.0");
        
        articleGrid.getChildren().clear();
        articles = h.fetchArticleByPrice(Double.parseDouble(prix_min.getText()),Double.parseDouble(prix_max.getText()));
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<articles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ArticleItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            ArticleItemController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));
            
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            articleGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void recherchcara(MouseEvent event) {
                articleGrid.getChildren().clear();
        articles = h.fetchArticleByCaracter(car.getText());
        int columns=0;
        int rows=0;
        try {
        for(int i=0;i<articles.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ArticleItem.fxml"));
            
            AnchorPane item = fxmlLoader.load();
           
            
            ArticleItemController itemController = fxmlLoader.getController();
            System.out.println(articles.get(i));
            itemController.setData(articles.get(i));
            
            if(columns == 4){
                columns = 0 ;
                ++rows;
            }
            
            articleGrid.add(item, columns++, rows);
        }}
              catch (IOException ex) {
                Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void stat_art(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLstat.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    }
    
    
    
    
     

    
    

//    @FXML
//    private void handleReadExcelButton(ActionEvent event)throws FileNotFoundException, IOException {
//            
//         XWPFDocument document = new XWPFDocument();
//       FileOutputStream out = new FileOutputStream(new File("demo.docx"));
//       XWPFParagraph paragraph = document.createParagraph();
//       XWPFRun run = paragraph.createRun();
//        String value1 = ftNom.getText();
//           
//            
//            String value2 = ftAdresse.getText();
//            String value3 = ftPrixph.getText();
//            String value4 = ftContact.getText();
//            String value5 = ftImage.getText();
//            String s1 = "";
//            s1= s1.concat("         namepro:"     ).concat(value1).concat("     ADRESS:     ").concat(value2).concat("      PRICE:    ").
//                    concat(value3).concat("      CONTACT:         ").concat(value4).concat("      OWNER:        ").concat(value5);
//       run.setText(s1);
//       document.write(out);
//       out.close();
//       Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Information");
//                alert.setHeaderText(null);
//                alert.setContentText("DOCUMENT ENREGISTRE");
//                
//                alert.showAndWait();
//    }
public void refresh() {
    
        allArticles.setAll(new ArticleService().fetchArticle());
    }

    private void recherche_avance() throws IOException {
        
       afficher_Articles(h.fetchArticle());
        ObservableList<Article> Articles=FXCollections.observableArrayList(h.fetchArticle());
        FilteredList<Article> filtreddata=new FilteredList<>(Articles,r->true);
        id_rech.textProperty().addListener((observable,oldValue,newValue)->{
           try {
               filtreddata.setPredicate(art->{
                   if(newValue==null||newValue.isEmpty()){
                       return true;
                   }
                   String newValuelowercase=newValue.toLowerCase();
                   if(art.getNom_article().toLowerCase().indexOf(newValuelowercase)!=-1){
                       return true;
                   }
                   else if(art.getDescription().toLowerCase().indexOf(newValuelowercase)!=-1){
                       return true;
                   }
                   else if(String.valueOf(art.getPrice()).toLowerCase().indexOf(newValuelowercase)!=-1){
                       return true;
                   }
                   else if(String.valueOf(art.getQuantity()).toLowerCase().indexOf(newValuelowercase)!=-1){
                       return true;
                   }
                   else{
                       return false;
                   }
               });
               afficher_Articles(filtreddata);
           } catch (IOException ex) {
               Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
           }
        });
    }

    @FXML
    private void ajouterArticle(MouseEvent event) {
         try {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXML.fxml"));
        Parent view_2=loader.load();
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    @FXML
    private void stat_art(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../gui/FXMLstat.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    }

   
    

    
    
}
