package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.FightState;
import fr.esiea.inf3132tp2024.model.Game;
import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterDeadException;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.play.MonsterStats;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Fight extends TFrame implements DisplayableComponent {
    private final Random random;
    private final Game game;
    private final Terrain terrain;
    private final Player playerOne;
    private final Player playerTwo;
    private Monster monsterPlayerOne;
    private Monster monsterPlayerTwo;
    private FightState state = FightState.STARTING;
    private AudioTrack fightAudioTrack;
    private boolean display = true;
    private boolean over = false;

    // Éléments graphiques
    private final TPanel leftPanel;
    private final MonsterStats playerStats;
    private final TPanel centerPanel;
    private final TChoices menu;
    private final TPanel rightPanel;
    private final MonsterStats enemyStats;
    private final TLabel logs;

    public Fight(Game game) {
        super(0, 0, "Combat");

        this.game = game;
        this.terrain = game.getTerrain();
        this.playerOne = game.getPlayerOne();
        this.playerTwo = game.getPlayerTwo();
        this.random = game.getRandom();

        this.getContentPane().setRenderingMainPadding(false);
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);

        this.leftPanel = new TPanel(0, 0);

        this.playerStats = new MonsterStats(player, Orientation.VERTICAL);
        leftPanel.getComponents().add(playerStats);

        this.getContentPane().getComponents().add(leftPanel);

        this.centerPanel = new TPanel(20, 0);

        this.menu = new TChoices(1);
        updateMenuButtons();

        centerPanel.getComponents().add(menu);
        this.getContentPane().getComponents().add(centerPanel);

        this.rightPanel = new TPanel(0, 0);
        this.enemyStats = new MonsterStats(enemy, Orientation.VERTICAL);
        rightPanel.getComponents().add(enemyStats);
        this.getContentPane().getComponents().add(rightPanel);

        TPanel footer = new TPanel(0, 0, Orientation.HORIZONTAL, false);

        this.logs = new TLabel("");
        logs.setHeight(0);
        footer.getComponents().add(logs);

        this.setFooter(footer);

        this.fightAudioTrack = AudioPlayer.getInstance().createAudioTrack(Music.FIGHT);
        fightAudioTrack.setLoop(true);
        fightAudioTrack.play();
    }

    @Override
    public boolean isInLoopingMode() {
        if (state.equals(State.FINISHED)) {
            stopLoopingMode();
        } else
            // On vérifie si le combat est terminé
            if (state.equals(State.FIGHTING) && (player.isDead() || enemy.isDead())) {
                over = true;
                // Si l'ennemi est mort
                if (enemy.isDead()) {
                    // On actualise les stats du joueur
                    if (enemy instanceof Enemy) {
                        game.getStatistic().addAEnemyKill();
                    }

                    // Quitter le combat
                    menu.getComponents().clear();
                    menu.getComponents().add(new TLabel("Appuyez sur\nune touche\npour continuer..."));
                    menu.setHeight(3);
                    state = State.FINISHED;
                } else {
                    // Quitter le combat
                    menu.getComponents().clear();
                    menu.getComponents().add(new TLabel("Appuyez sur\nune touche\npour continuer..."));
                    menu.setHeight(3);
                    state = State.FINISHED;
                }
            } else if (state.equals(State.LOOTING)) {
                Terminal.getInstance().show(new LootMenu(player, enemy));
                playerStats.update();
                enemyStats.update();
                // Quitter le combat
                menu.getComponents().clear();
                menu.getComponents().add(new TLabel("Appuyez sur\nune touche\npour continuer..."));
                menu.setHeight(3);
                state = State.FINISHED;
            }

        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    public boolean isOver() {
        return over;
    }

    @Override
    public void stopLoopingMode() {
        display = false;
        if (fightAudioTrack != null) {
            fightAudioTrack.stop();
        }
    }

    public void updateMenuButtons() {
        menu.removeAll();
        menu.add(new AttackButton(this));
        if (player.hasItem() && player.getConsumable() instanceof Consumable consumable) {
            List<Entity> fightEntities = new LinkedList<>();
            if (!enemy.isDead()) {
                fightEntities.add(enemy);
            }
            if (!player.isDead()) {
                fightEntities.add(player);
            }
            menu.add(new UseItemButton(this, consumable, fightEntities));
        }
        menu.setLength(20);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        int statsLength = this.getContentPane().getLength() - this.menu.getLength() - 2;
        this.leftPanel.setLength(statsLength / 2);
        this.playerStats.setLength(statsLength / 2);
        if (this.petStats != null) {
            this.petStats.setLength(statsLength / 2);
        }
        this.rightPanel.setLength(statsLength / 2);
        this.enemyStats.setLength(statsLength / 2);
        this.logs.setLength(this.getContentPane().getLength());
    }

    @Override
    public void setHeight(int height) {
        this.getFooter().setHeight(this.logs.getHeight());
        super.setHeight(height);
        this.leftPanel.setHeight(this.getContentPane().getHeight());
        this.centerPanel.setHeight(this.getContentPane().getHeight());
        this.rightPanel.setHeight(this.getContentPane().getHeight());
    }

    public void attack() {
        List<String> logs = new LinkedList<>();

        // Les entités s'attaquent
        attackWithoutPet(logs);

        // On affiche les logs du combat
        this.logs.setHeight(logs.size());
        StringBuilder text = new StringBuilder();
        for (String log : logs) {
            text.append("\n").append(log);
        }
        this.logs.setText(text.toString().replaceFirst("\n", ""));
        this.setHeight(this.getHeight());

        // On actualise les stats
        playerStats.update();
        enemyStats.update();
        if (petStats != null) {
            petStats.update();
        }
    }

    private void attackWithoutPet(List<String> logs) {
        // Si le joueur est le premier à attaquer
        if (player.getSpeed() >= enemy.getSpeed()) {
            // Le joueur attaque l'ennemi
            if (attack(logs, player, enemy)) return;

            // L'ennemi attaque le joueur
            attack(logs, enemy, player);

            // Sinon si l'ennemi est le premier à attaquer
        } else {
            // L'ennemi attaque le joueur
            if (attack(logs, enemy, player)) return;

            // Le joueur attaque l'ennemie
            attack(logs, player, enemy);
        }
    }

    /**
     * Méthode qui permet à une entité d'attaquer une autre entité.
     *
     * @param logs     Les logs
     * @param attacker L'entité qui attaque
     * @param attacked L'entité attaquée
     * @return true si le combat est fini, false sinon
     */
    private boolean attack(List<String> logs, Entity attacker, Entity attacked) {
        if (attacked.isDead() || attacker.isDead()) {
            return attacked == player || attacked == enemy;
        }
        if (canAttack(attacker)) {
            if (attacker == player) {
                logs.add("Vous avez infligé " + attacker.getStrength() + " dégâts à " + attacked.getName() + ".");
            } else if (attacked == player) {
                logs.add(attacker.getName() + " vous a infligé " + attacker.getStrength() + " dégâts.");
            } else {
                logs.add(attacker.getName() + " a infligé " + attacker.getStrength() + " dégâts à " + attacked.getName() + ".");
            }

            try {
                attacked.damage(attacker.getStrength());
            } catch (MonsterDeadException e) {
                if (attacker == player) {
                    logs.add("Vous avez tué " + attacked.getName() + ".");
                } else if (attacked == player) {
                    logs.add(attacker.getName() + " vous a tué.");
                } else {
                    logs.add(attacker.getName() + " a tué " + attacked.getName() + ".");
                }
                return attacked == player || attacked == enemy;
            }
        } else {
            if (attacker == player) {
                logs.add("Vous avez raté votre attaque.");
            } else {
                logs.add(attacker.getName() + " a raté son attaque.");
            }
        }
        return false;
    }

    private boolean canAttack(Entity entity) {
        return random.nextInt(0, ACCURACY) < entity.getAccuracy();
    }
}
