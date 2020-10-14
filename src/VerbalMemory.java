import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class VerbalMemory {
    private Scene scene;


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
