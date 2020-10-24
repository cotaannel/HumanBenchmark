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

    public void startGame() {
        scores = Main.getScores();
        gameUpdates.setText("");
        int highScore = scores.getNumberMemoryScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        submitButton.setDisable(false);
        numberInput.setVisible(false);
        Random rand = new Random();
        int n = Integer.parseInt(randomNums);
        int min = Integer.parseInt(minNum);
        number = rand.nextInt(n + 1 - min) + (min + 1);
        numberLabel.setText(Integer.toString(number));
        PauseTransition pause1 = new PauseTransition(Duration.seconds(numberOfSeconds));
        PauseTransition pause2 = new PauseTransition(Duration.seconds(numberOfSeconds));
        pause1.setOnFinished(e -> numberLabel.setText(null));
        pause2.setOnFinished(e -> numberInput.setVisible(true));
        pause1.play();
        pause2.play();
    }

    public void getNumberInput() {
        String s = numberInput.getText();
        numberGuess = Integer.parseInt(s);
    }

    public void compareNumbers() {
        if(numberGuess == number) {
            randomNums += "9";
            minNum += "9";
            numberInput.clear();
            numberOfSeconds++;
            level++;
            submitButton.setDisable(true);
            gameUpdates.setText("Level "+ level +":\n" + "Number: " + number  +
                    "\nYour Answer: " + numberGuess + "\nPress start for next level");
        } else {
            //if gets wrong number, disables start and submit button
            startButton.setDisable(true);
            submitButton.setDisable(true);
            scores.addNumberMemoryScore(level);
            gameUpdates.setText("Level "+ level +":\n" + "Number: " + number  +
                    "\nYour Answer: " + numberGuess + "\nWrong Number" +
                    "\nRestart game or go back to Home Screen");
        }
    }

    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("numberMemory.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }


    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
