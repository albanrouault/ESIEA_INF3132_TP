package fr.esiea.inf3132tp2024.controller.main.menu;

import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.controller.main.menu.information.InfoButton;

public class MainMenu extends TFrame implements DisplayableComponent {
    private final AudioTrack menuAudioTrack;
    private boolean display = true;

    public MainMenu() {
        super(0, 0, "Menu principal");

        this.menuAudioTrack = AudioPlayer.getInstance().createAudioTrack(Music.MENU);
        menuAudioTrack.setLoop(true);
        menuAudioTrack.play();

        TChoices choices = new TChoices(1);

        choices.add(new PlayButton(this));
        choices.add(new StatisticsButton());
        choices.add(new InfoButton());
        choices.add(new SettingsButton(menuAudioTrack));
        choices.add(new TQuitComponentButton(this, "Quitter"));

        this.getContentPane().getComponents().add(choices);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    public void stopLoopingMode() {
        display = false;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    public AudioTrack getMenuAudioTrack() {
        return menuAudioTrack;
    }
}
