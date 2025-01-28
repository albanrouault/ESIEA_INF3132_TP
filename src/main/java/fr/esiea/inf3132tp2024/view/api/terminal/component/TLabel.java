package fr.esiea.inf3132tp2024.view.api.terminal.component;

import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class TLabel extends TComponent {
    private final List<TColor> colors = new LinkedList<>();
    private String[] textLines;

    public TLabel(String text) {
        this(HorizontalAlignment.CENTER, text);
    }

    public TLabel(HorizontalAlignment horizontalAlignment, String text) {
        this(horizontalAlignment, StringUtils.convertStringToStringArray(text), StringUtils.getMaximumLength(StringUtils.convertStringToStringArray(text)), StringUtils.convertStringToStringArray(text).length);
    }

    public TLabel(String text, int length) {
        this(HorizontalAlignment.CENTER, text, length);
    }

    public TLabel(HorizontalAlignment horizontalAlignment, String text, int length) {
        this(horizontalAlignment, formatLines(StringUtils.convertStringToStringArray(text), length), length, formatLines(StringUtils.convertStringToStringArray(text), length).length);
    }

    public TLabel(String text, int length, int height) {
        this(HorizontalAlignment.CENTER, text, length, height);
    }

    public TLabel(HorizontalAlignment horizontalAlignment, String text, int length, int height) {
        this(horizontalAlignment, StringUtils.convertStringToStringArray(text), length, height);
    }

    public TLabel(String[] lines) {
        this(HorizontalAlignment.CENTER, lines);
    }

    public TLabel(HorizontalAlignment horizontalAlignment, String[] lines) {
        this(horizontalAlignment, lines, StringUtils.getMaximumLength(lines), lines.length);
    }

    public TLabel(String[] lines, int length) {
        this(HorizontalAlignment.CENTER, lines, length);
    }

    public TLabel(HorizontalAlignment horizontalAlignment, String[] lines, int length) {
        this(horizontalAlignment, formatLines(lines, length), length, formatLines(lines, length).length);
    }

    public TLabel(String[] lines, int length, int height) {
        this(HorizontalAlignment.CENTER, lines, length, height);
    }

    public TLabel(HorizontalAlignment horizontalAlignment, String[] lines, int length, int height) {
        super(horizontalAlignment, length, height);

        this.textLines = lines;
    }

    private static String[] formatLines(String[] lines, int length) {
        List<String> linesFormatted = new LinkedList<>();

        for (String line : lines) {
            boolean first = true;
            while (line.length() > length) {
                first = false;
                linesFormatted.add(line.substring(0, length));
                line = line.substring(length);
            }

            if (!line.isEmpty()) {
                if (!first) {
                    line = line + " ".repeat(length - line.length());
                }
                linesFormatted.add(line);
            }
        }

        return linesFormatted.toArray(String[]::new);
    }

    @Override
    public String[] render() {
        String[] result = new String[this.getHeight()];
        int linePointer = 0;
        String emptyLine = " ".repeat(this.getLength());

        // Lignes de la console - lignes de texte au milieu
        int paddingHeight = this.getHeight() - textLines.length;
        for (int i = 0; i < paddingHeight / 2; i++) {
            result[linePointer++] = emptyLine;
        }
        for (String textLine : textLines) {
            if (textLine.length() > this.getLength()) {
                textLine = textLine.substring(0, this.getLength());
            } else if (textLine.length() < this.getLength()) {
                switch (this.getHorizontalAlignment()) {
                    case LEFT -> textLine += " ".repeat(this.getLength() - textLine.length());
                    case CENTER -> textLine = StringUtils.centerString(textLine, ' ', this.getLength());
                    case RIGHT -> textLine = " ".repeat(this.getLength() - textLine.length()) + textLine;
                }
            }

            for (TColor color : colors) {
                textLine = color.getForeground() + textLine + color.getForegroundReset();
            }

            if (linePointer < result.length) {
                result[linePointer++] = textLine;
            } else {
                break;
            }
        }

        // Bourrage à la fin
        for (; linePointer < result.length; linePointer++) {
            result[linePointer] = emptyLine;
        }

        return result;
    }

    public List<TColor> getColors() {
        return colors;
    }

    public String getText() {
        return StringUtils.convertStringArrayToString(textLines);
    }

    public void setText(String text) {
        this.textLines = StringUtils.convertStringToStringArray(text);
    }

    public void setText(String[] lines) {
        this.textLines = lines;
    }
}
