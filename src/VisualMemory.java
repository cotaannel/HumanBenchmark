import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class VisualMemory {
    private Scene scene;
    private Values values;

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        values = Main.getValues();
        scene = values.getHome();
        scene.setRoot(newRoot);
    }
}
