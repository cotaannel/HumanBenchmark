/**
 * @author Annel Cota
 *
 * This class is used to loat the fxml file.
 */

import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class Loader {
    /**
     * Loads the fxml file that is passed through the method.
     * @param filename : string of the fxml file name
     * @param <T>
     * @return : returns the root
     */
    public static <T> T loadFxmlFile(String filename) {
        FXMLLoader loader = new FXMLLoader(Loader.class.getResource(filename));
        T root = null;
        try {
            root = loader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
