package fr.esiea.inf3132tp2024.view.console.play.fight.loot;

import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.item.weapon.Weapon;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

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
