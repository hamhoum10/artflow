module com.example.newartflow {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.javadoc;
    requires twilio;
    requires java.desktop;


    opens com.example.newartflow to javafx.fxml;
    exports com.example.newartflow;
    exports controller;
    opens controller to javafx.fxml;
    exports controller.Stock;
    opens controller.Stock to javafx.fxml;
    exports controller.Retour;
    opens controller.Retour to javafx.fxml;
    exports controller.Livraison;
    opens controller.Livraison to javafx.fxml;

}