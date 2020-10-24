import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Typing {
    private Scene scene;
    @FXML
    private TextArea prompt;
    @FXML
    private TextArea userInput;
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

    public void startGame() {
        createPrompt();
    }

    public void createPrompt() {
        Random rand = new Random();
        int n = rand.nextInt(3) + 1;
        if(n == 1) {
            prompt.setText(prompt1);
        } else if(n == 2) {
            prompt.setText(prompt2);
        } else {
            prompt.setText(prompt3);
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
