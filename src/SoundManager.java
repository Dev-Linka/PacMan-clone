import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {
    private static final Map<String, Clip> soundClips = new HashMap<>();

    public static void loadAllSounds() {
        loadSound("beginning", "sounds/beginning.wav");
        loadSound("chomp", "sounds/chomp.wav");
        loadSound("eatfruit", "sounds/eatfruit.wav");
        loadSound("eatghost", "sounds/eatghost.wav");
        loadSound("extrapac", "sounds/extrapac.wav");
        loadSound("gameOver", "sounds/death.wav");
        loadSound("intermission", "sounds/intermission.wav"); // Non so che cazzo sia ma l'ho trovato nel pacchetto dei suoni <3
    }

    private static void loadSound(String name, String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            soundClips.put(name, clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playSound(String name) {
        Clip clip = soundClips.get(name);
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public static void playIntroAndLoopBackground() {
        Clip introClip = soundClips.get("beginning");
        Clip backgroundClip = soundClips.get("chomp");
    
        if (introClip != null && backgroundClip != null) {
            new Thread(() -> {
                introClip.setFramePosition(0);
                introClip.start();
    
                try {
                    Thread.sleep(introClip.getMicrosecondLength() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                backgroundClip.setFramePosition(0);
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            }).start();
        }
    }
    
    public static void stopSound(String name) {
        Clip clip = soundClips.get(name);
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }
}
