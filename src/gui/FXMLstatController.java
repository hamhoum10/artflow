/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import pidevAuthArtiste.LoginArtisteController;
import services.ArtisteService;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author MediaStudio
 */
public class FXMLstatController implements Initializable {

    @FXML
    private PieChart piechart;
    ObservableList<PieChart.Data> data=FXCollections.observableArrayList();
    ArtisteService sa=new ArtisteService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stat();
    }    
    public void stat(){
        Connection cnx =MyConnection.getInstance().getCnx();
        String query="select count(*) As value,id_artiste as art from article group by id_artiste";
        try {
            PreparedStatement ps= cnx.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("art"));
                System.out.println(rs.getInt("value"));
                data.add(new PieChart.Data(rs.getString("art"),rs.getInt("value")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLstatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("d"+data);
        piechart.setTitle("***Statistics number of articles by artist**");
        piechart.setLegendSide(Side.LEFT);
        piechart.setData(data);
        
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("./FXMLafficher.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show(); 
    }
    
}
