package fr.esiea.inf3132tp2024.view.main.menu;

import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.main.menu.settings.menu.SettingsMenu;

public class SettingsButton extends TButton {
    private final AudioTrack menuAudioTrack;

    public SettingsButton(AudioTrack menuAudioTrack) {
        super("Paramètres");

        this.menuAudioTrack = menuAudioTrack;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new SettingsMenu(menuAudioTrack));
    }
}
