package fr.esiea.inf3132tp2024.view.play.escape.cheat;

import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TErrorDialog;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TInfoDialog;
import fr.esiea.inf3132tp2024.view.play.escape.EscapeMenu;
import fr.esiea.inf3132tp2024.view.play.game.GameView;

public class ActivateCheatButton extends TButton {
    private final CheatMenu menu;
    private final GameView gameView;
    private final EscapeMenu escapeMenu;

    public ActivateCheatButton(CheatMenu menu, GameView gameView, EscapeMenu escapeMenu) {
        super("Activer le code de triche");

        this.menu = menu;
        this.gameView = gameView;
        this.escapeMenu = escapeMenu;
    }

    @Override
    public void execute() {
        String cheatCode = menu.getCheatCodeField().getText();

        switch (cheatCode) {
            case ("123") -> {
                Terminal.getInstance().show(new TInfoDialog(DialogType.INFO, "Vous avez activé un code de triche !"));
            }
            case ("404") -> {
                AudioPlayer audioPlayer = AudioPlayer.getInstance();
                audioPlayer.stopAllPlayers();
                AudioTrack audioTrack = audioPlayer.createAudioTrack(Music.CHEAT);
                audioTrack.play();
                Terminal.getInstance().show(new TInfoDialog(DialogType.INFO, "Vous avez activé une exception !"));
                throw new RuntimeException("Oups!");
            }
            default -> {
                Terminal.getInstance().show(new TErrorDialog(DialogType.WARNING, "Code de triche invalide !"));
                return;
            }
        }
        gameView.getGame().getGameStatistic().activeCheat();
        menu.stopLoopingMode();
    }
}
