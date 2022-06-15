module com.example.laba10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laba10 to javafx.fxml;
    exports com.example.laba10;
}