package fr.esiea.inf3132tp2024.view.play.item.consumable;

import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

import java.util.List;

public class ConsumableItemMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public ConsumableItemMenu(Consumable consumable, List<Entity> entities) {
        super(0, 0, "Utiliser " + ((Item) consumable).getName());

        Item item = (Item) consumable;

        TLabel label = new TLabel("Sur quelle entité voulez-vous utiliser " + item.getName() + " ?");
        this.getContentPane().getComponents().add(label);

        TChoices choices = new TChoices(1);
        for (Entity entity : entities) {
            choices.add(new ConsumeItemButton(this, item, entity));
        }

        choices.add(new TQuitComponentButton(this, "Retour"));

        this.getContentPane().getComponents().add(choices);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    public void stopLoopingMode() {
        display = false;
    }
}
