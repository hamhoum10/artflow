package services;

import models.Article;
import models.Ligne_panier;
import util.Conditions;
import util.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Ligne_PanierService {


    // Constructeur
    public Ligne_PanierService() {}

    // Connexion à la base de données
    Connection cnx = MyConnection.getInstance().getCnx();
    Conditions c =new Conditions();

    // Déconnexion de la base de données
    public void disconnect() {
    }
    // CRUD operations

    public void AjouterDansTableligne_Panier(Ligne_panier lp, int id_article) {
        try {//ken mesh mawjoud el article tzid ligne
            if(c.DoArticleIdExistinLignePanier(id_article,lp.getId_panier())==false){
                // Créer une requête préparée pour insérer les données dans la table
                String sql = "insert into ligne_panier(id_panier,id_article,Nom_article,prix_unitaire, quantity,Nom_artiste,Prenom_artiste) values (?, ?,?,?,?,?,?)";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, lp.getId_panier());//hethi te5o el id mta panier ki namlou instance ligne-panier(..,idpanier)
                st.setInt(2, id_article);
                st.setString(3, lp.getArticle().getNom_article());
                st.setDouble(4, lp.getArticle().getPrice());
                st.setDouble(5, lp.getQuantity());
                st.setString(6, lp.getArticle().getArtiste().getFirstname());
                st.setString(7, lp.getArticle().getArtiste().getLastname());
                // Exécuter la requête
                st.executeUpdate();
                System.out.println("product added dans la ligne_panier associe a la panier  d'ID "+ lp.getId_panier());
                //tesna3 ligne fil panier fih hethom fi front-end baed
            }else{//ken article mawjoud tzid quantity
                String sql = "UPDATE ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier SET lp.quantity = lp.quantity + ? WHERE lp.id_article =? AND p.id_panier =? ";
                PreparedStatement st = cnx.prepareStatement(sql);
                st.setInt(1, lp.getQuantity());
                st.setInt(2, id_article);
                st.setInt(3,lp.getId_panier() );
                st.executeUpdate();
                System.out.println("quantity is added");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Supprimer un produit par son ID d'un user preciser par son iduser du panier
    public void deleteFromLigne_panierByArticle(int id_panier, int id_article) {
        try {
            // Créer une requête préparée pour supprimer l'entrée spécifiée
            //String sql = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_client = ? AND lp.id_article = ?";
            String sql = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_panier= ? AND lp.id_article = ?";
            PreparedStatement p  = cnx.prepareStatement(sql);
            p.setInt(1, id_panier);
            p.setInt(2, id_article);
            p.executeUpdate();
            System.out.println("product d'ID "+ id_article +" " + "supprimé de la panier  d'ID "+id_panier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Supprimer un produit par son ID d'un user preciser par son iduser du panier
    public void deleteAllFromLigne_panier(int id_panier) {
        try {
            // Créer une requête préparée pour supprimer l'entrée spécifiée
            //String sql = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_client = ?"; //cvlient fi parametre 9bal
            String sql = "DELETE lp FROM ligne_panier lp JOIN panier p ON lp.id_panier = p.id_panier WHERE p.id_panier = ?";
            PreparedStatement p  = cnx.prepareStatement(sql);
            p.setInt(1, id_panier);
            p.executeUpdate();
            System.out.println("la ligne panier est vider  "+id_panier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //A MODIFIER JOINTURE ENTRE TABLE LIGNE PANIER ET PANIER
    //10000000000000000000000000000000000000000%  8alta
   /* public double totalmontantPanier(int userid){
        Double totalPrixPanier=0.0 ;
        try {
            // Créer une requête pour lire pro-id et quantity la table
            String sql = "select SUM(prix * quantity) as total from panier where customer_id =" +userid  ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // Boucler à travers les résultats et ajouter chaque entrée à la liste
            while (rs.next()) {
                totalPrixPanier = rs.getDouble("total");//total est colonne virtuell, il n'existe pas dans la table panier
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrixPanier;}*/



}
