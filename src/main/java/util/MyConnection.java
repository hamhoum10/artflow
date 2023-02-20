package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private Connection cnx;
    static MyConnection instance;


    //credentiels
    final String URL = "jdbc:mysql://localhost:3306/artflow";
    final String USERNAME ="root";
    final String password ="";
    public MyConnection(){
        try {
            cnx= DriverManager.getConnection(URL,USERNAME,password);
            System.out.println("connexion etabli");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    //3
    public static MyConnection getInstance() {
        if(instance == null)
            instance = new MyConnection();

        return instance;
    }
}
