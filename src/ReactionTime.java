import javafx.animation.PauseTransition;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ReactionTime {
    private Scores scores;
    private Scene scene;
    private long startTime;
    private LongProperty reactionTimeValue;
    private  long rand;
    @FXML
    private  Label gameUpdate;
    @FXML
    private  Label highScoreLabel;
    @FXML
    private Pane root;
    @FXML
    private Label reactionTime;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ReactionTime() { reactionTimeValue = new SimpleLongProperty(0); }

    public void initialize() {
        scores = Main.getScores();
        long highScore = scores.getReactionTmeScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        reactionTime.textProperty().bind(reactionTimeValue.asString());
    }

    public void startTimer(ActionEvent actionEvent) throws InterruptedException {
        rand = ThreadLocalRandom.current().nextLong(1000, 5000);
        TimeUnit.MILLISECONDS.sleep(rand);
        root.setStyle("-fx-background-color: green");
        startTime = System.nanoTime();
    }

    public void finishTimer(ActionEvent actionEvent) {
        long finishTime = System.nanoTime();
        long reactionTimeNano = finishTime - startTime;
        long milliValue = TimeUnit.NANOSECONDS.toMillis(reactionTimeNano);
        long startMilliValue = TimeUnit.NANOSECONDS.toMillis(startTime);
        if(reactionTimeNano >= startMilliValue) {
            scores.addReactionTimeScore(milliValue);
            reactionTimeValue.setValue(milliValue);
        } else {
            gameUpdate.setText("You clicked too early!\n Game will be reset in 5 seconds.");
            PauseTransition pause = new PauseTransition(Duration.seconds(5));
            pause.setOnFinished(e -> retryGame());
            pause.play();
        }
    }

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the game's fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("reactionTime.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    /**
     * When the go back to home screen button is clicked, this
     * method reloads the home screen with its fxml file.
     */
    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
