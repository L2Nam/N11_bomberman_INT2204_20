package uet.oop.bomberman.scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uet.oop.bomberman.gui.Frame;
import uet.oop.bomberman.level.FileLevelLoader;

import java.io.IOException;

import static uet.oop.bomberman.BombermanGame.primaryStage;


public class MenuController {
    public void singleGame() {
        FileLevelLoader.is_multi = false;
        System.out.println("Start Single Game");
        primaryStage.close();
        new Frame();
    }

    public void multiGame() {
        FileLevelLoader.is_multi = true;
        System.out.println("Start Multiple Game");
        primaryStage.close();
        new Frame();
    }
    public void highScore() {

    }
    public void helpGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/help.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void exitGame() {
        System.exit(0);
    }
}
