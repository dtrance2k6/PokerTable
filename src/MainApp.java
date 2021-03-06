
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane TableLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PokerTable");

        initTableLayout();

        showPokerTable();
    }

    /**
     * Initializes the table layout.
     */
    public void initTableLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("TableLayout.fxml"));
            TableLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(TableLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the PokerTable inside the table layout.
     */
    public void showPokerTable() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("PokerTable.fxml"));
            AnchorPane PokerTable = (AnchorPane) loader.load();

            // Set tableLayout into the center of root layout.
            TableLayout.setCenter(PokerTable);
            
            PokerTableController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}