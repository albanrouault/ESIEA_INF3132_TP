package fr.esiea.inf3132tp2024.old.gui.play.escape.cheat;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.audio.Music;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.dialog.DialogType;
import fr.esiea.inf3132tp2024.old.gui.dialog.ErrorDialog;
import fr.esiea.inf3132tp2024.old.gui.dialog.InfoDialog;
import fr.esiea.inf3132tp2024.old.gui.play.escape.EscapeMenu;
import fr.esiea.inf3132tp2024.old.item.weapon.Weapon;
import fr.esiea.inf3132tp2024.old.utils.audio.SimpleAudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ActivateCheatButton extends CButton {
    private final App app;
    private final CheatMenu menu;
    private final Game game;
    private final EscapeMenu escapeMenu;

    public ActivateCheatButton(App app, CheatMenu menu, Game game, EscapeMenu escapeMenu) {
        super(app, "Activer le code de triche");

        this.app = app;
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
                app.stopAllPlayers();
                try {
                    SimpleAudioPlayer audioPlayer = app.createAudioPlayer(Music.CHEAT);
                    audioPlayer.setVolume(app.getSettings().getMusicVolume());
                    audioPlayer.play();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                         IllegalArgumentException ignored) {
                }
                app.getConsole().show(new InfoDialog(DialogType.INFO, "Vous avez activé une exception !"));
                throw new RuntimeException("Oups!");
            }
            case ("777") -> {
                player.setWeapon(new Weapon("Damoclès", "L'épée ultime pour tricheur !", 35, 20, 20));
                app.getConsole().show(new InfoDialog(DialogType.INFO, "Vous avez reçu l'épée de Damoclès !"));
            }
            case ("42") -> {
                player.heal(player.getMaxHealth());
                app.getConsole().show(new InfoDialog(DialogType.INFO, "Vous avez activé le cheat de récupération de vie !"));
            }
            case ("666") -> {
                player.kill();
                app.getConsole().show(new InfoDialog(DialogType.INFO, "Il y a parfois des courageux!\n \nMais il faut croire que vous n'en n'êtes pas un."));
                escapeMenu.stopLoopingMode();
            }
            default -> {
                app.getConsole().show(new ErrorDialog(DialogType.WARNING, "Code de triche invalide !"));
                return;
            }
        }
        game.getStatistic().activeCheat();
        menu.stopLoopingMode();
    }
}
