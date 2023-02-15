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
    
    
    
    public Artiste(){
     
     
     }
  

    public Artiste(int id_artiste, String firstname, String lastname, String birthplace, String birthdate, String description, 
       String image, String address, String phonenumber, String username, String password, String email) {
        this.id_artiste = this.id_artiste;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId_artiste(int id_artiste) {
        this.id_artiste = id_artiste;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Artiste{" + "id_artiste=" + id_artiste + ", firstname=" + firstname + ", lastname=" + lastname + ", birthplace=" + birthplace + ", birthdate=" + birthdate + ", description=" + description + ", image=" + image + ", address=" + address + ", phonenumber=" + phonenumber + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
    
}
