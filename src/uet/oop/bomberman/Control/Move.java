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
    private static void setDirection(String direction, Character player, int isMove) {
        switch (direction) {
            case "down":
                down_step(player);
                player.setY(player.getY() + isMove);
                break;
            case "up":
                up_step(player);
                player.setY(player.getY() - isMove);
                break;
            case "left":
                left_step(player);
                player.setX(player.getX() - isMove);
                break;
            case "right":
                right_step(player);
                player.setX(player.getX() + isMove);
                break;
        }
    }

    private static void down_step(Character player) {      //hiện thị đi xuống
        if (player instanceof Player && player.getY() % 8 == 0) {
            if (player.getSwap() == 1) {
                player.setImg(Sprite.control_down.getFxImage());
                player.setSwap(2);
            } else if (player.getSwap() == 2) {
                player.setImg(Sprite.control_down_1.getFxImage());
                player.setSwap(3);
            } else if (player.getSwap() == 3) {
                player.setImg(Sprite.control_down.getFxImage());
                player.setSwap(4);
            } else {
                player.setImg(Sprite.control_down_2.getFxImage());
                player.setSwap(1);
            }
        }
    }

    public static void down(Character player) {        //điều khiển đi xuống
        if (player.getY() % 32 == 0 && player.getX() % 32 == 0) {
            if (player instanceof Player && Blocked.block_down(player)) {
                player.setDirection("down");
                player.setCount(4 / 1);
                checkRun(player);
            }
        }
    }

    public static void up(Character player) {      //hiện thị đi lên
        if (player.getY() % 32 == 0 && player.getX() % 32 == 0) {
            if (player instanceof Player && Blocked.block_up(player)) {
                player.setDirection("up");
                player.setCount(4 / 1);
                checkRun(player);
            }
        }
    }

    private static void up_step(Character player) {        //cài đặt đi lên
        if (player instanceof Player && player.getY() % 8 == 0) {
            if (player.getSwap() == 1) {
                player.setImg(Sprite.control_up.getFxImage());
                player.setSwap(2);
            } else if (player.getSwap() == 2) {
                player.setImg(Sprite.control_up_1.getFxImage());
                player.setSwap(3);
            } else if (player.getSwap() == 3) {
                player.setImg(Sprite.control_up.getFxImage());
                player.setSwap(4);
            } else {
                player.setImg(Sprite.control_up_2.getFxImage());
                player.setSwap(1);
            }
        }
    }

    public static void left(Character player) {        //hiện thị sang trái
        if (player.getX() % 32 == 0 && player.getY() % 32 == 0) {
            if (player instanceof Player && Blocked.block_left(player)) {
                player.setDirection("left");
                player.setCount(4 / 1);
                checkRun(player);
            }
        }
    }

    private static void left_step(Character player) {      //điều khiển sang trái
        if (player instanceof Player && player.getX() % 8 == 0) {
            if (player.getSwap() == 1) {
                player.setImg(Sprite.control_left.getFxImage());
                player.setSwap(2);
            } else if (player.getSwap() == 2) {
                player.setImg(Sprite.control_left_1.getFxImage());
                player.setSwap(3);
            } else if (player.getSwap() == 3) {
                player.setImg(Sprite.control_left.getFxImage());
                player.setSwap(4);
            } else {
                player.setImg(Sprite.control_left_2.getFxImage());
                player.setSwap(1);
            }
        }
    }

    public static void right(Character player) {       //hiện thị sang phải
        if (player.getX() % 32 == 0 && player.getY() % 32 == 0) {
            if (player instanceof Player && Blocked.block_right(player)) {
                player.setDirection("right");
                player.setCount(4 / 1);
                checkRun(player);
            }
        }
    }

    public static void right_step(Character player) {      //điều khiển sang phải
        if (player instanceof Player && player.getX() % 8 == 0) {
            if (player.getSwap() == 1) {
                player.setImg(Sprite.control_right.getFxImage());
                player.setSwap(2);
            } else if (player.getSwap() == 2) {
                player.setImg(Sprite.control_right_1.getFxImage());
                player.setSwap(3);
            } else if (player.getSwap() == 3) {
                player.setImg(Sprite.control_right.getFxImage());
                player.setSwap(4);
            } else {
                player.setImg(Sprite.control_right_2.getFxImage());
                player.setSwap(1);
            }
        }
    }

}
