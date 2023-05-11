/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Reservation {
    private int id;
    private Evenement event;
    private Client client;
    private int nb_place;
    //private double price;
    private Date dateres;
    
   

   
    
    public Reservation(){
    
    }

    public Reservation(int id, Evenement event, int nb_place, Date dateres,Client client) {
        this.id = id;
        this.event = event;
        this.nb_place = nb_place;
        this.dateres = dateres;
        this.client=client;
    }
       public Reservation( Evenement event, int nb_place, Date dateres,Client client) {
        
        this.event = event;
        this.nb_place = nb_place;
        this.dateres = dateres;
        this.client=client;
    }


   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
    

    public Evenement getEvent() {
        return event;
    }

    public void setEvent(Evenement event) {
        this.event = event;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

   

    public Date getDateres() {
        return dateres;
    }

    public void setDateres(Date dateres) {
        this.dateres = dateres;
    }

//    @Override
//    public String toString() {
//        return "Reservation{" + "id=" + id + ", event=" + event + ", client=" + client + ", nb_place=" + nb_place + ", dateres=" + dateres + '}';
//    }

     @Override
    public String toString() {
        return  "nb_place='" + nb_place +System.lineSeparator()+
                  "dateres='" + dateres +System.lineSeparator();
    }



   
    

    

   
   
    

 

    

    
    
    
}
