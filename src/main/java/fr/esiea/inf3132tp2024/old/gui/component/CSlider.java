package fr.esiea.inf3132tp2024.old.gui.component;

import fr.esiea.inf3132tp2024.old.event.key.KeyListener;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.old.gui.CColor;
import fr.esiea.inf3132tp2024.old.utils.direction.Direction;
import fr.esiea.inf3132tp2024.old.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.old.utils.direction.DirectionUtils;

public class CSlider extends CProgressBar implements SelectableComponent, KeyListener {
    private boolean selected = false;

    public CSlider(int length, int height, int value, int maxValue, String text) {
        this(length, height, value, 0, maxValue, text);
    }

    public CSlider(int length, int height, int value, int minValue, int maxValue, String text) {
        super(length, height, value, minValue, maxValue, text);

        this.getTextColors().add(CColor.BLACK);
        this.getProgressedColors().add(CColor.BRIGHT_BLACK);
        this.getUnProgressedColors().add(CColor.WHITE);
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
            if (!this.getProgressedColors().contains(CColor.YELLOW)) {
                this.getProgressedColors().add(CColor.YELLOW);
            }
            if (!this.getUnProgressedColors().contains(CColor.BRIGHT_YELLOW)) {
                this.getUnProgressedColors().add(CColor.BRIGHT_YELLOW);
            }
        } else {
            this.getProgressedColors().remove(CColor.YELLOW);
            this.getUnProgressedColors().remove(CColor.BRIGHT_YELLOW);
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
