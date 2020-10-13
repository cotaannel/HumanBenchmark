import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    private static Home home;
    private static Values values = new Values();
    //private Values values;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Human Benchmark");

        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("home.fxml"));

        GridPane root = loader.load();
        Scene scene = new Scene(root);

        values.setHome(scene);
        home = loader.getController();
        home.setScene(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Values getValues() {
        return values;
    }
}
