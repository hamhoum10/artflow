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
public class Evenement {
    private int id;
    private String name;
    private String date;
    private String start_hour;
    private String finish_hour;
    private String capacity;
    private String description;
    private String image;
    private String location;
    private Artiste artiste;

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }
    
    
    public Evenement(){
    
    }
    
    public Evenement(int id, String name, String date, String start_hour, String finish_hour, String capacity, String description, String image, String location){
    
        this.id = id;
        this.name = name;
        this.date = date;
        this.start_hour = start_hour;
        this.finish_hour = finish_hour;
        this.capacity = capacity;
        this.description = description;
        this.image = image;
        this.location = location;
    
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", name=" + name + ", date=" + date + ", start_hour=" + start_hour + ", finish_hour=" + finish_hour + ", capacity=" + capacity + ", description=" + description + ", image=" + image + ", location=" + location + ", artiste=" + artiste + '}';
    }

    
    

    
    
}
