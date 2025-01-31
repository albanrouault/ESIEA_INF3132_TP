package fr.esiea.inf3132tp2024.view.play.consumable;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;

public class ConsumableItemMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public ConsumableItemMenu(Terrain terrain, Consumable consumable, Monster[] monsters) {
        super(0, 0, "Utiliser " + consumable.getName());

        TLabel label = new TLabel("Sur quelle entité voulez-vous utiliser " + consumable.getName() + " ?");
        this.getContentPane().getComponents().add(label);

        TChoices choices = new TChoices(1);
        for (Monster monster : monsters) {
            choices.add(new ConsumeItemButton(this, consumable, terrain, monster));
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
