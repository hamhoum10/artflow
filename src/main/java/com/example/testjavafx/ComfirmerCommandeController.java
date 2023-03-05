package com.example.testjavafx;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Commande;
import services.CommandeService;
import services.Ligne_PanierService;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ComfirmerCommandeController implements Initializable {

    @FXML
    private Button imprimer;

    @FXML
    private Button retour;



    @FXML
    private Button showCommande;

    @FXML
    private Label adresselabel;

    @FXML
    private Label codepostallabel;

    @FXML
    private Label creelabel;

    @FXML
    private Label numerilabel;

    @FXML
    private Label prenomlabel;

    @FXML
    private Label statuslabel;

    @FXML
    private Label totallabel;

    @FXML
    private Label nomlabel;

    @FXML
    private ListView<Commande> listviewcommande;



    @FXML
    void showCommandeAction(ActionEvent event) {

        prenomlabel.setText(CommandeController.prenomsta);
        nomlabel.setText(CommandeController.nomsta);
        codepostallabel.setText(String.valueOf(CommandeController.codepostalsta));
        statuslabel.setText(CommandeController.statussta);
        creelabel.setText(CommandeController.createdsta);
        numerilabel.setText(CommandeController.numerosta);
        totallabel.setText(String.valueOf(CommandeController.totalsta));
        adresselabel.setText(CommandeController.adressesta);



       /* CommandeService cs =new CommandeService();
        List<Commande> commandeList =cs.readCommandesbyPanier(4);
        ObservableList<Commande> e= FXCollections.observableArrayList(commandeList);
        listviewcommande.setItems(e);

        listviewcommande.setCellFactory(param -> new ListCell<Commande>() {
            @Override
            protected void updateItem(Commande item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);

                } else {
                prenomlabel.setText(item.getPrénomClientCommande());
                nomlabel.setText(item.getNomClientCommande());
                codepostallabel.setText(String.valueOf(item.getCodepostal()));
                statuslabel.setText(item.getStatus());
                creelabel.setText(item.getCreatedAt());
                numerilabel.setText(String.valueOf(item.getNumeroPhoneclient()));
                totallabel.setText(String.valueOf(item.getTotalAmount())+ "DT");
                adresselabel.setText(item.getAdresse());


                    //tostring
                    Label contenu =new Label(item.toString());
                    contenu.setStyle("-fx-font-family: Arial; -fx-font-size: 12;");

                    //BORDERPANE
                    BorderPane borderPane = new BorderPane();
                    borderPane.setCenter(contenu);

                    //contenu el ToString()
                    HBox centerBox = new HBox(contenu);
                    centerBox.setAlignment(Pos.CENTER_LEFT);
                    centerBox.setSpacing(5);
                    borderPane.setCenter(centerBox);




                    setGraphic(borderPane);

                }
            }
        });*/
    }
    @FXML
    void BacktoPanierAction(ActionEvent event) {
        Ligne_PanierService lps =new Ligne_PanierService();
        CommandeService commandeService =new CommandeService();
        commandeService.deleteCommande(PanierController.id_panierlistview); //4
        lps.deleteAllFromLigne_panier(PanierController.id_panierlistview);//4
        //PanierController.id_panierlistview=  ps.getPanierIdByIDUser(3); //lezem n7ot id bel methode hethi alkhtr valeur static mesh ywali null w twli errors, w momken le mezelt ntesti


        FXMLLoader loader = new FXMLLoader(getClass().getResource("panierView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) retour.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void imprimerCommandeAction(ActionEvent event) throws com.lowagie.text.DocumentException, IOException {

        //5edmt el pdf

        Document document =new Document();
        PdfWriter.getInstance(document,new FileOutputStream("recuCommande.pdf"));
        document.open();
        Image image = Image.getInstance("C:/Users/medya/IdeaProjects/artflow_javafx_Pidev/src/main/resources/images/artflowlogoo.png");

        int moveLeft = 50; // the amount of movement to the left
        float newX = 500 - ((150 - 120) / 2) - moveLeft; // calculate the new X coordinate
        image.setAbsolutePosition(newX, 750);
        image.scaleAbsolute(150, 150);

        document.add(image);
        document.add(new Paragraph("\n"));
        Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);
        document.add(new Paragraph("2030 rue ezzahra "));
        document.add(new Paragraph("71666016"));
        document.add(new Paragraph("artflow@art.com"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("___________________________"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Client :" + CommandeController.prenomsta +" " + CommandeController.numerosta));
        document.add(new Paragraph("Numero :" + CommandeController.numerosta ));
        document.add(new Paragraph("status : effectué"  ));
        document.add(new Paragraph("Adresse :" + CommandeController.adressesta ));
        document.add(new Paragraph("codepostale : :" + CommandeController.codepostalsta ));
        document.add(new Paragraph("teamp de creation :" + CommandeController.createdsta ));
        document.add(new Paragraph("Total :" + CommandeController.totalsta + " DT"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("___________________________"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Entreprise : ArtFlow"));
        document.close();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF File");
        File file = fileChooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());

        if (file != null) {
            try {
                FileInputStream inputStream = new FileInputStream("recuCommande.pdf");
                OutputStream outputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                inputStream.close();
                outputStream.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("PDF Downloaded");
                alert.setContentText("The PDF has been downloaded successfully.");
                alert.showAndWait();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File Error");
                alert.setContentText("An error occurred while reading or writing the file.");
                alert.showAndWait();
            }
}






        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("panierView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) imprimer.getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/

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
        showCommandeAction(null);
    }
}



