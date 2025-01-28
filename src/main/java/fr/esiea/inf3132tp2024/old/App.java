package fr.esiea.inf3132tp2024.old;

import fr.esiea.inf3132tp2024.old.audio.Music;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.old.game.StatisticsManager;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.console.api.dialog.ErrorDialog;
import fr.esiea.inf3132tp2024.view.console.main.SplashScreen;
import fr.esiea.inf3132tp2024.view.console.main.menu.MainMenu;

import java.io.File;
import java.io.IOException;

public class App {
    private static final App INSTANCE = new App();

    public static App getInstance() {
        return INSTANCE;
    }

    private Game currentGame;

    /**
     * Méthode permettant de démarrer l'application.
     */
    public void start() {
        Console console = Console.getInstance();

        // Load app settings
        File settingsFile = new File(AppSettings.DEFAULT_FILE_PATH);
        if (settingsFile.exists()) {
            try {
                AppSettings.getInstance().load(settingsFile);
            } catch (IOException | SettingsFileCorruptedException e) {
                console.show(new ErrorDialog(DialogType.ERROR, "Impossible de charger les paramètres\n \nErreur : " + e.getMessage()));
            }
        }

        try {
            console.show(new SplashScreen());
            StatisticsManager.getInstance().loadStatistics();
            MainMenu mainMenu = new MainMenu();
            console.show(mainMenu);
            console.finalClear(true);
        } catch (Exception ex) {
            StackTraceElement[] trace = ex.getStackTrace();
            String[] lines = new String[trace.length + 1];
            lines[0] = ex.toString();
            for (int i = 1; i <= trace.length; i++) {
                lines[i] = "   at " + trace[i - 1];
            }
            AudioPlayer.getInstance().stopAllPlayers();
            AudioTrack errorSound = AudioPlayer.getInstance().createAudioTrack(Music.ERROR);
            errorSound.play();
            console.show(new ErrorDialog(DialogType.EXCEPTION, lines));
            console.finalClear(false);
        }
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}
