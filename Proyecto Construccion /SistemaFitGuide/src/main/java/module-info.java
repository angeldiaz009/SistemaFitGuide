module omr.uacm.sistemafitguide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens omr.uacm.sistemafitguide to javafx.fxml;
    exports omr.uacm.sistemafitguide;
}
