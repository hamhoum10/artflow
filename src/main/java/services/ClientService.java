package services;

import models.Client;
import util.MyConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientService  {
    Connection cnx = MyConnection.getInstance().getCnx();


    public Client saveClient(Client p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `client`(`firstname`, `lastname`, `birthdate`, `address`, `phonenumber`,`email`,`username`, `password`) VALUES (?,?,?,?,?,?,?,?)");

            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            a.setString(4, p.getAddress());
            a.setString(5, p.getEmail());
            a.setString(6, p.getPhonenumber());
            a.setString(7, p.getUsername());
            a.setString(8, p.getPassword());
            a.executeUpdate();
            p.setId(getId_client(p));
            System.out.println("the id is attribué : " + p.getId());
            System.out.println("client Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;    }


    public List<Client> fetchClient(int id) {
        List<Client> client = new ArrayList<>();
        try {
            String req = "SELECT * FROM client";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Client p = new Client();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setLastname(rs.getString("birthdate"));
                p.setAddress(rs.getString("address"));
                p.setPhonenumber(rs.getString("phoneNumber"));
                p.setEmail(rs.getString("email"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));

                client.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return client;
    }


    public Client getClient(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void updateClient(Client p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "UPDATE `client` SET `firstname`=?,`lastname`=?,`birthdate`=?,`address`=?,`phoneNumber`=?,`email`=?,`username`=?,`password`=? WHERE `id`=?");

            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getBirthday());
            a.setString(4, p.getAddress());
            a.setString(5, p.getPhonenumber());
            a.setString(6, p.getEmail());
            a.setString(7, p.getUsername());
            a.setString(8, p.getPassword());
            a.setInt(9, p.getId());
            a.executeUpdate();
            System.out.println("client modified successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }


    public void deleteClient(int id) {
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `client` WHERE id=?");

            a.setInt(1, id);
            a.executeUpdate();
            System.out.println("client deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // hethi lezem nada ta3melha zeda fi code te3ha mesh najem npassi client object fi parametre me8ir takssir rass
    public int getId_client(Client c) {
        int client_id = 0;
        String query = "SELECT id FROM client WHERE username = ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setString(1, c.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                client_id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client_id;
    }

}
