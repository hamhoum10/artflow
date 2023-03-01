/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author Elizabeth
 */
public class Participant {
    
    private int idp;
    private Client client;
    private Enchere Enchere;
    private double montant;

    public Participant() {
    }

    public Participant(Client client, Enchere Enchere, double montant) {
        this.client = client;
        this.Enchere = Enchere;
        this.montant = montant;
    }

    public Participant(int idp, Client client, Enchere Enchere, double montant) {
        this.idp = idp;
        this.client = client;
        this.Enchere = Enchere;
        this.montant = montant;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Enchere getEnchere() {
        return Enchere;
    }

    public void setEnchere(Enchere Enchere) {
        this.Enchere = Enchere;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }


    
    
    
    @Override
    public String toString() {
        return "Participant{" + "idp=" + idp + ", client=" + client + ", Enchere=" + Enchere + ", montant=" + montant + '}';
    }
         
    /*
    public void GeneratePdf() throws FileNotFoundException, DocumentException, SQLException {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document() {
        };
        PdfWriter.getInstance(document, new FileOutputStream("try.pdf"));
        document.open();
        EnchereService es = new EnchereService();
        Enchere enchere = new Enchere();

   document.add(new Paragraph("Hello, World!"+es.getWinningBidder(enchere)));

            
            document.close();
        
    }

    */
}
