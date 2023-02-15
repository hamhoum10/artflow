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
public class Client {
    private int id_client;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String address;
    private String phonenumber;
    private String email;
    private String username;
    private String password;
    
    
    public Client(){
    
    
    }

    public Client(int id_client, String firstname, String lastname, Date birthdate, String address, String phonenumber, 
            String email, String username, String password) {
        this.id_client = id_client;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId_client() {
        return id_client;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate + ", address=" + address + ", phonenumber=" + phonenumber + ", email=" + email + ", username=" + username + ", password=" + password + '}';
    }
    
    
    
    
}
