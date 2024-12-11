package fr.esiea.inf3132tp2024.gui.play.fight.loot;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.entity.Entity;
import fr.esiea.inf3132tp2024.entity.Player;
import fr.esiea.inf3132tp2024.gui.component.CButton;

public class TakeWeaponButton extends CButton {
    private final Player player;
    private final Entity enemy;
    private final LootMenu lootMenu;

    public TakeWeaponButton(App app, Player player, Entity enemy, LootMenu lootMenu) {
        super(app, "Prendre l'arme");

        this.player = player;
        this.enemy = enemy;
        this.lootMenu = lootMenu;
    }

    @Override
    public void execute() {
        player.setWeapon(enemy.getWeapon());
        enemy.setWeapon(null);
        lootMenu.getButtons().remove(this);
        lootMenu.getLeaveButton().setSelected(true);
    }

    public Entity getEnemy() {
        return enemy;
    }
}
