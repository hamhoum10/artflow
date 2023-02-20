/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.AdminInterface;
import models.Admin;
import util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kanza
 */
public class AdminService implements AdminInterface {
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public Admin saveAdmin(Admin p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "INSERT INTO `admin`(`firstname`, `lastname`, `email`, `phoneNumber`, `username`, `password`) VALUES (?,?,?,?,?,?)");
            
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getEmail());
            a.setString(4, p.getPhoneNumber());
            a.setString(5, p.getUsername());
            a.setString(6, p.getPassword());

            a.executeUpdate();
            System.out.println("Admin Added successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Admin> fetchAdmin(int id) {
          List<Admin> admin = new ArrayList<>();
          
        try {
            String req = "SELECT * FROM admin";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Admin p = new Admin();
                p.setId(rs.getInt(1));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setEmail(rs.getString("email"));
                p.setPhoneNumber(rs.getString("phoneNumber"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                
                admin.add(p);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return admin;
    }

    @Override
    public Admin getAdmin(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAdmin(Admin p) {
        try {
            PreparedStatement a = cnx.prepareStatement( "UPDATE `admin` SET `firstname`=?,`lastname`=?,`email`=?,`phoneNumber`=?,`username`=?,`password`=? WHERE `id`=?");
            
            a.setString(1, p.getFirstname());
            a.setString(2, p.getLastname());
            a.setString(3, p.getEmail());
            a.setString(4, p.getPhoneNumber());
            a.setString(5, p.getUsername());
            a.setString(6, p.getPassword());
            a.setInt(7, p.getId());

            a.executeUpdate();
            System.out.println("Admin modified successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAdmin(int id) {
        try {
            PreparedStatement a = cnx.prepareStatement( "DELETE FROM `admin` WHERE id=?");
            
            a.setInt(1, id);
            a.executeUpdate();
            System.out.println("Admin deleted successfully!");
            a.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    }


    

