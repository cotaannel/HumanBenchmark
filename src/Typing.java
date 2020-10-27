/**
 * @author Annel Cota
 *
 * This Typing game class gives the player a prompt
 * that they have to copy by typing in the text
 * area below the prompt given. Once they're done,
 * their wpm will be calculated.
 */

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Typing {
    private Scores scores;
    private Scene scene;
    private int i = 0;
    private int characters = 0;
    private long startTime;
    private String userText = "";
    @FXML
    private TextArea prompt;
    @FXML
    private TextArea userInput;
    @FXML
    private Label highScoreLabel;
    @FXML
    private Label wpmLabel;
    private String currentPrompt;
    private String prompt1 = "Water. Earth. Fire. Air. " +
            "Long ago, the four nations lived together in harmony. " +
            "Then everything changed when the Fire Nation attacked. " +
            "Only the Avatar, master of all four elements, could stop them. " +
            "But when the world needed him most, he vanished. " +
            "A hundred years passed and my brother and I discovered the new Avatar, " +
            "an airbender named Aang, and although his airbending skills are great, " +
            "he still has a lot to learn before he's ready to save anyone. " +
            "But I believe Aang can save the world.";
    private String prompt2 = "The third little pig worked hard all day and " +
            "built his house with bricks. It was a sturdy house complete with " +
            "a fine fireplace and chimney. It looked like it could withstand the " +
            "strongest winds. The next day, a wolf happened to pass by the lane " +
            "where the three little pigs lived; and he saw the straw house, and " +
            "he smelled the pig inside. He thought the pig would make a mighty " +
            "fine meal and his mouth began to water.";
    private String prompt3 = "The landlady informed me that he had left the house " +
            "shortly after eight o'clock in the morning. I sat down beside the fire, " +
            "however, with the intention of awaiting him, however long he might be. " +
            "I was already deeply interested in his inquiry, for, though it was " +
            "surrounded by none of the grim and strange features which were " +
            "associated with the two crimes which I have already recorded, still, " +
            "the nature of the case and the exalted station of his client gave " +
            "it a character of its own.";

    /**
     * When the start button is clicked, the high score label is
     * updated if there is one and the create prompt is selected.
     */
    public void startGame() {
        //gets scores from Main
        scores = Main.getScores();
        //if there is a high score for this game, updates high score label
        int highScore = scores.getTypingScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        userInput.setDisable(false);
        createPrompt();
        startTime = System.nanoTime();
    }

    /**
     * Once the user finishes typing and they click on the
     * finish button, this method is called. The total time
     * it took them is calculated and then used to calculate
     * the wpm.
     */
    public void finishTyping() {
        //finishes timer and calculates total time
        long finishTime = System.nanoTime();
        long totalTimeNano = finishTime - startTime;
        long secValue = TimeUnit.NANOSECONDS.toSeconds(totalTimeNano);
        int seconds = (int) secValue / 60;
        //calculates words per minute
        int wpm = (characters / 5) / seconds;
        //add wpm to scores class
        scores.addTypingScore(wpm);
        wpmLabel.setText("Your speed: " + wpm + " wpm");
    }

    @FXML
    private void checkMatch() {
        userText = userInput.getText();
        if(userText.charAt(i) == currentPrompt.charAt(i)) {
            System.out.println("match");
        } else {
            System.out.println("no match");
        }
        System.out.println("current prompt: " + currentPrompt.charAt(i));
        System.out.println("use string " + userText.charAt(i));
        i++;
    }

    /**
     * Updates the text area with one of the three
     * prompts at random.
     */
    public void createPrompt() {
        Random rand = new Random();
        int n = rand.nextInt(3) + 1;
        if(n == 1) {
            prompt.setText(prompt1);
            currentPrompt = prompt1;
            characters = 625;
        } else if(n == 2) {
            prompt.setText(prompt2);
            currentPrompt = prompt2;
            characters = 519;
        } else {
            prompt.setText(prompt3);
            currentPrompt = prompt3;
            characters = 605;
        }
    }

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the game's fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("typing.fxml");
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
