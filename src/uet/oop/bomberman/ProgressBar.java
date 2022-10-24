package uet.oop.bomberman;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

public class ProgressBar extends JFrame {
    public static boolean isDoned = false;
    JProgressBar jb;
    int i = 0, num = 0;

    ProgressBar() {
        jb = new JProgressBar(0, 2000);
        jb.setBounds(438,488 , 600, 30);

        jb.setValue(0);
        jb.setStringPainted(true);

        add(jb);
        this.setTitle("Bomberman by OOP_N11");
        this.setSize(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void iterate() {
        while (i <= 2000) {
            jb.setValue(i);
            if (i <= 1700) {
                i += 20;
            } else {
                i += 10;
            }
            try {
                Thread.sleep(150);
            } catch (Exception e) {
            }
        }
        isDoned = true;
    }
}