package services;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import interfaces.livraisonInterface;
import models.livraison;
import models.retour;
import models.stock;
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

            System.out.println("livraison Added Successfully!");

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
            while (rs.next()) {
                livraison s = new livraison();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setUser_name(rs.getString("User_name"));
                s.setAddres(rs.getString(4));
                s.setArtiste(rs.getString("artiste"));
                s.setId_commende(rs.getInt("id_commende"));
//                s.setDate_entr(rs.getDate("date_sort"));

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
            String req = "select * FROM `livraison` where `user_name` like '%"+usr+"%'";
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
                s.setDate_entr(rs.getDate("date_sort"));
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
        List<livraison> livraisons=new ArrayList<>();
        try {
            String req = "select * FROM `livraison` where `date_sort` = "+d;
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
    public void moveToretour(livraison s) {
        retourService sl = new retourService();

        deleatlivraisonById(s.getId());
        retour l = new retour(s.getId(),s.getName(),s.getArtiste(),s.getAddres(),s.getDate_sort(),s.getId_commende(),s.getUser_name());
        sl.addretour(l);
        System.out.println("le stock is now in livraison");
    }

    @Override
    public void moveToStock(livraison s) {
        stockService sl = new stockService();

        deleatlivraisonById(s.getId());
        stock l = new stock(s.getId(),s.getName(),s.getArtiste(),s.getAddres(),s.getDate_sort(),s.getId_commende(),s.getUser_name());
        sl.addstock(l);
        System.out.println("le stock is now in stock");
        
    }

    @Override
    public void SmsNotification() {
        String ACCOUNT_SID = "AC0d38c511436eadf48ac03b413f251cbb";
        String AUTH_TOKEN = "28b08adf773c0df3f314fc80c562026a";


            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber("+21650660438"),

                            new com.twilio.type.PhoneNumber("+12766638918"),
                            "ArtFlow want to unform you that your commend is withe the delevery man now")
                    .create();

            System.out.println(message.getSid());

    }

}
