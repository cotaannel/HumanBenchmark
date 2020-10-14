import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.awt.*;

public class NumberMemory {
    private Scene scene;
    private int number;
    @FXML
    private TextField numberInput;



    public void getNumberInput() {
        String s = numberInput.getText();
        number = Integer.parseInt(s);
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
