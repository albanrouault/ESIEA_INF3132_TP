package fr.esiea.inf3132tp2024.view.main.menu.information;

import fr.esiea.inf3132tp2024.model.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

public class InfoMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public InfoMenu() {
        super(0, 0, "Informations");

        TChoices choices = new TChoices(1);

        choices.add(new EntityButton());
        choices.add(new CommandButton());
        choices.add(new CreditButton());
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

