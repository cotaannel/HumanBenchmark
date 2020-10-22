import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class MatchPairs {
    private Scene scene;
    @FXML
    private StackPane stackpane;
    @FXML
    private Label gameOverLabel;
    private GridPane pane;
    //stores images
    private ArrayList<Image> images = new ArrayList<>();
    //stores images and its copy
    private ArrayList<Image> imagesCopy = new ArrayList<>();
    //stores buttons with the images
    private ArrayList<Button> buttons = new ArrayList<>();
    private boolean firstClick = true;
    private Button clickedButton;
    private int clickedButtonIndex;
    //is used to keep track of when the game is over
    private int gameOver = 0;
    private long startTime;

    /**
     * In this method, time start time is set.
     * The images are all added to the image list
     * and the image copy list. Everything is added to
     * the gridpane and then to the stackpane.
     */
    public void startGame() {
        startTime = System.nanoTime();
        gameOverLabel.setDisable(true);
        //puts the images in arraylist
        for(int i = 1; i <= 12; i++) {
            Image image =  new Image("Resources/images/"+i+".png",
                    70,70,false,true);
            images.add(image);
            //adds image and image copy to arraylist
            imagesCopy.add(image);
            imagesCopy.add(image);
        }
        setupButtons();
        pane = new GridPane();
        addButtons();
        stackpane.getChildren().add(pane);
    }

    /**
     * This method shuffles the pictures around and
     * adds the images to the buttons.
     */
    public void setupButtons() {
        //shuffles images and adds them to buttons
        Collections.shuffle(imagesCopy);
        for(int i = 0; i < imagesCopy.size(); i++) {
            buttons.add(new Button());
            buttons.get(i).setGraphic(new ImageView(imagesCopy.get(i)));
            buttons.get(i).getGraphic().setVisible(false);
            int finalI = i;
            buttons.get(i).setOnMouseClicked(e -> handleClick(finalI));
        }
    }

    /**
     * This method adds the buttons with
     * the images to the gridpane.
     */
    public void addButtons(){
        pane.getChildren().clear();
        int i = 0, col = 0, row = 0;
        //adds the buttons to gridpane
        while(i < buttons.size()) {
            pane.add(buttons.get(i), col, row);
            col++;
            if (col == 6) {
                col = 0;
                row++;
            }
            i++;
        }
    }

    /**
     * This method handles when the buttons are clicked.
     * If the first button clicked equals the second button
     * clicked, a pair is found. When all the pairs are found,
     * the game is over and the label is updated to show
     * that and how long the user took to find all the pairs.
     * @param btnIndex : index of the button in list that was clicked
     */
    public void handleClick(int btnIndex) {
        Button b = buttons.get(btnIndex);
        //if it is the first click, stores button index that was clicked
        if(firstClick) {
            firstClick = false;
            clickedButton = b;
            clickedButtonIndex = btnIndex;
            b.getGraphic().setVisible(true);
        } else {
            //if there is a second click, compares first and second button clicked
            if(imagesCopy.get(btnIndex).equals(imagesCopy.get(clickedButtonIndex))
                    && btnIndex != clickedButtonIndex) {
                //if they are the same, disables them and keeps their images showing
                b.getGraphic().setVisible(true);
                b.setDisable(true);
                clickedButton.setDisable(true);
                //keeps track of number of button pairs that are disabled
                gameOver++;
            } else {
                clickedButton.getGraphic().setVisible(false);
                clickedButton.setDisable(false);
            }
            firstClick = true;
        }

        //once all the buttons are disabled, game is over
        if(gameOver == 12) {
            long finishTime = System.nanoTime();
            long reactionTimeNano = finishTime - startTime;
            long secValue = TimeUnit.NANOSECONDS.toSeconds(reactionTimeNano);
            gameOverLabel.setDisable(false);
            gameOverLabel.setText("Game Over\n Time taken to find all the pairs:\n"+secValue+" seconds");
        }
    }

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("matchPairs.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    /**
     * When the go back to home screen button is clicked, this
     * method reloads the home screen with the fxml file.
     */
    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
