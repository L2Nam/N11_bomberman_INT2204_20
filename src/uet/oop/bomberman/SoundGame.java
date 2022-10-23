package uet.oop.bomberman;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundGame {
    public static boolean playSoundCheck = true;
    public void playSound(String soundFile, boolean playSoundCheck) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (playSoundCheck) {
            File f = new File( soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        }
    }
}
