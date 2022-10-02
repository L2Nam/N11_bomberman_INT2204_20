package uet.oop.bomberman.Control;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.Main.GameRun;
import uet.oop.bomberman.Map.Map1;

import static uet.oop.bomberman.Main.GameRun.*;

public class Menu {
    public static ImageView statusGame;
    public static Text level, bomb, time;
    public static int bomb_number = 20, time_number = 120;
    public static Image pauseGame, playGame;

    public static void createMenu(Group root) {
        level = new Text("Level: 1");
        level.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        level.setFill(Color.WHITE);
        level.setX(416);
        level.setY(20);
        bomb = new Text("Bombs: 20");
        bomb.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bomb.setFill(Color.WHITE);
        bomb.setX(512);
        bomb.setY(20);
        time = new Text("Times: 120");
        time.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        time.setFill(Color.WHITE);
        time.setX(608);
        time.setY(20);

        Image newGame = new Image("images/startButton.png");
        statusGame = new ImageView(newGame);
        statusGame.setX(-25);
        statusGame.setY(250);
        statusGame.setScaleX(1);
        statusGame.setScaleY(1);

        Pane pane = new Pane();
        pane.getChildren().addAll(level, bomb, time, statusGame);
        pane.setMinSize(800, 32);
        pane.setMaxSize(800, 480);
        pane.setStyle("-fx-background-color: #353535");

        root.getChildren().add(pane);

        playGame = new Image("images/pauseButton.png");
        pauseGame = new Image("images/resumeButton.png");

        ////Sự kiện khi bạn nhấp vào nút chơi trò chơi, nếu nhân vật của bạn vẫn còn sống, trò chơi sẽ tạm dừng, nếu không trò chơi sẽ bắt đầu ở cấp độ 1
        statusGame.setOnMouseClicked(event -> {
//            if (player.isLife()) {
//                isPause = !isPause;
//            } else {
//                new Level1();
//                running = true;
//            }
//            //updateMenu();
            new Map1();
            running = true;
        });

    }

    /*public static void updateMenu() { //Update menu
        //level.setText("Level: " + RunBomberman.level);
        bomb.setText("Bombs: " + bomb_number);

        if (player.isLife())
            if (isPause) {
                statusGame.setImage(pauseGame);
            } else {
                statusGame.setImage(playGame);
            }
        else {
            Image newGame = new Image("images/startButton.png");
            statusGame.setImage(newGame);
        }
    }*/
}
