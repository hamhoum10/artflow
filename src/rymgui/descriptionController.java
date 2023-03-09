/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rymgui;


import com.google.zxing.WriterException;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Client;
import models.Enchere;
import models.Participant;
import pidevAuth.LoginFXMLController;
import services.ClientService;
import services.EnchereService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class descriptionController implements Initializable {

    EnchereService es = new  EnchereService();
    Participant p = new Participant();
    Enchere e = new Enchere();
    Client c = new Client();
    ClientService cs = new ClientService(); 
    @FXML
    private ImageView image_view;
    @FXML
    private Label desc;
    @FXML
    private Label datel;
    @FXML
    private Label title;
    @FXML
    private Label lastamount;
    @FXML
    private TextField mont;
    @FXML
    private Button downloadPDF;
    @FXML
    private ComboBox<String> nom_client;
     @FXML
    private ComboBox<String> titre; 
    ObservableList list1 = FXCollections.observableArrayList();
     ObservableList list2 = FXCollections.observableArrayList();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         list1.removeAll(list1);
         
          es.fetchEnchere().stream().forEach(e -> list1.add(e.getTitre()));
        titre.getItems().addAll(list1);
         
          
    }    
    
    
     void setEnchere(Enchere e) throws SQLException {
         lastamount.setText(String.valueOf(es.getHighestBidAmount1(e)));
        title.setText(e.getTitre());
        desc.setText(e.getDescription());
         File file=new File("C:\\xampp\\htdocs\\img\\"+e.getImg());
        Image img=new Image(file.toURI().toString());
        image_view.setImage(img);
         datel.setText(e.getDate_limite().toString());
//           double lastBidAmount = es.getHighestBidAmount(p);
////       lastamount.setText(String.valueOf(lastBidAmount));
         
 
    }

//    


    @FXML
    private void exit(ActionEvent event) throws IOException {
    FXMLLoader loader= new FXMLLoader(getClass().getResource("./ShowAllItems.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    
    }

    @FXML
    private void addParticipation(ActionEvent event) throws SQLException {
                    

    p.setMontant(Double.parseDouble(mont.getText()));
        double amount = es.getHighestBidAmount(p);
        if (p.getMontant() <= amount) {
                        System.out.println(es);

            // Display an error message if the bid amount is not higher than the current highest bid
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Bid Amount");
            alert.setContentText("Bid must be superior to " + amount + " DT");
            alert.showAndWait();
            System.out.println(es);
        } else {
            if (es.enchereExist(p)) {
                // Update the participant if they have already placed a bid
                            System.out.println(es);

                es.updateParticipant(p);
            } else {
                // Add the participant to the auction if they are a new bidder
                            System.out.println(es);

                es.addParticipant(p);
            }
        }
    }

  

    
    @FXML
    private void listeEnchere(ActionEvent event) {
    
       p.setEnchere(es.fetchEnchereByname(titre.getValue()));
        }
    
    
    
     @FXML
    private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException, BadElementException, IOException, WriterException {
        java.util.Date today = new java.util.Date();
        Participant winningBidder = es.getWinningBidder(p.getEnchere());
        ClientService clientService = new ClientService();
        Date dateLimite = p.getEnchere().getDate_limite();
        if (today.compareTo(dateLimite) > 0) {
            if (winningBidder.getClient().getId() ==  clientService.getidclientbyusername(LoginFXMLController.usernamewelcome)) {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));

                document.open();

                //com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance("C:\\Users\\Elizabeth\\Documents\\NetBeansProjects\\pidev\\src\\css\\image.png");

                int moveLeft = 50; // the amount of movement to the left
                float newX = 500 - ((150 - 120) / 2) - moveLeft; // calculate the new X coordinate
              //  image.setAbsolutePosition(newX, 750);
               // image.scaleAbsolute(150, 150);

              //  document.add(image);
                document.add(new Paragraph("\n"));
                Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);
                document.add(new Paragraph("2030 rue ezzahra ", smallFont));
                document.add(new Paragraph("71666016", smallFont));
                document.add(new Paragraph("artflow@art.com", smallFont));

                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph("__________________________________________________________________________"));

                document.add(new Paragraph("information de l'enchere"));
                document.add(new Paragraph("titre :             " + winningBidder.getEnchere().getTitre()));
                document.add(new Paragraph("description :             " + winningBidder.getEnchere().getDescription()));
                document.add(new Paragraph("date limite :             " + winningBidder.getEnchere().getDate_limite()));
                document.add(new Paragraph("date limite :             " + winningBidder.getEnchere().getImg()));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________________"));
                document.add(new Paragraph("information sur le gagnant : "));
                document.add(new Paragraph("username :             " + winningBidder.getClient().getUsername()));
                document.add(new Paragraph("prenom :             " + winningBidder.getClient().getFirstname()));
                document.add(new Paragraph("nom :             " + winningBidder.getClient().getLastname()));
                document.add(new Paragraph("adresse :             " + winningBidder.getClient().getAddress()));
                document.add(new Paragraph("telephone :             " + winningBidder.getClient().getPhonenumber()));
                document.add(new Paragraph("email :             " + winningBidder.getClient().getEmail()));

                document.add(new Paragraph("\n"));

                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________________"));
                document.add(new Paragraph("information additionnelles "));
                document.add(new Paragraph("Montant à payer(DT)             " + winningBidder.getMontant()));
                //   document.add(new Paragraph("felicitation vous avez gagner l'enchere"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));

                Paragraph qrSummary = new Paragraph("scannez le code qr à fin de recevoir une surprise");

                BarcodeQRCode qrCode = new BarcodeQRCode("De la part de l'équipe de la page : \n  Cher client,\\Au nom de toute l'équipe ArtFlow, \n En signe de notre gratitude, nous aimerions vous offrir un code promo de 20% sur votre prochain achat dans notre boutique en ligne avec lo code '', l'artiste aimerait vous faire parvenir une carte dédicacée en remerciement de votre achat. Celle-ci sera un petit témoignage de sa reconnaissance et de son appréciation de votre soutien à son travail.\n  Nous espérons que cette expérience d'enchère vous aura plu et que vous continuerez à soutenir l'art et les artistes à l'avenir.\n  Cordialement,\n L'équipe ArtFlow.", 1, 1, null);
                com.itextpdf.text.Image qrImage = qrCode.getImage();
                qrImage.scaleAbsolute(100, 100); // Increase the size to 100x100

                PdfPTable table = new PdfPTable(2); // Create a table with two columns
                table.setWidthPercentage(100); // Set the table width to 100%

                PdfPCell cell1 = new PdfPCell(qrSummary);
                cell1.setBorder(Rectangle.NO_BORDER); // Hide the cell border

                PdfPCell cell2 = new PdfPCell();
                cell2.setBorder(Rectangle.NO_BORDER); // Hide the cell border
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // Center the cell content horizontally
                Chunk emptyChunk = new Chunk(" ");
                cell2.addElement(emptyChunk); // Add an empty Chunk before the image
                cell2.addElement(qrImage); // Add the QR code image
                cell2.addElement(emptyChunk); // Add another empty Chunk after the image

                table.addCell(cell1);
                table.addCell(cell2);

                document.add(table);

                document.add(new Paragraph("\n"));

                Font botom = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
                Font condition = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
                document.add(new Paragraph("Conditions générales ", condition));
                document.add(new Paragraph("\n Paiement à effectuer de préférence par virement bancaire. \n La facture doit être payée dans un délai de 30 jours après sa date démission. En cas de retard de paiement, les pénalités de retard sélèvent à 10% du montant total de la facture. Lindemnité forfaitaire pour frais de recouvrement est de 200 Dinars. Indemnisation complémentaire sur justification. Escompte pour paiement anticipé :néant", botom));

                document.close();

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save PDF File");
                File file = fileChooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());

                if (file != null) {
                    try {
                        FileInputStream inputStream = new FileInputStream("winning_bidder.pdf");
                        OutputStream outputStream = new FileOutputStream(file);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = inputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, length);
                        }
                        inputStream.close();
                        outputStream.close();
                        
                        
                        String title ="The PDF has been downloaded successfully";
                        TrayNotification tray = new  TrayNotification();
                        AnimationType type =  AnimationType.POPUP;
                        
                        tray.setAnimationType(type);
                        tray.setTitle(title);
                        tray.setMessage(title);
                        tray.setNotificationType(NotificationType.SUCCESS);
                        tray.showAndDismiss(Duration.millis(3000));

//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Success");
//                        alert.setHeaderText("PDF Downloaded");
//                        alert.setContentText("The PDF has been downloaded successfully.");
//                        alert.showAndWait();
                    } catch (IOException e) {
                        
                        
                        String title ="An error occurred while reading or writing the file.";
                        TrayNotification tray = new  TrayNotification();
                        AnimationType type =  AnimationType.POPUP;
                        
                        tray.setAnimationType(type);
                        tray.setTitle(title);
                        tray.setMessage(title);
                        tray.setNotificationType(NotificationType.WARNING);
                        tray.showAndDismiss(Duration.millis(3000));
//                        Alert alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Error");
//                        alert.setHeaderText("File Error");
//                        alert.setContentText("An error occurred while reading or writing the file.");
//                        alert.showAndWait();
                    }
                }
            } else {
                
                        String title ="You are not authorized to download this PDF.";
                        TrayNotification tray = new  TrayNotification();
                        AnimationType type =  AnimationType.POPUP;
                        
                        tray.setAnimationType(type);
                        tray.setTitle(title);
                        tray.setMessage(title);
                        tray.setNotificationType(NotificationType.ERROR);
                        tray.showAndDismiss(Duration.millis(3000));
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Error");
//                alert.setHeaderText("Unauthorized Access");
//                alert.setContentText("You are not authorized to download this PDF.");
//                alert.showAndWait();
            }
        } else {
            
            
            
                        String title ="The auction is still open. You cannot download the PDF.";
                        TrayNotification tray = new  TrayNotification();
                        AnimationType type =  AnimationType.POPUP;
                        
                        tray.setAnimationType(type);
                        tray.setTitle(title);
                        tray.setMessage(title);
                        tray.setNotificationType(NotificationType.WARNING);
                        tray.showAndDismiss(Duration.millis(3000));
            
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Auction still open");
//            alert.setContentText("The auction is still open. You cannot download the PDF.");
//            alert.showAndWait();
        }
    }

    
    
    
    
    
    
    
    
    
    
    
}
