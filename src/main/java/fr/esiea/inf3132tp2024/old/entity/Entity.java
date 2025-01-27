package fr.esiea.inf3132tp2024.old.entity;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.game.EntityDeadException;
import fr.esiea.inf3132tp2024.view.console.play.fight.Fight;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.Key;
import fr.esiea.inf3132tp2024.old.item.weapon.Weapon;
import fr.esiea.inf3132tp2024.old.item.wearable.Wearable;
import fr.esiea.inf3132tp2024.utils.audio.SimpleAudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Classe d'une entité
 */
public abstract class Entity {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_STRENGTH = 15;
    private static final int DEFAULT_ACCURACY = 10;
    private static final int DEFAULT_SPEED = 10;

    private final App app;
    private String name;
    private Weapon weapon;
    private Item item;
    private int health = DEFAULT_HEALTH;
    private int maxHealth = DEFAULT_HEALTH;
    private int strength = DEFAULT_STRENGTH;
    private int maxStrength = DEFAULT_STRENGTH;
    private int accuracy = DEFAULT_ACCURACY;
    private int maxAccuracy = DEFAULT_ACCURACY;
    private int speed = DEFAULT_SPEED;
    private int maxSpeed = DEFAULT_SPEED;

    /**
     * Constructeur
     *
     * @param app      L'application
     * @param name     Le nom
     * @param health   La santé
     * @param strength La force
     * @param accuracy La précision
     * @param speed    La rapidité
     */
    public Entity(App app, String name, int health, int strength, int accuracy, int speed) {
        this(app, name);

        this.health = health;
        this.maxHealth = health;
        this.strength = strength;
        this.maxStrength = strength;
        this.accuracy = accuracy;
        this.maxAccuracy = accuracy;
        this.speed = speed;
        this.maxSpeed = speed;
    }

    /**
     * Constructeur
     *
     * @param app  L'application
     * @param name Le nom de l'entité
     */
    public Entity(App app, String name) {
        this.app = app;
        this.name = name;
    }

    /**
     * Méthode permettant d'infliger des points de dégâts à l'entité.
     *
     * @param damagePoints Points de dégâts
     * @throws EntityDeadException Exception levée si l'entité meurt
     */
    public void damage(int damagePoints) throws EntityDeadException {
        if (damagePoints < 0) {
            return;
        }

        this.health -= damagePoints;
        if (this.health <= 0) {
            this.kill();
            throw new EntityDeadException(this, name + " est mort");
        }
    }

    /**
     * Méthode permettant de soigner une entité.
     * La vie ne peut pas dépasser le max de l'entité
     *
     * @param health entier, point de vie supplémentaire
     */
    public void heal(int health) {
        if (health < 0) {
            return;
        }

        if (this.health + health > this.getMaxHealth()) {
            this.health = this.getMaxHealth();
        } else {
            this.health += health;
        }
    }

    /**
     * Méthode permettant de tuer l'entité.
     */
    public void kill() {
        // S'il reste de la vie à l'entité, on la met à 0
        if (this.health > 0) {
            this.health = 0;
        }
    }

    /**
     * Permet de déclencher un combat avec un joueur
     *
     * @param player  Le joueur
     * @param runAway Si le joueur peut fuir le combat
     * @return Le combat terminé
     */
    public Fight fight(Player player, boolean runAway) {
        Fight fight = new Fight(app, player, this, runAway);
        SimpleAudioPlayer gamePlayer = app.getCurrentGame().getAudioPlayer();
        if (gamePlayer != null) {
            gamePlayer.stop();
        }
        app.getConsole().show(fight);
        if (!player.isDead() && gamePlayer != null) {
            try {
                gamePlayer.restart();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ignored) {
            }
        }
        return fight;
    }

    /**
     * Méthode permettant de savoir si l'entité est morte.
     *
     * @return Vrai si l'entité est morte, faux sinon
     */
    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Méthode permettant de récupérer le nom de l'entité.
     *
     * @return Le nom
     */
    public String getName() {
        return name;
    }

    /**
     * Méthode permettant de définir le nom de l'entité.
     *
     * @param name Le nom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Méthode pour vérifier que l'entité possède une arme
     *
     * @return si elle a une arme
     */
    public boolean hasWeapon() {
        return this.weapon != null;
    }

    /**
     * Méthode qui permet de récupérer l'arme de l'entité.
     * <p>
     * Retourne null si l'entité ne possède pas d'arme, null est équivalent aux
     * mains nues
     *
     * @return l'arme
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Méthode qui permet de définir l'arme possédée par l'entité.
     * <p>
     * null est équivalent aux mains nues
     *
     * @param weapon la nouvelle arme
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean hasItem() {
        return this.getItem() != null;
    }

    /**
     * Méthode permettant de récupérer l'item que possède l'entité.
     *
     * @return un Item
     */
    public Item getItem() {
        return item;
    }

    /**
     * Méthode qui permet de définir l'item porté par l'entité
     *
     * @param item un Item
     */
    public void setItem(Item item) {
        if (!(item instanceof Key)) {
            this.item = item;
        }
    }

    /**
     * Méthode permettant de récupérer la santé de l'entité.
     *
     * @return la santé
     */
    public int getHealth() {
        return health;
    }

    /**
     * Méthode permettant de récupérer la force.
     * Retourne 0 si le résultat est inférieur à 0
     *
     * @return la force
     */
    public int getStrength() {
        int totalStrength = this.strength;
        if (this.hasWeapon()) {
            totalStrength += this.getWeapon().getStrength();
        }
        if (this.item instanceof Wearable wearable) {
            totalStrength += wearable.getStrength();
        }
        if (totalStrength < 0) {
            return 0;
        }
        return totalStrength;
    }

    /**
     * Méthode permettant de récupérer la précision.
     * Retourne 0 si le résultat est inférieur à 0
     *
     * @return la précision
     */
    public int getAccuracy() {
        int totalAccuracy = this.accuracy;
        if (this.hasWeapon()) {
            totalAccuracy += this.getWeapon().getAccuracy();
        }
        if (this.item instanceof Wearable wearable) {
            totalAccuracy += wearable.getAccuracy();
        }
        if (totalAccuracy < 0) {
            return 0;
        }
        return totalAccuracy;
    }

    /**
     * Méthode permettant de récupérer la rapidité.
     * Retourne 0 si le résultat est inférieur à 0
     *
     * @return la rapidité
     */
    public int getSpeed() {
        int totalSpeed = this.speed;
        if (this.hasWeapon()) {
            totalSpeed += this.getWeapon().getSpeed();
        }
        if (this.item instanceof Wearable wearable) {
            totalSpeed += wearable.getSpeed();
        }
        if (totalSpeed < 0) {
            return 0;
        }
        return totalSpeed;
    }

    /**
     * Méthode permettant de récupérer la vie maximum de l'entité.
     *
     * @return la vie maximale
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Méthode permettant de récupérer la force maximale de l'entité.
     *
     * @return la force maximale
     */
    public int getMaxStrength() {
        return maxStrength;
    }

    /**
     * Méthode permettant de récupérer la précision maximale de l'entité.
     *
     * @return la précision maximale
     */
    public int getMaxAccuracy() {
        return maxAccuracy;
    }

    /**
     * Méthode permettant de récupérer la rapidité maximale de l'entité.
     *
     * @return la rapidité maximale
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }
}
