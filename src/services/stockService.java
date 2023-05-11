package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import interfaces.stockInterface;
import models.livraison;
import models.stock;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import services.livraisonService;
import services.livraisonService;

public class stockService implements stockInterface {
    //var
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addstock(stock s) {
        try {

            String req = "INSERT INTO `stock`(`name_produit`, `artiste`,`addres`, `id_commende_id`,`user_name`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, s.getName());
            ps.setString(2, s.getArtiste());
            ps.setString(3,s.getAddres());
            ps.setInt(4, s.getId_commende());
            ps.setString(5,s.getUser_name());
            ps.executeUpdate();

            System.out.println("stock Added Successfully!");
//SmsNotification();
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
            String req = "select * FROM `stock` where `id_commende_id` = "+cmd;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                stock s = new stock();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
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

                s.setName(rs.getString(3));
                s.setArtiste(rs.getString(4));
                s.setAddres(rs.getString(5));
                s.setId_commende(rs.getInt(2));
                s.setUser_name(rs.getString(6));
                s.setDate_entr(rs.getDate("date_entr"));

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

            String req = "UPDATE `stock` SET `name_produit`=?,`artiste`=?,`addres`=?,`id_commende_id`=?,`user_name`=? WHERE id = ?; ";
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
                s.setId_commende(rs.getInt("id_commende_id"));
                s.setDate_entr(rs.getDate("date_entr"));
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
                s.setId_commende(rs.getInt("id_commende_id"));
                s.setDate_entr(rs.getDate("date_entr"));
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
            String req = "select * FROM `stock` where `user_name`like '%"+usr+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                stock s = new stock();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
                s.setAddres(rs.getString("addres"));
                s.setUser_name(rs.getString("user_name"));
                s.setDate_entr(rs.getDate("date_entr"));
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

        List<stock> stocks=new ArrayList<>();
        try {
            String req = "select * FROM `stock` where `date_ent` = "+d;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                stock s = new stock();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
                s.setAddres(rs.getString("addres"));
                s.setUser_name(rs.getString("user_name"));
                s.setDate_entr(rs.getDate("date_entr"));
                ;
                stocks.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stocks;
    }

    @Override
    public void SmsNotification(String id) {
        String num="";

        try {
            String req = "select numero FROM `commande` where `nom` = '"+id+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                num=rs.getString("numero") ;


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        String ACCOUNT_SID = "AC4730297eb72be182dde74c2a2143deb8";
        String AUTH_TOKEN = "fba49a82e157a83953c49896694c44ec";


        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+216"+num),

                        new com.twilio.type.PhoneNumber("+12764448061"),
                        "ArtFlow want to unform you that your commend is in the Stock now")
                .create();

        System.out.println(message.getSid());

    }
    public void SmsNotification(int id) {
        String num="";

        try {
            String req = "select numero FROM `commande` where `id` = '"+id+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                num=rs.getString("numero") ;


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        String ACCOUNT_SID = "AC4730297eb72be182dde74c2a2143deb8";
        String AUTH_TOKEN = "fba49a82e157a83953c49896694c44ec";


        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+216"+num),

                        new com.twilio.type.PhoneNumber("+12764448061"),
                        "ArtFlow want to unform you that your commend is in the Stock now")
                .create();

        System.out.println(message.getSid());

    }






    @Override
    public void moveToLivraison(stock s) {
        livraisonService sl = new livraisonService();

        deleatstockById(s.getId());
        livraison l = new livraison(s.getId(),s.getName(),s.getArtiste(),s.getAddres(),s.getDate_entr(),s.getId_commende(),s.getUser_name());
        sl.addlivraison(l);
        System.out.println("le stock is now in livraison");


    }

}
