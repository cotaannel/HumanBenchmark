import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class VisualMemory {
    private Scene scene;

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
