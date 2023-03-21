module com.example.cs213_pa4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs213_pa4 to javafx.fxml;
    exports com.example.cs213_pa4;
}