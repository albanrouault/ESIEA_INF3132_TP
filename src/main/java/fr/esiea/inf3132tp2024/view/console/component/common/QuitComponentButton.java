package fr.esiea.inf3132tp2024.view.console.component.common;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;

public class QuitComponentButton extends TButton {
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
