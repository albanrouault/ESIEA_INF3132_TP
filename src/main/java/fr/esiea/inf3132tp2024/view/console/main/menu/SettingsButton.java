package fr.esiea.inf3132tp2024.view.console.main.menu;

import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.settings.menu.SettingsMenu;

public class SettingsButton extends TButton {
    private final AudioTrack menuAudioTrack;

    public SettingsButton(AudioTrack menuAudioTrack) {
        super("Paramètres");

        this.menuAudioTrack = menuAudioTrack;
    }

    @Override
    public void execute() {
        Console.getInstance().show(new SettingsMenu(menuAudioTrack));
    }
}
