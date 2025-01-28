package fr.esiea.inf3132tp2024.utils.audio;

/**
 * DumbAudioTrack is a class to avoid exceptions when the audio system is not available.
 */
public class DumbAudioTrack implements AudioTrack {
    @Override
    public void play() {
        // Do nothing
    }

    @Override
    public void pause() {
        // Do nothing
    }

    @Override
    public void resume() {
        // Do nothing
    }

    @Override
    public void restart() {
        // Do nothing
    }

    @Override
    public void stop() {
        // Do nothing
    }

    @Override
    public AudioTrackStatus getStatus() {
        return AudioTrackStatus.NONE;
    }

    @Override
    public void jump(long c) {
        // Do nothing
    }

    @Override
    public float getVolume() {
        return 0;
    }

    @Override
    public void setVolume(float volume) {
        // Do nothing
    }

    @Override
    public boolean isLoop() {
        return false;
    }

    @Override
    public void setLoop(boolean loop) {
        // Do nothing
    }
}
