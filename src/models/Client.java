/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author kanza
 */
public class Client {
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private String phonenumber;
    private String email;   
    private String username;
    private String password;

    public Client() {
    }

    public Client(int id, String firstname, String lastname, String address, String phonenumber, String email, String username) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
    }

    
    
    public Client(int id, String firstname, String lastname, String address, String phonenumber, String email, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Client(String firstname, String lastname, String address, String phonenumber, String email, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }
  public Client(String firstname, String lastname, String address, String phonenumber, String email, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
  
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phonenumber=" + phonenumber + ", email=" + email + ", username=" + username + ", password=" + password + '}';
    }
    
    
}
