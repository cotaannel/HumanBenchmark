/**
 * @author Annel Cota
 *
 * This Verbal Memory class is a game where the user
 * is shown a word and they have to tell whether it is
 * a new word or a word they have already seen in the game.
 * They have three lives and every time they get a word right,
 * their score increases.
 */

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VerbalMemory {
    private Scores scores;
    private Scene scene;
    private int lives = 3;
    private int score = 0;
    private String currentWord;
    private String lastWord;
    private ArrayList<String> bank = new ArrayList<>();
    private ArrayList<String> seenWords = new ArrayList<>();
    @FXML
    private Label wordLabel;
    @FXML
    private Label livesLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label highScoreLabel;
    @FXML
    private Button seenButton;
    @FXML
    private Button newButton;
    @FXML
    private Button startButton;

    /**
     * When the start game button is clicked, the words are
     * added to the bank, the current word is selected,
     * and all of the labels are updated.
     */
    public void startGame() {
        //gets scores from Main
        scores = Main.getScores();
        //if there is a high score for this game, updates high score label
        int highScore = scores.getVerbalMemoryScore();
        if(highScore != 0) { highScoreLabel.setText("High Score: " + highScore); }
        //adds words to bank
        addWordsToBank();
        //shuffles words in bank so same word isn't always picked first
        Collections.shuffle(bank);
        //the first word in the bank becomes the current word
        currentWord = bank.get(0);
        lastWord = currentWord;
        wordLabel.setText(currentWord);
        livesLabel.setText("Lives: " + lives);
        scoreLabel.setText("Score: " + score);
    }

    /**
     * If the seen button is clicked, the seen words list is
     * checked to see if it contains that word. If it does, user
     * score goes up, if not they lose a life. Current word is then
     * added to the seen words list and the current word is changed.
     */
    public void checkIfSeen() {
        if(seenWords.contains(currentWord)) {
            score++;
        } else {
            lives--;
        }
        addWordToSeen();
        changeCurrentWord();
    }

    /**
     * If the new button is clicked, the seen words list is
     * checked to see if it contains that word. If it does,
     * the user loses a life, if not their score goes up. Current
     * word is then added to the seen words list and the current
     * word is changed.
     */
    public void checkIfNew() {
        if(seenWords.contains(currentWord)) {
            lives--;
        } else {
            score++;
        }
        addWordToSeen();
        changeCurrentWord();
    }

    /**
     * When a word is being added to the seen words list,
     * it first checks to see if its not already in there.
     * If the word is not in there already, it adds the word
     * to the list.
     */
    public void addWordToSeen() {
        if(!seenWords.contains(currentWord)) {
            seenWords.add(currentWord);
        }
    }

    /**
     * Changes the current word to a new word. It either
     * gets a new word from the bank or a word from the seen
     * words list, at random. It also updates the labels that
     * show the lives and scores. If a user reaches 0 lives,
     * the game is over.
     */
    public void changeCurrentWord() {
        livesLabel.setText("Lives: " + lives);
        scoreLabel.setText("Score: " + score);
        if(lives != 0) {
            Collections.shuffle(bank);
            //makes sure seen words has at least 2 words before
            //it starts showing words from there to avoid repeats
            if(seenWords.isEmpty() || seenWords.size() == 1) {
                currentWord = bank.get(0);
            } else {
                Random rand = new Random();
                Collections.shuffle(seenWords);
                int n = rand.nextInt(3) + 1;
                String nextWord;
                if(n == 1) {
                    //prevents repeats right after one another
                    nextWord = seenWords.get(0);
                    if(lastWord.equals(nextWord)) {
                        currentWord = seenWords.get(1);
                    } else {
                        currentWord = nextWord;
                    }
                } else {
                    //prevents repeats
                    nextWord = bank.get(0);
                    if(lastWord.equals(nextWord)) {
                        currentWord = bank.get(1);
                    } else {
                        currentWord = nextWord;
                    }
                }
            }
            lastWord = currentWord;
            wordLabel.setText(currentWord);
        } else {
            seenButton.setDisable(true);
            newButton.setDisable(true);
            startButton.setDisable(true);
            //adds score to scores class
            scores.addVerbalMemoryScore(score);
            wordLabel.setText("Game over, you got a score of " + score + " words.");
        }
    }

    /**
     * Adds 101 different words to the bank list.
     */
    public void addWordsToBank(){
        bank.add("agreement");
        bank.add("volcanoes");
        bank.add("guardians");
        bank.add("flunked");
        bank.add("nitpicks");
        bank.add("expunged");
        bank.add("grovelling");
        bank.add("newsstands");
        bank.add("pedagogies");
        bank.add("predators");
        bank.add("parachutes");
        bank.add("guiding");
        bank.add("upsilon");
        bank.add("riddles");
        bank.add("demarcating");
        bank.add("microbial");
        bank.add("actuated");
        bank.add("fulgent");
        bank.add("unset");
        bank.add("asserters");
        bank.add("outstretch");
        bank.add("intrusion");
        bank.add("stuff");
        bank.add("deceased");
        bank.add("hygiene");
        bank.add("deadly");
        bank.add("squeegee");
        bank.add("gator");
        bank.add("unrealistic");
        bank.add("catchy");
        bank.add("neutrality");
        bank.add("palpate");
        bank.add("courteous");
        bank.add("grammatically");
        bank.add("molars");
        bank.add("glistened");
        bank.add("wearable");
        bank.add("geysers");
        bank.add("marvelously");
        bank.add("miniseries");
        bank.add("voluminous");
        bank.add("inventors");
        bank.add("mounded");
        bank.add("castors");
        bank.add("endeavoured");
        bank.add("cooperate");
        bank.add("enactments");
        bank.add("theatrics");
        bank.add("lose");
        bank.add("naturel");
        bank.add("tabasco");
        bank.add("nationalisation");
        bank.add("omnipotent");
        bank.add("hierarchical");
        bank.add("reissuing");
        bank.add("compliance");
        bank.add("rundowns");
        bank.add("outlay");
        bank.add("degrading");
        bank.add("misfired");
        bank.add("augmentations");
        bank.add("cascading");
        bank.add("yarns");
        bank.add("barnacles");
        bank.add("novelist");
        bank.add("spleens");
        bank.add("humidly");
        bank.add("goldsmiths");
        bank.add("stereotype");
        bank.add("useful");
        bank.add("nylons");
        bank.add("believed");
        bank.add("ballets");
        bank.add("clinger");
        bank.add("lurks");
        bank.add("jinxed");
        bank.add("tastelessness");
        bank.add("knuckled");
        bank.add("unbranded");
        bank.add("sanitize");
        bank.add("yet");
        bank.add("ecosystems");
        bank.add("polynomials");
        bank.add("beagles");
        bank.add("hilarious");
        bank.add("corroboration");
        bank.add("commerced");
        bank.add("deletions");
        bank.add("prevalence");
        bank.add("wallpapering");
        bank.add("divinely");
        bank.add("nonequivalent");
        bank.add("nobleness");
        bank.add("except");
        bank.add("barking");
        bank.add("housed");
        bank.add("staggered");
        bank.add("warns");
        bank.add("slew");
        bank.add("ethereal");
        bank.add("boulevards");
    }

    /**
     * When the retry button is clicked, it calls this
     * method that reloads the game's fxml file.
     */
    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("verbalMemory.fxml");
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
