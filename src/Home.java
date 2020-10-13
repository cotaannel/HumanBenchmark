import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Home {
    private final String homePage;
    private Scene scene;

    public Home() {
        homePage ="home.fxml";
    }

    public void initialize() {
        scene = Main.getScene();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void reactionTimeClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("reactionTime.fxml");
        scene.setRoot(newRoot);
    }

    public void aimTrainerClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("aimTrainer.fxml");
        scene.setRoot(newRoot);
    }

    public void chimpTestClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("chimpTest.fxml");
        scene.setRoot(newRoot);
    }

    public void visualMemoryClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("visualMemory.fxml");
        scene.setRoot(newRoot);
    }

    public void typingClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("typing.fxml");
        scene.setRoot(newRoot);
    }

    public void numberMemoryClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("numberMemory.fxml");
        scene.setRoot(newRoot);
    }

    public void verbalMemoryClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("verbalMemory.fxml");
        scene.setRoot(newRoot);
    }
}