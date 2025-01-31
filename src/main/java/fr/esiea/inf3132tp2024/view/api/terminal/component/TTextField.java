package fr.esiea.inf3132tp2024.view.api.terminal.component;

import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyListener;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.api.common.component.SelectableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.utils.direction.Direction;
import fr.esiea.inf3132tp2024.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.utils.direction.DirectionUtils;

public class TTextField extends TComponent implements SelectableComponent, KeyListener {
    private boolean selected = true;
    private String text;
    private String hint;
    private int pointer;
    private boolean editable = true;

    public TTextField(int length) {
        this(HorizontalAlignment.CENTER, length);
    }

    public TTextField(HorizontalAlignment horizontalAlignment, int length) {
        this(horizontalAlignment, "", length, null);
    }

    public TTextField(String hint, int length) {
        this(HorizontalAlignment.CENTER, hint, length, null);
    }

    public TTextField(String hint, int length, String text) {
        this(HorizontalAlignment.CENTER, hint, length, text);
    }

    public TTextField(HorizontalAlignment horizontalAlignment, String hint, int length, String text) {
        super(horizontalAlignment, length, 1);

        this.hint = hint;

        if (text != null) {
            this.text = text;
            this.pointer = text.length();
        } else {
            this.text = "";
            this.pointer = 0;
        }
    }

    @Override
    public String[] render() {
        String[] result = new String[this.getHeight()];
        int linePointer = 0;
        String emptyLine = " ".repeat(this.getLength());

        // Lignes de la console - lignes de texte au milieu
        int paddingHeight = this.getHeight() - 1;
        for (int i = 0; i < paddingHeight / 2; i++) {
            result[linePointer++] = emptyLine;
        }

        int finalLength = this.getLength();
        int pointerIndex = pointer;
        if (selected) {
            finalLength--;
        }
        String line = "";

        if (text.isEmpty() && !selected) {
            String hintText = hint;
            if (hintText.length() > finalLength) {
                hintText = hintText.substring(0, finalLength);
            }
            int toFill = finalLength - hintText.length();
            hintText = "" + TColor.BRIGHT_BLACK + TColor.ITALIC + hintText + TColor.ITALIC.getForegroundReset() + TColor.BRIGHT_BLACK.getForegroundReset();
            switch (this.getHorizontalAlignment()) {
                case LEFT -> line = hintText + " ".repeat(toFill);
                case CENTER -> line = " ".repeat(toFill / 2) + hintText + " ".repeat(toFill / 2 + toFill % 2);
                case RIGHT -> line = " ".repeat(toFill) + hintText;
            }
        } else if (text.length() > finalLength) {
            if (pointerIndex > finalLength) {
                line = text.substring(pointerIndex - finalLength, pointerIndex);
                pointerIndex = finalLength;
            } else {
                line = text.substring(0, finalLength);
            }
        } else if (text.length() < finalLength) {
            switch (this.getHorizontalAlignment()) {
                case LEFT -> line = text + " ".repeat(finalLength - text.length());
                case CENTER -> {
                    int padding = (finalLength - text.length()) / 2;
                    line = " ".repeat(padding) + text + " ".repeat(padding + (finalLength - text.length()) % 2);
                    pointerIndex = pointer + padding;
                }
                case RIGHT -> {
                    line = " ".repeat(finalLength - text.length()) + text;
                    pointerIndex = pointer + finalLength - text.length();
                }
            }
        } else {
            line = text;
        }

        if (selected) {
            line = line.substring(0, pointerIndex)
                    + TColor.BLINKING + TColor.REVERSE + " " + TColor.REVERSE.getForegroundReset() + TColor.BLINKING.getForegroundReset()
                    + line.substring(pointerIndex);
        }

        result[linePointer++] = line;

        // Bourrage à la fin
        for (; linePointer < result.length; linePointer++) {
            result[linePointer] = emptyLine;
        }

        return result;
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (!isSelected()) {
            return;
        }

        int key = event.getKey();

        try {
            Direction direction = DirectionUtils.parseDirection(key, false);
            switch (direction) {
                case LEFT -> {
                    if (pointer > 0) {
                        pointer--;
                    }
                }
                case RIGHT -> {
                    if (pointer < text.length()) {
                        pointer++;
                    }
                }
            }
            return;
        } catch (DirectionNotFoundException ignored) {
        }

        if (text.length() > 0) {
            // 8 = backspace ; 127 = DEL
            if ((key == 8 || key == 127) && pointer > 0) {
                String newText = text.substring(0, pointer - 1);
                newText += text.substring(pointer);
                text = newText;
                pointer--;
                // 57427 = suppr
            } else if (key == 57427 && pointer < text.length()) {
                String newText = text.substring(0, pointer);
                newText += text.substring(pointer + 1);
                text = newText;
            }
        }

        // Si caractères spéciaux alors on n'ajoute pas le caractère
        // Source: https://upload.wikimedia.org/wikipedia/commons/1/1b/ASCII-Table-wide.svg
        if (key < 32 || key == 127 || key == 57427) {
            return;
        }

        char character = (char) key;
        String newText = text.substring(0, pointer);
        newText += character;
        newText += text.substring(pointer);
        text = newText;
        pointer++;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.pointer = text.length();
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
