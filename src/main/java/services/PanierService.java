package services;

import models.Article;
import models.Ligne_panier;
import models.Panier;
import util.Conditions;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PanierService {
    public PanierService() {
    }
    Connection cnx = MyConnection.getInstance().getCnx();
    // onn click +produit /wala awel myconnecti el user  ==> creation de panier(userid)
    //mesh ywali ana panier 7adher w baed ki nenzel ajouter produit n3ayto lel ligne_panierservice w najitw el product

    // Créer une nouvelle commande
    public void createPanier(Panier p) {
        try {
            Conditions c =new Conditions();
            // Créer une requête préparée pour insérer une nouvelle entrée dans la table "commandes"
            String sql = "insert into panier (id_client) values (?) ";
            PreparedStatement  ps = cnx.prepareStatement(sql);
            if(c.DoUserIdExistinPanier(p.getId_client())==false) {
                ps.setInt(1, p.getId_client());
                ps.executeUpdate();
                System.out.println("Panier Created");
            }else{
                System.out.println("Panier of this user already exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lire tous les éléments de la ligne-panier  d'un userID (contenu de son panier)
    public List<Ligne_panier> readelementPanierbyiduser(int id_client) {
        List<Ligne_panier> ps = new ArrayList<>();
        ArticleService as =new ArticleService();
        try {
            // Créer une requête pour lire toutes les entrées de la table
            String sql = "SELECT p.id_panier, lp.id_article, lp.prix_unitaire, lp.quantity FROM panier p JOIN ligne_panier lp ON p.id_panier = lp.id_panier WHERE p.id_client ="+id_client  ;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // Boucler à travers les résultats et ajouter chaque entrée à la liste
            while (rs.next()) {
                Ligne_panier lp = new Ligne_panier();
                lp.setId_panier(rs.getInt("p.id_panier"));
                lp.setArticle((Article) as.fetchArticleById(rs.getInt("lp.id_article")));
                //lp.setPrix(rs.getDouble("lp.prix"));
                lp.setQuantity(rs.getInt("lp.quantity"));
                ps.add(lp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public double totalmontantPanier(int id_client){
        Double totalPrixPanier=0.0 ;
        try {
            String sql = "SELECT SUM( prix * quantity) AS total FROM panier JOIN ligne_panier ON panier.id_panier = ligne_panier.id_panier WHERE panier.id_client = "+ id_client;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                totalPrixPanier = rs.getDouble("total");//total est colonne virtuell, il n'existe pas dans la table panier
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPrixPanier;
    }
    public int getPanierIdForUser(int id_client) {
        int panierId = 0;
        String query = "SELECT id_panier FROM panier WHERE id_client = ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setInt(1, id_client);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                panierId = rs.getInt("id_panier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return panierId;
    }

}
