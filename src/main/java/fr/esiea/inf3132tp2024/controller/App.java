package fr.esiea.inf3132tp2024.controller;

import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TErrorDialog;
import fr.esiea.inf3132tp2024.view.main.SplashScreen;
import fr.esiea.inf3132tp2024.view.main.menu.MainMenu;

import java.io.File;
import java.io.IOException;

public class App {
    private static final App INSTANCE = new App();

    public static App getInstance() {
        return INSTANCE;
    }

    // Bloquer l'instanciation de la classe (pattern Singleton)
    private App() {
    }

    /**
     * Méthode permettant de démarrer l'application.
     */
    public void start() {
        // Initialiser le terminal
        Terminal terminal = Terminal.getInstance();

        // Charger les paramètres
        File settingsFile = new File(AppSettings.DEFAULT_FILE_PATH);
        if (settingsFile.exists()) {
            try {
                AppSettings.getInstance().load(settingsFile);
            } catch (IOException | SettingsFileCorruptedException e) {
                terminal.show(new TErrorDialog(DialogType.ERROR, "Impossible de charger les paramètres\n \nErreur : " + e.getMessage()));
            }
        }

        // En cas de problème quelconque, afficher le message d'erreur
        try {
            // Afficher l'écran de démarrage
            terminal.show(new SplashScreen());

            // Charger les statistiques
            StatisticsManager.getInstance().loadStatistics();

            // Charger les monstres
            //MonstreManager.getInstance().addFile();

            // Charger les attaques

            // Afficher le menu principal
            MainMenu mainMenu = new MainMenu();
            terminal.show(mainMenu);
            terminal.finalClear(true);
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
            terminal.show(new TErrorDialog(DialogType.EXCEPTION, lines));
            terminal.finalClear(false);
        }
    }
}
