module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}