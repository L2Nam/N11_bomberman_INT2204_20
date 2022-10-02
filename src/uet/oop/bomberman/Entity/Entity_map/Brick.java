package uet.oop.bomberman.Entity.Entity_map;

import javafx.scene.image.Image;
import uet.oop.bomberman.Entity.Entity;
import uet.oop.bomberman.Features.Sprite;

import static uet.oop.bomberman.Main.GameRun.block;
import static uet.oop.bomberman.Main.GameRun.list_kill;

public class Brick extends Entity {

    public Brick(int x, int y, Image img) {     // Create a contructor of the Brick class
        super(x, y, img);
    }

    private void checkHide() {    // Kiểm tra khả năng hiển thị của Brick
        for (Entity entity : block) {
            if (entity instanceof Brick)
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4) {    // At the element of the 2-dimensional listKill array with the value 4, Brick and Grass will appear
                    entity.setImg(Sprite.grass.getFxImage());
                }
        }
    }

    @Override
    public void update() {
        checkHide();
    }
}
