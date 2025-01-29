package fr.esiea.inf3132tp2024.view.play.fight.loot;

import fr.esiea.inf3132tp2024.model.entity.Entity;
import fr.esiea.inf3132tp2024.model.entity.Player;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class TakeWeaponButton extends TButton {
    private final Player player;
    private final Entity enemy;
    private final LootMenu lootMenu;

    public TakeWeaponButton(Player player, Entity enemy, LootMenu lootMenu) {
        super("Prendre l'arme");

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
