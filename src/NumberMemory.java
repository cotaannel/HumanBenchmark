/**
 * @author Annel Cota
 *
 * This Number Memory game class shows a random
 * number with a certain amount of digits to the player
 * for only a certain amount of seconds. The player then
 * has to re-type that number that was shown once it
 * disappears.
 */

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.Random;

public class NumberMemory {
    private Scores scores;
    private Scene scene;
    private int number;
    private int level = 0;
    private int numberGuess;
    private int numberOfSeconds = 2;
    private String randomNums = "9";
    private String minNum = "0";
    @FXML
    private TextField numberInput;
    @FXML
    private Label numberLabel;
    @FXML
    private Label highScoreLabel;
    @FXML
    private Label gameUpdates;
    @FXML
    private Button startButton;
    @FXML
    private Button submitButton;

    /**
     * When the start button is clicked, a random number between the
     * specified number of digits is created and shown to user for a
     * specified amount of time. If there is a high score, the label is
     * updated.
     */
    public void startGame() {
        gameUpdates.setText("");
        //gets scores from Main
        scores = Main.getScores();
        //if there is a high score for this game, updates high score label
        int highScore = scores.getNumberMemoryScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        submitButton.setDisable(false);
        numberInput.setVisible(false);
        Random rand = new Random();
        //gets a random int between the minNum and randomNum
        int n = Integer.parseInt(randomNums);
        int min = Integer.parseInt(minNum);
        number = rand.nextInt(n + 1 - min) + (min + 1);
        numberLabel.setText(Integer.toString(number));
        //after specified number of seconds passed, clears the number and open the textfield
        PauseTransition pause1 = new PauseTransition(Duration.seconds(numberOfSeconds));
        PauseTransition pause2 = new PauseTransition(Duration.seconds(numberOfSeconds));
        pause1.setOnFinished(e -> numberLabel.setText(null));
        pause2.setOnFinished(e -> numberInput.setVisible(true));
        pause1.play();
        pause2.play();
    }

    /**
     * Once the submit button is clicked, the users
     * input is converted to a number.
     */
    public void getNumberInput() {
        String s = numberInput.getText();
        numberGuess = Integer.parseInt(s);
    }

    /**
     * This method compares the right number to the users
     * guess number. If they do not match, game over. If
     * they do match, it adds a digit to the number and
     * updates the game label.
     */
    public void compareNumbers() {
        if(numberGuess == number) {
            //adds a digit to the string to make sure the correct num of digits used
            randomNums += "9";
            minNum += "9";
            numberInput.clear();
            //adds a second to show the number to user
            numberOfSeconds++;
            //level goes up
            level++;
            submitButton.setDisable(true);
            gameUpdates.setText("Level "+ level +":\n" + "Number: " + number  +
                    "\nYour Answer: " + numberGuess + "\nPress start for next level");
        } else {
            //if gets wrong number, disables start and submit button
            startButton.setDisable(true);
            submitButton.setDisable(true);
            //adds score to scores class
            scores.addNumberMemoryScore(level);
            //shows user the stats
            gameUpdates.setText("Level "+ level +":\n" + "Number: " + number  +
                    "\nYour Answer: " + numberGuess + "\nWrong Number" +
                    "\nRestart game or go back to Home Screen");
        }
    }

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the game's fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("numberMemory.fxml");
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
