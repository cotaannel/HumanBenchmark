/**
 * @author Annel Cota
 *
 * This Scores class keeps the scores of the games
 * stored in arrays. It updates the scores of the games
 * as they finish, gets the high score of each game, and
 * updates the scores in the scores section of the home
 * screen.
 */

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

    /**
     * Gets all the score, if any, from previous games, from Main
     * and updates labels.
     */
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

    /**
     * Gets Aim Trainer scores array
     * @return aim trainer score array
     */
    public ArrayList getAimTrainer() { return aimTrainer; }

    /**
     * Gets Chimp Test scores array
     * @return chimp test scores array
     */
    public ArrayList getChimpTest() { return chimpTest; }

    /**
     * Gets Match Pairs scores array
     * @return match pairs scores array
     */
    public ArrayList getMatchPairs() { return matchPairs; }

    /**
     * Gets Number Memory scores array
     * @return number memory scores array
     */
    public ArrayList getNumberMemory() { return numberMemory; }

    /**
     * Gets Reaction Time scores array
     * @return reaction time scores array
     */
    public ArrayList getReactionTime() { return reactionTime; }

    /**
     * Gets Typing scores array
     * @return typing scores array
     */
    public ArrayList getTyping() { return typing; }

    /**
     * Gets Verbal Memory scores array
     * @return verbal memory scores array
     */
    public ArrayList getVerbalMemory() { return verbalMemory; }

    /**
     * Gets Visual Memory scores array
     * @return visual memory scores array
     */
    public ArrayList getVisualMemory() { return visualMemory; }

    /**
     * Updates the label specified.
     * @param name : the name to add in the label
     * @param label : which label is being edited
     * @param list : which scores array is being used
     */
    public void updateLabel(String name, Label label, ArrayList list) {
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            string.append("\n").append(list.get(i));
        }
        label.setText(name + string);
    }

    /**
     * Adds score to Aim Trainer array.
     * @param totalTime : time score from aim trainer game
     */
    public void addAimTrainerScore(long totalTime) {
        aimTrainer.add(totalTime);
    }

    /**
     * Gets the min score from the aim trainer array if its not empty.
     * @return min score from aim trainer game
     */
    public long getAimTrainerHighScore() {
        if(aimTrainer.isEmpty()) {
            return 0;
        } else {
            return Collections.min(aimTrainer);
        }
    }

    /**
     * Adds score to Chimp Test array.
     * @param numberOfSquares : score from chimp test game
     */
    public void addChimpTestScore(int numberOfSquares) { chimpTest.add(numberOfSquares); }

    /**
     * Gets the max score from the chimp test array if its not empty.
     * @return max score from the chimp test game
     */
    public int getChimpTestScore() {
        if(chimpTest.isEmpty()) {
            return 0;
        } else {
            return Collections.max(chimpTest);
        }
    }

    /**
     * Adds score to Match Pairs array.
     * @param secValue : time score from match pairs game
     */
    public void addMatchPairsScore(long secValue) { matchPairs.add(secValue); }

    /**
     * Gets the min score from the match pairs array if its not empty.
     * @return min score from the match pairs game
     */
    public long getMatchPairsScore() {
        if(matchPairs.isEmpty()) {
            return 0;
        } else {
            return Collections.min(matchPairs);
        }
    }

    /**
     * Adds score to Number Memory array.
     * @param level : score from number memory game
     */
    public void addNumberMemoryScore(int level) { numberMemory.add(level); }

    /**
     * Gets the max score from the number memory array if its not empty.
     * @return max score from the number memory game
     */
    public int getNumberMemoryScore() {
        if(numberMemory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(numberMemory);
        }
    }

    /**
     * Adds score to Reaction Time array.
     * @param milliValue : time score from reaction time game
     */
    public void addReactionTimeScore(long milliValue) { reactionTime.add(milliValue); }

    /**
     * Gets the min score from the reaction time array if its not empty.
     * @return min score from reaction time game
     */
    public long getReactionTmeScore() {
        if(reactionTime.isEmpty()) {
            return 0;
        } else {
            return Collections.min(reactionTime);
        }
    }

    /**
     * Adds score to Typing array.
     * @param wpm : wpm score from typing game
     */
    public void addTypingScore(int wpm) { typing.add(wpm); }

    /**
     * Gets the min score from the typing array if its not empty.
     * @return min score from typing game
     */
    public int getTypingScore() {
        if(typing.isEmpty()) {
            return 0;
        } else {
            return Collections.min(typing);
        }
    }

    /**
     * Adds score to Verbal Memory array.
     * @param score : score from verbal memory game
     */
    public void addVerbalMemoryScore(int score) { verbalMemory.add(score); }

    /**
     * Gets the max score from the verbal memory array if its not empty.
     * @return max score from verbal memory game
     */
    public int getVerbalMemoryScore() {
        if(verbalMemory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(verbalMemory);
        }
    }

    /**
     * Adds score to Visual Memory array.
     * @param level : score from visual memory game
     */
    public void addVisualMemoryScore(int level) { visualMemory.add(level); }

    /**
     * Gets the max score from visual memory array if its not empty.
     * @return max score from visual memory
     */
    public int getVisualMemoryScore() {
        if(visualMemory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(visualMemory);
        }
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
