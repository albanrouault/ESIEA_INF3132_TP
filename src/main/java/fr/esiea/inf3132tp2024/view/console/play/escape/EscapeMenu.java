package fr.esiea.inf3132tp2024.view.console.play.escape;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TLabel;
import fr.esiea.inf3132tp2024.view.console.api.component.TPanel;
import fr.esiea.inf3132tp2024.view.console.main.menu.information.InfoButton;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;

public class EscapeMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public EscapeMenu(App app, Game game) {
        super(0, 0, "Pause");

        TChoices choices = new TChoices(app, 1);
        choices.add(new QuitComponentButton(app, this, "Reprendre la partie"));
        if (game.getPlayer().hasItem() && game.getPlayer().getItem() instanceof Consumable) {
            choices.add(new UseItemButton(app, this, game.getPlayer()));
        }
        choices.add(new InfoButton(app));
        choices.add(new CheatButton(app, game, this));
        choices.add(new SettingsButton(app, game));
        choices.add(new QuitGameButton(app, this));

        this.getContentPane().getComponents().add(choices);

        TPanel footer = new TPanel(0, 1);
        TLabel seedLabel = new TLabel("Seed : " + game.getSeed());
        footer.getComponents().add(seedLabel);
        this.setFooter(footer);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (event.getKey() == 27) {
            stopLoopingMode();
            return;
        }

        super.onKeyPressed(event);
    }

    public void stopLoopingMode() {
        display = false;
    }
}
