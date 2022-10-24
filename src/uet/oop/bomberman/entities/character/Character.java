package uet.oop.bomberman.entities.character;

import uet.oop.bomberman.Map;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.AnimatedEntitiy;
import uet.oop.bomberman.graphics.Screen;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Bao gồm Bomber và Enemy
 */
public abstract class Character extends AnimatedEntitiy {
	
	protected Map _map;
	protected int _direction = -1;
	public static boolean _alive = true;
	protected boolean _moving = false;
	public int _timeAfter = 40;
	
	public Character(int x, int y, Map map) {
		_x = x;
		_y = y;
		_map = map;
	}
	
	@Override
	public abstract void update() throws UnsupportedAudioFileException, LineUnavailableException, IOException;
	
	@Override
	public abstract void render(Screen screen);

	/**
	 * Tính toán hướng đi
	 */
	protected abstract void calculateMove() throws UnsupportedAudioFileException, LineUnavailableException, IOException;
	
	protected abstract void move(double xa, double ya) throws UnsupportedAudioFileException, LineUnavailableException, IOException;

	/**
	 * Được gọi khi đối tượng bị tiêu diệt
	 */
	public abstract void kill();

	/**
	 * Xử lý hiệu ứng bị tiêu diệt
	 */
	protected abstract void afterKill();

	/**
	 * Kiểm tra xem đối tượng có di chuyển tới vị trí đã tính toán hay không
	 * @param x
	 * @param y
	 * @return
	 */
	protected abstract boolean canMove(double x, double y) throws UnsupportedAudioFileException, LineUnavailableException, IOException;

	protected double getXMessage() {
		return (_x * Game.SCALE) + (_sprite.SIZE / 2 * Game.SCALE);
	}
	
	protected double getYMessage() {
		return (_y* Game.SCALE) - (_sprite.SIZE / 2 * Game.SCALE);
	}
	
}
