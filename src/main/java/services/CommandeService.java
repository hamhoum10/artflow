package services;

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
        try {

            // Créer une requête préparée pour insérer une nouvelle entrée dans la table "commandes"
            String sql = "insert into commande ( id_panier,status,total_amount, created_at, codepostal, adresse) values (?, ?, ?, ?, ?,?)";
            PreparedStatement  p = cnx.prepareStatement(sql);
            if(c.DoPanierIdExistinCommande(o.getId_panier())==false){
                p.setInt(1, o.getId_panier());
                p.setString(2, o.getStatus());
                p.setDouble(3, o.getTotalAmount());
                p.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                p.setInt(5, o.getCodepostal());
                p.setString(6, o.getAdresse());

                // Exécuter la requête
                p.executeUpdate();
                System.out.println("Commande is created");
            }else{
                System.out.println("Commande  exist");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    // Mettre à jour un élément dans la commande
    public void updatestatus(int id, String status) {
        try {
            // Créer une requête préparée pour mettre à jour une entrée dans la table "commandes"
            String sql = "update commande set status = ? where id = ?";
            PreparedStatement p = cnx.prepareStatement(sql);
            p.setString(1, status);
            p.setInt(2, id);

            // Exécuter la requête
            p.executeUpdate();
            System.out.println("status is updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un élément dans la commande codepostalm
    public void updatecodepostal(int id, int cpostal) {
        try {
            // Créer une requête préparée pour mettre à jour une entrée dans la table "commandes"
            String sql = "update commande set codepostal = ? where id = ?";
            PreparedStatement p = cnx.prepareStatement(sql);
            p.setInt(1, cpostal);
            p.setInt(2, id);

            // Exécuter la requête
            p.executeUpdate();
            System.out.println("codepostal is updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un élément dans la commande codepostalm
    public void updateadresse(int id, String addresse) {
        try {
            // Créer une requête préparée pour mettre à jour une entrée dans la table "commandes"
            String sql = "update commande set adresse = ? where id = ?";
            PreparedStatement p = cnx.prepareStatement(sql);
            p.setString(1, addresse);
            p.setInt(2, id);

            // Exécuter la requête
            p.executeUpdate();
            System.out.println("adresse is updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer une commande
    public void delete(int id) {
        try {
            // Créer une requête préparée pour supprimer une entrée de la table "commandes"
            String sql ="delete from commandes where id = ?";
                PreparedStatement p = cnx.prepareStatement("delete from commande where id = ?");
            p.setInt(1, id);

            // Exécuter la requête
            p.executeUpdate();
            System.out.println("order deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//A MODIFIER JOINTURE TABLE LIGNEPANIER ET PANIER  ==> mawjouda fi lignepanier service
    //methode t7ot el montant total eli fi panier mta user attribut totalAmount
    //on passe le resultat de cette methode lors de la creation d'une commande  creat(.,., instanceOrderService.totalmonatantcommande(userID),.,)
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

    public void payer(){
        //ki ta3mel payment el panier twali vide
        //wta3mel delete lel commande mel base de donnes
    }



}
