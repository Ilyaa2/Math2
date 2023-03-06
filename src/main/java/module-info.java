module com.example.mymath2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mymath2 to javafx.fxml;
    exports com.example.mymath2;
}