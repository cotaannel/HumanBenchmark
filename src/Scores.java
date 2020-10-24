import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Scores {
    public ArrayList<Long> aimTrainer = new ArrayList<>();
    public ArrayList<Integer> chimpTest = new ArrayList<>();
    public ArrayList<Integer> matchPairs = new ArrayList<>();
    public ArrayList<Integer> numberMemory = new ArrayList<>();
    public ArrayList<Integer> reactionTime = new ArrayList<>();
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

    public void addChimpTestScore() { }

    public void addMatchPairsScore() { }

    public void addNumberMemoryScore() { }

    public void addReactionTimeScore() { }

    public void addTypingScore() { }

    public void addVerbalMemoryScore() { }

    public void addVisualMemoryScore() { }

}
