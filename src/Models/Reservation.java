/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Lenovo
 */
public class Reservation {
    private int id;
    private int nb_place;
    private double price;
    private Client client;

   
    
    public Reservation(){
    
    }

    public Reservation(int id, int nb_place, double price) {
        this.id = id;
        this.nb_place = nb_place;
        this.price = price;
    }

   
     public Client getClient() {
        return client;
    }
    
    

    public int getId() {
        return id;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    

    public int getNb_place() {
        return nb_place;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", nb_place=" + nb_place + ", price=" + price + ", client=" + client + '}';
    }

    
    
    
}
