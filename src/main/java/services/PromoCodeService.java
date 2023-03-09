package services;

import models.Article;
import models.Ligne_panier;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PromoCodeService {

    Connection cnx = MyConnection.getInstance().getCnx();

    public boolean verifierPromocode(String code){
        boolean exist=false;
        String query = "SELECT code FROM promocode WHERE code = ?";
        try {
            PreparedStatement p  = cnx.prepareStatement(query);
            p.setString(1,code);
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()) {
                System.out.println("Le code existe dans la table promocode.");
                exist =true;
                deletepromocode(code);

            } else {
                System.out.println("Le code n'existe pas dans la table promocode.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exist;

    }

    public void deletepromocode(String code) {
        try {
            String sql ="DELETE from promocode WHERE code = ?";
            PreparedStatement p  = cnx.prepareStatement(sql);
            p.setString(1,code);
            p.executeUpdate();
            System.out.println(code +" est supprimé");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int generatenewCode(){
        Random random = new Random();
        int randomNumber = random.nextInt(90000000) + 10000000;
        System.out.println(randomNumber);
        try {
            String sql ="insert into promocode (code) values (?) ";
            PreparedStatement p  = cnx.prepareStatement(sql);
            p.setInt(1,randomNumber);
            p.executeUpdate();
            System.out.println("new promocode est ajouté");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return randomNumber;
    }
}
