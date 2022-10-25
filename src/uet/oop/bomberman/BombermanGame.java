package uet.oop.bomberman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uet.oop.bomberman.gui.Frame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

import static uet.oop.bomberman.ProgressBar.isDoned;
//import static uet.oop.bomberman.ScreenLoad._scLoad;
//import static uet.oop.bomberman.ScreenLoad.isDone;

public class BombermanGame {
    public static Stage primaryStage;
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, FontFormatException {
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
