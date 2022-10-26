package uet.oop.bomberman;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundGame {
    private Clip clip = null;

    public static boolean playSoundCheck = true;
    public void playSound(String soundFile, boolean playSoundCheck, int Loop) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (playSoundCheck) {
            File f = new File(soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            clip.loop(Loop);
        }
    }
    public void stopSound() {
        this.clip.stop();
        this.clip.close();
    }


}
