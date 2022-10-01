package uet.oop.bomberman.Entity;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;


public abstract class TileObject extends Entity {
    protected boolean breakable;
    protected Excepsion explosionContact;

    /**
     * Khai báo TileObject.
     * @param position
     * @param sprite
     */
    TileObject(Point2D.Float position, BufferedImage sprite) {
        super(position, sprite);
        this.addToGrid();
    }

    public abstract boolean isBreakable();

    /**
     * Bổ sung các đối tượng vào map.
     */
    protected void addToGrid() {
        double x = Math.round(this.position.getX() / 32) * 32;
        double y = Math.round(this.position.getY() / 32) * 32;
        this.position.setLocation(x, y);
    }

    /**
     * Kiểm tra va chạm.
     * @return
     */
    protected boolean checkExplosion() {
        return this.isBreakable() && this.explosionContact != null && this.explosionContact.isDestroyed();
    }

    /**
     * Xử lý va chạm.
     * @param explosionObj
     */
    @Override
    public void handleCollision(Explosion explosionObj) {
        if (this.isBreakable()) {
            if (this.explosionContact == null) {
                this.explosionContact = explosionObj;
            }
        }
    }
}
