/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.awt.Image;
import java.sql.Date;


/**
 *
 * @author Lenovo
 */
public class Artiste {
   private int id_artiste;
    private String firstname;
    private String lastname;
    private String birthplace;
    private String birthdate;
    private String description;
    private String image;
    private String address;
    private String phonenumber;
    private String username;
    private String password;
    private String email;

    public Artiste() {
    }

    public Artiste(String firstname, String lastname, String birthplace, String birthdate, String description, String image, String address, String phonenumber, String username, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
        this.description = description;
        this.image = image;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Artiste(int id_artiste, String firstname, String lastname, String birthplace, String birthdate, String description, String image, String address, String phonenumber, String username, String password, String email) {
        this.id_artiste = id_artiste;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
        this.description = description;
        this.image = image;
        this.address = address;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId_artiste() {
        return id_artiste;
    }

    public void setId_artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    

   

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @Override
//    public String toString() {
//        return "id_artiste=" + id_artiste;
//                
//                }

    @Override
    public String toString() {
        return "firstname=" + firstname ;
    }

    
    
    
}