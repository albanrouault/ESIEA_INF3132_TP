package fr.esiea.inf3132tp2024.utils.audio;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * SimpleAudioPlayer is a class to play a song file.
 * <p>
 * Source: <a href="https://www.geeksforgeeks.org/play-audio-file-using-java/">URL</a>
 *
 * @author GeeksforGeeks
 */
public class NativeAudioTrack implements AudioTrack {
    private final Clip clip;
    private final String filePath;

    // to store current position
    private Long currentFrame;

    // current status of clip
    private AudioTrackStatus status = AudioTrackStatus.NONE;
    private boolean loop = false;
    private float volume = 1f;

    // constructor to initialize streams and clip
    public NativeAudioTrack(String filePath) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.clip = AudioSystem.getClip();
        this.filePath = filePath;

        resetAudioStream();
    }

    // Method to play the audio
    @Override
    public void play() {
        //start the clip
        clip.start();

        status = AudioTrackStatus.PLAYING;
    }

    // Method to pause the audio
    @Override
    public void pause() {
        if (!status.equals(AudioTrackStatus.PLAYING)) {
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        clip.close();
        status = AudioTrackStatus.PAUSED;
    }

    // Method to resume the audio
    @Override
    public void resume() {
        if (!status.equals(AudioTrackStatus.PAUSED)) {
            return;
        }
        clip.stop();
        clip.close();
        try {
            resetAudioStream();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO: Handle exception
            e.printStackTrace();
        }
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    // Method to restart the audio
    @Override
    public void restart() {
        this.stop();
        try {
            resetAudioStream();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO: Handle exception
            e.printStackTrace();
        }
        this.play();
    }

    // Method to stop the audio
    @Override
    public void stop() {
        if (!(status.equals(AudioTrackStatus.PLAYING) || status.equals(AudioTrackStatus.PAUSED))) {
            return;
        }

        clip.stop();
        clip.close();
        currentFrame = 0L;
        status = AudioTrackStatus.STOPPED;
    }

    @Override
    public AudioTrackStatus getStatus() {
        return status;
    }

    // Method to jump over a specific part
    @Override
    public void jump(long c) {
        if (c > 0 && c < clip.getMicrosecondLength()) {
            this.stop();
            try {
                resetAudioStream();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                // TODO: Handle exception
                e.printStackTrace();
            }
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    @Override
    public float getVolume() {
        return volume;
    }

    // Method to set volume 0.0 is 0% and 1.0 is 100%
    @Override
    public void setVolume(float volume) {
        this.volume = volume;
        float db = (float) (Math.log(volume) / Math.log(10.0) * 40.0);
        FloatControl c = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        c.setValue(db);
    }

    @Override
    public boolean isLoop() {
        return loop;
    }

    // Method to set loop mode
    @Override
    public void setLoop(boolean loopMode) {
        this.loop = loopMode;
        if (loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            clip.loop(0);
        }
    }

    // Method to reset audio stream
    private void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(NativeAudioTrack.class.getResourceAsStream(filePath)));
        clip.open(audioInputStream);
        if (loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        float db = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
        FloatControl c = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        c.setValue(db);
    }
}
