package uet.oop.bomberman.Features;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteSheet {
    private String path;
    public final int SIZE;
    public int[] sprite_pixels;
    public BufferedImage image;

    // để tải đối tượng hình ảnh pixel ở màu RGB: Bomber, Enemy, Bomb Flame, Brick,....
    private void load() {
        try {
            URL url = SpriteSheet.class.getResource(path);        // Will only be able to read from classpath
            image = ImageIO.read(url);
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, sprite_pixels, 0, width);
        } catch (IOException e) {           // Catch exception
            e.printStackTrace();            // printStackTrace(): Help to understand where the problem is actually happening.
            System.exit(0);           // Exit the system
        }
    }

    public SpriteSheet(String path, int SIZE) {
        this.path = path;
        this.SIZE = SIZE;
        sprite_pixels = new int[this.SIZE * this.SIZE];
        load();
    }

    // Tạo một đối tượng với liên kết đến ảnh trong trò chơi đối tượng.
    public static SpriteSheet tiles = new SpriteSheet("/textures/classic.png", 256);
}

