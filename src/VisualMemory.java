/**
 * @author Annel Cota
 *
 * This Visual Memory game class creates a grid of squares
 * that has a certain amount of red squares. The red squares
 * are shown to the player for 3 seconds and then the grid
 * is cleared(makes squares all black) and the player then has
 * to click on the black squares that used to be red. The player
 * can get it wrong 3 times but will lose a life after that. The
 * player has 3 lives and then game over after that.
 */

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
    private Scores scores;
    private Scene scene;
    private int lives = 3;
    private int level = 1;
    private int misses;
    private int sideSquares = 3;
    private int colorSquaresFound;
    private int numOfSquares;
    private int numOfColorSquares = 3;
    private int changeRound = 1;
    private ArrayList<Rectangle> squaresList;
    private ArrayList<Rectangle> squaresListClear;
    @FXML
    private Label livesLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label roundUpdate;
    @FXML
    private Label highScoreLabel;
    @FXML
    private Button startButton;
    @FXML
    private Pane pane;
    private GridPane grid;

    /**
     * Once the start button is clicked, the labels are updated, the squares
     * lists are created and added to the gridpane, and then to the pane. The
     * list with the red squares is shown to user for 3 seconds and then the
     * list that is clear(all black squares) is shown for the user to click
     * on.
     */
    public void startGame() {
        //gets scores from Main
        scores = Main.getScores();
        //if there is a high score for this game, updates high score label
        int highScore = scores.getVisualMemoryScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        startButton.setDisable(true);
        //updates the level and lives label
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
        //shows the red squares
        setupSquares(false);
        //after 3 seconds, clears the squares and makes them all black
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(e -> setupSquares(true));
        pause.play();
        pane.setDisable(false);
    }

    /**
     * Creates the squares and adds them to their list.
     * If it is the squares that contain the red ones,
     * it adds squares with red fill. If not, all the
     * squares will be filled with black.
     * @param clear : if true, al squares are clear(black)
     */
    public void setupSquares(boolean clear) {
        ArrayList<Rectangle> list;
        //adds to the correct list
        if(clear) {
            list = squaresListClear;
        } else {
            list = squaresList;
        }
        int x = 0;
        for(int i = 0; i < numOfSquares; i++) {
            list.add(new Rectangle(30,30));
            //if its the clear list, all squares will be black
            if(clear) {
                list.get(i).setFill(Color.BLACK);
            } else {
                //makes red squares depending on the number of color squares
                if(x < numOfColorSquares) {
                    list.get(i).setFill(Color.RED);
                    x++;
                } else {
                    //makes the rest of the squares black
                    list.get(i).setFill(Color.BLACK);
                }
            }
        }
        //shuffles the list in case their are red and black squares
        Collections.shuffle(list);
        //adds mouse clicked event to the squares
        for(int i = 0; i < numOfSquares; i++) {
            int finalI = i;
            list.get(i).setOnMouseClicked(e -> handleClick(finalI));
        }
        addSquares(list);
    }

    /**
     * When a square is clicked, this method checks
     * to see if the one that they clicked was a red
     * square.
     * @param btnIndex : the button index of the square clicked
     */
    public void handleClick(int btnIndex) {
        Rectangle rec = squaresList.get(btnIndex);
        //checks if the square was red
        if(rec.getFill().equals(Color.RED)) {
            colorSquaresFound++;
            //updates the black square to red
            updateSquares(btnIndex, Color.RED);
            //checks if all the color squares were found
            if(colorSquaresFound == numOfColorSquares) {
                pane.setDisable(true);
                startButton.setDisable(false);
                //increases round, number of color squares, and level
                changeRound++;
                numOfColorSquares++;
                level++;
                //after every third round, the size of grid increases
                if(changeRound == 3) {
                    sideSquares++;
                    changeRound = 0;
                }
                roundUpdate.setText("Round complete!\n Press start to continue.");
                colorSquaresFound = 0;
            }
        } else {
            //if square clicked wasn't red, they get a miss
            misses++;
            //makes black square gray to show a miss
            updateSquares(btnIndex, Color.GRAY);
            //once there are 3 misses, lose a life
            if(misses == 3) {
                pane.setDisable(true);
                lives--;
                //once 3 lives lost, game over
                if(lives == 0) {
                    //add scores to scores class
                    scores.addVisualMemoryScore(level);
                    roundUpdate.setText("Game Over.\nYou got to Level " + level);
                } else {
                    startButton.setDisable(false);
                    roundUpdate.setText("Missed 3 tiles, one life lost.\n Press start to try again");
                }
            }
        }
    }

    /**
     * Updates the squares list that has all black squares
     * to show what the user has clicked. If the user clicked
     * a correct red square, will update black square to red.
     * If user clicked incorrect red square, will change black
     * square to gray.
     * @param btnIndex : gets button index
     * @param color : gets color to make square
     */
    public void updateSquares(int btnIndex, Color color) {
        squaresListClear.get(btnIndex).setFill(color);
        addSquares(squaresListClear);
    }

    /**
     * This method adds the squares to a gridpane
     * which is then added to the pane.
     * @param list : the list of squares to be added.
     */
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

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the game's fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("visualMemory.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    /**
     * When the go back to home screen button is clicked, this
     * method reloads the home screen with its fxml file.
     */
    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
