package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.settings.audio.music.ConfigureMusicFrame;

public class ConfigureMusicButton extends TButton {
    private final AudioTrack menuAudioTrack;

    public ConfigureMusicButton(AudioTrack menuAudioTrack) {
        super("Configurer le volume de la musique");

        this.menuAudioTrack = menuAudioTrack;
    }

    @Override
    public void execute() {
        Console.getInstance().show(new ConfigureMusicFrame(menuAudioTrack));
    }
}
