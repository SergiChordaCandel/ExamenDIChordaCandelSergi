module org.example.examenpractico2di {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.examenpractico2di to javafx.fxml;
    exports org.example.examenpractico2di;
}