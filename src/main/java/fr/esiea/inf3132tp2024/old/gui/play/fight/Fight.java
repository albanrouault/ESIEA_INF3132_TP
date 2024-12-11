package fr.esiea.inf3132tp2024.old.gui.play.fight;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.audio.Music;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.entity.enemy.Enemy;
import fr.esiea.inf3132tp2024.old.game.EntityDeadException;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.old.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.old.gui.component.CChoices;
import fr.esiea.inf3132tp2024.old.gui.component.CFrame;
import fr.esiea.inf3132tp2024.old.gui.component.CLabel;
import fr.esiea.inf3132tp2024.old.gui.component.CPanel;
import fr.esiea.inf3132tp2024.old.gui.play.EntityStats;
import fr.esiea.inf3132tp2024.old.gui.play.fight.loot.LootMenu;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.old.utils.audio.SimpleAudioPlayer;
import fr.esiea.inf3132tp2024.old.utils.direction.Orientation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Fight extends CFrame implements DisplayableComponent {
    private static final int ACCURACY = 30;

    private final App app;
    private final Player player;
    private final Entity enemy;
    private final boolean runAway;
    private final Random random;
    private State state = State.FIGHTING;
    private SimpleAudioPlayer audioPlayer;
    private boolean display = true;
    private boolean over = false;

    private final CPanel leftPanel;
    private final EntityStats playerStats;
    private final CPanel centerPanel;
    private final CChoices menu;
    private final CPanel rightPanel;
    private final EntityStats enemyStats;
    private final CLabel logs;

    private EntityStats petStats;

    public Fight(App app, Player player, Entity enemy, boolean runAway) {
        super(0, 0, "Combat");

        this.app = app;
        this.player = player;
        this.enemy = enemy;
        this.runAway = runAway;
        this.random = new Random();

        this.getContentPane().setRenderingMainPadding(false);
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);

        this.leftPanel = new CPanel(0, 0);

        this.playerStats = new EntityStats(player, Orientation.VERTICAL);
        leftPanel.getComponents().add(playerStats);

        this.getContentPane().getComponents().add(leftPanel);

        this.centerPanel = new CPanel(20, 0);

        this.menu = new CChoices(app, 1);
        updateMenuButtons();

        centerPanel.getComponents().add(menu);
        this.getContentPane().getComponents().add(centerPanel);

        this.rightPanel = new CPanel(0, 0);
        this.enemyStats = new EntityStats(enemy, Orientation.VERTICAL);
        rightPanel.getComponents().add(enemyStats);
        this.getContentPane().getComponents().add(rightPanel);

        CPanel footer = new CPanel(0, 0, Orientation.HORIZONTAL, false);

        this.logs = new CLabel("");
        logs.setHeight(0);
        footer.getComponents().add(logs);

        this.setFooter(footer);

        try {
            this.audioPlayer = app.createAudioPlayer(Music.FIGHT);
            audioPlayer.setVolume(app.getSettings().getMusicVolume());
            audioPlayer.setLoop(true);
            audioPlayer.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                 IllegalArgumentException ignored) {
        }
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
                        app.getCurrentGame().getStatistic().addAEnemyKill();
                    }

                    // On affiche le menu de butin
                    if (enemy.hasWeapon() || enemy.hasItem()) {
                        menu.getComponents().clear();
                        menu.getComponents().add(new CLabel("Appuyez sur\nune touche\npour le pilier..."));
                        menu.setHeight(3);
                        state = State.LOOTING;
                    } else {
                        // Quitter le combat
                        menu.getComponents().clear();
                        menu.getComponents().add(new CLabel("Appuyez sur\nune touche\npour continuer..."));
                        menu.setHeight(3);
                        state = State.FINISHED;
                    }
                } else {
                    // Quitter le combat
                    menu.getComponents().clear();
                    menu.getComponents().add(new CLabel("Appuyez sur\nune touche\npour continuer..."));
                    menu.setHeight(3);
                    state = State.FINISHED;
                }
            } else if (state.equals(State.LOOTING)) {
                app.getConsole().show(new LootMenu(app, player, enemy));
                playerStats.update();
                enemyStats.update();
                // Quitter le combat
                menu.getComponents().clear();
                menu.getComponents().add(new CLabel("Appuyez sur\nune touche\npour continuer..."));
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
        if (audioPlayer != null) {
            audioPlayer.stop();
        }
    }

    public void updateMenuButtons() {
        menu.removeAll();
        menu.add(new AttackButton(app, this));
        if (player.hasItem() && player.getItem() instanceof Consumable consumable) {
            List<Entity> fightEntities = new LinkedList<>();
            if (!enemy.isDead()) {
                fightEntities.add(enemy);
            }
            if (!player.isDead()) {
                fightEntities.add(player);
            }
            menu.add(new UseItemButton(app, this, consumable, fightEntities));
        }
        if (runAway) {
            menu.add(new QuitComponentButton(app, this, "Fuir"));
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
            } catch (EntityDeadException e) {
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

    private enum State {
        FIGHTING,
        LOOTING,
        FINISHED
    }
}
