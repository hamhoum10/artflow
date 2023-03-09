package interfaces;

import services.*;
import interfaces.DashbordInterface;
import models.Dashbord;
import models.livraison;
import util.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DashbordService implements DashbordInterface {
    Connection cnx = MyConnection.getInstance().getCnx();
    @Override
    public List<Dashbord> fetchDashbord() {
        List<Dashbord> dashbords =new ArrayList<>();
        try {
            String req = "SELECT YEAR(created_at) as year, MONTH(created_at) as month, " +
                    "SUM(total_amount) as total_product FROM commande GROUP BY month(created_at)," +
                    " MONTH(created_at) ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Dashbord d = new Dashbord();
                d.setYears(rs.getInt(1));
                d.setMonth(rs.getInt(2));
                d.setTotal_amount(rs.getInt(3));

                dashbords.add(d);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dashbords;
    }
}
