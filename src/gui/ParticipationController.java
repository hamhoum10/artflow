/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import models.Client;
import models.Enchere;
import models.Participant;
import services.ClientService;
import services.EnchereService;

/**
 * FXML Controller class
 *
 * @author Elizabeth
 */
public class ParticipationController implements Initializable {
     
    EnchereService es = new  EnchereService ();
    ClientService c = new ClientService();
    Enchere en = new Enchere();
    Participant p = new Participant();
    
    @FXML
    private TextField mont;
    @FXML
    private Label iden;
    @FXML
    private ComboBox<String> titre;
    
    ObservableList list1 = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> nom_client;
    @FXML
    private Label dateL;
    @FXML
    private Label lastamount;
    @FXML
    private Button downloadPDF;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list1.removeAll(list1);
        list2.removeAll(list2);
        es.fetchEnchere().stream().forEach(e->list1.add(e.getTitre()));
        titre.getItems().addAll(list1);
        c.fetchClient().stream().forEach(e->list2.add(e.getNom()));
        nom_client.getItems().addAll(list2);
      
       
        
    }    

    @FXML
    private void addParticipation(ActionEvent event) {
        p.setMontant(Double.parseDouble(mont.getText()));
        double amount = es.getHighestBidAmount(p);
    if (p.getMontant() <= amount) {
        // Display an error message if the bid amount is not higher than the current highest bid
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Bid Amount");
        alert.setContentText("Bid must be superior to " + amount + " DT");
        alert.showAndWait();
    } else {
        if (es.enchereExist(p)) {
            // Update the participant if they have already placed a bid
            es.updateParticipant(p);
        } else {
            // Add the participant to the auction if they are a new bidder
            es.addParticipant(p);
        }
    }
}
    

        
    

    @FXML
    private void listeEnchere(ActionEvent event) {
   
     //  p.setEnchere(es.fetchEnchereByname(titre.getValue())); THIS WORKS
       
      
        Enchere selectedEnchere = es.fetchEnchereByname(titre.getValue());
         
    if (selectedEnchere != null) {
        p.setEnchere(selectedEnchere);
        dateL.setText(selectedEnchere.getDate_limite().toString());
       
    } else {
        // Handle the case where no Enchere is found for the selected titre
        dateL.setText("No Enchere found for the selected titre.");
    }
    double lastBidAmount = es.getHighestBidAmount(p);
        lastamount.setText(String.valueOf(lastBidAmount));



}
   
        
   

    @FXML
    private void listeClient(ActionEvent event) {
        p.setClient(c.fetchClientByName(nom_client.getValue()));
    }
    



/*

    @FXML
    private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
    // Call the getWinningBidder() method to get the winning bidder for the selected auction
    Participant winningBidder = es.getWinningBidder(p.getEnchere());
    
    // Generate the PDF using the winning bidder information
    // You can use a third-party library such as iText to generate the PDF
    // For example:
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
    document.open();
    document.add(new Paragraph("Winning Bidder Information"));
    document.add(new Paragraph("Name: " +winningBidder.getEnchere().getTitre()+ winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
    document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
    document.close();
    
    // Display a success message to the user
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText("PDF Generated");
    alert.setContentText("The PDF has been generated successfully.");
    alert.showAndWait();
}

*/

    
    
    
    
    
    
    
    //-------------------------this code works
    
    
    /*
  

@FXML
    private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        // Call the getWinningBidder() method to get the winning bidder for the selected auction
        java.util.Date currentDate = new java.util.Date();
Participant winningBidder = es.getWinningBidder(p.getEnchere());

// Check if the current date is before the limit date of the auction
if (    currentDate.after(p.getEnchere().getDate_limite())) {
    
    // Check if the logged in user is the winning bidder
    if (winningBidder.getClient().getIdc() == p.getClient().getIdc()) {

        // Generate the PDF using the winning bidder information
        // You can use a third-party library such as iText to generate the PDF
        // For example:
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
        document.open();
        document.add(new Paragraph("Winning Bidder Information"));
        document.add(new Paragraph("Name: " +winningBidder.getEnchere().getTitre()+ winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
        document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
        document.close();

        // Display a success message to the user
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("PDF Generated");
        alert.setContentText("The PDF has been generated successfully.");
        alert.showAndWait();
    } else {
        // Display an error message to the user if they are not the winning bidder
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Unauthorized Access");
        alert.setContentText("You are not authorized to download this PDF.");
        alert.showAndWait();
    }
} else {
    // Display an error message to the user if the limit date has passed
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Auction still open");
    alert.setContentText("The auction has closed. You cannot download the PDF.");
    alert.showAndWait();
}

    }

 */   
    
 
  //  -----------------------------------------try 2

/*

    @FXML
    private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
    
    Participant winningBidder = es.getWinningBidder(p.getEnchere());

    // Check if the current date is after the limit date of the auction
    if (LocalDate.now().isAfter(p.getEnchere().getDate_limite().toLocalDate())) {
        // Check if the logged in user is the winning bidder
    // Check if the logged in user is the winning bidder
    if (winningBidder.getClient().getIdc() == p.getClient().getIdc()) {
        // Generate the PDF using the winning bidder information
        // You can use a third-party library such as iText to generate the PDF
        // For example:
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
        document.open();
        document.add(new Paragraph("Winning Bidder Information"));
        document.add(new Paragraph("Name : " +winningBidder.getEnchere().getTitre()+ winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
        document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
        document.close();

        // Display a success message to the user
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("PDF Generated");
        alert.setContentText("The PDF has been generated successfully.");
        alert.showAndWait();
    } else {
        // Display an error message to the user if they are not the winning bidder
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Unauthorized Access");
        alert.setContentText("You are not authorized to download this PDF.");
        alert.showAndWait();
    }
    }
    else{
    // Display an error message to the user if the limit date has not passed
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Auction Open");
    alert.setContentText("The auction is still open. You cannot download the PDF yet.");
    alert.showAndWait();

}



}*/

   // ------------------try 3 

/*
@FXML
private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
    
    Participant winningBidder = es.getWinningBidder(p.getEnchere());

    // Check if the current date is after the limit date of the auction
    if (LocalDate.now().isAfter(p.getEnchere().getDate_limite().toLocalDate())) {
        // Check if the logged in user is the winning bidder
if ( winningBidder.getClient().getIdc() == p.getClient().getIdc()) {
            // Generate the PDF using the winning bidder information
            // You can use a third-party library such as iText to generate the PDF
            // For example:
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
            document.open();
            document.add(new Paragraph("Winning Bidder Information"));
            document.add(new Paragraph("Name : " + winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
            document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
            document.close();

            // Display a success message to the user
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("PDF Generated");
            alert.setContentText("The PDF has been generated successfully.");
            alert.showAndWait();
        } 

else {
            // Display an error message to the user if they are not the winning bidder
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unauthorized Access");
            alert.setContentText("You are not authorized to download this PDF.");
            alert.showAndWait();
        } }
    else{
        // Display an error message to the user if they try to download the PDF before the limit date
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Auction Still Open");
        alert.setContentText("The auction is still open. You cannot download the PDF yet.");
        alert.showAndWait();
    }
   
}

*/

    
    
    
    
   // -----------------------------------4 
    
    
    /*
    
    @FXML
private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
    // Call the getWinningBidder() method to get the winning bidder for the selected auction
    Participant winningBidder = es.getWinningBidder(p.getEnchere());

    // Check if the current date is after the limit date of the auction
    if (LocalDate.now().isAfter(p.getEnchere().getDate_limite().toLocalDate())) {
   
   // Check if the logged in user is the winning bidder
      if (winningBidder != null && winningBidder.getClient().getIdc() == selectedUser.getIdc()) {

//  if (winningBidder != null && winningBidder.getClient().getIdc() == p.getClient().getIdc()) {
            // Generate the PDF using the winning bidder information
            // You can use a third-party library such as iText to generate the PDF
            // For example:
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
            document.open();
            document.add(new Paragraph("Winning Bidder Information"));
            document.add(new Paragraph("Name: " +winningBidder.getEnchere().getTitre()+ winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
            document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
            document.close();

            // Display a success message to the user
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("PDF Generated");
            alert.setContentText("The PDF has been generated successfully.");
            alert.showAndWait();
        } else {
            // Display an error message to the user if they are not the winning bidder
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unauthorized Access");
            alert.setContentText("You are not authorized to download this PDF.");
            alert.showAndWait();
        }
    } else {
        // Display an error message to the user if the limit date has not passed yet
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Auction Not Closed");
        alert.setContentText("The auction has not closed yet. You cannot download the PDF.");
        alert.showAndWait();
    }
}

    */
    
    
    
    
    
    
    /*
      @FXML
    private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
    // Call the getWinningBidder() method to get the winning bidder for the selected auction
    java.util.Date currentDate = new java.util.Date();
    Participant winningBidder = es.getWinningBidder(p.getEnchere());

    // Check if the current date is before the limit date of the auction
    if (currentDate.after(p.getEnchere().getDate_limite())) {
        // Check if the logged in user is the winning bidder
        if (winningBidder.getClient().getIdc() == p.getClient().getIdc()) {
            // Generate the PDF using the winning bidder information
            // You can use a third-party library such as iText to generate the PDF
            // For example:
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
            document.open();
            document.add(new Paragraph("Winning Bidder Information"));
            document.add(new Paragraph("Name: " +winningBidder.getEnchere().getTitre()+ winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
            document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
            document.close();

            // Use a FileChooser to prompt the user to select a directory where the PDF file will be saved
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF File");
            File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());

            if (file != null) {
                // Read the PDF file and send it to the user as a downloadable attachment
                try {
                    OutputStream outputStream;
                    try (FileInputStream inputStream = new FileInputStream("winning_bidder.pdf")) {
                        outputStream = new FileOutputStream(file);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = inputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, length);
                        }
                    }
                    outputStream.close();

                    // Display a success message to the user
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("PDF Downloaded");
                    alert.setContentText("The PDF has been downloaded successfully.");
                    alert.showAndWait();
                } catch (IOException e) {
                    // Display an error message if an error occurs while reading or writing the file
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("File Error");
                    alert.setContentText("An error occurred while reading or writing the file.");
               
}
}
 else {
// Display an error message to the user if they are not the winning bidder
Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Error");
alert.setHeaderText("Unauthorized Access");
alert.setContentText("You are not authorized to download this PDF.");
alert.showAndWait();
}
            }
    }
 else {
// Display an error message to the user if the limit date has not passed
Alert alert = new Alert(AlertType.ERROR);
alert.setTitle("Error");
alert.setHeaderText("Auction still open");
alert.setContentText("The auction has not closed yet. You cannot download the PDF.");
alert.showAndWait();
}
}
    
  */  
    
    
    
    
    
    
   //---------------------------------------------------------------------------------------this workssssssssssssss 
    /*
    @FXML
private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
    // Call the getWinningBidder() method to get the winning bidder for the selected auction
    Participant winningBidder = es.getWinningBidder(p.getEnchere());
    
    // Generate the PDF using the winning bidder information
    // You can use a third-party library such as iText to generate the PDF
    // For example:
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
    document.open();
    document.add(new Paragraph("Winning Bidder Information"));
    document.add(new Paragraph("Name: " +winningBidder.getEnchere().getTitre()+ winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
    document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
    document.close();
    
    // Use a FileChooser to prompt the user to select a directory where the PDF file will be saved
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save PDF File");
    File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
    
    if (file != null) {
        // Read the PDF file and send it to the user as a downloadable attachment
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
            
            // Display a success message to the user
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("PDF Downloaded");
            alert.setContentText("The PDF has been downloaded successfully.");
            alert.showAndWait();
        } catch (IOException e) {
            // Display an error message if an error occurs while reading or writing the file
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("File Error");
            alert.setContentText("An error occurred while reading or writing the file.");
            alert.showAndWait();
        }
    }
}

    */
    
    //---------------------------------------------------this works when the auction is closed he can download the code but everyone can 
    
    
    @FXML
private void downloadPDF(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
    // Call the getWinningBidder() method to get the winning bidder for the selected auction
    Participant winningBidder = es.getWinningBidder(p.getEnchere());
     java.util.Date today = new java.util.Date();
    // Check if the auction is still open
      Date dateLimite = p.getEnchere().getDate_limite();
            if (today.compareTo(dateLimite) < 0) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Auction Still Open");
        alert.setContentText("The auction is still open, the winning bidder information may change.");
        alert.showAndWait();
    } else {
    
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("winning_bidder.pdf"));
    document.open();
    document.add(new Paragraph("Winning Bidder Information"));
    document.add(new Paragraph("Name: " +winningBidder.getEnchere().getTitre()+ winningBidder.getClient().getNom() + " " + winningBidder.getClient().getPrenom()));
    document.add(new Paragraph("Bid Amount: " + winningBidder.getMontant()));
    document.close();
    
    // Use a FileChooser to prompt the user to select a directory where the PDF file will be saved
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save PDF File");
    File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
    
    if (file != null) {
        // Read the PDF file and send it to the user as a downloadable attachment
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
            
            // Display a success message to the user
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("PDF Downloaded");
            alert.setContentText("The PDF has been downloaded successfully.");
            alert.showAndWait();
        } catch (IOException e) {
            // Display an error message if an error occurs while reading or writing the file
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("File Error");
            alert.setContentText("An error occurred while reading or writing the file.");
            alert.showAndWait();
        }
    }
}
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
            }
    
    
    












