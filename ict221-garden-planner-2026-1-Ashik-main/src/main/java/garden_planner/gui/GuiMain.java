package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * ============================================================
 * Change made by Claude Code (Workshop 7, Sections 6 and 7)
 * ------------------------------------------------------------
 * The original GuiMain only displayed a single placeholder
 * Button in a 300x275 Scene. It has been rewritten to render
 * the default garden layout and show the first bed's
 * properties, as described in the workshop brief.
 *
 * What was added:
 *  - SCALE constant (metres -> pixels)
 *  - planner field (1-1 association to GardenPlanner)
 *  - widthField / heightField / leftField / topField fields
 *    for displaying the first bed's properties
 *  - GuiMain() constructor: creates a GardenPlanner and calls
 *    createBasicDesign() so the default layout is ready
 *  - start(): builds an 800x600 Scene with a BorderPane root,
 *    a green Pane in the centre showing one Rectangle per
 *    RectBed (scaled by SCALE), and a VBox of TextFields on
 *    the right showing the first bed's width/height/left/top
 *  - buildPropertiesPanel(): helper that constructs the VBox
 *    of property TextFields
 * ============================================================
 */

/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

    // Change made by Claude Code: scale factor so 1 m -> 100 pixels
    private static final double SCALE = 100.0;

    // Change made by Claude Code: 1-1 association with GardenPlanner backend
    private final GardenPlanner planner;

    // Change made by Claude Code: TextFields for displaying first bed properties
    private TextField widthField;
    private TextField heightField;
    private TextField leftField;
    private TextField topField;

    // Change made by Claude Code: new constructor that sets up the default garden
    public GuiMain() {
        planner = new GardenPlanner();
        planner.createBasicDesign();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Change made by Claude Code: green background Pane that hosts the garden beds
        Pane gardenPane = new Pane();
        gardenPane.setStyle("-fx-background-color: #007700;");

        // Change made by Claude Code: loop over every RectBed and draw it as a
        // scaled JavaFX Rectangle inside the gardenPane.
        for (RectBed bed : planner.getBeds()) {
            Rectangle rect = new Rectangle();
            rect.setX(bed.getLeft() * SCALE);
            rect.setY(bed.getTop() * SCALE);
            rect.setWidth(bed.getWidth() * SCALE);
            rect.setHeight(bed.getHeight() * SCALE);
            rect.setFill(Color.SADDLEBROWN);
            gardenPane.getChildren().add(rect);
        }

        // Change made by Claude Code: BorderPane root with garden in the centre
        // and a properties panel on the right (Section 7).
        BorderPane root = new BorderPane();
        root.setCenter(gardenPane);
        root.setRight(buildPropertiesPanel());

        // Change made by Claude Code: enlarged Scene from 300x275 to 800x600
        // so the whole garden is visible.
        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Change made by Claude Code (Workshop 7, Section 7):
     * Builds a VBox that shows the first bed's width, height, left and top
     * in individual TextField widgets.
     */
    private VBox buildPropertiesPanel() {
        VBox box = new VBox(8);
        box.setStyle("-fx-padding: 10;");

        widthField = new TextField();
        heightField = new TextField();
        leftField = new TextField();
        topField = new TextField();

        if (!planner.getBeds().isEmpty()) {
            RectBed first = planner.getBeds().get(0);
            widthField.setText(Double.toString(first.getWidth()));
            heightField.setText(Double.toString(first.getHeight()));
            leftField.setText(Double.toString(first.getLeft()));
            topField.setText(Double.toString(first.getTop()));
        }

        box.getChildren().addAll(
                new TextField("Bed 1 properties:"),
                widthField,
                heightField,
                leftField,
                topField
        );
        return box;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
