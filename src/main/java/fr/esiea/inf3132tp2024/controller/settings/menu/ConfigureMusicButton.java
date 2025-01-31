package fr.esiea.inf3132tp2024.controller.settings.menu;

import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.controller.settings.audio.music.ConfigureMusicFrame;

public class ConfigureMusicButton extends TButton {
    private final AudioTrack menuAudioTrack;

    public ConfigureMusicButton(AudioTrack menuAudioTrack) {
        super("Configurer le volume de la musique");

        this.menuAudioTrack = menuAudioTrack;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new ConfigureMusicFrame(menuAudioTrack));
    }
}
