package uet.oop.bomberman.Control;

import uet.oop.bomberman.Entity.Entity;
import static uet.oop.bomberman.Main.GameRun.id_objects;

public class Blocked {

    public static boolean block_down(Entity entity) {   //tạo ra khóa ngăn các đối tượng lại
        return id_objects[entity.getX() / 32][entity.getY() / 32 + 1] == 0;
    }

    public static boolean block_up(Entity entity) {     //ngăn tất cả đi qua đối tượng
        return id_objects[entity.getX() / 32][entity.getY() / 32 - 1] == 0;
    }

    public static boolean block_left(Entity entity) {   //ngăn đi qua trái đối tượng
        return id_objects[entity.getX() / 32 - 1][entity.getY() / 32] == 0;
    }

    public static boolean block_right(Entity entity) {   //ngăn đi qua phải đối tượng
        return id_objects[entity.getX() / 32 + 1][entity.getY() / 32] == 0;
    }

    public static boolean block_down_bomb(Entity entity, int power) {   //Giới hạn phạm vi và hoạt ảnh của vụ nổ xuống dưới
        return id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 0
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 3
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 6
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 7
                || id_objects[entity.getX() / 32][entity.getY() / 32 + 1 + power] == 8;
    }

    public static boolean block_up_bomb(Entity entity, int power) {     //Giới hạn phạm vi và hoạt ảnh của vụ nổ lên trên
        return id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 0
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 3
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 6
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 7
                || id_objects[entity.getX() / 32][entity.getY() / 32 - 1 - power] == 8;
    }

    public static boolean block_left_bomb(Entity entity, int power) {   //Giới hạn phạm vi và hoạt ảnh của vụ nổ ở bên trái
        return id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 0
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 3
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 6
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 7
                || id_objects[entity.getX() / 32 - 1 - power][entity.getY() / 32] == 8;
    }

    public static boolean block_right_bomb(Entity entity, int power) {      //Giới hạn phạm vi và hoạt ảnh của vụ nổ ở bên phải
        return id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 0
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 3
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 6
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 7
                || id_objects[entity.getX() / 32 + 1 + power][entity.getY() / 32] == 8;
    }
}
