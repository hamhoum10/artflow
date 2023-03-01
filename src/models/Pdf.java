///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package models;
//
///**
// *
// * @author Elizabeth
// */
//
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import javax.swing.text.Document;
//
//
//
//import models.Participant;
//import services.EnchereService;
//
//
//public class Pdf {
//    
//    
//    public void GeneratePdf() throws FileNotFoundException, DocumentException {
//        com.itextpdf.text.Document document = new com.itextpdf.text.Document() {
//        };
//        PdfWriter.getInstance(document, new FileOutputStream("try.pdf"));
//        document.open();
//            document.add(new Paragraph("Hello, World!"));
//            document.close();
//        
//    }
//    }
//    
//    /*  com.itextpdf.text.Document document = new com.itextpdf.text.Document() {
//        };
//        PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
//        document.open();
//
//        
//        EnchereService es = new EnchereService();
//         document.add(new Paragraph("          titre de  l'enchere est :"+p.getEnchere().getTitre()));
//         document.add(new Paragraph("           descritpyion est :"+p.getEnchere().getDescription()));
//         document.add(new Paragraph("            la date limite est :"+p.getEnchere().getDate_limite()));
//         document.add(new Paragraph("            le prix de depart est :"+p.getEnchere().getPrixdepart()));
//         document.add(new Paragraph("            l'image est :"+p.getEnchere().getImg()));
//         document.add(new Paragraph("            le nom est :"+p.getClient().getNom()));
//         document.add(new Paragraph("            le prenom est :"+p.getClient().getPrenom()));
//
//
//        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
//        document.add(new Paragraph("                             ARTFLOW                   "));
//        document.close();
//        Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + filename + ".pdf");
//        
//    }
//
//    @Override
//    public String toString() {
//        return "Pdf{" +GeneratePdf(filename, p, 0)+ ";
//    }
//    
//    */
//   
//}
