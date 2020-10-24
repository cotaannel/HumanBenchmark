import java.util.ArrayList;
import java.util.Collections;

public class Scores {
    public ArrayList<Long> aimTrainer = new ArrayList<>();
    public ArrayList<Integer> chimpTest = new ArrayList<>();
    public ArrayList<Long> matchPairs = new ArrayList<>();
    public ArrayList<Integer> numberMemory = new ArrayList<>();
    public ArrayList<Long> reactionTime = new ArrayList<>();
    public ArrayList<Integer> typing = new ArrayList<>();
    public ArrayList<Integer> verbalMemory = new ArrayList<>();
    public ArrayList<Integer> visualMemory = new ArrayList<>();

    public void addAimTrainerScore(long totalTime) { aimTrainer.add(totalTime); }

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

}
