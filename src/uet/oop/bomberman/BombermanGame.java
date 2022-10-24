package uet.oop.bomberman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uet.oop.bomberman.gui.Frame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static uet.oop.bomberman.ProgressBar.isDoned;
//import static uet.oop.bomberman.ScreenLoad._scLoad;
//import static uet.oop.bomberman.ScreenLoad.isDone;

public class BombermanGame {
    public static Stage primaryStage;
//
//    @Override
//    public void start(Stage stage) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/scenes/Menu.fxml"));
//            Scene scene = new Scene(root);
//            stage.setTitle("Bomberman by OOP_N11");
//            stage.setScene(scene);
//            stage.setResizable(false);
//            primaryStage = stage;
//            primaryStage.show();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ProgressBar intro = new ProgressBar();
        intro.setVisible(true);
        intro.setLocationRelativeTo(null);
        intro.iterate();
        if(isDoned) {
            intro.setVisible(false);
            new Frame();
        }
        else {
            System.out.println("Please wait a moment");
        }
    }
}
