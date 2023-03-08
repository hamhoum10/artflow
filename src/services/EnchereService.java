/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import interfaces.EnchereParticipantInterface;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Enchere;
import models.Client;
import models.Participant;
import utils.MyConnection;

/**
 *
 * @author Elizabeth
 */
public class EnchereService implements EnchereParticipantInterface {

    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void AddEnchere(Enchere e) {
        try {
            String req = "INSERT INTO `enchere`(`titre`, `description`, `prixdepart`, `date_limite`,`image`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, e.getTitre());
            ps.setString(2, e.getDescription());
            ps.setDouble(3, e.getPrixdepart());
            ps.setDate(4, e.getDate_limite());
            ps.setString(5, e.getImg());

            ps.executeUpdate();
            System.out.println("auction Added Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public boolean updateEnchere(Enchere e) {

        String req = "UPDATE `enchere` SET `titre`=?,`description`=?,`prixdepart`=?,`date_limite`=?, `image`=? WHERE `enchere`.`ide`=?;";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, e.getTitre());
            ps.setString(2, e.getDescription());
            ps.setDouble(3, e.getPrixdepart());
            ps.setDate(4, e.getDate_limite());
            ps.setString(5, e.getImg());
            ps.setInt(6, e.getIde());
            int n = ps.executeUpdate();

            if (n >= 1) {
                System.out.println("Modif réussi");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("problème de requête Modif" + ex.getMessage());
        }
        return false;
    }

    @Override
    public Enchere fetchEnchereById(int ide) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Enchere> fetchEnchere() {
        List<Enchere> enchere = new ArrayList<>();
        try {
            String req = "SELECT * FROM enchere ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Enchere ene = new Enchere();
                ene.setIde(rs.getInt("ide"));
                ene.setTitre(rs.getString("titre"));
                ene.setDescription(rs.getString("description"));
                ene.setPrixdepart(rs.getDouble("prixdepart"));
                ene.setDate_limite(rs.getDate("date_limite"));
                ene.setImg(rs.getString("image"));

                enchere.add(ene);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return enchere;
    }

    @Override
    public Enchere fetchEnchereByname(String titre) {
        Enchere c = new Enchere();
        try {

            String req = "SELECT * FROM enchere WHERE `titre` = '" + titre + "' ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                c.setIde(rs.getInt("Ide"));
                c.setTitre(rs.getString("titre"));
                c.setDescription(rs.getString("description"));
                c.setPrixdepart(rs.getDouble("prixdepart"));
                c.setDate_limite(rs.getDate("date_limite"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    @Override
    public void deleteEnchere(int idee) {
        String req = "delete from `enchere` where `ide`= " + idee;

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.executeUpdate(req);

            System.out.println("suppression réussie");

        } catch (SQLException ex) {
            System.out.println("problème de requête de suppression" + ex.getMessage());
        }
    }

    @Override
    public boolean enchereExist(Participant p) {
        boolean test = false;
        String requete = "select * from `participant` where `participant`.`id`= ? and `participant`.`ide`=? ";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getClient().getId());
            pst.setInt(2, p.getEnchere().getIde());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if (p.getClient().getId() == rs.getInt("id") && p.getEnchere().getIde() == rs.getInt("ide")) {
                    test = true;
                }
            }

        } catch (SQLException ex) {
            System.err.println("Error executing SQL query: " + ex.getMessage());
        }
        return test;
    }

    @Override
    public void addParticipant(Participant p) {

        try {
            String req = "INSERT INTO `participant`(`id`,`ide`,`montant`) VALUES (?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, p.getClient().getId());
            st.setInt(2, p.getEnchere().getIde());
            st.setInt(3, (int) p.getMontant());
            st.executeUpdate();
            System.out.println("participation added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean updateParticipant(Participant p) {
        String requete = "update `participant` set `montant`=?   where `participant`.`id`=? and `participant`.`ide`=? ;";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setDouble(1, p.getMontant());
            pst.setInt(2, p.getClient().getId());
            pst.setInt(3, p.getEnchere().getIde());

            int n = pst.executeUpdate();

            if (n >= 1) {
                System.out.println("Modification réussi");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("problème de requête Modif" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteParticipant(Participant p) {
        String requete = "delete from `participant` where `participant`.`id`=? and `participant`.`ide`=?;";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getClient().getId());
            pst.setInt(2, p.getEnchere().getIde());
            int n = pst.executeUpdate();
            if (n >= 1) {
                System.out.println("suppression réussie");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("problème de requête de suppression" + ex.getMessage());
        }
        return false;
    }

    @Override
    public double getHighestBidAmount(Participant p) {
        double montant = 0;
        String requete = "select MAX(montant) AS amount from `participant` where  `participant`.`ide`=? ";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getEnchere().getIde());
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                rs.next();
                montant = rs.getDouble("amount");

                if (montant == 0) {
                   requete = "select prixdepart  from `enchere` where  `ide`=? ";
                    
                    pst = cnx.prepareStatement(requete);
                    pst.setDouble(1, p.getEnchere().getPrixdepart());
                    rs = pst.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            return rs.getDouble("prixDepart");
                               
                        }
                    }
                }

            }

        } catch (SQLException ex) {
            System.err.println("probleme de req select" + ex.getMessage());

        }
        return montant;
    }

    @Override
    public void effectuerParticipation(Participant p) {
        double amount = getHighestBidAmount(p);
        if (p.getMontant() <= amount) {
            System.out.println("bid must be superiro to " + amount + " DT");
        } else {
            if (enchereExist(p)) {
                updateParticipant(p);
            } else {
                addParticipant(p);
            }
        }

    }
    
    



    
   public Participant getWinningBidder(Enchere enchere) throws SQLException {
    java.util.Date today = new java.util.Date();
    Participant winningBidder = null;
    String query = "SELECT p.idp, p.montant, c.id, c.lastname, c.firstname, c.address, c.phonenumber, c.email,c.username " +
                   "FROM participant AS p " +
                   "INNER JOIN client AS c ON p.id = c.id " +
                   "WHERE p.ide = ? " +
                   "ORDER BY p.montant DESC " +
                   "LIMIT 1";
    
    try (PreparedStatement pst = cnx.prepareStatement(query)) {
        pst.setInt(1, enchere.getIde());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            double montant = rs.getDouble("montant");
            Date dateLimite = enchere.getDate_limite();
            if (today.compareTo(dateLimite) < 0) {
                System.out.println("This auction still open!");
            } else {
                int idp = rs.getInt("idp");
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                 String address = rs.getString("address");
                  int phone = rs.getInt("phonenumber");
                   String email = rs.getString("email");
                   String username = rs.getString("username");
                  
                
                
              
                Client client = new Client(id,firstname, lastname,address, phone, email, username);
                winningBidder = new Participant(idp, client, enchere, montant);
            }
        } else {
            System.out.println("this is the "+enchere.getPrixdepart()+"No bids for this auction!");
        }
    } catch (SQLException ex) {
        System.err.println("Error executing SQL query: " + ex.getMessage());
        throw ex;
    }
    
    return winningBidder;
}
   
   
   
   
   
   
   
   
   
     public double getHighestBidAmount1(Enchere e) throws SQLException {
        double montant = 0;
//String requete = "SELECT MAX(montant) AS amount FROM `participant` INNER JOIN `enchere` ON `participant`.`ide` = `enchere`.`ide` WHERE `enchere`.ide = ?"     ;
 String requete = "select MAX(montant) AS amount from `participant`, `enchere` where  `participant`.`ide`=`enchere`.`ide` and `participant`.`ide`="+e.getIde();

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                rs.next();
              
                montant = rs.getDouble("amount");

//                if (montant == 0) {
//                   requete = "select prixdepart  from `enchere` where  `ide`=? ";
//                    
//                    pst = cnx.prepareStatement(requete);
//                    pst.setDouble(1, p.getEnchere().getPrixdepart());
//                    rs = pst.executeQuery();
//                    if (rs != null) {
//                        if (rs.next()) {
//                            return rs.getDouble("prixDepart");
//                               
//                        }
//                    }
//                }

//            }
            }
        } catch (SQLException ex) {
            System.err.println("probleme de req select" + ex.getMessage());

        }
        return montant;
    }
   
   
   
   
}

    







