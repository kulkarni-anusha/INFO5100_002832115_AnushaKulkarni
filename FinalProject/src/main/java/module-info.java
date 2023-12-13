module com.example.finalprojectjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.finalprojectjava to javafx.fxml;
    exports com.example.finalprojectjava;
}