import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class VisualMemory {
    private int lives = 3;
    private int level = 1;
    private int misses;
    private int sideSquares = 3;
    private int colorSquaresFound;
    private int numOfSquares;
    private int numOfColorSquares = 3;
    private Scene scene;
    private int changeRound = 1;
    @FXML
    private Label livesLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label roundUpdate;
    @FXML
    private Button startButton;
    @FXML
    private Pane pane;
    private GridPane grid;
    private ArrayList<Rectangle> squaresList;
    private ArrayList<Rectangle> squaresListClear;

    public void startGame() {
        startButton.setDisable(true);
        levelLabel.setText("Level: " + level);
        livesLabel.setText("Lives: " + lives);
        roundUpdate.setText("");
        colorSquaresFound = 0;
        misses = 0;
        numOfSquares = sideSquares*sideSquares;
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        squaresList = new ArrayList<>();
        squaresListClear = new ArrayList<>();
        setupSquares(false);
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(e -> setupSquares(true));
        pause.play();
        pane.setDisable(false);
    }

    public void setupSquares(boolean clear) {
        ArrayList<Rectangle> list;
        if(clear) {
            list = squaresListClear;
        } else {
            list = squaresList;
        }
        int x = 0;
        for(int i = 0; i < numOfSquares; i++) {
            list.add(new Rectangle(30,30));
            if(clear) {
                list.get(i).setFill(Color.BLACK);
            } else {
                if(x < numOfColorSquares) {
                    list.get(i).setFill(Color.RED);
                    x++;
                } else {
                    list.get(i).setFill(Color.BLACK);
                }
            }
        }
        Collections.shuffle(list);
        for(int i = 0; i < numOfSquares; i++) {
            int finalI = i;
            list.get(i).setOnMouseClicked(e -> handleClick(finalI));
        }
        if(clear) {
            addSquares(list);
        } else {
            addSquares(list);
        }
    }

    public void handleClick(int btnIndex) {
        Rectangle rec = squaresList.get(btnIndex);
        if(rec.getFill().equals(Color.RED)) {
            colorSquaresFound++;
            updateSquares(btnIndex, Color.RED);
            if(colorSquaresFound == numOfColorSquares) {
                pane.setDisable(true);
                startButton.setDisable(false);
                changeRound++;
                numOfColorSquares++;
                level++;
                if(changeRound == 3) {
                    sideSquares++;
                    changeRound = 0;
                }
                roundUpdate.setText("Round complete!\n Press start to continue.");
                colorSquaresFound = 0;
            }
        } else {
            misses++;
            updateSquares(btnIndex, Color.GRAY);
            if(misses == 3) {
                pane.setDisable(true);
                lives--;
                if(lives == 0) {
                    roundUpdate.setText("Game Over.\nYou got to Level " + level);
                } else {
                    startButton.setDisable(false);
                    roundUpdate.setText("Missed 3 tiles, one life lost.\n Press start to try again");
                }
            }
        }
    }

    public void updateSquares(int btnIndex, Color color) {
        squaresListClear.get(btnIndex).setFill(color);
        addSquares(squaresListClear);
    }

    public void addSquares(ArrayList<Rectangle> list) {
        pane.getChildren().clear();
        grid.getChildren().clear();
        int i = 0;
        int col = 0;
        int row = 0;
        //adds the squares to gridpane
        while(i < list.size()) {
            grid.add(list.get(i), col, row);
            col++;
            if (col == sideSquares) {
                col = 0;
                row++;
            }
            i++;
        }
        pane.getChildren().addAll(grid);
    }

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
