module com.example.testjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires stripe.java;
    requires itextpdf;
    requires itext;
    //requires java.mail;
    //requires smtp;
    //requires pop3;
    //requires imap;
    //requires mailapi;
    //requires dsn;
    requires javafx.media;
    requires org.slf4j;
    requires twilio;
    requires java.mail;

    opens com.example.testjavafx to javafx.fxml;
    exports com.example.testjavafx;
}