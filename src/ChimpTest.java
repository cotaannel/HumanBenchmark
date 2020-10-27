/**
 * @author Annel Cota
 *
 * In this Chimp Test game class, there are
 * squares created with numbers in ascending order that
 * the user has to click on in that order. As each square is
 * clicked, it disapears. For the first round, all numbers are
 * visible to the user as each square is clicked. After the first
 * round, after the #1 square is clicked, all the squares turn black.
 * The number of squares increase after each round. If the user clicks
 * incorrectly, they get a strike. After strike 3, game over.
 */

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class ChimpTest {
    private Scores scores;
    private Scene scene;
    @FXML
    private Pane pane;
    @FXML
    private Label highScoreLabel;
    @FXML
    private Label updateLabel;
    @FXML
    private Button continueButton;
    @FXML
    private Button startButton;
    private int strikes = 0;
    private int numberOfSquares = 4;
    private int num = 0;
    private ArrayList<StackPane> list;

    /**
     * When the start button is clicked, this method is called.
     * It starts the game and creates the number of squares that
     * are required. If the game has a high score, it updates the
     * label.
     */
    public void startGame() {
        //gets scores from Main
        scores = Main.getScores();
        //if there is a high score for this game, updates high score label
        int highScore = scores.getChimpTestScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        startButton.setDisable(true);
        continueButton.setDisable(true);
        updateLabel.setText("");
        updateLabel.setDisable(true);
        list = new ArrayList<>();
        num = 0;
        //creates squares depending on the number of squares required
        for(int i = 1; i <= numberOfSquares; i++) {
            createSquare(i);
        }
    }

    /**
     * Creates a square with a number label. It is added
     * to a stackpane and then added to the pane in a random
     * location. It adds mouse clicked events to each square
     * created.
     * @param i : number of square that is used for label
     */
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
        //adds stackpane to list to compare later
        list.add(stackPane);
        pane.getChildren().add(stackPane);

        stackPane.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                //if stackpane clicks = first on list (which is # 1)
                if(stackPane == list.get(num)) {
                    stackPane.getChildren().clear();
                    //only makes the squares be filled(no number) if first round passed
                    if(numberOfSquares != 4) {
                        //covers up number after first # 1 is clicked
                        if(num == 0) {
                            pane.getChildren().clear();
                            StackPane sp;
                            //creates the remaining squares again, this time with black fill
                            for(int i = 1; i <= numberOfSquares-1; i++) {
                                sp = list.get(i);
                                Rectangle rect = new Rectangle(1,1,40,40);
                                rec.setFill(Color.BLACK);
                                sp.getChildren().addAll(rect);
                                pane.getChildren().add(sp);
                            }
                        }
                    }
                    num++;
                    //once all squares clicked, new round
                    if(num == numberOfSquares) {
                        numberOfSquares++;
                        updateEndOfRound();
                    }
                } else {
                    //if they click wrong square, they get a strike
                    strikes++;
                    //once theres 3 strikes, game is over
                    if(strikes == 3) {
                        scores.addChimpTestScore(numberOfSquares);
                        updateLabel.setDisable(false);
                        pane.getChildren().clear();
                        updateLabel.setText("Game Over.\nScore:\n" + numberOfSquares);
                    } else {
                        updateEndOfRound();
                    }
                }
            }
        });
    }

    /**
     * When the round is over, this method updates the lable
     * and shows the user their score so far and strikes.
     */
    public void updateEndOfRound() {
        continueButton.setDisable(false);
        updateLabel.setDisable(false);
        pane.getChildren().clear();
        updateLabel.setText("Numbers:\n" + numberOfSquares + "\nStrikes:\n" + strikes +
                " of 3\n Click 'Continue' to keep going");
    }

    /**
     * After round is over and user clicks on continue
     * button, this method is called.
     */
    public void continueButtonClicked() {
        startGame();
    }

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the game's fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("chimpTest.fxml");
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
