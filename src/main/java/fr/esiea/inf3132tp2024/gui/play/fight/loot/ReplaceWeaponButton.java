package fr.esiea.inf3132tp2024.gui.play.fight.loot;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.entity.Entity;
import fr.esiea.inf3132tp2024.entity.Player;
import fr.esiea.inf3132tp2024.gui.component.CButton;
import fr.esiea.inf3132tp2024.item.weapon.Weapon;

public class ReplaceWeaponButton extends CButton {
    private final Player player;
    private final Entity enemy;

    public ReplaceWeaponButton(App app, Player player, Entity enemy) {
        super(app, "Échanger les armes");

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
