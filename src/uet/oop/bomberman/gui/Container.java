package uet.oop.bomberman.gui;
import uet.oop.bomberman.BombermanGame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import static uet.oop.bomberman.gui.PanelGame.check;
import static uet.oop.bomberman.gui.PanelGame.check2;
public class Container extends JPanel {
    public static final String PANEL_GAME = "PanelGame";
    public static final String PANEL_MENU = "PanelMenu";
    public static final String PANEL_HELP = "PanelHelp";
    public static boolean check = false;
    private PanelGame panelGame;
    private PanelMenu panelMenu;
    private PanelHelp panelHelp;
    private CardLayout cardLayout;

    public Container() {
        cardLayout = new CardLayout();
        panelGame = new PanelGame();
        panelHelp = new PanelHelp(this);
        panelMenu = new PanelMenu(this);
        setLayout(cardLayout);
        add(panelGame, PANEL_GAME);
        add(panelMenu, PANEL_MENU);
        add(panelHelp, PANEL_HELP);
        cardLayout.show(this, PANEL_MENU);
        setFocusable(true);
        //check = true;
    }

    public void showCard(String name) {
        if (Objects.equals(name, PANEL_GAME)) {
            cardLayout.show(this,name);
            System.out.println("showCard");
            panelGame.initPanelGame();
            System.out.println("showCard2");
            if (check2) {
                System.out.println("dung show");
                //new Framed();
            }
            //new Framed();
//            BombermanGame.gui.setVisible(false);
//            new Framed().setVisible(true);
        } else if (Objects.equals(name, PANEL_HELP)) {
            cardLayout.show(this, name);
        } else if (Objects.equals(name, PANEL_MENU)) {
            cardLayout.show(this, name);
        }
    }
}
