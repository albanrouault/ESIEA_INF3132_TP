package fr.esiea.inf3132tp2024.view.api.terminal;

import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class TQuitComponentButton extends TButton {
    private final DisplayableComponent component;

    public TQuitComponentButton(DisplayableComponent component, String text) {
        super(text);

        this.component = component;
    }

    public TQuitComponentButton(DisplayableComponent component, String text, int length) {
        super(text, length);

        this.component = component;
    }

    @Override
    public void execute() {
        this.component.stopLoopingMode();
    }
}
