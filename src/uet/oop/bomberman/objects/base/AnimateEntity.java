package uet.oop.bomberman.objects.base;

import javafx.scene.image.Image;
import uet.oop.bomberman.objects.entities.Entity;


public abstract class AnimateEntity extends Entity {
    protected int animation = 0;
    protected final int MAX_ANIMATION = 7500;

    public AnimateEntity(int x, int y, Image img) {
        super(x, y, img);
    }

    public void animated() {
        if(animation >= MAX_ANIMATION) {
            animation = 0;
        } else {
            animation += 1;
        }
    }

    public abstract void playAnimation();
}
