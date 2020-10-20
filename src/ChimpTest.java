import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChimpTest {
    private Scene scene;
    @FXML
    private Pane pane;
    private int strikes = 0;
    private int numberOfSquares = 4;
    private int num = 0;
    private ArrayList<StackPane> list;

    public void startGame() {
        //pane.getChildren().clear();
        list = new ArrayList<>();
        for(int i = 1; i <= numberOfSquares; i++) {
            createSquare(i);
        }
    }

    public void createSquare(int i) {
        StackPane stackPane = new StackPane();
        String s = Integer.toString(i);
        Label label = new Label(s);
        Random random = new Random();
        int ranX = random.nextInt((int) (pane.getWidth()-1));
        int ranY = random.nextInt((int) (pane.getHeight()-1));
        Rectangle rec = new Rectangle(1, 1, 40, 40);
        rec.setStroke(Color.BLACK);
        rec.setFill(Color.WHITE);
        stackPane.getChildren().addAll(rec, label);
        stackPane.setLayoutX(ranX);
        stackPane.setLayoutY(ranY);
        list.add(stackPane);
        pane.getChildren().add(stackPane);

        stackPane.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(stackPane == list.get(num)) {
                    if(numberOfSquares != 4) {

                    }
                    System.out.println("1 clicked");
                    num++;
                    stackPane.getChildren().clear();

                } else {
                    System.out.println("not 1");
                }
            }
        });
    }

    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("chimpTest.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
