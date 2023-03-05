module com.example.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires stripe.java;
    requires itextpdf;
    requires itext;

    opens com.example.testjavafx to javafx.fxml;
    exports com.example.testjavafx;
}