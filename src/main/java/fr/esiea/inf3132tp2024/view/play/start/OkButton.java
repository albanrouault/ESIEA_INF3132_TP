package fr.esiea.inf3132tp2024.view.play.start;

import fr.esiea.inf3132tp2024.controller.App;
import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.controller.game.Game;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
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
        String playerOneName = getPlayerName(playMenu.getPlayerOneNameField().getText());
        String playerTwoName = getPlayerName(playMenu.getPlayerTwoNameField().getText());

        Terminal.getInstance().show(new TInfoDialog(DialogType.HISTORY,
                "Après une soirée bien arrosée dans un camping avec des inconnus, " + playerOneName + " et " + playerTwoName + " " +
                        "se réveillent, avec un léger mal de crâne dans un lieu totalement inconnu. \n \n " +
                        "Ils pensent alors à une farce et se rendent très rapidement compte qu'ils ne peuvent\npas sortir.\n \n" +
                        "En fouillant, ils trouvent dans la pièce un bout de papier et un stylo qui leur \npermettra de dessiner les lieux " +
                        "au fur et à mesure de leur avancée ! \n \n" +
                        "Leur talent de joueurs leur permet de déduire que si une autre sortie existe,\nelle est sûrement sur le toit !"));

        long seed = getSeed(playMenu.getSeedField().getText());

        playMenu.stopLoopingMode();
        AudioTrack menuAudioTrack = mainMenu.getMenuAudioTrack();
        if (menuAudioTrack != null) {
            menuAudioTrack.stop();
        }

        Game game = new Game(seed, playerOneName, playerTwoName);
        App.getInstance().setCurrentGame(game);
        Terminal.getInstance().show(game);
        App.getInstance().setCurrentGame(null);

        if (menuAudioTrack != null) {
            menuAudioTrack.setVolume(AppSettings.getInstance().getMusicVolume());
            menuAudioTrack.restart();
        }
    }

    private String getPlayerName(String inputName) {
        if (inputName.isBlank()) {
            return randomPseudos[new Random().nextInt(randomPseudos.length)];
        }
        return inputName;
    }

    private long getSeed(String inputSeed) {
        if (inputSeed.isBlank()) {
            return new Random().nextLong();
        } else {
            try {
                return Long.parseLong(inputSeed);
            } catch (NumberFormatException ex) {
                long seed = 0;
                for (char c : inputSeed.toCharArray()) {
                    seed += c;
                }
                return seed;
            }
        }
    }
}