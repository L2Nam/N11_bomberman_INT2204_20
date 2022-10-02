package uet.oop.bomberman.Entity.Entity_map;

import javafx.scene.image.Image;
import uet.oop.bomberman.Entity.Entity;

public class Brick extends Entity {

    public Brick(int x, int y, Image img) {     // Create a contructor of the Brick class
        super(x, y, img);
    }

    private void checkHide() {    // Kiểm tra khả năng hiển thị của Brick
    }

    @Override
    public void update() {
        checkHide();
    }
}
