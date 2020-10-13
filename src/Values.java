import javafx.scene.Scene;

public class Values {
    private Scene home;
    private Scene reactionTime;
    private boolean reactionTimeAgain;
    private Scene aimTrainer;
    private boolean aimTrainerAgain;
    private Scene chimpTest;
    private boolean chimpTestAgain;
    private Scene visualMemory;
    private boolean visualMemoryAgain;
    private Scene typing;
    private boolean typingAgain;
    private Scene numberMemory;
    private boolean numberMemoryAgain;
    private Scene verbalMemory;
    private boolean verbalMemoryAgain;

    public void setHome(Scene scene) { home = scene; }

    public Scene getHome() { return home; }

    public void setReactionTime(Scene scene) {
        reactionTime = scene;
        reactionTimeAgain = true;
    }

    public boolean getReactionTimeAgain() { return reactionTimeAgain; }

    public Scene getReactionTime() { return reactionTime; }

    public void setAimTrainer(Scene scene) {
        aimTrainer = scene;
        aimTrainerAgain = true;
    }

    public boolean getAimTrainerAgain() { return aimTrainerAgain; }

    public Scene getAimTrainer() { return aimTrainer; }

    public void setChimpTest(Scene scene) {
        chimpTest = scene;
        chimpTestAgain = true;
    }

    public boolean getChimpTestAgain() { return chimpTestAgain; }

    public Scene getChimpTest() { return chimpTest; }

    public void setVisualMemory(Scene scene) {
        visualMemory = scene;
        visualMemoryAgain = true;
    }

    public boolean getVisualMemoryAgain() { return visualMemoryAgain; }

    public Scene getVisualMemory() { return visualMemory; }

    public void setTyping(Scene scene) {
        typing = scene;
        typingAgain = true;
    }

    public boolean getTypingAgain() { return typingAgain; }

    public Scene getTyping() { return typing; }

    public void setNumberMemory(Scene scene) {
        numberMemory = scene;
        numberMemoryAgain = true;
    }

    public boolean getNumberMemoryAgain() { return numberMemoryAgain; }

    public Scene getNumberMemory() { return numberMemory; }

    public void setVerbalMemory(Scene scene) {
        verbalMemory = scene;
        verbalMemoryAgain = true;
    }

    public boolean getVerbalMemoryAgain(){ return verbalMemoryAgain; }

    public Scene getVerbalMemory() { return verbalMemory; }
}

