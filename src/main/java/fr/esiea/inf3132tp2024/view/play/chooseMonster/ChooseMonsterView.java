package fr.esiea.inf3132tp2024.view.play.chooseMonster;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.play.game.GameView;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;

/**
 * Vue de sélection du monstre qui doit combattre.
 * Cette vue est accessible depuis la GameView via un bouton.
 */
public class ChooseMonsterView extends TFrame implements DisplayableComponent {
    private final GameView gameView;
    private final TPanel monstersPanel;
    private final Player currentPlayer;
    private boolean display = true;

    /**
     * Constructeur de la vue de sélection du monstre.
     *
     * @param gameView la vue de la partie en cours à laquelle on revient après la sélection
     */
    public ChooseMonsterView(GameView gameView, Player currentPlayer) {
        super(0, 0, "Choisir un monstre");
        this.gameView = gameView;
        this.currentPlayer = currentPlayer;

        // Initialisation du panneau vertical pour lister les monstres disponibles
        monstersPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);

        // Récupérer le joueur courant à partir de la GameView
        // On suppose que la méthode getCurrentPlayer() existe dans la classe Game.
        // Pour chaque monstre non vaincu, créer un bouton de sélection
        for (Monster monster : currentPlayer.getMonsters()) {
            if (monster.isAlive()) {
                MonsterButton b = new MonsterButton(monster);
                monstersPanel.getComponents().add(b);
            }
        }
        // Ajout du panneau au content pane
        this.getContentPane().getComponents().add(monstersPanel);
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public void stopLoopingMode() {
        display = false;
    }

    /**
     * Bouton interne représentant un monstre sélectionnable.
     */
    private class MonsterButton extends TButton {
        private final Monster monster;

        public MonsterButton(Monster monster) {
            // Le texte du bouton affiche le nom et quelques stats (ATQ/VIT/DEF)
            super(monster.getName() + " | ATQ:" + monster.getAttack() + " VIT:" + monster.getSpeed() + " DEF:" + monster.getDefense());
            this.monster = monster;
        }

        @Override
        public void execute() {
            // Lors de la sélection, on informe la GameView du choix effectué.
            // On suppose que GameView dispose d'une méthode selectMonster(Monster monster)
            currentPlayer.setCurrentMonster(monster);

            // Retour à la GameView
            Terminal.getInstance().show(gameView);

            // Arrêter le mode looping pour clore cette vue
            stopLoopingMode();
        }
    }
}
