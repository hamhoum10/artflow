package services;

import interfaces.stockInterface;
import models.stock;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class stockService implements stockInterface {
    //var
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addstock(stock s) {
        try {

            String req = "INSERT INTO `stock`(`name_produit`, `artiste`,`addres`, `id_commende`,`user_name`) VALUES (?,?,?,?,?)";
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
    public void deleatallstock(){
        try { String req = "DELETE FROM `stock` WHERE 0 ";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.executeUpdate();
            System.out.println("Allstock deleted Successfully!");


        }catch (SQLException ex){
            ex.printStackTrace();
        }
           }
    @Override
    public void deleatstockById(int id) {
        try { String req = "DELETE FROM `stock` WHERE `id` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("stock deleted Successfully!");


        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List<stock> filtreParCommende(int cmd) {
        List<stock> stocks=new ArrayList<>();
        try {
            String req = "select * FROM `stock` where `id_commende` = "+cmd;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                stock s = new stock();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                stocks.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stocks;

    }


    @Override
    public List<stock> fetchstock() {
        List<stock> stocks = new ArrayList<>();

        try {String req = "select * FROM `stock`   ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                stock s = new stock();
                s.setId(rs.getInt(1));

                s.setName(rs.getString(2));
                s.setArtiste(rs.getString(3));
                s.setAddres(rs.getString(4));
                s.setId_commende(rs.getInt(5));
                s.setUser_name(rs.getString(6));

                stocks.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return stocks;
    }
    @Override
    public void updateAllstock(stock s) {
        try {

            String req = "UPDATE `stock` SET `name_produit`=?,`artiste`=?,`addres`=?,`id_commende`=?,`user_name`=? WHERE id = ?; ";
            PreparedStatement ps = cnx.prepareStatement(req);
            System.out.println(1);
            ps.setString(1, s.getName());
            System.out.println(2);
            ps.setString(2, s.getArtiste());
            System.out.println(3);
            ps.setString(3, s.getAddres());
            System.out.println(4);
            ps.setInt(4,s.getId_commende());
            System.out.println(5);
            ps.setString(5, s.getUser_name());
            System.out.println(6);
            ps.setInt(6,s.getId());
            System.out.println(7);
            ps.executeUpdate();
            System.out.println(8);
            System.out.println("stock updated Successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<stock> SelectById(int id) {
        List<stock> stocks = new ArrayList<>();

        try {
            String req = "select * FROM `stock` where `id` = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                stock s = new stock();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                stocks.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stocks;


    }

    @Override
    public List<stock> SelectByArtiste(String art) {
        List<stock> stocks=new ArrayList<>();
        try {
            String req = "select * FROM `stock` where `artiste` = "+art;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                stock s = new stock();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                stocks.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stocks;

    }

    @Override
    public List<stock> SelectByUser(String usr) {
        List<stock> stocks=new ArrayList<>();
        try {
            String req = "select * FROM `stock` where `user_name` = "+usr;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                stock s = new stock();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
                s.setAddres(rs.getString("addres"));
                s.setUser_name(rs.getString("user_name"));
                ;
                stocks.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stocks;
    }

    @Override
    public List<stock> SlectByDate(Date d) {
        return null;
    }
}
