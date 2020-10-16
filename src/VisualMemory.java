import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class VisualMemory {
    private Scene scene;

    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("visualMemory.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
