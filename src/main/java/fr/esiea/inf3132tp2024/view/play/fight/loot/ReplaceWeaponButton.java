package fr.esiea.inf3132tp2024.view.play.fight.loot;

import fr.esiea.inf3132tp2024.model.entity.Entity;
import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.weapon.Weapon;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class ReplaceWeaponButton extends TButton {
    private final Player player;
    private final Entity enemy;

    public ReplaceWeaponButton(Player player, Entity enemy) {
        super("Échanger les armes");

        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void execute() {
        Weapon playerWeapon = player.getWeapon();
        player.setWeapon(enemy.getWeapon());
        enemy.setWeapon(playerWeapon);
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getEnemy() {
        return enemy;
    }
}
