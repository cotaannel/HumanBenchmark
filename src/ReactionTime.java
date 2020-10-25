/**
 * @author Annel Cota
 *
 * The Reaction Time game class shows the player a red screen
 * that turns green after a random time. The player has to click
 * a button once the screen turns green and their reaction time is
 * then displayed. If the player clicks too early, before the screen
 * even turns green, they will notified and the game will be reset.
 */

import javafx.animation.PauseTransition;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
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
    private  long rand;
    private LongProperty reactionTimeValue;
    @FXML
    private  Label gameUpdate;
    @FXML
    private  Label highScoreLabel;
    @FXML
    private Pane root;
    @FXML
    private Label reactionTime;

    /**
     * Gets the scene.
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Sets the scene as the scene from the parameter.
     * @param scene : the scene from the parameter.
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Creates the reaction time value.
     */
    public ReactionTime() { reactionTimeValue = new SimpleLongProperty(0); }

    /**
     * If there is a high score for this game, the label
     * is updated to show that.
     */
    public void initialize() {
        //gets scores from Main
        scores = Main.getScores();
        //if there is a high score for this game, updates high score label
        long highScore = scores.getReactionTmeScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        reactionTime.textProperty().bind(reactionTimeValue.asString());
    }

    /**
     * Once the game is started, the root will be set to the
     * color green after a random amount of time. Once it sets
     * to green, the start time will be noted so that the
     * reaction time can be calculated.
     * @throws InterruptedException
     */
    public void startTimer() throws InterruptedException {
        rand = ThreadLocalRandom.current().nextLong(1000, 5000);
        TimeUnit.MILLISECONDS.sleep(rand);
        root.setStyle("-fx-background-color: green");
        startTime = System.nanoTime();
    }

    /**
     * Once the user clicks on the button to show signify their reaction
     * of the root turning green, that time is noted as the finish time.
     * The reaction time is calculated by doing finishTime - startTime.
     * If the user clicks before the screen turns green, they will be
     * notified and the game will restart. If they do not click too early,
     * their reaction time will be displayed on the screen.
     */
    public void finishTimer() {
        long finishTime = System.nanoTime();
        long reactionTimeNano = finishTime - startTime;
        long milliValue = TimeUnit.NANOSECONDS.toMillis(reactionTimeNano);
        long startMilliValue = TimeUnit.NANOSECONDS.toMillis(startTime);
        //if the reaction time is less than the start time, they clicked too early
        if(reactionTimeNano >= startMilliValue) {
            //the users reaction time is added to the scores class
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
