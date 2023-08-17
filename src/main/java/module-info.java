module monitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens monitor to javafx.fxml;
    exports monitor;
}