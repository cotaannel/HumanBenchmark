import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VerbalMemory {
    private Scene scene;
    private int lives = 3;
    private int score = 0;
    private String currentWord;
    private String lastWord;
    private ArrayList<String> bank = new ArrayList<>();
    private ArrayList<String> seenWords;
    @FXML
    private Label wordLabel;
    @FXML
    private Label livesLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button seenButton;
    @FXML
    private Button newButton;
    @FXML
    private Button startButton;

    public void startGame() {
        seenWords = new ArrayList<>();
        addWordsToBank();
        Collections.shuffle(bank);
        currentWord = bank.get(0);
        lastWord = currentWord;
        wordLabel.setText(currentWord);
        livesLabel.setText("Lives: " + lives);
        scoreLabel.setText("Score: " + score);
    }

    public void checkIfSeen() {
        if(seenWords.contains(currentWord)) {
            score++;
        } else {
            lives--;
        }
        addWordToSeen();
        changeCurrentWord();
    }

    public void checkIfNew() {
        if(seenWords.contains(currentWord)) {
            lives--;
        } else {
            score++;
        }
        addWordToSeen();
        changeCurrentWord();
    }

    public void addWordToSeen() {
        if(!seenWords.contains(currentWord)) {
            seenWords.add(currentWord);
        }
    }

    public void changeCurrentWord() {
        livesLabel.setText("Lives: " + lives);
        scoreLabel.setText("Score: " + score);
        if(lives != 0) {
            Collections.shuffle(bank);
            //makes sure seen words has at least 2 words before
            //it starts showing words from there to avoid repeats
            if(seenWords.isEmpty() || seenWords.size() == 1) {
                currentWord = bank.get(0);
                wordLabel.setText(currentWord);
            } else {
                Random rand = new Random();
                Collections.shuffle(seenWords);
                int n = rand.nextInt(3) + 1;
                String nextWord;
                if(n == 1) {
                    //prevents repeats
                    nextWord = seenWords.get(0);
                    if(lastWord == nextWord) {
                        currentWord = seenWords.get(1);
                    } else {
                        currentWord = nextWord;
                    }
                } else {
                    //prevents repeats
                    nextWord = bank.get(0);
                    if(lastWord == nextWord) {
                        currentWord = bank.get(1);
                    } else {
                        currentWord = nextWord;
                    }
                }
                wordLabel.setText(currentWord);
                System.out.println(n);
            }
        } else {
            seenButton.setDisable(true);
            newButton.setDisable(true);
            startButton.setDisable(true);
            wordLabel.setText("Game over, you got a score of " + score + " words.");
        }
    }

    //creates bank of 101 words
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
        bank.add("cooperate");;
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

    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("verbalMemory.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
