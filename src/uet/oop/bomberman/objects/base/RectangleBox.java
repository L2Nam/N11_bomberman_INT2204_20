package uet.oop.bomberman.objects.base;

import javafx.geometry.Rectangle2D;

public class RectangleBox {
    private int x;
    private int y;
    private double width;
    private double height;

    Rectangle2D boundedBox;

    public RectangleBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        boundedBox = new Rectangle2D(x, y, width, height);
    }

    public Rectangle2D getBoundedBox() {
        return boundedBox;
    }

    /**
     * Hàm kiểm tra va chạm.
     * @param other
     * @return
     */
    public boolean checkCollision(RectangleBox other) {
        boolean check;
        check = other.getBoundedBox().intersects(boundedBox);
        return check;
    }

    public void setPos(int x, int y) {
        boundedBox = new Rectangle2D(x,y,width,height);
    }
}
