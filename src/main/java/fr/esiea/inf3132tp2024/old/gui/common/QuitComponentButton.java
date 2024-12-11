package fr.esiea.inf3132tp2024.old.gui.common;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;

public class QuitComponentButton extends CButton {
    private final DisplayableComponent component;

    public QuitComponentButton(App app, DisplayableComponent component, String text) {
        super(app, text);

        this.component = component;
    }

    public QuitComponentButton(App app, DisplayableComponent component, String text, int length) {
        super(app, text, length);

        this.component = component;
    }

    @Override
    public void execute() {
        this.component.stopLoopingMode();
    }
}
