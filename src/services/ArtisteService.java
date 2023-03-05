/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ArtisteInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Artiste;
import models.Categorie;
import util.MyConnection;

/**
 *
 * @author MediaStudio
 */
public class ArtisteService implements ArtisteInterface {
        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public Artiste fetchArtisteByName(String name) {
      Artiste artiste = new Artiste();
        try {
            
            String req = "SELECT * FROM Artiste WHERE nom_artiste = '"+name+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                artiste.setId_artiste(rs.getInt(1));
                artiste.setNom_artiste(rs.getString(2));
                artiste.setPrenom_artiste(rs.getString(3));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return artiste;
    }   

    @Override
    public List<Artiste> fetchArtiste() {
List<Artiste> artiste = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `artiste` ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Artiste e = new Artiste();
                e.setId_artiste(rs.getInt("Id_artiste"));

                e.setNom_artiste(rs.getString("Nom_artiste"));
                e.setPrenom_artiste(rs.getString("Prenom_artiste"));
                

                artiste.add(e);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return artiste;    }
        
    
    public String getArtistNameById(int id){
        return fetchArtiste().stream().filter(a->a.getId_artiste()==id).findFirst().get().getNom_artiste();
    }
}

