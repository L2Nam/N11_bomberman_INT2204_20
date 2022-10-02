package uet.oop.bomberman.Main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import uet.oop.bomberman.Control.Menu;
import uet.oop.bomberman.Entity.Character.Character;
import uet.oop.bomberman.Entity.Entity;
import uet.oop.bomberman.Features.Sprite;

import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.Control.Menu.statusGame;

public class GameRun extends Application {
    /**
     * Kích thước màn hình
     * H: 480px W: 800px
     **/
    public static final int HEIGHT = 15;
    public static final int WIDTH = 25;

    public static int width = 0;
    public static int height = 0;
    public static int level = 1;

    public static Character player;

    public static final List<Entity> block = new ArrayList<>();     // Các thực thể cố định (map)
    public static List<Character> monster = new ArrayList<>();           // Các thực thể quái vật
    public static int[][] id_objects;
    public static int[][] list_kill;

    public static boolean running;
    public static ImageView view;

    private GraphicsContext gc;
    private Canvas canvas;

    //    private int frame = 1;
    private long last_time;

    public static Stage mainStage = null;
    public static boolean isPause = false;

//    Group root = new Group();
//        Menu.createMenu(root);

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        canvas.setTranslateY(32);
        gc = canvas.getGraphicsContext2D();
        Image author = new Image("images/author.png");
        view = new ImageView(author);
        view.setX(-400);
        view.setY(-208);
        view.setScaleX(0.5);
        view.setScaleY(0.5);
        Group root = new Group();
        Menu.createMenu(root);
        root.getChildren().add(canvas);
        root.getChildren().add(view);
        root.getChildren().add(statusGame);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Bomberman by N11_OPP");
        Image icon = new Image("images/ttsalpha4.0@0.5x.png");
        stage.getIcons().add(icon);
        mainStage = stage;
        mainStage.show();

        last_time = System.currentTimeMillis();
    }

    public void update() {
        block.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
    }

    public void time() {
//        frame++;
    }

    public static void main(String[] args) {
        Application.launch(GameRun.class);
    }
}
