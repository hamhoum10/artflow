/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/*import Interfaces.ArtisteInterface;
import Model.Artiste;
import Util.MyConnection;*/

import interfaces.ArtisteInterface;
import models.Artiste;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kanza
 */
public class ArtisteService implements ArtisteInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public Artiste saveArtiste(Artiste p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `artiste`(`firstname`, `lastname`,`birthplace`,`birthdate`,`description`,`image`,`address`, `phonenumber`, `username`, `password`,`email`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            /*FileInputStream imagefile= new FileInputStream(p.getImage());
            byte[] png_Artiste =new byte[imagefile.available()];
            imagefile.read(png_Artiste);*/
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getBirthplace());
            a.setString(4, p.getBirthdate());
            a.setString(5, p.getDescription());
            a.setString(6, "fedf"/*p.getImage()*/);
            a.setString(7, p.getAddress());
            a.setString(9, p.getPhonenumber());
            a.setString(10, p.getUsername());
            a.setString(11, p.getPassword());
            a.setString(8, p.getEmail());
            a.executeUpdate();
            System.out.println("artiste Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }/* catch (FileNotFoundException ex) {
            Logger.getLogger(ArtisteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArtisteService.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return p;    
    }

    @Override
    public List<Artiste> fetchArtiste(int id) {
          List<Artiste> artiste = new ArrayList<>();
          
        try {
            String req = "SELECT * FROM artiste";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Artiste p = new Artiste();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setBirthplace(rs.getString("birthplace"));
                p.setBirthdate(rs.getString("birthdate"));
                p.setDescription(rs.getString("description"));
                p.setImage(rs.getString("image"));
                p.setAddress(rs.getString("address"));
                p.setPhonenumber(rs.getString("phoneNumber"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setEmail(rs.getString("email"));

                artiste.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return artiste;
    }

    @Override
    public Artiste getArtiste(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateArtiste(Artiste p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "UPDATE `artiste` SET `firstname`=?,`lastname`=?,`birthplace`=?,`birthdate`=?,`description`=?,`image`=?,`address`=?,`phoneNumber`=?,`username`=?,`password`=?,`email`=? WHERE `id`=?");
            
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getBirthplace());
            a.setString(4, p.getBirthdate());
            a.setString(5, p.getDescription());
            a.setString(6, p.getImage());
            a.setString(7, p.getAddress());
            a.setString(9, p.getPhonenumber());
            a.setString(10, p.getUsername());
            a.setString(11, p.getPassword());
            a.setString(8, p.getEmail());

            a.setInt(12, p.getId());


            a.executeUpdate();
            System.out.println("artiste modified successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteArtiste(int id) {
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `artiste` WHERE id=?");
            
            a.setInt(1, id);
            a.executeUpdate();
            System.out.println("artiste deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}