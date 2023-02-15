package services;

import interfaces.livraisonInterface;
import models.livraison;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class livraisonService implements livraisonInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addlivraison(livraison s) {
        try {

            String req = "INSERT INTO `livraison`(`name_produit`, `artiste`,`addres`, `id_commende`,`user_name`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, s.getName());
            ps.setString(2, s.getArtiste());
            ps.setString(3,s.getAddres());
            ps.setInt(4, s.getId_commende());
            ps.setString(5,s.getUser_name());
            ps.executeUpdate();

            System.out.println("stock Added Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<livraison> fetchlivraison() {
        List<livraison> livraisons = new ArrayList<>();

        try {String req = "select * FROM `livraison`   ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            System.out.println("152");
            while (rs.next()) {
                livraison s = new livraison();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));

                livraisons.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return livraisons;
    }

    @Override
    public void updateAlllivraison(livraison s) { try {

        String req = "UPDATE `livraison` SET `name_produit`=?,`artiste`=?,`addres`=?,`id_commende`=?,`user_name`=? WHERE id = ?; ";
        PreparedStatement ps = cnx.prepareStatement(req);

        ps.setString(1, s.getName());
        ps.setString(2, s.getArtiste());
        ps.setString(3, s.getAddres());
        ps.setInt(4,s.getId_commende());
        ps.setString(5, s.getUser_name());
        ps.setInt(6,s.getId());
        ps.executeUpdate();
        System.out.println("livraison updated Successfully!");

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    }

    @Override
    public void deleatlivraisonById(int id) {
        try { String req = "DELETE FROM `livraison` WHERE `id` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("livraison deleted Successfully!");


        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<livraison> filtreParCommendeliv(int cmd) {
        List<livraison> livraisons=new ArrayList<>();
        try {
            String req = "select * FROM `livraison` where `id_commende` = "+cmd;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                livraison s = new livraison();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                livraisons.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livraisons;

    }

    @Override
    public void deleatalllivraison() {
        try { String req = "DELETE FROM `livraison` WHERE 0  ";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.executeUpdate();
            System.out.println("Alllivraison deleted Successfully!");


        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List<livraison> SelectByIdliv(int id) {
        List<livraison> livraisons = new ArrayList<>();

        try {
            String req = "select * FROM `livraison` where `id` = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                livraison s = new livraison();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                livraisons.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livraisons;
    }

    @Override
    public List<livraison> SelectByArtisteliv(String art) {
        List<livraison> livraisons=new ArrayList<>();
        try {
            String req = "select * FROM `livraison` where `artiste` = "+art;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                livraison s = new livraison();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                livraisons.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livraisons;

    }

    @Override
    public List<livraison> SelectByUserliv(String usr) {
        List<livraison> livraisons=new ArrayList<>();
        try {
            String req = "select * FROM `livraison` where `user_name` = "+usr;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                livraison s = new livraison();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                s.setAddres(rs.getString("addres"));
                s.setUser_name(rs.getString("user_name"));
                ;
                livraisons.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livraisons;
    }

    @Override
    public List<livraison> SlectByDateliv(Date d) {
        return null;
    }
}
