import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Home {
    private final String homePage;
    private Scene scene;
    private Values values;

    public Home() {
        homePage ="home.fxml";
    }

    public void initialize() {
        values = Main.getValues();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void reactionTimeClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("reactionTime.fxml");
        if(!values.getReactionTimeAgain()) {
            scene.setRoot(newRoot);
            values.setReactionTime(scene);
        } else {
            scene = values.getReactionTime();
            scene.setRoot(newRoot);
        }
    }

    public void aimTrainerClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("aimTrainer.fxml");
        if(!values.getAimTrainerAgain()) {
            scene.setRoot(newRoot);
            values.setAimTrainer(scene);
        } else {
            scene = values.getAimTrainer();
            scene.setRoot(newRoot);
        }
    }

    public void chimpTestClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("chimpTest.fxml");
        if(!values.getChimpTestAgain()) {
            scene.setRoot(newRoot);
            values.setChimpTest(scene);
        } else {
            scene = values.getChimpTest();
            scene.setRoot(newRoot);
        }
    }

    public void visualMemoryClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("visualMemory.fxml");
        if(!values.getVisualMemoryAgain()) {
            scene.setRoot(newRoot);
            values.setVisualMemory(scene);
        } else {
            scene = values.getVisualMemory();
            scene.setRoot(newRoot);
        }
    }

    public void typingClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("typing.fxml");
        if(!values.getTypingAgain()) {
            scene.setRoot(newRoot);
            values.setTyping(scene);
        } else {
            scene = values.getTyping();
            scene.setRoot(newRoot);
        }
    }

    public void numberMemoryClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("numberMemory.fxml");
        if(!values.getNumberMemoryAgain()) {
            scene.setRoot(newRoot);
            values.setNumberMemory(scene);
        } else {
            scene = values.getNumberMemory();
            scene.setRoot(newRoot);
        }
    }

    public void verbalMemoryClicked(ActionEvent actionEvent) {
        Pane newRoot = Loader.loadFxmlFile("verbalMemory.fxml");
        if(!values.getVerbalMemoryAgain()) {
            scene.setRoot(newRoot);
            values.setVerbalMemory(scene);
        } else {
            scene = values.getVerbalMemory();
            scene.setRoot(newRoot);
        }
    }
}