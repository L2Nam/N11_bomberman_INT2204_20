package uet.oop.bomberman.Control;

import uet.oop.bomberman.Entity.Character.Character;
import uet.oop.bomberman.Entity.Character.Player;
import uet.oop.bomberman.Features.Sprite;


public class Move {

    public static void checkRun(Character animal) {    //Check if all your mob move or not
        if (animal instanceof Player && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 8 * 1);
            animal.setCount(animal.getCount() - 1);
        }
    }
    //hiện thị hướng của các nhân vật
    private static void setDirection(String direction, Character animal, int isMove) {
        switch (direction) {
            case "down":
                down_step(animal);
                animal.setY(animal.getY() + isMove);
                break;
            case "up":
                up_step(animal);
                animal.setY(animal.getY() - isMove);
                break;
            case "left":
                left_step(animal);
                animal.setX(animal.getX() - isMove);
                break;
            case "right":
                right_step(animal);
                animal.setX(animal.getX() + isMove);
                break;
        }
    }

    private static void down_step(Character animal) {      //hiện thị đi xuống
        if (animal instanceof Player && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_down.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_down_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_down.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_down_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void down(Character animal) {        //điều khiển đi xuống
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Player && Blocked.block_down(animal)) {
                animal.setDirection("down");
                animal.setCount(4 / 1);
                checkRun(animal);
            }
        }
    }

    public static void up(Character animal) {      //hiện thị đi lên
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Player && Blocked.block_up(animal)) {
                animal.setDirection("up");
                animal.setCount(4 / 1);
                checkRun(animal);
            }
        }
    }

    private static void up_step(Character animal) {        //cài đặt đi lên
        if (animal instanceof Player && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_up.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_up_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_up.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_up_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void left(Character animal) {        //hiện thị sang trái
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Player && Blocked.block_left(animal)) {
                animal.setDirection("left");
                animal.setCount(4 / 1);
                checkRun(animal);
            }
        }
    }

    private static void left_step(Character animal) {      //điều khiển sang trái
        if (animal instanceof Player && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_left.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_left_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_left.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void right(Character animal) {       //hiện thị sang phải
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Player && Blocked.block_right(animal)) {
                animal.setDirection("right");
                animal.setCount(4 / 1);
                checkRun(animal);
            }
        }
    }

    public static void right_step(Character animal) {      //điều khiển sang phải
        if (animal instanceof Player && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.control_right.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.control_right_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.control_right.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.control_right_2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

}
