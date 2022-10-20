package uet.oop.bomberman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BombermanGame extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/scenes/Menu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Bomberman by OOP_N11");
            stage.setScene(scene);
            stage.setResizable(false);
            primaryStage = stage;
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
