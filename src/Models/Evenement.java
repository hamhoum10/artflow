/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.sql.Date;
//import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public class Evenement {
    private int id;
    private String name;
   // private Date date_evemt;
    private String start_hour;
    private String finish_hour;
    private String capacity;
    private String description;
    private String image;
    private String location;
    private Artiste artiste;
    private Date date_evemt;
    private Double prix;

   

   

   
    
    
    public Evenement(){
    
    }

    public Evenement(int id, String name, String start_hour, String finish_hour, String capacity, String description, String image, String location, Artiste artiste, Date date_evemt, Double prix) {
        this.id = id;
        this.name = name;
        this.start_hour = start_hour;
        this.finish_hour = finish_hour;
        this.capacity = capacity;
        this.description = description;
        this.image = image;
        this.location = location;
        this.artiste = artiste;
        this.date_evemt = date_evemt;
        this.prix = prix;
    }

   

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

   

   
    

   

   

   
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate_evemt() {
        return date_evemt;
    }

    

   

   

   

    public String getStart_hour() {
        return start_hour;
    }

    public String getFinish_hour() {
        return finish_hour;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Double getPrix() {
        return prix;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate_evemt(Date date_evemt) {
        this.date_evemt = date_evemt;
    }

   
    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public void setFinish_hour(String finish_hour) {
        this.finish_hour = finish_hour;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    
    @Override
    public String toString() {
         //"Evenement{" + "id=" + id + 
              return  //"id=" + id +
                "name='" + name +System.lineSeparator()+
                //+ "name='" + name + System.lineSeparator()+
                "start_hour='" + start_hour +System.lineSeparator()+
               // + "start_hour=" + start_hour + 
                "finish_hour='" + finish_hour +System.lineSeparator()+
                //+ "finish_hour=" + finish_hour + 
                "capacity='" + capacity +System.lineSeparator()+
                "description='" + description +System.lineSeparator()+
                "image='" + image +System.lineSeparator()+
                "location='" + location +System.lineSeparator()+
                "artiste=" + artiste +System.lineSeparator()+
                "date_evemt='" + date_evemt +System.lineSeparator()+
                  "prix='" + prix +System.lineSeparator();
                
                
                             
    
               
         }  
//
//    @Override
//    public String toString() {
//        return "Evenement{" + "id=" + id + ", name=" + name + ", start_hour=" + start_hour + ", finish_hour=" + finish_hour + ", capacity=" + capacity + ", description=" + description + ", image=" + image + ", location=" + location + ", artiste=" + artiste + ", date_evemt=" + date_evemt + '}';
//    }

   

   

    
}


    

    
   

    
    

    
    

