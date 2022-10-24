package uet.oop.bomberman.graphics;

import uet.oop.bomberman.Map;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.Bomber2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Xử lý render cho tất cả Entity và một số màn hình phụ ra Game Panel
 */
public class Screen {
	private Image backgroundFixed;
	private BufferedImage background;
	private Font font;
	protected int _width, _height;
	public int[] _pixels;
	private int _transparentColor = 0xffff00ff;
	
	public static int xOffset = 0, yOffset = 0;
	
	public Screen(int width, int height) {
		_width = width;
		_height = height;
		
		_pixels = new int[width * height];

		try {
			background = ImageIO.read(new File("res/textures/menu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		backgroundFixed = background.getScaledInstance(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, Image.SCALE_DEFAULT);
	}
	
	public void clear() {
		for (int i = 0; i < _pixels.length; i++) {
			_pixels[i] = 0;
		}
	}
	
	public void renderEntity(int xp, int yp, Entity entity) { //save entity pixels
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < entity.getSprite().getSize(); y++) {
			int ya = y + yp; //add offset
			for (int x = 0; x < entity.getSprite().getSize(); x++) {
				int xa = x + xp; //add offset
				if(xa < -entity.getSprite().getSize() || xa >= _width || ya < 0 || ya >= _height) break; //fix black margins
				if(xa < 0) xa = 0; //start at 0 from left
				int color = entity.getSprite().getPixel(x + y * entity.getSprite().getSize());
				if(color != _transparentColor) _pixels[xa + ya * _width] = color;
			}
		}
	}
	
	public void renderEntityWithBelowSprite(int xp, int yp, Entity entity, Sprite below) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < entity.getSprite().getSize(); y++) {
			int ya = y + yp;
			for (int x = 0; x < entity.getSprite().getSize(); x++) {
				int xa = x + xp;
				if(xa < -entity.getSprite().getSize() || xa >= _width || ya < 0 || ya >= _height) break; //fix black margins
				if(xa < 0) xa = 0;
				int color = entity.getSprite().getPixel(x + y * entity.getSprite().getSize());
				if(color != _transparentColor) 
					_pixels[xa + ya * _width] = color;
				else
					_pixels[xa + ya * _width] = below.getPixel(x + y * below.getSize());
			}
		}
	}
	
	public static void setOffset(int xO, int yO) {
		xOffset = xO;
		yOffset = yO;
	}
	
	public static int calculateXOffset(Map map, Bomber bomber) {
		if(bomber == null) return 0;
		int temp = xOffset;
		
		double BomberX = bomber.getX() / 16;
		double complement = 0.5;
		int firstBreakpoint = map.getWidth();
		int lastBreakpoint = map.getWidth() - firstBreakpoint;
		
		if( BomberX > firstBreakpoint + complement && BomberX < lastBreakpoint - complement) {
			temp = (int)bomber.getX()  - (Game.WIDTH / 2);
		}
		
		return temp;
	}

	public static int calculateXOffset2(Map map, Bomber2 bomber) {
		if(bomber == null) return 0;
		int temp = xOffset;

		double BomberX = bomber.getX() / 16;
		double complement = 0.5;
		int firstBreakpoint = map.getWidth();
		int lastBreakpoint = map.getWidth() - firstBreakpoint;

		if( BomberX > firstBreakpoint + complement && BomberX < lastBreakpoint - complement) {
			temp = (int)bomber.getX()  - (Game.WIDTH / 2);
		}

		return temp;
	}

	public void intializeFont() {
		try {
			File fontFile = new File("res/font/VBRUSHTB.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 60);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
		} catch (IOException | FontFormatException e) {
			//Handle exception
		}
	}
	public void drawPaused(Graphics g) {
		g.setFont(font);
		g.setColor(Color.white);
		drawCenteredString("PAUSED", getRealWidth(), getRealHeight(), g);

	}
	public void drawChangeLevel(Graphics g, int level) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getRealWidth(), getRealHeight());

		g.setFont(font);
		g.setColor(Color.white);
		drawCenteredString("LEVEL " + level, getRealWidth(), getRealHeight(), g);
	}

	public void drawMenu(Graphics g) {
		g.drawImage(backgroundFixed, 0, 0, null);
	}

	public void drawCenteredString(String s, int w, int h, Graphics g) {
	    FontMetrics fm = g.getFontMetrics();
	    int x = (w - fm.stringWidth(s)) / 2;
	    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
	    g.drawString(s, x, y);
	 }

	public void drawCenteredImage(Image image, int imageWidth, int imageHeight,
								  int gameWidth, int gameHeight, Graphics g) {
		int x = (gameWidth - imageWidth) / 2;
		int y = (gameHeight - imageHeight) / 2;
		g.drawImage(image, x, y, null);
	}
	
	public int getWidth() {
		return _width;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public int getRealWidth() {
		return _width * Game.SCALE;
	}
	
	public int getRealHeight() {
		return _height * Game.SCALE;
	}

    public void drawEndGame(Graphics g, int points) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getRealWidth(), getRealHeight());

		Font font = new Font("Arial", Font.PLAIN, 20 * Game.SCALE);
		g.setFont(font);
		g.setColor(Color.white);
		drawCenteredString("GAME OVER", getRealWidth(), getRealHeight(), g);

		font = new Font("Arial", Font.PLAIN, 10 * Game.SCALE);
		g.setFont(font);
		g.setColor(Color.yellow);
		drawCenteredString("POINTS: " + points, getRealWidth(), getRealHeight() + (Game.TILES_SIZE * 2) * Game.SCALE, g);
    }
}
