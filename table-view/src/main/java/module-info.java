module table {
    requires javafx.fxml;
    requires javafx.controls;
    opens table to javafx.graphics;
    exports table;
}