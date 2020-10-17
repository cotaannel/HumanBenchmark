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

public class AimTrainer {
    private Scene scene;
    @FXML
    private Label remainingLabel;
    @FXML
    private Pane pane;
    private ImageView image;
    private int remaining = 30;

    @FXML
    private void startGame() {
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

        image.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("image clicked");
                remaining--;
                createAimImage();
            }
        });

        if(remaining == 0) {
            pane.getChildren().clear();
            System.out.println("done");
        }
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
