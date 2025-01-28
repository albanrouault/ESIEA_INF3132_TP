package fr.esiea.inf3132tp2024.view.console.play.escape.cheat;

import fr.esiea.inf3132tp2024.old.audio.Music;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.old.item.weapon.Weapon;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.api.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.console.api.dialog.ErrorDialog;
import fr.esiea.inf3132tp2024.view.console.api.dialog.InfoDialog;
import fr.esiea.inf3132tp2024.view.console.play.escape.EscapeMenu;

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
                Console.getInstance().show(new InfoDialog(DialogType.INFO, "Vous avez activé une exception !"));
                throw new RuntimeException("Oups!");
            }
            case ("777") -> {
                player.setWeapon(new Weapon("Damoclès", "L'épée ultime pour tricheur !", 35, 20, 20));
                Console.getInstance().show(new InfoDialog(DialogType.INFO, "Vous avez reçu l'épée de Damoclès !"));
            }
            case ("42") -> {
                player.heal(player.getMaxHealth());
                Console.getInstance().show(new InfoDialog(DialogType.INFO, "Vous avez activé le cheat de récupération de vie !"));
            }
            case ("666") -> {
                player.kill();
                Console.getInstance().show(new InfoDialog(DialogType.INFO, "Il y a parfois des courageux!\n \nMais il faut croire que vous n'en n'êtes pas un."));
                escapeMenu.stopLoopingMode();
            }
            default -> {
                Console.getInstance().show(new ErrorDialog(DialogType.WARNING, "Code de triche invalide !"));
                return;
            }
        }
        game.getStatistic().activeCheat();
        menu.stopLoopingMode();
    }
}
