package fr.esiea.inf3132tp2024.game;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.audio.Music;
import fr.esiea.inf3132tp2024.entity.Player;
import fr.esiea.inf3132tp2024.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.gui.component.CFrame;
import fr.esiea.inf3132tp2024.gui.component.CLabel;
import fr.esiea.inf3132tp2024.gui.component.CPanel;
import fr.esiea.inf3132tp2024.gui.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.gui.play.EntityStats;
import fr.esiea.inf3132tp2024.gui.play.escape.EscapeMenu;
import fr.esiea.inf3132tp2024.gui.play.finish.FinishMenu;
import fr.esiea.inf3132tp2024.utils.StringUtils;
import fr.esiea.inf3132tp2024.utils.audio.SimpleAudioPlayer;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Game extends CFrame implements DisplayableComponent {
    private final App app;
    private final long seed;
    private final Player player;
    private final CLabel stageLevelLabel;
    private final CLabel blockNameLabel;
    private final EntityStats playerStats;
    private final CPanel otherInfos;
    private String infos;
    private SimpleAudioPlayer audioPlayer;
    private boolean display = true;
    private final Statistic statistic;

    public Game(App app, long seed, String playerName) {
        super(0, 0);

        this.app = app;

        this.seed = seed;

        this.player = new Player(app, playerName);

        //this.getContentPane().getComponents().add(map);

        CPanel header = new CPanel(0, 1, Orientation.HORIZONTAL, false);
        this.stageLevelLabel = new CLabel(HorizontalAlignment.LEFT, "Étage 1");
        header.getComponents().add(stageLevelLabel);
        CLabel title = new CLabel("Partie");
        header.getComponents().add(title);
        this.blockNameLabel = new CLabel(HorizontalAlignment.RIGHT, " ");
        header.getComponents().add(blockNameLabel);
        this.setHeader(header);

        CPanel footer = new CPanel(0, 4, Orientation.HORIZONTAL, false);

        this.playerStats = new EntityStats(player, Orientation.HORIZONTAL);
        playerStats.setHeight(4);
        footer.getComponents().add(playerStats);

        this.otherInfos = new CPanel(0, 4, Orientation.VERTICAL, false);
        this.infos = "Échap - Menu de pause";
        CLabel otherInfosLabel = new CLabel(infos);
        this.otherInfos.getComponents().add(new CLabel(""));
        this.otherInfos.getComponents().add(otherInfosLabel);
        footer.getComponents().add(otherInfos);

        this.setFooter(footer);

        try {
            this.audioPlayer = app.createAudioPlayer(Music.GAME);
            audioPlayer.setVolume(app.getSettings().getMusicVolume());
            audioPlayer.setLoop(true);
            audioPlayer.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                 IllegalArgumentException ignored) {
        }

        this.statistic = new Statistic(seed, playerName);
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        // Touche échap = on ouvre le menu de pause
        if (event.getKey() == 27) {
            app.getConsole().show(new EscapeMenu(app, this));
            return;
        }

        // On transmet la touche appuyée aux composants dans cette fenêtre
        super.onKeyPressed(event);

        // Touche espace =
        if (event.getKey() == 32) {

        }
    }

    @Override
    public boolean isInLoopingMode() {
        // Si le joueur est mort, on arrête le jeu
        if (player.isDead()) {
            stopLoopingMode();

            SimpleAudioPlayer deathAudioPlayer = null;
            try {
                deathAudioPlayer = app.createAudioPlayer(Music.DEATH);
                deathAudioPlayer.setVolume(app.getSettings().getMusicVolume());
                deathAudioPlayer.setLoop(true);
                deathAudioPlayer.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                     IllegalArgumentException ignored) {
            }
            app.getConsole().show(new FinishMenu(app, this, false));
            if (deathAudioPlayer != null) {
                deathAudioPlayer.stop();
            }
        }

        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public void stopLoopingMode() {
        display = false;
        if (audioPlayer != null) {
            audioPlayer.stop();
        }
    }

    @Override
    public String[] render() {
        // Actualisation du header
        int headerFreeLength = this.getLength() - "Partie".length() - 2;
        this.stageLevelLabel.setLength(headerFreeLength / 2);
        this.blockNameLabel.setLength(headerFreeLength / 2 + headerFreeLength % 2);

        this.stageLevelLabel.setText(" ");

        // Actualisation du nom du block en haut à droite
        this.blockNameLabel.setText(" ");

        // Actualisation du texte d'informations en bas à droite
        String[] infosTable = StringUtils.convertStringToStringArray(infos);
        if (infosTable.length > 1) {
            infos = infosTable[infosTable.length - 1];
        }

        // Actualisation du footer
        int footerStatsLength = this.getContentPane().getLength();

        this.getFooter().getComponents().clear();
        this.playerStats.setLength(footerStatsLength / 2);
        this.getFooter().getComponents().add(this.playerStats);

        this.otherInfos.getComponents().clear();
        this.otherInfos.getComponents().add(new CLabel(""));

        this.otherInfos.getComponents().add(new CLabel(infos, footerStatsLength / 2));
        this.otherInfos.setLength(footerStatsLength / 2);
        this.getFooter().getComponents().add(this.otherInfos);

        return super.render();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);

        //this.map.setHeight(this.getContentPane().getHeight());
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);

        //this.map.setLength(this.getContentPane().getLength());
    }

    public long getSeed() {
        return seed;
    }

    public Player getPlayer() {
        return player;
    }

    public SimpleAudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public Statistic getStatistic() {
        return statistic;
    }
}
