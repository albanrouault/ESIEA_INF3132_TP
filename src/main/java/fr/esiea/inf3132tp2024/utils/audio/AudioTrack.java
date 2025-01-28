package fr.esiea.inf3132tp2024.utils.audio;

public interface AudioTrack {
    void play();

    void pause();

    void resume();

    void restart();

    void stop();

    AudioTrackStatus getStatus();

    void jump(long c);

    float getVolume();

    void setVolume(float volume);

    boolean isLoop();

    void setLoop(boolean loop);
}
