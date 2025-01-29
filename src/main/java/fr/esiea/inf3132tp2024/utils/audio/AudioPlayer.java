package fr.esiea.inf3132tp2024.utils.audio;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.model.audio.SoundEffect;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AudioPlayer {
    private static final AudioPlayer INSTANCE = new AudioPlayer();

    public static AudioPlayer getInstance() {
        return INSTANCE;
    }

    private final AppSettings settings = AppSettings.getInstance();
    private final List<AudioTrack> audioTracks = new LinkedList<>();

    public AudioTrack createAudioTrack(SoundEffect soundEffect) {
        AudioTrack audioTrack = createAudioTrack(soundEffect.getFilePath());
        audioTrack.setVolume(settings.getSoundEffectsVolume());
        return audioTrack;
    }

    public AudioTrack createAudioTrack(Music music) {
        AudioTrack audioTrack = createAudioTrack(music.getFilePath());
        audioTrack.setVolume(settings.getMusicVolume());
        return audioTrack;
    }

    private AudioTrack createAudioTrack(String filePath) {
        try {
            NativeAudioTrack audioTrack = new NativeAudioTrack(filePath);
            audioTracks.add(audioTrack);
            return audioTrack;
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            return new DumbAudioTrack();
        }
    }

    public void stopAllPlayers() {
        Iterator<AudioTrack> iterator = audioTracks.iterator();
        while (iterator.hasNext()) {
            AudioTrack track = iterator.next();
            track.stop();
            iterator.remove();
        }
    }
}
