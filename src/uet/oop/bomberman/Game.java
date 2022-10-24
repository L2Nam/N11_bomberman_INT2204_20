package uet.oop.bomberman;

import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.input.Keyboard;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import static uet.oop.bomberman.SoundGame.playSoundCheck;
import static uet.oop.bomberman.level.FileLevelLoader.is_multi;

/**
 * Tạo vòng lặp cho game, lưu trữ một vài tham số cấu hình toàn cục,
 * Gọi phương thức render(), update() cho tất cả các entity
 */
public class Game extends Canvas implements MouseListener, MouseMotionListener {


    public static final int TILES_SIZE = 16, WIDTH = TILES_SIZE * (62 / 2), HEIGHT = 13 * TILES_SIZE;

    public static int SCALE = 3;

    public static SoundGame soundGame = new SoundGame();
    public static final String TITLE = "BombermanGame by N11_OOP";

    private static final int BOMBRATE = 1;
    private static final int BOMBRADIUS = 1;
    private static final double BOMBERSPEED = 1.0;

    public static final int TIME = 200;
    public static final int POINTS = 0;

    protected static int SCREENDELAY = 3;

    protected static int bombRate = BOMBRATE;
    protected static int bombRate2 = BOMBRATE;
    protected static int bombRadius = BOMBRADIUS;
    protected static int bombRadius2 = BOMBRADIUS;
    protected static double bomberSpeed = BOMBERSPEED;
    protected static double bomberSpeed2 = BOMBERSPEED;
    protected int _screenDelay = SCREENDELAY;

    private Keyboard _input;
    private Keyboard _input1;
    private boolean _running = false;
    private boolean _paused = true;
    private boolean _isOptions = false;
    private static Map _map;

    private Screen screen;
    private Frame _frame;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    private boolean _menu = true;

    public Game(Frame frame) {
        _frame = frame;
        _frame.setTitle(TITLE);

        screen = new Screen(WIDTH, HEIGHT);
        _input = new Keyboard();
        _input1 = new Keyboard();
        _map = new Map(this, _input, _input1, screen);
        addKeyListener(_input);
        addKeyListener(_input1);
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    private void renderGame() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        _map.render(screen);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen._pixels[i];
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();
    }

    private void renderScreen() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        Graphics g = bs.getDrawGraphics();

        _map.drawScreen(g);

        g.dispose();
        bs.show();
    }

    private void update() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        _input.update();
        _input1.update1();
        _map.update();
    }

    public void start() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        soundGame.playSound("Stage.wav", playSoundCheck);
        while (_menu) {
            renderScreen();
        }
        _map.loadLevel(1);
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0; // nanosecond, 60 frames per second
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();

        while (_running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            if (_paused) {
                if (_screenDelay <= 0) {
                    _map.setShow(-1);
                    _paused = false;
                }
                renderScreen();
            } else {
                renderGame();
            }


            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                _frame.setTitle(TITLE);
                updates = 0;
                frames = 0;

                if (_map.getShow() == 2)
                    --_screenDelay;
            }
        }
    }

    public static double getBomberSpeed() {
        return bomberSpeed;
    }

    public static double getBomberSpeed2() {
        return bomberSpeed2;
    }

    public static int getBombRate() {
        return bombRate;
    }

    public static int getBombRate2() {
        return bombRate2;
    }

    public static int getBombRadius() {
        return bombRadius;
    }

    public static int getBombRadius2() {
        return bombRadius2;
    }

    public static void addBomberSpeed(double i) {
        bomberSpeed += i;
    }

    public static void addBomberSpeed2(double i) {
        bomberSpeed2 += i;
    }

    public static void addBombRadius(int i) {
        bombRadius += i;
    }
    public static void addBombRadius2(int i) {
        bombRadius2 += i;
    }

    public static void  addBombRate(int i) {
        bombRate += i;
    }

    public static void addBombRate2(int i) {
        bombRate2 += i;
    }

    public void resetScreenDelay() {
        _screenDelay = SCREENDELAY;
    }

    public static Map getBoard() {
        return _map;
    }

    public boolean isPaused() {
        return _paused;
    }

    public void pause() {
        _paused = true;
    }

    public void setRunning(boolean _running) {
        this._running = _running;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle singleButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT - 41, 237, 63);
        if (singleButton.contains(e.getX(), e.getY()) && _menu) {
            is_multi = false;
            _menu = false;
            _running = true;
        }

        Rectangle multiButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT + 62, 237, 63);
        if (multiButton.contains(e.getX(), e.getY()) && _menu) {
            is_multi = true;
            _menu = false;
            _running = true;
        }

        Rectangle optionButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT + 162, 237, 63);
        if (optionButton.contains(e.getX(), e.getY()) && _menu) {
            _isOptions = true;
            _menu = false;
            ///////
        }

        Rectangle exitButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT + 262, 237, 63);
        if (exitButton.contains(e.getX(), e.getY()) && _menu) {
            _menu = false;
            System.exit(0);
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        Rectangle singleButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT - 41, 237, 63);
        Rectangle multiButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT + 62, 237, 63);
        Rectangle optionButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT + 162, 237, 63);
        Rectangle exitButton = new Rectangle(Game.WIDTH + 129, Game.HEIGHT + 262, 237, 63);
        if (_menu) {
            if (singleButton.contains(e.getX(), e.getY()) || multiButton.contains(e.getX(), e.getY()) || optionButton.contains(e.getX(), e.getY()) || exitButton.contains(e.getX(), e.getY())) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(Cursor.getDefaultCursor());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
