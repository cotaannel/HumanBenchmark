import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ChimpTest {
    private Scores scores;
    private Scene scene;
    @FXML
    private Pane pane;
    @FXML
    private Label updateLabel;
    @FXML
    private Label highScoreLabel;
    @FXML
    private Button continueButton;
    @FXML
    private Button startButton;
    private int strikes = 0;
    private int numberOfSquares = 4;
    private int num = 0;
    private ArrayList<StackPane> list;
    private ArrayList<StackPane> listCopy;
    private GridPane grid;


    public void startGame() {
        scores = Main.getScores();
        int highScore = scores.getChimpTestScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        startButton.setDisable(true);
        continueButton.setDisable(true);
        updateLabel.setText("");
        updateLabel.setDisable(true);
        list = new ArrayList<>();
        listCopy = new ArrayList<>();
        num = 0;
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        setupSquares();
    }

    public void setupSquares() {
        int totalSquares = 98;
        for(int i = 0; i < numberOfSquares; i++) {
            list.add(new StackPane());
            String s = Integer.toString(i+1);
            //Label label = new Label(s);
            Rectangle rec = new Rectangle(1, 1, 30, 30);
            rec.setStroke(Color.BLACK);
            rec.setFill(Color.WHITE);
            list.get(i).getChildren().addAll(rec, new Label(s));
        }
        for(int i = numberOfSquares; i < totalSquares; i++) {
            list.add(new StackPane());
            Rectangle rec = new Rectangle(1, 1, 30, 30);
            rec.setFill(Color.TRANSPARENT);
            list.get(i).getChildren().addAll(rec);
        }
        //listCopy = list;
        for(int i = 0; i < totalSquares; i++) {
            int finalI = i;
            list.get(i).setOnMouseClicked(e -> handleClick(finalI));
        }
        listCopy = list;
        Collections.shuffle(list);
        addSquares(list);
    }

    public void addSquares(ArrayList<StackPane> list) {
        pane.getChildren().clear();
        grid.getChildren().clear();
        int i = 0;
        int col = 0;
        int row = 0;
        //adds the squares to gridpane
        while(i < list.size()) {
            grid.add(list.get(i), col, row);
            col++;
            if (col == 14) {
                col = 0;
                row++;
            }
            i++;
        }
        pane.getChildren().addAll(grid);
    }

    public void handleClick(int finalI) {
        //if stackpane clicks = first on list (which is # 1)
        StackPane stack = list.get(finalI);
        System.out.println(stack);
        System.out.println(list.get(num));
        if(stack == list.get(num)) {
            stack.getChildren().clear();
            //only makes the squares be filled(no number) if
            //round is passed # of 4 squares round
            if(numberOfSquares != 4) {
                //covers up number after first # 1 is clicked
                if(num == 0) {
                    grid.getChildren().clear();
                    ArrayList<StackPane> newList = new ArrayList<>();
                    StackPane sp;
                    for(int i = 1; i <= numberOfSquares-1; i++) {
                        sp = list.get(i);
                        newList.add(sp);
                        Rectangle rect = new Rectangle(1,1,30,30);
                        rect.setFill(Color.BLACK);
                        sp.getChildren().addAll(rect);
                        addSquares(newList);
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
            strikes++;
            updateEndOfRound();
        }
    }


    public void updateEndOfRound() {
        updateLabel.setDisable(false);
        pane.getChildren().clear();
        if(strikes == 3) {
            scores.addChimpTestScore(numberOfSquares);
            updateLabel.setText("Game Over.\nScore:\n" + numberOfSquares);
        } else {
            continueButton.setDisable(false);
            updateLabel.setText("Numbers:\n" + numberOfSquares + "\nStrikes:\n" + strikes +
                    " of 3\n Click 'Continue' to keep going");
        }
    }

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
