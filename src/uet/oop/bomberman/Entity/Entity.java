package uet.oop.bomberman.Entity;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Features.Sprite;

public abstract class Entity {
    protected int x;
    protected int y;
    protected Image img;

<<<<<<< HEAD
    
    public Entity(int x_unit, int y_unit, Image img) {
        this.x = x_unit * Sprite.SCALED_SIZE;
        this.y = y_unit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public Entity() {

=======

    //set vị trí
    Entity(Point2D.Float position) {
        this.position = new Point2D.Float(position.x, position.y);
        this.rotation = 0;
    }

    //khởi tạo đưa ảnh đến vị trí xác định
    Entity(Point2D.Float position, BufferedImage sprite) {
        this(sprite);
        this.position = new Point2D.Float(position.x, position.y);
        this.rotation = 0;
        this.collider = new Rectangle2D.Float(position.x, position.y, this.width, this.height);
>>>>>>> d5980ae8019815e62fd89d387b8c8a1f4ede7174
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

<<<<<<< HEAD
    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
=======
    /**
     * Xử lí va chạm vật rắn như tường
     *
     * @param obj vật rắn như tường
     */
    void solidCollision(Entity obj) {
        Rectangle2D intersection = this.collider.createIntersection(obj.collider);
        // Vertical collision
////        if (intersection.getWidth() >= intersection.getHeight()) {
////            // From the top
////            if (intersection.getMaxY() >= this.collider.getMaxY()) {
////                this.position.setLocation(this.position.x, this.position.y - intersection.getHeight());
////            }
////            // From the bottom
////            if (intersection.getMaxY() >= obj.collider.getMaxY()) {
////                this.position.setLocation(this.position.x, this.position.y + intersection.getHeight());
////            }
////
////            // Smoothing around corners
////            if (intersection.getWidth() < 16) {
////                if (intersection.getMaxX() >= this.collider.getMaxX()) {
////                    this.position.setLocation(this.position.x - 0.5, this.position.y);
////                }
////                if (intersection.getMaxX() >= obj.collider.getMaxX()) {
////                    this.position.setLocation(this.position.x + 0.5, this.position.y);
////                }
////            }
////        }
//
//        // Va chạm ngang
//        if (intersection.getHeight() >= intersection.getWidth()) {
//            // From the left
//            if (intersection.getMaxX() >= this.collider.getMaxX()) {
//                this.position.setLocation(this.position.x - intersection.getWidth(), this.position.y);
//            }
//            // From the right
//            if (intersection.getMaxX() >= obj.collider.getMaxX()) {
//                this.position.setLocation(this.position.x + intersection.getWidth(), this.position.y);
//            }
//
//            // Smoothing around corners
//            if (intersection.getHeight() < 16) {
//                if (intersection.getMaxY() >= this.collider.getMaxY()) {
//                    this.position.setLocation(this.position.x, this.position.y - 0.5);
//                }
//                if (intersection.getMaxY() >= obj.collider.getMaxY()) {
//                    this.position.setLocation(this.position.x, this.position.y + 0.5);
//                }
//            }
//        }
    }

    /**
     * Nhận lại vị trí của Collider
     *
     * @return A Rectangle2D collider
     */
    public Rectangle2D.Float getCollider() {
        return this.collider;
>>>>>>> d5980ae8019815e62fd89d387b8c8a1f4ede7174
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void render(GraphicsContext gc) {    // Using to render the frame of the game
        gc.drawImage(img, x, y);
    }

    public abstract void update();
}
