import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class VisualMemory {
    private int lives = 3;
    private int level = 0;
    private Scene scene;
    @FXML
    private Label livesLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Pane pane;
    private GridPane grid;

    public void startGame() {
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Rectangle rectangle = new Rectangle(30,30);
                rectangle.setFill(javafx.scene.paint.Color.RED);
                grid.add(rectangle, i, j);
            }
        }
        
        pane.getChildren().addAll(grid);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> makeGridClear());
        pause.play();
    }

    public void makeGridClear() {
        pane.getChildren().clear();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Rectangle rectangle = new Rectangle(30,30);
                rectangle.setFill(javafx.scene.paint.Color.BLACK);
                grid.add(rectangle, i, j);
            }
        }

        pane.getChildren().addAll(grid);

    }


//    @FXML
//    private void mouseEntered(MouseEvent e) {
//        Node source = (Node)e.getSource() ;
//        Integer colIndex = GridPane.getColumnIndex(source);
//        Integer rowIndex = GridPane.getRowIndex(source);
//        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex, rowIndex);
//
//        grid.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
//            Node node = (Node) grid.getChildren();
//            //ObservableList<Node> childrens = grid.getChildren();
//
//            Integer x = GridPane.getColumnIndex(node);
//            Integer y = GridPane.getColumnIndex(node);
//            System.out.println("Mouse clicked cell " + x + "," + y);
//        });
//    }

    public void retryGame() {
        Pane newRoot = Loader.loadFxmlFile("visualMemory.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }

    public void goBackHome() {
        Pane newRoot = Loader.loadFxmlFile("home.fxml");
        scene = Main.getScene();
        scene.setRoot(newRoot);
    }
}
