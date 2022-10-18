package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;

import javax.swing.*;
import static uet.oop.bomberman.gui.PanelGame.check;
import static uet.oop.bomberman.gui.PanelGame.check2;

public class Gui extends JFrame {
    public Gui(){
        initGui();
    }

    private void initGui() {
        setTitle("Bomberman by N11_OOP");
        setSize(Game.WIDTH * Game.SCALE,Game.HEIGHT * Game.SCALE);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Container());

    }
}
