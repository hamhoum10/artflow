package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import interfaces.retourInterface;
import models.livraison;
import models.retour;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class retourService  implements retourInterface  {
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public void addretour(retour s) {
     try{   String req = "INSERT INTO `retour`(`name_produit`, `artiste`,`addres`, `id_commende_id`,`user_name`) VALUES (?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, s.getName());
        ps.setString(2, s.getArtiste());
        ps.setString(3,s.getAddres());
        ps.setInt(4, s.getId_commende());
        ps.setString(5,s.getUser_name());
        ps.executeUpdate();
        System.out.println("retour Added Successfully!");
//        SmsNotification();
    } catch (
    SQLException ex) {
        ex.printStackTrace();
    }
    }

    @Override
    public List<retour> fetchretour() {
        List<retour> retours = new ArrayList<>();

        try {String req = "select * FROM `retour`   ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                retour s = new retour();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(3));
                s.setUser_name(rs.getString("user_name"));
                s.setAddres(rs.getString(5));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
                s.setDate_retour(rs.getDate("date"));


                retours.add(s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return retours;
    }

    @Override
    public void updateAllretour(retour s) {try {

        String req = "UPDATE `retour` SET `name_produit`=?,`artiste`=?,`addres`=?,`id_commende_id`=?,`user_name`=? WHERE id = ?; ";

        PreparedStatement ps = cnx.prepareStatement(req);

        ps.setString(1, s.getName());

        ps.setString(2, s.getArtiste());

        ps.setString(3, s.getAddres());

        ps.setInt(4,s.getId_commende());

        ps.setString(5, s.getUser_name());

        ps.setInt(6,s.getId());

        ps.executeUpdate();

        System.out.println("retour updated Successfully!");

    } catch (SQLException ex) {
        ex.printStackTrace();
    }


    }

    @Override
    public void deleatretourById(int id) {
        try { String req = "DELETE FROM `retour` WHERE `id` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("retour deleted Successfully!");


        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List<retour> filtreParCommenderet(int cmd) {
        List<retour> retours = new ArrayList<>();
        try {
            String req = "select * FROM `retour` where `id_commende_id` = "+cmd;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                retour s = new retour();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
                retours.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retours;

    }

    @Override
    public void deleatallretour() {
        try { String req = "DELETE FROM `retour` WHERE 0  ";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.executeUpdate();
            System.out.println("Alllretour deleted Successfully!");


        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<retour> SelectByIdret(int id) {
        List<retour> retours = new ArrayList<>();

        try {
            String req = "select * FROM `retour` where `id` = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                retour s = new retour();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));

                retours.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retours;
    }

    @Override
    public List<retour> SelectByArtistere(String art) {
        List<retour> retours =new ArrayList<>();
        try {
            String req = "select * FROM `retour` where `artiste` = "+art;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                retour s = new retour();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
                retours.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retours;
    }

    @Override
    public List<retour> SelectByUserret(String usr) {
        List<retour> retours=new ArrayList<>();
        try {
            String req = "select * FROM `retour` where `user_name`like '%"+usr+"%'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                retour s = new retour();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
                s.setAddres(rs.getString("addres"));
                s.setUser_name(rs.getString("user_name"));
                s.setDate_entr(rs.getDate("date"));
                s.setDate_retour(rs.getDate("date"));
                retours.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retours;
    }

    @Override
    public List<retour> SlectByDatere(Date d) {
        List<retour> retours=new ArrayList<>();
        try {
            String req = "select * FROM `retour` where `date` = "+d;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                retour s = new retour();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende_id"));
                s.setAddres(rs.getString("addres"));
                s.setUser_name(rs.getString("user_name"));
                ;
                retours.add(s);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return retours;
    }

    @Override
    public void mouveToLivraison(retour s) {
        livraisonService sl = new livraisonService();

        deleatretourById(s.getId());
        livraison l = new livraison(s.getId(),s.getName(),s.getArtiste(),s.getAddres(),s.getDate_sort(),s.getId_commende(),s.getUser_name());
        sl.addlivraison(l);
        System.out.println("le commende  is now in livraison");

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
                        "ArtFlow want to unform you that your commend is back to the Stock")
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
                        "ArtFlow want to unform you that your commend is back to the Stock")
                .create();

        System.out.println(message.getSid());

    }


}
