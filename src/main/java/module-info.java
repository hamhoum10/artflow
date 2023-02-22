module com.example.newartflow {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.javadoc;



    opens com.example.newartflow to javafx.fxml;
    exports com.example.newartflow;
    exports controller;
    opens controller to javafx.fxml;

}