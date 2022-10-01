package uet.oop.bomberman.Entity;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Wall extends TileObject {
    /**
     * Khai báo Wall.
     * @param position
     * @param sprite
     * @param breakable
     */
    public Wall(Point2D.Float position, BufferedImage sprite, boolean breakable) {
        super(position, sprite);
        this.breakable = breakable;
    }

    /**
     * Phá hủy Wall khi bị nổ.
     */
    @Override
    public void update() {
        if (this.checkExplosion()) {
            this.destroy();
        }
    }

    /**
     * Làm xuất hiện ngẫu nhiên powerup sau khi nổ tường.
     */
    @Override
    public void afterDestroy() {
        double random = Math.random(); // random từ 0.0 - 1.0
        if (random < 0.4) {
            Powerup powerup = new Powerup(this.position, Powerup.randomPower());
            GameObjectCollection.spawn(powerup);
        }
    }

    @Override
    public void onCollisionEnter(Entity Obj) {
        Obj.handleCollision(this);
    }

    /**
     * Kiểm tra tường có phá được hay không.
     * true = phá được, false = không phá được.
     * @return
     */
    @Override
    public boolean isBreakable() {
        return this.breakable;
    }
}
