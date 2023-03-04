/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Reservation {
    private int id;
    private int nb_place;
    private double price;
    private Client client;
    private String name;
   

   
    
    public Reservation(){
    
    }

    public Reservation(int id, int nb_place, double price, Client client, String name) {
        this.id = id;
        this.nb_place = nb_place;
        this.price = price;
        this.client = client;
        this.name = name;
       
    }

    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_place() {
        return nb_place;
    }

    public String getName() {
        return name;
    }

    
    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public double getPrice() {
        return price;
    }

    
    

    public void setPrice(double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setName(String name) {
        this.name = name;
    }

   

//   
   
     @Override
    public String toString() {
         //"Evenement{" + "id=" + id + 
              return  //"id=" + id +
                      
                "nb_place='" + nb_place +System.lineSeparator()+
                //+ "name='" + name + System.lineSeparator()+
                "price='" + price +System.lineSeparator()+
               // + "start_hour=" + start_hour + 
                "client='" + client +System.lineSeparator()+
                //+ "finish_hour=" + finish_hour + 
                
                "name='" + name +System.lineSeparator();
                     
                
                
                             
    
               
         }  
    

    

 

    

    
    
    
}
