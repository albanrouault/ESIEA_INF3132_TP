package fr.esiea.inf3132tp2024.view.console.component.common;

import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class QuitComponentButton extends TButton {
    private final DisplayableComponent component;

    public QuitComponentButton(DisplayableComponent component, String text) {
        super(text);

        this.component = component;
    }

    public QuitComponentButton(DisplayableComponent component, String text, int length) {
        super(text, length);

        this.component = component;
    }

    @Override
    public void execute() {
        this.component.stopLoopingMode();
    }
}
