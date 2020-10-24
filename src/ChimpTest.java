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

    public void startGame() {
        scores = Main.getScores();
        int highScore = scores.getChimpTestScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        startButton.setDisable(true);
        continueButton.setDisable(true);
        updateLabel.setText("");
        updateLabel.setDisable(true);
        list = new ArrayList<>();
        num = 0;
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
        //adds stackpane to list to compare later
        list.add(stackPane);
        pane.getChildren().add(stackPane);

        stackPane.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                //if stackpane clicks = first on list (which is # 1)
                if(stackPane == list.get(num)) {
                    stackPane.getChildren().clear();
                    //only makes the squares be filled(no number) if
                    //round is passed # of 4 squares round
                    if(numberOfSquares != 4) {
                        //covers up number after first # 1 is clicked
                        if(num == 0) {
                            pane.getChildren().clear();
                            StackPane sp;
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
                    strikes++;
                    updateEndOfRound();
                }
            }
        });
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
