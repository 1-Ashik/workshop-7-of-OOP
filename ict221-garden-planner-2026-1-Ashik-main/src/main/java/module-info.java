module garden_planner.gui {
    requires javafx.controls;
    requires javafx.fxml;

    exports garden_planner.gui;
    exports garden_planner.model;
    exports garden_planner.textui;

    opens garden_planner.gui to javafx.fxml;
}
