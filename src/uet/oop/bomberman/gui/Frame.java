package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    public GamePanel _gamepane;
    private JPanel _containerpane;
    private InfoPanel _infopanel;
    private Game _game;

    public Frame(){
        _containerpane = new JPanel(new BorderLayout());
        _gamepane = new GamePanel(this);
        _infopanel = new InfoPanel(_gamepane.getGame());

        _containerpane.add(_infopanel, BorderLayout.NORTH);
        _containerpane.add(_gamepane, BorderLayout.CENTER);

        _game = _gamepane.getGame();
        _infopanel.setVisible(false);

        add(_containerpane);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        _game.start();
    }
}
