package fr.esiea.inf3132tp2024.utils.audio;

import fr.esiea.inf3132tp2024.old.audio.Music;
import fr.esiea.inf3132tp2024.old.audio.SoundEffect;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private static float defaultSoundEffectVolume = 1f;
    private static float defaultMusicVolume = 1f;

    public static AudioTrack createAudioTrack(SoundEffect soundEffect) {
        AudioTrack audioTrack = createAudioTrack(new File(soundEffect.getFilePath()));
        audioTrack.setVolume(defaultSoundEffectVolume);
        return audioTrack;
    }

    public static AudioTrack createAudioTrack(Music music) {
        AudioTrack audioTrack = createAudioTrack(new File(music.getFilePath()));
        audioTrack.setVolume(defaultMusicVolume);
        return audioTrack;
    }

    public static void setDefaultSoundEffectVolume(float volume) {
        defaultSoundEffectVolume = volume;
    }

    public static void setDefaultMusicVolume(float volume) {
        defaultMusicVolume = volume;
    }

    private static AudioTrack createAudioTrack(File audioFile) {
        try {
            return new NativeAudioTrack(audioFile);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            return new DumbAudioTrack();
        }
    }
}
