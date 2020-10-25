/**
 * @author Annel Cota
 *
 * This Home class handles all of the different
 * Mini Game button clicks. When the user clicks
 * on a button to start a Mini Game, its
 * corresponding fxml file will be loaded.
 */

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Home {
    private Scene scene;

    /**
     * Gets the scene from Main.
     */
    public void initialize() { scene = Main.getScene(); }

    /**
     * Gets the scene.
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Sets the scene as the parameter scene.
     * @param scene : scene that is passed into method
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * If the Reaction Time button is clicked, the reaction
     * time fxml file is loaded.
     */
    public void reactionTimeClicked() {
        Pane newRoot = Loader.loadFxmlFile("reactionTime.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Aim Trainer button is clicked, the aim trainer
     * fxml file is loaded.
     */
    public void aimTrainerClicked() {
        Pane newRoot = Loader.loadFxmlFile("aimTrainer.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Chimp Test button is clicked, the chimp test fxml
     * file is loaded.
     */
    public void chimpTestClicked() {
        Pane newRoot = Loader.loadFxmlFile("chimpTest.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Visual Memory button is clicked, the visual
     * memory fxml file is loaded.
     */
    public void visualMemoryClicked() {
        Pane newRoot = Loader.loadFxmlFile("visualMemory.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Typing button is clicked, the typing fxml file
     * is loaded.
     */
    public void typingClicked() {
        Pane newRoot = Loader.loadFxmlFile("typing.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Number Memory button is clicked, the number
     * memory fxml file is loaded.
     */
    public void numberMemoryClicked() {
        Pane newRoot = Loader.loadFxmlFile("numberMemory.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Verbal Memory button is clicked, the verbal
     * memory fxml file is loaded.
     */
    public void verbalMemoryClicked() {
        Pane newRoot = Loader.loadFxmlFile("verbalMemory.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Match Pairs button is clicked, the match pairs
     * fxml file is loaded.
     */
    public void matchPairsClicked() {
        Pane newRoot = Loader.loadFxmlFile("matchPairs.fxml");
        scene.setRoot(newRoot);
    }

    /**
     * If the Game Score button is clicked, the scores
     * fxml file is loaded.
     */
    public void scoresClicked() {
        Pane newRoot = Loader.loadFxmlFile("scores.fxml");
        scene.setRoot(newRoot);
    }
}