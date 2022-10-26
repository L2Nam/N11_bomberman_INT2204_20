package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Swing Panel hiển thị thông tin thời gian, điểm mà người chơi đạt được
 */
public class InfoPanel extends JPanel {

	private JLabel pointsLabel;
	private JLabel livesLabel;
	private JLabel emptyLabel_1;
	private JLabel emptyLabel_2;
	private JLabel emptyLabel_4;




	private ImageIcon center_bar = new ImageIcon((new ImageIcon("res/textures/center-bar.png")).getImage().getScaledInstance(80, 30, Image.SCALE_DEFAULT));
	private ImageIcon right_bar = new ImageIcon((new ImageIcon("res/textures/right-bar.png")).getImage().getScaledInstance(80, 30, Image.SCALE_DEFAULT));

	public InfoPanel(Game game) {
		setLayout(new GridLayout(1, 5));

		Color color = new Color(99, 171, 63, 255);
		emptyLabel_1 = new JLabel();
		emptyLabel_2 = new JLabel();
		emptyLabel_4 = new JLabel();

		pointsLabel = new JLabel();
		pointsLabel.setIcon(center_bar);
		pointsLabel.setText("Points: " + game.getBoard().getPoints());
		pointsLabel.setForeground(Color.white);
		pointsLabel.setHorizontalAlignment(JLabel.CENTER);
		pointsLabel.setHorizontalTextPosition(JLabel.CENTER);

		livesLabel = new JLabel();
		livesLabel.setIcon(right_bar);
		livesLabel.setText("Lives: " + game.getBoard().getLives());
		livesLabel.setForeground(Color.white);
		livesLabel.setHorizontalAlignment(JLabel.LEFT);
		livesLabel.setHorizontalTextPosition(JLabel.CENTER);

		add(emptyLabel_1);
		add(emptyLabel_2);
		add(pointsLabel);
		add(livesLabel);
		add(emptyLabel_4);


		setBackground(color);
		setPreferredSize(new Dimension(0, 40));
	}


	public void setLives(int t) {
		livesLabel.setText("Lives: " + t);

	}

	public void setPoints(int t) {
		pointsLabel.setText("Points: " + t);
	}

	class FixedStateButtonModel extends DefaultButtonModel {
		FixedStateButtonModel() {
		}

		public boolean isPressed() {
			return false;
		}

		public boolean isRollover() {
			return false;
		}

		public void setRollover(boolean b) {
		}
	}
}
