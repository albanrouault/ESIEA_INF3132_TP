package fr.esiea.inf3132tp2024.view.play.start;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TInfoDialog;
import fr.esiea.inf3132tp2024.view.main.menu.MainMenu;

import java.util.Random;

public class OkButton extends TButton {
    private static final String[] randomPseudos = new String[]{"Aloy", "Joel", "Ellie", "Kratos", "Masterchief", "Sam Porter Bridges", "Claire Redfield", "Ada Wong", "Shepard", "Mason", "Capitaine Price", "Steve", "Conor", "Amicia", "Ezio", "Chell", "Tina", "Jesse Faden", "Carl Johnson", "Ulfric Sombrage", "Aerith", "Tifa", "Yuna", "Trevor", "Claudette", "Lara Croft", "Nancy", "Eleven", "Nathan Drake", "Peter Parker"};

    private final MainMenu mainMenu;
    private final PlayMenu playMenu;

    public OkButton(MainMenu mainMenu, PlayMenu playMenu) {
        super("Lancer la partie");

        this.mainMenu = mainMenu;
        this.playMenu = playMenu;
    }

    @Override
    public void execute() {
        String playerName;
        if (playMenu.getPlayerNameField().getText().isBlank()) {
            playerName = randomPseudos[new Random().nextInt(randomPseudos.length)];
        } else {
            playerName = playMenu.getPlayerNameField().getText();
        }

        Terminal.getInstance().show(new TInfoDialog(DialogType.HISTORY,
                "Après une soirée bien arrosée dans un camping avec des inconnus " + playerName + " " +
                        "se réveille, avec un léger mal de crâne dans un lieu totalement inconnu. \n \n " +
                        "Il pense alors à une farse et se rend très rapidement compte qu'il ne peut\npas sortir.\n \n" +
                        "En fouillant trouva dans la pièce un bout de papier et un stylo qui lui \npermettra de dessiner les lieux " +
                        "au fur et à mesure de son avancée ! \n \n" +
                        "Son talent de joueur lui permet de déduire que si une autre sortie existe,\nelle est sûrement sur le toit !"));

        long seed = 0;
        if (playMenu.getSeedField().getText().isBlank()) {
            seed = new Random().nextLong();
        } else {
            try {
                seed = Long.parseLong(playMenu.getSeedField().getText());
            } catch (NumberFormatException ex) {
                String strSeed = playMenu.getSeedField().getText();
                // Convert seed string to long seed
                for (int i = 0; i < strSeed.length(); i++) {
                    seed += strSeed.charAt(i);
                }
            }
        }
        playMenu.stopLoopingMode();
        AudioTrack menuAudioTrack = mainMenu.getMenuAudioTrack();
        if (menuAudioTrack != null) {
            menuAudioTrack.stop();
        }
        Game game = new Game(seed, playerName);
        App.getInstance().setCurrentGame(game);
        Terminal.getInstance().show(game);
        App.getInstance().setCurrentGame(null);
        if (menuAudioTrack != null) {
            menuAudioTrack.setVolume(AppSettings.getInstance().getMusicVolume());
            menuAudioTrack.restart();
        }
    }
}
