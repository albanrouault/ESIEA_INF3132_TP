package fr.esiea.inf3132tp2024.gui.main.menu.information;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.component.CChoices;
import fr.esiea.inf3132tp2024.gui.component.CFrame;

public class InfoMenu extends CFrame implements DisplayableComponent {
    private boolean display = true;

    public InfoMenu(App app) {
        super(0, 0, "Informations");

        CChoices choices = new CChoices(app, 1);

        choices.add(new EntityButton(app));
        choices.add(new CommandButton(app));
        choices.add(new CreditButton(app));
        choices.add(new QuitComponentButton(app, this, "Retour"));

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

