/**
 * @author Annel Cota
 *
 * This Main class starts up the game
 * by loading the home part of the game.
 */

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

    /**
     * Starts up the Human Benchmark game by loading
     * the home screen part of the game.
     * @param primaryStage : stage
     * @throws Exception
     */
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

    /**
     * Gets the scene.
     * @return scene
     */
    public static Scene getScene() {
        return scene;
    }

    /**
     * Gets the scores.
     * @return scores
     */
    public static Scores getScores() {
        return scores;
    }
}
