package fr.esiea.inf3132tp2024.view.play.game;

import fr.esiea.inf3132tp2024.model.Game;
import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.play.PlayerStats;
import fr.esiea.inf3132tp2024.view.play.escape.EscapeMenu;
import fr.esiea.inf3132tp2024.view.play.finish.FinishMenu;

public class GameView extends TFrame implements DisplayableComponent {
    private final Game game;
    private final AudioTrack gameAudioTrack;
    private boolean display = true;

    // Composants graphiques
    private final PlayerStats playerOneStats;
    private final PlayerStats playerTwoStats;
    private final TChoices gameActions;
    private final TPanel leftPanel;
    private final TPanel centerPanel;
    private final TPanel rightPanel;

    public GameView(Game game) {
        super(0, 0);
        this.game = game;

        // Configuration du header
        TPanel header = new TPanel(0, 1);
        TLabel title = new TLabel("Partie");
        header.getComponents().add(title);
        this.setHeader(header);

        // Configuration du contentPane
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);
        this.getContentPane().setRenderingMainPadding(false);

        // Panel gauche - Stats Joueur 1
        this.leftPanel = new TPanel(0, 0);
        this.playerOneStats = new PlayerStats(game.getPlayerOne());
        leftPanel.getComponents().add(playerOneStats);

        // Panel central - Actions du jeu
        this.centerPanel = new TPanel(0, 0);
        this.gameActions = new TChoices(Orientation.VERTICAL, 1);
        updateGameActions();
        centerPanel.getComponents().add(gameActions);

        // Panel droit - Stats Joueur 2
        this.rightPanel = new TPanel(0, 0);
        this.playerTwoStats = new PlayerStats(game.getPlayerTwo());
        rightPanel.getComponents().add(playerTwoStats);

        // Ajout des panels au contentPane
        this.getContentPane().getComponents().add(leftPanel);
        this.getContentPane().getComponents().add(centerPanel);
        this.getContentPane().getComponents().add(rightPanel);

        // Configuration du footer
        TPanel footer = new TPanel(0, 1);
        footer.getComponents().add(new TLabel("Échap - Menu de pause"));
        this.setFooter(footer);

        // Configuration audio
        this.gameAudioTrack = AudioPlayer.getInstance().createAudioTrack(Music.GAME);
        gameAudioTrack.setLoop(true);
        gameAudioTrack.play();
    }

    private void updateGameActions() {
        gameActions.removeAll();
        gameActions.add(new NextRoundButton());
        gameActions.autoResize();
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (event.getKey() == 27) { // Échap
            Terminal.getInstance().show(new EscapeMenu(this));
            return;
        }
        super.onKeyPressed(event);
        gameActions.onKeyPressed(event);
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public boolean isInLoopingMode() {
        if (game.getPlayerOne().hasLost() || game.getPlayerTwo().hasLost()) {
            stopLoopingMode();
            Terminal.getInstance().show(new FinishMenu(this, false));
        }
        return display;
    }

    @Override
    public void stopLoopingMode() {
        display = false;
        gameAudioTrack.stop();
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        int contentWidth = length - 2;
        leftPanel.setLength(contentWidth / 3);
        centerPanel.setLength(contentWidth / 3);
        rightPanel.setLength(contentWidth / 3);
        gameActions.setLength(contentWidth / 3);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        int contentHeight = height - 2;
        leftPanel.setHeight(contentHeight);
        centerPanel.setHeight(contentHeight);
        rightPanel.setHeight(contentHeight);
    }

    // Méthodes d'actions
    private void startFight() { /* Implémentation combat */ }

    private void openInventory() { /* Implémentation inventaire */ }

    private void switchMonster() { /* Implémentation changement monstre */ }

    public Game getGame() {
        return game;
    }
}
