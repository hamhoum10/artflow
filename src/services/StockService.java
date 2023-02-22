/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.StockInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Client;
import models.stock;
import util.MyConnection;

/**
 *
 * @author MediaStudio
 */
public class StockService implements StockInterface {
           Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public stock fetchStockByName(String nom) {
        stock Stock = new stock();
        try {
            
            String req = "SELECT * FROM stock WHERE Name = '"+nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Stock.setId_stock(rs.getInt("Id_stock"));
                Stock.setName(rs.getString("Name"));
                Stock.setId_commende(rs.getInt("Id_commende"));
                Stock.setArtiste(rs.getString("Artiste"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Stock;    }

    @Override
    public List<stock> fetchStock() {
      List<stock> St = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `stock` ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                stock s = new stock();
                s.setId_stock(rs.getInt("Id_stock"));
                s.setName(rs.getString("Name"));
                s.setId_commende(rs.getInt("Id_commende"));
                s.setArtiste(rs.getString("Artiste"));

                St.add(s);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return St;    }
    
}
