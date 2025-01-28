package fr.esiea.inf3132tp2024.view.console.main.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.audio.Music;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.main.menu.information.InfoButton;
import fr.esiea.inf3132tp2024.utils.audio.NativeAudioTrack;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MainMenu extends TFrame implements DisplayableComponent {
    private NativeAudioTrack audioPlayer;
    private boolean display = true;

    public MainMenu(App app) {
        super(0, 0, "Menu principal");

        try {
            this.audioPlayer = app.createAudioPlayer(Music.MENU);
            audioPlayer.setVolume(app.getSettings().getMusicVolume());
            audioPlayer.setLoop(true);
            audioPlayer.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                 IllegalArgumentException ignored) {
        }

        TChoices choices = new TChoices(app, 1);

        choices.add(new PlayButton(app, this));
        choices.add(new StatisticsButton(app, this));
        choices.add(new InfoButton(app));
        choices.add(new SettingsButton(app, audioPlayer));
        choices.add(new QuitComponentButton(app, this, "Quitter"));

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

    public NativeAudioTrack getAudioPlayer() {
        return audioPlayer;
    }
}
