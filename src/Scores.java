import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;

public class Scores {
    private Scene scene;
    @FXML
    private Label aimTrainerScores = new Label();
    @FXML
    private Label chimpTestScores;
    @FXML
    private Label matchPairsScores;
    @FXML
    private Label numberMemoryScores;
    @FXML
    private Label reactionTimeScores;
    @FXML
    private Label typingScores;
    @FXML
    private Label verbalMemoryScores;
    @FXML
    private Label visualMemoryScores;
    public ArrayList<Long> aimTrainer = new ArrayList<>();
    public ArrayList<Integer> chimpTest = new ArrayList<>();
    public ArrayList<Long> matchPairs = new ArrayList<>();
    public ArrayList<Integer> numberMemory = new ArrayList<>();
    public ArrayList<Long> reactionTime = new ArrayList<>();
    public ArrayList<Integer> typing = new ArrayList<>();
    public ArrayList<Integer> verbalMemory = new ArrayList<>();
    public ArrayList<Integer> visualMemory = new ArrayList<>();

    public void initialize() {
        Scores scores = Main.getScores();
        updateLabel("Aim Trainer:", aimTrainerScores, scores.getAimTrainer());
        updateLabel("Chimp Test:", chimpTestScores, scores.getChimpTest());
        updateLabel("Match Pairs:", matchPairsScores, scores.getMatchPairs());
        updateLabel("Number Memory:", numberMemoryScores, scores.getNumberMemory());
        updateLabel("Reaction Time:", reactionTimeScores, scores.getReactionTime());
        updateLabel("Typing:", typingScores, scores.getTyping());
        updateLabel("Verbal Memory:", verbalMemoryScores, scores.getVerbalMemory());
        updateLabel("Visual Memory:", visualMemoryScores, scores.getVisualMemory());
    }

    public ArrayList getAimTrainer() { return aimTrainer; }
    public ArrayList getChimpTest() { return chimpTest; }
    public ArrayList getMatchPairs() { return matchPairs; }
    public ArrayList getNumberMemory() { return numberMemory; }
    public ArrayList getReactionTime() { return reactionTime; }
    public ArrayList getTyping() { return typing; }
    public ArrayList getVerbalMemory() { return verbalMemory; }
    public ArrayList getVisualMemory() { return visualMemory; }

    public void updateLabel(String name, Label label, ArrayList list) {
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            string.append("\n").append(list.get(i));
        }
        label.setText(name + string);
    }

    public void addAimTrainerScore(long totalTime) {
        aimTrainer.add(totalTime);
    }

    public long getAimTrainerHighScore() {
        if(aimTrainer.isEmpty()) {
            return 0;
        } else {
            return Collections.min(aimTrainer);
        }
    }

    public void addChimpTestScore(int numberOfSquares) { chimpTest.add(numberOfSquares); }
    public int getChimpTestScore() {
        if(chimpTest.isEmpty()) {
            return 0;
        } else {
            return Collections.max(chimpTest);
        }
    }

    public void addMatchPairsScore(long secValue) { matchPairs.add(secValue); }
    public long getMatchPairsScore() {
        if(matchPairs.isEmpty()) {
            return 0;
        } else {
            return Collections.min(matchPairs);
        }
    }

    public void addNumberMemoryScore(int level) { numberMemory.add(level); }
    public int getNumberMemoryScore() {
        if(numberMemory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(numberMemory);
        }
    }

    public void addReactionTimeScore(long milliValue) { reactionTime.add(milliValue); }
    public long getReactionTmeScore() {
        if(reactionTime.isEmpty()) {
            return 0;
        } else {
            return Collections.min(reactionTime);
        }
    }

    public void addTypingScore() { }
    public int getTypingScore() {
        if(typing.isEmpty()) {
            return 0;
        } else {
            return Collections.max(typing);
        }
    }

    public void addVerbalMemoryScore(int score) { verbalMemory.add(score); }
    public int getVerbalMemoryScore() {
        if(verbalMemory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(verbalMemory);
        }
    }

    public void addVisualMemoryScore(int level) { visualMemory.add(level); }
    public int getVisualMemoryScore() {
        if(visualMemory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(visualMemory);
        }
    }

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
