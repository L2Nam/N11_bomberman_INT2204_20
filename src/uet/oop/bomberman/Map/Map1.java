package uet.oop.bomberman.Map;

import javafx.scene.image.Image;
import uet.oop.bomberman.Entity.Character.Character;
import uet.oop.bomberman.Features.Sprite;
import uet.oop.bomberman.Graphics.MapCreation;

import static uet.oop.bomberman.Main.GameRun.*;
import static uet.oop.bomberman.Entity.Character.Player.swap_kill;
import static uet.oop.bomberman.Entity.Entity_map.Bomb.*;
import static uet.oop.bomberman.Control.Menu.*;

public class Map1 {
    public Map1() {
        // xóa toàn bộ quái vật nếu chơi lại từ lv1
        monster.clear();
        block.clear();
        swap_kill = 1;
        power_bomb = 0;
        new MapCreation("res/levels/Level1.txt");
//        player.setLife(true);
//        player.setX(32);
//        player.setY(32);
        time_number = 120;
        bomb_number = 20;
        is_bomb = 0;

//        player.setImg(Sprite.control_right_2.getFxImage());
        Image transparent = new Image("images/transparent.png");
        view.setImage(transparent);

        // set life cho monster
        for (Character character : monster) {
            character.setLife(true);
        }
    }
}
