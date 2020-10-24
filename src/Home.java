import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Home {
    private Scene scene;

    public void initialize() { scene = Main.getScene(); }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void reactionTimeClicked() {
        Pane newRoot = Loader.loadFxmlFile("reactionTime.fxml");
        scene.setRoot(newRoot);
    }

    public void aimTrainerClicked() {
        Pane newRoot = Loader.loadFxmlFile("aimTrainer.fxml");
        scene.setRoot(newRoot);
    }

    public void chimpTestClicked() {
        Pane newRoot = Loader.loadFxmlFile("chimpTest.fxml");
        scene.setRoot(newRoot);
    }

    public void visualMemoryClicked() {
        Pane newRoot = Loader.loadFxmlFile("visualMemory.fxml");
        scene.setRoot(newRoot);
    }

    public void typingClicked() {
        Pane newRoot = Loader.loadFxmlFile("typing.fxml");
        scene.setRoot(newRoot);
    }

    public void numberMemoryClicked() {
        Pane newRoot = Loader.loadFxmlFile("numberMemory.fxml");
        scene.setRoot(newRoot);
    }

    public void verbalMemoryClicked() {
        Pane newRoot = Loader.loadFxmlFile("verbalMemory.fxml");
        scene.setRoot(newRoot);
    }

    public void matchPairsClicked() {
        Pane newRoot = Loader.loadFxmlFile("matchPairs.fxml");
        scene.setRoot(newRoot);
    }

    public void scoresClicked() {
        Pane newRoot = Loader.loadFxmlFile("scores.fxml");
        scene.setRoot(newRoot);
    }
}