import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AimTrainer {
    private Scores scores;
    private long startTime;
    private Scene scene;
    @FXML
    private Label remainingLabel;
    @FXML
    private Label highScoreLabel;
    @FXML
    private  Label results;
    @FXML
    private Pane pane;
    @FXML
    private Button startButton;
    private ImageView image;
    private int remaining = 30;

    @FXML
    private void startGame() {
        scores = Main.getScores();
        long highScore = scores.getAimTrainerHighScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        startTime = System.nanoTime();
        startButton.setDisable(true);
        results.setText("");
        results.setDisable(true);
        createAimImage();
    }

    public void createAimImage() {
        remainingLabel.setText("Remaining: " + remaining);
        pane.getChildren().clear();
        image = new ImageView(new Image("aim.png", 50, 50,
                true,true));
        image.setPickOnBounds(true);

        Random random = new Random();
        int ranX = random.nextInt((int) (pane.getWidth()-1));
        int ranY = random.nextInt((int) (pane.getHeight()-1));
        image.setLayoutX(ranX);
        image.setLayoutY(ranY);
        pane.getChildren().addAll(image);

        image.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                remaining--;
                if(remaining == 0) {
                    remainingLabel.setText("Remaining: " + remaining);
                    pane.getChildren().clear();
                    long finishTime = System.nanoTime();
                    long reactionTimeNano = finishTime - startTime;
                    long milliValue = TimeUnit.NANOSECONDS.toMillis(reactionTimeNano);
                    long totalTime = (milliValue / 30);
                    scores.addAimTrainerScore(totalTime);
                    results.setDisable(false);
                    results.setText("Average time per target:\n" + totalTime + " ms");
                } else {
                    createAimImage();
                }
            }
        });
    }

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the game's fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("aimTrainer.fxml");
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
