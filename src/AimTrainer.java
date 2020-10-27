/**
 * @author Annel Cota
 *
 * In this Aim Trainer game class, there are a total of
 * 30 aim images that the user has to click. The goal
 * is to try to click through all of them as fast as possible.
 * Once all the images are clicked, the average time is calculated.
 */

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
    private int remaining = 30;
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

    /**
     * When the start button is clicked, this method is called.
     * This method starts the timer time and updates the high
     * score label if there is one. The first image is then created.
     */
    @FXML
    private void startGame() {
        //gets scores from Main
        scores = Main.getScores();
        //if there is a high score for this game, updates high score label
        long highScore = scores.getAimTrainerHighScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        //gets the time to use as a start time
        startTime = System.nanoTime();
        startButton.setDisable(true);
        results.setText("");
        results.setDisable(true);
        //creates first aim image
        createAimImage();
    }

    /**
     * This method creates the image and adds it to the pane.
     * It adds mouse clicked on event to each image. When the image
     * is clicked, it recalls the method to erase the current image
     * and a new one in a different spot. If there are no remaining images
     * left, the game ends.
     */
    public void createAimImage() {
        remainingLabel.setText("Remaining: " + remaining);
        //clears pane of any images before making a new one
        pane.getChildren().clear();
        image = new ImageView(new Image("Resources/images/aim.png", 50, 50,
                true,true));
        image.setPickOnBounds(true);
        //creates random coordinates to add the image on the pane
        Random random = new Random();
        int ranX = random.nextInt((int) (pane.getWidth()-1));
        int ranY = random.nextInt((int) (pane.getHeight()-1));
        image.setLayoutX(ranX);
        image.setLayoutY(ranY);
        pane.getChildren().addAll(image);

        image.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                //every time a image is clicked, it removes 1 from remaining
                remaining--;
                //when game is over, calculates how long it took user to finish
                if(remaining == 0) {
                    remainingLabel.setText("Remaining: " + remaining);
                    pane.getChildren().clear();
                    long finishTime = System.nanoTime();
                    long reactionTimeNano = finishTime - startTime;
                    long milliValue = TimeUnit.NANOSECONDS.toMillis(reactionTimeNano);
                    //gets the average time the user took to click on all images
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
