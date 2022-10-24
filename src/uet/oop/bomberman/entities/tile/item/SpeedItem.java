package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.Bomber2;
import uet.oop.bomberman.graphics.Sprite;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static uet.oop.bomberman.Game.soundGame;
import static uet.oop.bomberman.SoundGame.playSoundCheck;

public class SpeedItem extends Item {
	public SpeedItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
		// TODO: xử lý Bomber ăn Item
		if(e instanceof Bomber || e instanceof Bomber2){
			if(this.isRemoved()) return true;
			remove();
			if (e instanceof Bomber ) {
				Game.addBomberSpeed(0.3);
			}
			if (e instanceof Bomber2) {
				Game.addBomberSpeed2(0.3);
			}
			soundGame.playSound("eat_item.wav", playSoundCheck);
		}
		return false;
	}
}
