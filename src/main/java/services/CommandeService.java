package services;

import models.Client;
import models.Commande;
import models.Panier;
import util.Conditions;
import util.MyConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandeService {

    Connection cnx = MyConnection.getInstance().getCnx();
    Conditions c =new Conditions();
    // Créer une nouvelle commande
    public void create(Commande o) {
       // Boolean exist =false;
        try {

            // Créer une requête préparée pour insérer une nouvelle entrée dans la table "commandes"
            String sql = "insert into commande ( id_panier,prenom,nom,numero,status,total_amount, created_at, codepostal, adresse) values (?, ?, ?, ?, ?,?,?,?,?)";
            PreparedStatement  p = cnx.prepareStatement(sql);
            //if(c.DoPanierIdExistinCommande(o.getId_panier())==false){
                p.setInt(1, o.getId_panier());
                p.setString(2, o.getPrénomClientCommande());
                p.setString(3, o.getNomClientCommande());
                p.setInt(4, o.getNumeroPhoneclient());
                p.setString(5, o.getStatus());
                p.setDouble(6, o.getTotalAmount());
                p.setString(7, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                p.setInt(8, o.getCodepostal());
                p.setString(9, o.getAdresse());

                // Exécuter la requête
                p.executeUpdate();
                System.out.println("Commande is created");
                //System.out.println(exist);
            /*}else{
                exist=true;
                System.out.println("Commande  exist");
                System.out.println(exist);
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return exist;
    }

    // Lire toutes les commandes
    public List<Commande> readAllCommandes() {
        List<Commande> commandeList = new ArrayList<>();
        try {
            // Créer une requête pour sélectionner toutes les entrées dans la table "commandes"
            String sql ="select * from commande";
            PreparedStatement p  = cnx.prepareStatement(sql);

            // Exécuter la requête et obtenir les résultats
            ResultSet rs = p.executeQuery();

            // Boucler à travers les résultats et ajouter chaque entrée à la liste
            while (rs.next()) {
                Panier panier =new Panier();
                panier.setId_panier(rs.getInt("id_panier"));
                Commande commande = new Commande();
                commande.setId(rs.getInt("id"));
                commande.setId_panier(rs.getInt("id_panier"));
                commande.setStatus("status");
                commande.setTotalAmount( rs.getFloat("total_amount"));
                commande.setCreatedAt(rs.getString("created_at"));
                commande.setCodepostal(rs.getInt("codepostal"));
                commande.setAdresse(rs.getString("adresse"));
                commandeList.add(commande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandeList;
    }
    public List<Commande> readCommandesbyPanier(int id_panier) {
        List<Commande> commandeList = new ArrayList<>();
        try {
            // Créer une requête pour sélectionner toutes les entrées dans la table "commandes"
            String sql ="select * from panier p join commande c on p.id_panier = c.id_panier WHERE p.id_panier ="+id_panier;
            PreparedStatement p  = cnx.prepareStatement(sql);

            // Exécuter la requête et obtenir les résultats
            ResultSet rs = p.executeQuery();

            // Boucler à travers les résultats et ajouter chaque entrée à la liste
            while (rs.next()) {
                Panier panier =new Panier();
                panier.setId_panier(rs.getInt("id_panier"));
                Commande commande = new Commande();
                commande.setId(rs.getInt("id"));
                commande.setId_panier(rs.getInt("id_panier"));
                commande.setNomClientCommande(rs.getString("nom"));
                commande.setPrénomClientCommande(rs.getString("prenom"));
                commande.setStatus("status");
                commande.setTotalAmount( rs.getFloat("total_amount"));
                commande.setCreatedAt(rs.getString("created_at"));
                commande.setCodepostal(rs.getInt("codepostal"));
                commande.setAdresse(rs.getString("adresse"));
                commande.setNumeroPhoneclient(rs.getInt("numero"));
                commandeList.add(commande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandeList;
    }
    // Mettre à jour un élément dans la commande
    public void updatestatus(int id_panier, String status) {
        try {
            // Créer une requête préparée pour mettre à jour une entrée dans la table "commandes"
            String sql = "update commande set status = ? where id_panier = ?";
            PreparedStatement p = cnx.prepareStatement(sql);
            p.setString(1, status);
            p.setInt(2, id_panier);

            // Exécuter la requête
            p.executeUpdate();
            System.out.println("status is updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un élément dans la commande codepostalm
    public void updatecodepostal(int id_panier, int cpostal) {
        try {
            // Créer une requête préparée pour mettre à jour une entrée dans la table "commandes"
            String sql = "update commande set codepostal = ? where id_panier = ?";
            PreparedStatement p = cnx.prepareStatement(sql);
            p.setInt(1, cpostal);
            p.setInt(2, id_panier);

            // Exécuter la requête
            p.executeUpdate();
            System.out.println("codepostal is updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un élément dans la commande codepostalm
    public void updateadresse(int id_panier, String addresse) {
        try {
            // Créer une requête préparée pour mettre à jour une entrée dans la table "commandes"
            String sql = "update commande set adresse = ? where id_panier = ?";
            PreparedStatement p = cnx.prepareStatement(sql);
            p.setString(1, addresse);
            p.setInt(2, id_panier);

            // Exécuter la requête
            p.executeUpdate();
            System.out.println("adresse is updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer une commande
    public void deleteCommande(int id_panier) {
        try {
            String sql = "DELETE FROM commande WHERE id_panier = ? AND status = ?";
            PreparedStatement stmt = cnx.prepareStatement(sql);

// set the parameters for the SQL statement
            stmt.setInt(1, id_panier);
            stmt.setString(2, "en attente");

// execute the SQL statement
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public double totalmontantCommande(int userid){
        Double totalPrixPanier=0.0 ;
        try {
            String sql = "select SUM(prix * quantity) as total from panier where customer_id =" +userid  ;
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
    public void updateStauts(int id_panier) {
        try {
            String sql = "UPDATE commande SET status = ? WHERE id_panier = ?";
            PreparedStatement stmt = cnx.prepareStatement(sql);

            // Set the parameter values
            stmt.setString(1, "done");
            stmt.setInt(2, id_panier); // replace id_panier with the actual value

            // Execute the SQL statement
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " rows updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getPanierIdByUser(Client c) {
        int panierId = 0;
        String query = "SELECT id_panier FROM panier p JOIN client c  on p.id_client = c.id  WHERE username = ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setString(1, c.getUsername());
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
