package fr.esiea.inf3132tp2024.view.play.escape.cheat;

import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.controller.game.Game;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.weapon.Weapon;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TErrorDialog;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TInfoDialog;
import fr.esiea.inf3132tp2024.view.play.escape.EscapeMenu;

public class ActivateCheatButton extends TButton {
    private final CheatMenu menu;
    private final Game game;
    private final EscapeMenu escapeMenu;

    public ActivateCheatButton(CheatMenu menu, Game game, EscapeMenu escapeMenu) {
        super("Activer le code de triche");

        this.menu = menu;
        this.game = game;
        this.escapeMenu = escapeMenu;
    }

    @Override
    public void execute() {
        String cheatCode = menu.getCheatCodeField().getText();
        Player player = game.getPlayer();

        switch (cheatCode) {
            case ("404") -> {
                AudioPlayer audioPlayer = AudioPlayer.getInstance();
                audioPlayer.stopAllPlayers();
                AudioTrack audioTrack = audioPlayer.createAudioTrack(Music.CHEAT);
                audioTrack.play();
                Terminal.getInstance().show(new TInfoDialog(DialogType.INFO, "Vous avez activé une exception !"));
                throw new RuntimeException("Oups!");
            }
            case ("777") -> {
                player.setWeapon(new Weapon("Damoclès", "L'épée ultime pour tricheur !", 35, 20, 20));
                Terminal.getInstance().show(new TInfoDialog(DialogType.INFO, "Vous avez reçu l'épée de Damoclès !"));
            }
            case ("42") -> {
                player.heal(player.getMaxHealth());
                Terminal.getInstance().show(new TInfoDialog(DialogType.INFO, "Vous avez activé le cheat de récupération de vie !"));
            }
            case ("666") -> {
                player.kill();
                Terminal.getInstance().show(new TInfoDialog(DialogType.INFO, "Il y a parfois des courageux!\n \nMais il faut croire que vous n'en n'êtes pas un."));
                escapeMenu.stopLoopingMode();
            }
            default -> {
                Terminal.getInstance().show(new TErrorDialog(DialogType.WARNING, "Code de triche invalide !"));
                return;
            }
        }
        game.getStatistic().activeCheat();
        menu.stopLoopingMode();
    }
}
