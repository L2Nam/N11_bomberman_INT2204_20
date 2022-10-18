package uet.oop.bomberman.gui;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Game;

import javax.swing.*;
import java.awt.*;
import uet.oop.bomberman.gui.Framed;
import uet.oop.bomberman.gui.Gui;

import static uet.oop.bomberman.gui.PanelGame.check;
public class PanelGame extends JLabel implements Runnable {
    public static boolean check = false;
    public static boolean check2 = false;
    //        private BitSet bitSet = new BitSet(256);
    private Frame frame = new Frame();
    private Game game;

    public void initPanelGame() {
//        game = new Game(frame);
//        game.start();
        //new Framed();
        System.out.println("init");
        //new Framed();
        check =true;
        check2 = true;
    }

    public Game getGame() {
        return game;
    }

    public void run() {
//        game.start();
//        BombermanGame.gui.setVisible(false);
//        new Framed().setVisible(true);
    }
}



