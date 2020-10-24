import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    private static Home home;
    private static Scene scene;
    private static Scores scores;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Human Benchmark");

        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("home.fxml"));

        GridPane root = loader.load();
        scores = new Scores();
        scene = new Scene(root);
        home = loader.getController();
        home.setScene(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Scene getScene() {
        return scene;
    }
    public static Scores getScores() {
        return scores;
    }
}
