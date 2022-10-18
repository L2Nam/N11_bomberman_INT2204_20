package uet.oop.bomberman;

//import uet.oop.bomberman.gui.Framed;
import uet.oop.bomberman.gui.Framed;
import uet.oop.bomberman.gui.Gui;

import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.gui.PanelGame.check;
import static uet.oop.bomberman.gui.PanelGame.check2;

public class BombermanGame {


    public static Gui gui;

    public static void main(String[] args) throws InterruptedException {
//		int i = 0;
//		while (!check) {
//
//			if (check) {
//				gui = new Gui();
//				gui.setVisible(true);
//			}
//			i++;
//		}
        boolean check3 = false;
        do {
            check = true;
            if (check) {
                gui = new Gui();
                gui.setVisible(true);
            }
        } while (!check);
//		if (check && check2) {
//			new Framed();
//			System.out.println("dung main");
//		}
        int i = 0;

        while (!check2) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("bam start nhanh con me may len");
            i++;
            if (i == 9) {
                System.out.println("ban ko choi thi cut");
                gui.setVisible(false);
                System.exit(0);
            }
        }
        gui.setVisible(false);
        new Framed();

    }

}
