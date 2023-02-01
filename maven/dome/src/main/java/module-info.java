module dome {
    requires javafx.controls;
    requires javafx.fxml;

    opens dome to javafx.fxml;
    exports dome;
}
