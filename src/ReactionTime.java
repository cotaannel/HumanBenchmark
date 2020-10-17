import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ReactionTime {
    @FXML
    private Pane root;
    @FXML
    private Label reactionTime;

    private Scene scene;

    private long startTime;

    private LongProperty reactionTimeValue;

    private  long rand;

    @FXML
    private  Label gameUpdate;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ReactionTime() {
        reactionTimeValue = new SimpleLongProperty(0);
    }

    public void initialize() {
        reactionTime.textProperty().bind(reactionTimeValue.asString());
    }

    public void startTimer(ActionEvent actionEvent) throws InterruptedException {
        rand = ThreadLocalRandom.current().nextLong(1000, 5000);
        TimeUnit.MILLISECONDS.sleep(rand);
        root.setStyle("-fx-background-color: green");
        startTime = System.nanoTime();
    }

    public void finishTimer(ActionEvent actionEvent) {
        long finishTime = System.nanoTime();
        long reactionTimeNano = finishTime - startTime;
        long milliValue = TimeUnit.NANOSECONDS.toMillis(reactionTimeNano);
        long finTime = TimeUnit.NANOSECONDS.toMillis(rand);
//        if(reactionTimeNano >= rand) {
//            reactionTimeValue.setValue(milliValue);
//        } else {
//            gameUpdate.setText("Clicked too soon! Try again.");
//            //retryGame();
//        }
        reactionTimeValue.setValue(milliValue);
        System.out.println(milliValue);
        System.out.println(finTime);
        //reactionTime.setText(Long.toString(milliValue) + " ms");
    }

    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("reactionTime.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
