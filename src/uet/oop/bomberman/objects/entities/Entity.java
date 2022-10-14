package uet.oop.bomberman.objects.entities;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.objects.base.RectangleBox;

public abstract class Entity {
    protected int x;
    protected int y;
    protected int xUnit;
    protected int yUnit;

    protected boolean removed = false;
    protected Image img;
    private RectangleBox boundedBox;

    /**
     * Xử lí tất cả các đối tượng trong game.
     *
     * @param x
     * @param y
     * @param img
     */
    public Entity(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        xUnit = x / Sprite.BLOCK_SIZE;
        yUnit = y / Sprite.BLOCK_SIZE;
        removed = false;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setRemoved() {
        removed = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public RectangleBox getBoundedBox() {
        return boundedBox;
    }

    public boolean isCollider(Entity other) {
        RectangleBox otherBox = other.getBoundedBox();
        return boundedBox.checkCollision(otherBox);
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public abstract void update();
}
