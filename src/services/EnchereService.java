/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.EnchereParticipantInterface;
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
         String req = "INSERT INTO `enchere`(`titre`, `description`, `prixdepart`, `date_limite`,`image`) VALUES (?,?,?,?,?)"   ;
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
    
       String req =" UPDATE `enchere` SET `titre`=?,`description`=?,`prixdepart`=?,`date_limite`=? , `image`=? `WHERE `enchere`.`ide`=?;";
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
    public void deleteEnchere(int id) {
        String req = "delete from `enchere` where `ide`= "+id;
      
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
        boolean test=false;
         String requete = "select * from `participant` where `participant`.`idc`= ? and `participant`.`ide`=? ";
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getClient().getIdc());
            pst.setInt(2,p.getEnchere().getIde());
            ResultSet rs = pst.executeQuery();
           
              if (rs.next()) {
            if (p.getClient().getIdc() == rs.getInt("idc") && p.getEnchere().getIde() == rs.getInt("ide")) {
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
            String req = "INSERT INTO `participant`(`idc`,`ide`,`montant`) VALUES (?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
           st.setInt(1, p.getClient().getIdc());
           st.setInt(2,p.getEnchere().getIde());
           st.setInt(3, (int) p.getMontant());
           st.executeUpdate();
            System.out.println("participation added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean updateParticipant(Participant p) {
        String requete = "update `participant` set `montant`=?   where `participant`.`idc`=? and `participant`.`ide`=? ;";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
             pst.setDouble(1, p.getMontant());
            pst.setInt(2, p.getClient().getIdc());
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
        String requete = "delete from `participant` where `participant`.`idc`=? and `participant`.`ide`=?;";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
             pst.setInt(1, p.getClient().getIdc());
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
      double montant =0 ;
         String requete = "select MAX(montant) AS amount from `participant` where  `participant`.`ide`=? ";

        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,  p.getEnchere().getIde());
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                rs.next();
                 montant= rs.getDouble("amount") ;
                 
                 if(montant == 0){
                     requete = "select prixdepart  from `enchere` where  `ide`=? ";
           
            pst = cnx.prepareStatement(requete);
            pst.setDouble(1, p.getEnchere().getPrixdepart());
            rs = pst.executeQuery();
            if (rs != null) {
                if (rs.next()) return rs.getDouble("prixDepart") ;
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
        if(p.getMontant() <= amount) System.out.println("bid must be superiro to " + amount+ " DT");
        else {
            if(enchereExist(p)){
          updateParticipant(p);
      } else{
          addParticipant(p);
      }
        }
      
    }

    /* @Override
    public Participant getWinningBidder(Participant p) {
          java.util.Date dt= new java.util.Date();
        Date today= new Date(dt.getTime());
         Date dateLimite= new Date(dt.getTime());
       Participant pa = null;

       /* String requete="select `c`.`idc`,`c`.`nom`,`c`.`prenom`,`p`.`montant`,`p`.`ide`,`enchere`.`date_limite` from `client` AS c"
                    +"JOIN `participant` as p ON `c`.`idc`= `p`.`idc`"
                    + "JOIN `enchere` ON `enchere`.`ide`= `p`.`ide`"
                    + "  where  `p`.`ide` = ? and  `p`.`montant`=( "
                    + " select montant from `participant` where `participant`.`ide`=? and "
                    + "`montant`= (select MAX(montant) from `participant` where `ide`=? ));"
       
       String requete= "select * from `client` as c, enchere as e, `participant` as p WHERE  `p`.`ide` = ? and  `p`.`montant`=( select `montant` from `participant` where `participant`.`ide`=? and `montant`= (select MAX(montant) from `participant` where `ide`=? ))";
       
       
       
        String nom,prenom;
        
        int id;
        double montant;
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getEnchere().getIde());

            ResultSet rs = pst.executeQuery();
              if( rs.next()){
                  Client cl=new Client();

                  dateLimite = rs.getDate("dateLimite");


                 if(today.compareTo(dateLimite) <=0 ) System.out.println("this auction still have time left ! ");
                 else {
                     Participant.s
                          
//                     id = rs.getInt("id");
//                 nom = rs.getString("nom");
//                 prenom = rs.getString("prenom");
//
//                montant = rs.getDouble("montant");
        //        enchere = new Enchere(montant, id, articleId,new Client(id, nom, prenom));
                

//    pa = new Participant(client, Enchere, montant);
              }
                
                     
                 }

                                
            
        } catch (SQLException ex) {
            System.err.println("probleme de req select" + ex.getMessage());

        }
        return pa;
 }
 


    @Override
        public Enchere getWinningBidder(int articleId)
 {
        java.util.Date dt= new java.util.Date();
        Date today= new Date(dt.getTime());
         Date dateLimite= new Date(dt.getTime());
       Enchere enchere = null;

        String requete = "select `c`.`id`,`c`.`nom`,`c`.`prenom`,`e`.`montant`,`e`.`articleId`,`article`.`dateLimite` from `client` AS c"
                + " JOIN `enchere` as e ON `c`.`id`= `e`.`clientId`"
                + "JOIN `article` ON `article`.`id`= `e`.`articleId`"
                + "  where  `e`.`articleId` = ? and  `e`.`montant`=( "
                + " select montant from `enchere` where `enchere`.`articleId`=? and "
                + "`montant`= (select MAX(montant) from `enchere` where articleId=? ));";
     
        String nom,prenom;
        
        int id;
        double montant;
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, articleId);
            pst.setInt(2, articleId);
            pst.setInt(3, articleId);

            ResultSet rs = pst.executeQuery();
              if( rs.next()){
                  dateLimite = rs.getDate("dateLimite");


                 if(today.compareTo(dateLimite) <=0 ) System.out.println("this auction still have time left ! ");
                 else {
                     id = rs.getInt("id");
                 nom = rs.getString("nom");
                 prenom = rs.getString("prenom");

                montant = rs.getDouble("montant");
                enchere = new Enchere(montant, id, articleId,new Client(id, nom, prenom));
                  
              }
                
                     
                 }

                                
            
        } catch (SQLException ex) {
            System.err.println("probleme de req select" + ex.getMessage());

        }
        return enchere;
 }
*/

    

    @Override
    public Enchere fetchEnchereByname(String titre) {
     Enchere c = new Enchere();
        try {
            
            String req = "SELECT * FROM enchere WHERE `titre` = '"+titre+"' ";
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
        
        return c ;
    }    


}

    
    
    
    
    
      
    
    
   



































    
    
    
    

    
    
    
    
    
 

   
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    

