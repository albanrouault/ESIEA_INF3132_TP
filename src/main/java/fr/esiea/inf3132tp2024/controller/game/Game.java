package fr.esiea.inf3132tp2024.controller.game;

import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.utils.StringUtils;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.play.PlayerStats;
import fr.esiea.inf3132tp2024.view.play.escape.EscapeMenu;
import fr.esiea.inf3132tp2024.view.play.finish.FinishMenu;

public class Game extends TFrame implements DisplayableComponent {
    private final long seed;
    private final Player playerOne;
    private final Player playerTwo;
    private final Terrain terrain;

    private String infos;
    private AudioTrack gameAudioTrack;

    // Éléments graphiques
    private boolean display = true;
    private final TLabel stageLevelLabel;
    private final TLabel blockNameLabel;
    private final PlayerStats playerOneStats;
    private final PlayerStats playerTwoStats;
    private final TPanel otherInfos;
    private final GameStatistic gameStatistic;

    public Game(long seed, Player playerOne, Player playerTwo) {
        super(0, 0);

        this.seed = seed;

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        this.terrain = new Terrain();

        //this.getContentPane().getComponents().add(map);

        TPanel header = new TPanel(0, 1, Orientation.HORIZONTAL, false);
        this.stageLevelLabel = new TLabel(HorizontalAlignment.LEFT, "Étage 1");
        header.getComponents().add(stageLevelLabel);
        TLabel title = new TLabel("Partie");
        header.getComponents().add(title);
        this.blockNameLabel = new TLabel(HorizontalAlignment.RIGHT, " ");
        header.getComponents().add(blockNameLabel);
        this.setHeader(header);

        TPanel footer = new TPanel(0, 4, Orientation.HORIZONTAL, false);

        this.playerOneStats = new PlayerStats(playerOne, Orientation.HORIZONTAL);
        playerOneStats.setHeight(1);
        footer.getComponents().add(playerOneStats);

        this.playerTwoStats = new PlayerStats(playerTwo, Orientation.HORIZONTAL);
        playerTwoStats.setHeight(1);
        footer.getComponents().add(playerTwoStats);

        this.otherInfos = new TPanel(0, 4, Orientation.VERTICAL, false);
        this.infos = "Échap - Menu de pause";
        TLabel otherInfosLabel = new TLabel(infos);
        this.otherInfos.getComponents().add(new TLabel(""));
        this.otherInfos.getComponents().add(otherInfosLabel);
        footer.getComponents().add(otherInfos);

        this.setFooter(footer);

        this.gameAudioTrack = AudioPlayer.getInstance().createAudioTrack(Music.GAME);
        gameAudioTrack.setLoop(true);
        gameAudioTrack.play();

        this.gameStatistic = new GameStatistic(seed, playerOne.getName(), playerTwo.getName());
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        // Touche échap = on ouvre le menu de pause
        if (event.getKey() == 27) {
            Terminal.getInstance().show(new EscapeMenu(this));
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
        if (playerOne.hasLost() || playerTwo.hasLost()) {
            stopLoopingMode();

            AudioTrack deathAudioTrack = AudioPlayer.getInstance().createAudioTrack(Music.DEATH);
            deathAudioTrack.setLoop(true);
            deathAudioTrack.play();
            Terminal.getInstance().show(new FinishMenu(this, false));
            deathAudioTrack.stop();
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
        if (gameAudioTrack != null) {
            gameAudioTrack.stop();
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
        this.getFooter().getComponents().add(new TLabel(""));

        this.otherInfos.getComponents().clear();
        this.otherInfos.getComponents().add(new TLabel(""));

        this.otherInfos.getComponents().add(new TLabel(infos, footerStatsLength / 2));
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

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public AudioTrack getGameAudioTrack() {
        return gameAudioTrack;
    }

    public GameStatistic getStatistic() {
        return gameStatistic;
    }
}
