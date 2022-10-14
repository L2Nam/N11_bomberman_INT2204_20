package uet.oop.bomberman.objects.base;

import javafx.scene.image.Image;

public abstract class MovingEntity extends AnimateEntity {


    /**
     * Quản lý các Entity chuyển động.
     * @param x
     * @param y
     * @param img
     */
    public MovingEntity(int x, int y, Image img) {
        super(x,y,img);
    }
}
