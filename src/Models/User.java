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
public class User {
     private int id_user;
    private String username;
    private String password;
    private String type;
    
    
    public User() {
    }

    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(int id_user, String username, String password, String type) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
} 