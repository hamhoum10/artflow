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


    public double totalmontantPanier(int id_client){
        Double totalPrixPanier=0.0 ;
        try {
            String sql = "SELECT SUM( prix_unitaire * quantity) AS total FROM panier JOIN ligne_panier ON panier.id_panier = ligne_panier.id_panier WHERE panier.id_client = "+ id_client;
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
