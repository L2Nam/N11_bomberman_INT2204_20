package uet.oop.bomberman.Entity.Entity_map;


import javafx.scene.image.Image;
import uet.oop.bomberman.Entity.Entity;
import uet.oop.bomberman.Features.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity {
    private static long time_bomb; // thời gian bom nổ
    private static long time_tmp; // thời gian để đặt 2 quả bom tránh trường hợp trùng 1 chỗ
    private static Entity bomb;
    private static int swap_active = 1; //thay đổi trạng thái hoạt động của bomb
    private static int swap_explosion = 1;//thay đổi trạng thái nổ của bomb

    private static List<Entity>list_bomb_width = new ArrayList<>();
    private static List<Entity>list_bomb_height = new ArrayList<>();

    private static int power_bomb = 0; // sức nổ của bomb

    /*sức công phá của bomb*/
    private static int power_bomb_up = 0;
    private static int power_bomb_down = 0;
    private static int power_bomb_left = 0;
    private static int power_bomb_right = 0;


    /*các vật cản của bomb*/
    private static Entity edge_down = null;
    private static Entity edge_up = null;
    private static Entity edge_left = null;
    private static Entity edge_right = null;

    /*kiểm tra các trạng thái của bomb*/
    private static boolean is_edge = false; // kiểm tra xem 1 cạnh có tồn tại hay không
    private static boolean is_middle = false;   // kiểm tra xem quả bomb có nổ hình dấu + hay chữ T

    public static int is_bomb = 0; // kiểm tra xem có bomb ở đó không //0 là ko có bomb, 1 là có bomb, 2 nổ.

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public void putBomb() {
        if (is_bomb == 0  /*bomb_number > 0*/) {
            is_bomb = 1;
            time_bomb = System.currentTimeMillis();
            time_tmp = time_bomb;
        }
    }
    /*load hình ảnh đặt bomb*/
    public static void actBomb() {
        if (swap_active == 1) {
            bomb.setImg(Sprite.bomb.getFxImage());
            swap_active = 2;
        }
        else if (swap_active == 2) {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swap_active = 3;
        }
        else if (swap_active == 3) {
            bomb.setImg(Sprite.bomb_2.getFxImage());
            swap_active = 4;
        }
        else {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swap_active = 1;
        }
    }


    public static void createEdge() {
        /*tạo ra một thứ để ngăn cản chuyển động nhân vật cũng như nổ bom*/
    }

    public static void createMiddle(){
        //điều chỉnh bom nổ ở vitri trung tâm
    }

    public static void explosionCenter() {
        //xác định tâm nổ của quả bom
    }

    private static void checkExplosion() {
        //kiểm tra thời gian phát nổ của quả bom sau khi đc đặt ra
    }

    private static void checkAct() {
        //kiểm tra xem bom đã xử lý như thế nào trước khi phát nổ
    }

    public void update() {
        checkAct();
        checkExplosion();
    }
}
