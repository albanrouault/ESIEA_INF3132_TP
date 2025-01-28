package fr.esiea.inf3132tp2024.view.api.terminal.component;

import fr.esiea.inf3132tp2024.old.event.key.KeyListener;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.api.common.component.SelectableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.utils.direction.Direction;
import fr.esiea.inf3132tp2024.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.utils.direction.DirectionUtils;

public class TSlider extends TProgressBar implements SelectableComponent, KeyListener {
    private boolean selected = false;

    public TSlider(int length, int height, int value, int maxValue, String text) {
        this(length, height, value, 0, maxValue, text);
    }

    public TSlider(int length, int height, int value, int minValue, int maxValue, String text) {
        super(length, height, value, minValue, maxValue, text);

        this.getTextColors().add(TColor.BLACK);
        this.getProgressedColors().add(TColor.BRIGHT_BLACK);
        this.getUnProgressedColors().add(TColor.WHITE);
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (!isSelected()) {
            return;
        }

        try {
            Direction direction = DirectionUtils.parseDirection(event.getKey(), false);
            int value = getValue();
            switch (direction) {
                case LEFT -> {
                    int minValue = getMinValue();
                    value--;
                    if (value < minValue) {
                        return;
                    }
                    setValue(value);
                }
                case RIGHT -> {
                    int maxValue = getMaxValue();
                    value++;
                    if (value > maxValue) {
                        return;
                    }
                    setValue(value);
                }
            }
        } catch (DirectionNotFoundException ignored) {
        }
    }

    @Override
    public String[] render() {
        if (isSelected()) {
            if (!this.getProgressedColors().contains(TColor.YELLOW)) {
                this.getProgressedColors().add(TColor.YELLOW);
            }
            if (!this.getUnProgressedColors().contains(TColor.BRIGHT_YELLOW)) {
                this.getUnProgressedColors().add(TColor.BRIGHT_YELLOW);
            }
        } else {
            this.getProgressedColors().remove(TColor.YELLOW);
            this.getUnProgressedColors().remove(TColor.BRIGHT_YELLOW);
        }

        return super.render();
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
