package controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import models.Dashbord;
import services.DashbordService;
import services.livraisonService;
import services.retourService;
import services.stockService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class DashbordController implements Initializable {
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    retourService rs = new retourService();
   stockService ss = new stockService();
   livraisonService ls = new livraisonService();
   DashbordService d = new DashbordService();
    @FXML
    private PieChart pieChart;
    void PieChart(){ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("les vente",ss.fetchstock().size()+ ls.fetchlivraison().size() ),
                    new PieChart.Data("Retour", rs.fetchretour().size()));



        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " amount: ", data.pieValueProperty()
                        )
                )
        );

        pieChart.getData().addAll(pieChartData);

    }
    void LineChart(){
       List<Dashbord> dd=d.fetchDashbord();
        XYChart.Series series = new XYChart.Series();
        for (int i = 0;i< dd.size();i++){
            switch (dd.get(i).getMonth()){
                case 0:
                    series.getData().add(new XYChart.Data("jan",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));

                    break;
                case 1:
//                    series.getData().add(new XYChart.Data("jan",0));
                    series.getData().add(new XYChart.Data("feb",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));

                    break;
                case 2:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
                    series.getData().add(new XYChart.Data("mar",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));

                    break;
                case 3:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
                    series.getData().add(new XYChart.Data("apr",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 4:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
                    series.getData().add(new XYChart.Data("may",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 5:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
                    series.getData().add(new XYChart.Data("jun",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 6:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
                    series.getData().add(new XYChart.Data("jul",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 7:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
                    series.getData().add(new XYChart.Data("aug",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 8:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
                    series.getData().add(new XYChart.Data("sep",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 9:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
                    series.getData().add(new XYChart.Data("oct",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("nov",0));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 10:
//
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
                    series.getData().add(new XYChart.Data("nov",dd.get(i).getTotal_amount()));
//                    series.getData().add(new XYChart.Data("dec",0));
                    break;
                case 11:
//                    series.getData().add(new XYChart.Data("jan",0));
//                    series.getData().add(new XYChart.Data("feb",0));
//                    series.getData().add(new XYChart.Data("mar",0));
//                    series.getData().add(new XYChart.Data("apr",0));
//                    series.getData().add(new XYChart.Data("may",0));
//                    series.getData().add(new XYChart.Data("jun",0));
//                    series.getData().add(new XYChart.Data("jul",0));
//                    series.getData().add(new XYChart.Data("aug",0));
//                    series.getData().add(new XYChart.Data("sep",0));
//                    series.getData().add(new XYChart.Data("oct",0));
//                    series.getData().add(new XYChart.Data("nov",0));
                    series.getData().add(new XYChart.Data("dec",dd.get(i).getTotal_amount()));
                    break;
            }

            lineChart.getData().add(series);

            System.out.println( );
            System.out.println(dd.get(0).getMonth()+"test");
            System.out.println(dd.get(1).getMonth()+"test1");
//            XYChart.Series series = new XYChart.Series();
//            series.getData().add(new XYChart.Data(i,dd.get(i).getTotal_amount()));
//            series.getData().add(new XYChart.Data("feb",dd.get(2).getTotal_amount()));
//            series.getData().add(new XYChart.Data("mar",dd.get(3).getTotal_amount()));
//            series.getData().add(new XYChart.Data("apr",dd.get(4).getTotal_amount()));
//            series.getData().add(new XYChart.Data("may",dd.get(5).getTotal_amount()));
//            series.getData().add(new XYChart.Data("jun",dd.get(6).getTotal_amount()));
//            series.getData().add(new XYChart.Data("jul",dd.get(7).getTotal_amount()));
//            series.getData().add(new XYChart.Data("aug",dd.get(8).getTotal_amount()));
//            series.getData().add(new XYChart.Data("sep",dd.get(9).getTotal_amount()));
//            series.getData().add(new XYChart.Data("oct",dd.get(10).getTotal_amount()));
//            series.getData().add(new XYChart.Data("nov",dd.get(11).getTotal_amount()));
//            series.getData().add(new XYChart.Data("dec",dd.get(12).getTotal_amount()));
//            lineChart.getData().add(series);
        }

//        XYChart.Series series = new XYChart.Series();
//        series.getData().add(new XYChart.Data("jan",23));
//        series.getData().add(new XYChart.Data("feb",23));
//        series.getData().add(new XYChart.Data("mar",23));
//        series.getData().add(new XYChart.Data("apr",23));
//        series.getData().add(new XYChart.Data("may",23));
//        series.getData().add(new XYChart.Data("jun",23));
//        series.getData().add(new XYChart.Data("jul",23));
//        series.getData().add(new XYChart.Data("aug",23));
//        series.getData().add(new XYChart.Data("sep",23));
//        series.getData().add(new XYChart.Data("oct",23));
//        series.getData().add(new XYChart.Data("nov",23));
//        series.getData().add(new XYChart.Data("dec",23));
//        lineChart.getData().add(series);
//        XYChart.Series series1 = new XYChart.Series();
//        series1.getData().add(new XYChart.Data("jan",23122));
//        series1.getData().add(new XYChart.Data("feb",23122));
//        series1.getData().add(new XYChart.Data("mar",23122));
//        series1.getData().add(new XYChart.Data("apr",23122));
//        series1.getData().add(new XYChart.Data("may",23122));
//        series1.getData().add(new XYChart.Data("jun",23122));
//        series1.getData().add(new XYChart.Data("jul",23122));
//        series1.getData().add(new XYChart.Data("aug",23122));
//        series1.getData().add(new XYChart.Data("sep",23122));
//        series1.getData().add(new XYChart.Data("oct",23122));
//        series1.getData().add(new XYChart.Data("nov",12223));
//        series1.getData().add(new XYChart.Data("dec",122));
//        lineChart.getData().add(series1);
        //SELECT YEAR(created_at) as year, MONTH(created_at) as month, SUM(total_amount) as total_product FROM commande GROUP BY YEAR(created_at), MONTH(created_at);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PieChart();
        LineChart();

    }

    }

