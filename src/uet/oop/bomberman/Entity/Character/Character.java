package uet.oop.bomberman.Entity.Character;

import javafx.scene.image.Image;
import uet.oop.bomberman.Entity.Entity;

public abstract class Character extends Entity {
    protected int is_move;        // 1 lần đi đc bao nhiêu ô
    protected int swap;           // đổi hình ảnh
    protected String direction;   // hướng của người chơi
    protected int count;          // đếm bước của 1 bước nhảy
    protected int count_to_run;
    protected boolean life;       // mạng của địch

    public Character(int x, int y, Image img) {
        super(x, y, img);
    }
    public Character(int is_move, int swap, String direction, int count, int count_to_run) {
        this.is_move= is_move;
        this.swap = swap;
        this.direction = direction;
        this.count = count;
        this.count_to_run = count_to_run;
    }

    public Character(boolean life) {
        this.life = life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public int getIsMove() {
        return is_move;
    }

    public void setIsMove(int is_move) {
        this.is_move = is_move;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountToRun() {
        return count_to_run;
    }

    public void setCountToRun(int count_to_run) {
        this.count_to_run = count_to_run;
    }

    public Character() {

    }

    @Override
    public void update() {

    }
}
