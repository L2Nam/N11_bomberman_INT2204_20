package uet.oop.bomberman.Entity.Entity_map;

import javafx.scene.image.Image;
import uet.oop.bomberman.Entity.Entity;

public class Portal extends Entity {
    public static boolean isPortal = false;         // Kiểm tra để hiện cổng khi qua màn

    public Portal(int x, int y, Image img) {         // Create a contructor of the Portal class
        super(x, y, img);
    }

    @Override
    public void update() {

    }
}

