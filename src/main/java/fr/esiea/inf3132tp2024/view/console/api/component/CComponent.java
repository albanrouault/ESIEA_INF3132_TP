package fr.esiea.inf3132tp2024.view.console.api.component;

import fr.esiea.inf3132tp2024.utils.StringUtils;

public abstract class CComponent {
    private HorizontalAlignment horizontalAlignment;
    private int length;
    private int height;

    public CComponent(HorizontalAlignment horizontalAlignment, int length, int height) {
        this.horizontalAlignment = horizontalAlignment;
        this.length = length;
        this.height = height;
    }

    public abstract String[] render();

    public HorizontalAlignment getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return StringUtils.convertStringArrayToString(render());
    }
}
