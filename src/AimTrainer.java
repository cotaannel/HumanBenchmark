import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AimTrainer {
    private long startTime;
    private Scene scene;
    @FXML
    private Label remainingLabel;
    @FXML
    private  Label results;
    @FXML
    private Pane pane;
    private ImageView image;
    private int remaining = 30;

    @FXML
    private void startGame() {
        results.setDisable(true);
        createAimImage();
    }

    public void createAimImage() {
        remainingLabel.setText("Remaining: " + remaining);
        pane.getChildren().clear();
        image = new ImageView(new Image("aim.png", 50, 50, true,true));
        image.setPickOnBounds(true);

        Random random = new Random();
        int ranX = random.nextInt((int) (pane.getWidth()-1));
        int ranY = random.nextInt((int) (pane.getHeight()-1));
        image.setLayoutX(ranX);
        image.setLayoutY(ranY);
        pane.getChildren().addAll(image);
        startTime = System.nanoTime();

        image.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("image clicked");
                remaining--;
                if(remaining == 0) {
                    remainingLabel.setText("Remaining: " + remaining);
                    pane.getChildren().clear();
                    long finishTime = System.nanoTime();
                    long reactionTime = finishTime - startTime;
                    long time = TimeUnit.NANOSECONDS.toMillis(finishTime);
                    long totalTime = (time / 30);
                    results.setDisable(false);
                    results.setText("Average time per target:\n" + totalTime + " ms");

                    System.out.println("done");
                } else {
                    createAimImage();
                }
            }
        });
    }

    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("aimTrainer.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
