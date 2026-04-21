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


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

    private static final double SCALE = 100.0;

    private final GardenPlanner planner;

    private TextField widthField;
    private TextField heightField;
    private TextField leftField;
    private TextField topField;

    public GuiMain() {
        planner = new GardenPlanner();
        planner.createBasicDesign();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane gardenPane = new Pane();
        gardenPane.setStyle("-fx-background-color: #007700;");

        for (RectBed bed : planner.getBeds()) {
            Rectangle rect = new Rectangle();
            rect.setX(bed.getLeft() * SCALE);
            rect.setY(bed.getTop() * SCALE);
            rect.setWidth(bed.getWidth() * SCALE);
            rect.setHeight(bed.getHeight() * SCALE);
            rect.setFill(Color.SADDLEBROWN);
            gardenPane.getChildren().add(rect);
        }

        BorderPane root = new BorderPane();
        root.setCenter(gardenPane);
        root.setRight(buildPropertiesPanel());

        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

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
