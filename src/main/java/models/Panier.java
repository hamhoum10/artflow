package models;

import models.nada.Client;
import util.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Panier {
    private static int id_panier;

    private int id_client; //change it into Customer class

    private Client client;

    Connection cnx = MyConnection.getInstance().getCnx();

    public Panier(){}
    public Panier(int id_client) {
        this.id_client = id_client;
    }

    public Panier(int id_client, Client client) {
        this.id_client = id_client;
        this.client = client;
    }

    public Panier(Client client) {
        this.client = client;
    }

    public  int getId_panier() {
        /*try {
            String sql ="select id_panier from panier p join client c on p.id_client =c.id  where c.username ="+client.getUsername(); //twali baed where client.username = 7aja alkhtr username unique w ana acces lih mel class mesh kif id auto incere wfama join entre client w panier
            PreparedStatement p  = cnx.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                id_panier = rs.getInt("id_panier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return id_panier;
    }

    public   void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getId_client() {
        return id_client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "id_panier=" + id_panier +
                ", id_client=" + id_client +
                ", client=" + client +
                '}';
    }}
