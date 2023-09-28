module com.example.parkinglotexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parkinglotexercise to javafx.fxml;
    exports com.example.parkinglotexercise;
}