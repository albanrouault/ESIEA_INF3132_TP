package fr.esiea.inf3132tp2024.old;

import fr.esiea.inf3132tp2024.old.audio.Music;
import fr.esiea.inf3132tp2024.old.audio.SoundEffect;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.old.game.Statistics;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.console.api.dialog.ErrorDialog;
import fr.esiea.inf3132tp2024.view.console.main.SplashScreen;
import fr.esiea.inf3132tp2024.view.console.main.menu.MainMenu;
import fr.esiea.inf3132tp2024.utils.audio.NativeAudioTrack;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class App {
    private final AppSettings settings;
    private final Console console;
    private final Statistics statistics;
    private final List<NativeAudioTrack> audioPlayers = new LinkedList<>();
    private Game currentGame;

    /**
     * Constructeur
     */
    public App() {
        this.settings = new AppSettings();
        this.console = new Console(settings);
        File settingsFile = new File(AppSettings.DEFAULT_FILE_PATH);
        if (settingsFile.exists()) {
            try {
                this.settings.load(settingsFile);
            } catch (IOException | SettingsFileCorruptedException e) {
                console.show(new ErrorDialog(DialogType.ERROR, "Impossible de charger les paramètres\n \nErreur : " + e.getMessage()));
            }
        }
        this.statistics = new Statistics();
    }

    /**
     * Méthode permettant de démarrer l'application.
     */
    public void start() {
        try {
            console.show(new SplashScreen());
            statistics.loadStatistics();
            MainMenu mainMenu = new MainMenu(this);
            console.show(mainMenu);
            console.finalClear(true);
        } catch (Exception ex) {
            StackTraceElement[] trace = ex.getStackTrace();
            String[] lines = new String[trace.length + 1];
            lines[0] = ex.toString();
            for (int i = 1; i <= trace.length; i++) {
                lines[i] = "   at " + trace[i - 1];
            }
            stopAllPlayers();
            try {
                NativeAudioTrack errorSound = createAudioPlayer(Music.ERROR);
                errorSound.setVolume(settings.getMusicVolume());
                errorSound.play();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException |
                     IllegalArgumentException ignored) {
            }
            console.show(new ErrorDialog(DialogType.EXCEPTION, lines));
            console.finalClear(false);
        }
        audioPlayers.clear();
    }

    public NativeAudioTrack createAudioPlayer(Music music) throws UnsupportedAudioFileException, LineUnavailableException, IOException, IllegalArgumentException {
        NativeAudioTrack player = new NativeAudioTrack(music.getFilePath());
        audioPlayers.add(player);
        return player;
    }

    public NativeAudioTrack createAudioPlayer(SoundEffect soundEffect) throws UnsupportedAudioFileException, LineUnavailableException, IOException, IllegalArgumentException {
        return new NativeAudioTrack(soundEffect.getFilePath());
    }

    public void stopAllPlayers() {
        for (NativeAudioTrack player : audioPlayers) {
            player.stop();
        }

        audioPlayers.clear();
    }

    public AppSettings getSettings() {
        return settings;
    }

    public Console getConsole() {
        return console;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
