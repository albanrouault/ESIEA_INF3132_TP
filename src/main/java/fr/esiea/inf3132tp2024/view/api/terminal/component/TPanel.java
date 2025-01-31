package fr.esiea.inf3132tp2024.view.api.terminal.component;

import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyListener;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.utils.Couple;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TPanel extends TComponent implements KeyListener {
    private final List<TComponent> components = new LinkedList<>();

    private final int spacing;
    private Orientation renderOrientation;
    private boolean renderMainPadding;

    public TPanel(int length, int height) {
        this(HorizontalAlignment.CENTER, length, height);
    }

    public TPanel(HorizontalAlignment horizontalAlignment, int length, int height) {
        this(horizontalAlignment, length, height, Orientation.VERTICAL, true);
    }

    public TPanel(int length, int height, Orientation renderOrientation, boolean renderMainPadding) {
        this(HorizontalAlignment.CENTER, length, height, renderOrientation, renderMainPadding);
    }

    public TPanel(HorizontalAlignment horizontalAlignment, int length, int height, Orientation renderOrientation, boolean renderMainPadding) {
        this(horizontalAlignment, length, height, renderOrientation, renderMainPadding, -1);
    }

    public TPanel(HorizontalAlignment horizontalAlignment, Orientation renderOrientation, int spacing) {
        this(horizontalAlignment, 0, 0, renderOrientation, false, spacing);
    }

    public TPanel(HorizontalAlignment horizontalAlignment, int length, int height, Orientation renderOrientation, int spacing) {
        this(horizontalAlignment, length, height, renderOrientation, false, spacing);
    }

    private TPanel(HorizontalAlignment horizontalAlignment, int length, int height, Orientation renderOrientation, boolean renderMainPadding, int spacing) {
        super(horizontalAlignment, length, height);

        this.renderOrientation = renderOrientation;
        this.renderMainPadding = renderMainPadding;
        this.spacing = spacing;
    }

    // TODO Faire le rendu en fonction de l'alignement horizontal
    @Override
    public String[] render() {
        String[] result = new String[this.getHeight()];

        switch (renderOrientation) {
            case VERTICAL -> {
                int linePointer = 0;
                String emptyLine = " ".repeat(this.getLength());

                int contentLines = 0;
                for (TComponent component : this.getComponents()) {
                    contentLines += component.getHeight();
                }

                // Lignes du panel - lignes de texte au milieu
                int paddingHeight = this.getHeight() - contentLines;
                int paddingNb = this.getComponents().size() - 1;
                if (renderMainPadding) {
                    paddingNb += 2;
                }

                Iterator<TComponent> componentsIterator = this.getComponents().iterator();
                mainLoop:
                for (int i = 0; componentsIterator.hasNext(); i++) {
                    TComponent component = componentsIterator.next();

                    // Espace de padding
                    // + 1 pour le padding automatique (bourrage) de fin
                    if (i != 0 || renderMainPadding) {
                        for (int j = 0; j < paddingHeight / paddingNb; j++) {
                            result[linePointer++] = emptyLine;
                        }
                    }

                    int componentLength = component.getLength();
                    if (componentLength > this.getLength()) {
                        component.setLength(this.getLength());
                    }

                    // Rendu du composant
                    for (String componentLine : component.render()) {
                        int paddingLength = this.getLength() - component.getLength();
                        String line = "";
                        if (paddingLength > 0) {
                            line += " ".repeat(paddingLength / 2);
                        }
                        line += componentLine;
                        if (paddingLength > 0) {
                            line += " ".repeat(paddingLength / 2 + paddingLength % 2);
                        }

                        if (linePointer < result.length) {
                            result[linePointer++] = line;
                        } else {
                            break mainLoop;
                        }
                    }

                    component.setLength(componentLength);
                }

                // Bourrage à la fin
                for (; linePointer < result.length; linePointer++) {
                    result[linePointer] = emptyLine;
                }
            }
            case HORIZONTAL -> {
                LinkedList<Couple<TComponent, String[]>> componentsLines = new LinkedList<>();
                int contentLength = 0;
                for (TComponent component : this.getComponents()) {
                    String[] render = component.render();
                    if (component.getHeight() < 1 || component.getLength() < 1) {
                        continue;
                    }
                    if (contentLength + component.getLength() > this.getLength()) {
                        break;
                    }
                    componentsLines.add(new Couple<>(component, render));
                    contentLength += component.getLength();
                }

                // Colonnes du panel - Colonnes du texte au milieu
                int paddingLength = this.getLength() - contentLength;
                int paddingNb = componentsLines.size() - 1;
                if (renderMainPadding) {
                    paddingNb += 2;
                }

                // Pour chaque ligne
                for (int i = 0; i < result.length; i++) {
                    StringBuilder line = new StringBuilder();
                    int lineLength = 0;

                    // Espace de padding
                    if (renderMainPadding) {
                        for (int j = 0; j < paddingLength / paddingNb; j++) {
                            line.append(' ');
                            lineLength++;
                        }
                    }

                    // Rendu des composants
                    Iterator<Couple<TComponent, String[]>> iterator = componentsLines.iterator();
                    for (int j = 0; iterator.hasNext(); j++) {
                        Couple<TComponent, String[]> renderedComponent = iterator.next();
                        int componentLength = renderedComponent.getElemOne().getLength();
                        String[] componentLines = renderedComponent.getElemTwo();
                        if (i < componentLines.length) {
                            line.append(componentLines[i]);
                        } else {
                            line.append(" ".repeat(componentLength));
                        }
                        lineLength += componentLength;

                        // Espace de padding
                        if (j == componentsLines.size() - 1) {
                            continue;
                        }
                        for (int k = 0; k < paddingLength / paddingNb; k++) {
                            line.append(' ');
                            lineLength++;
                        }
                    }

                    // Espace de padding (bourrage de fin de ligne)
                    line.append(" ".repeat(this.getLength() - lineLength));

                    result[i] = line.toString();
                }
            }
        }

        return result;
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        for (TComponent component : this.getComponents()) {
            if (component instanceof KeyListener componentListener) {
                componentListener.onKeyPressed(event);
            }
        }
    }

    public void autoResize() {
        switch (renderOrientation) {
            case VERTICAL -> {
                // Calcul de la hauteur
                int height = 0;
                for (TComponent component : components) {
                    height += component.getHeight();
                }
                if (components.size() != 0 && spacing > 0) {
                    height += (components.size() - 1) * spacing;
                }
                this.setHeight(height);

                // Calcul de la longueur
                int length = 0;
                for (TComponent component : components) {
                    if (component.getLength() > length) {
                        length = component.getLength();
                    }
                }
                this.setLength(length);
            }
            case HORIZONTAL -> {
                // Calcul de la hauteur
                this.setHeight(1);

                // Calcul de la longueur
                int length = 0;
                for (TComponent component : components) {
                    length += component.getLength();
                }
                if (components.size() != 0 && spacing > 0) {
                    length += (components.size() - 1) * spacing;
                }
                this.setLength(length);
            }
        }
    }

    public List<TComponent> getComponents() {
        return components;
    }

    public Orientation getRenderingOrientation() {
        return renderOrientation;
    }

    public void setRenderingOrientation(Orientation renderOrientation) {
        this.renderOrientation = renderOrientation;
    }

    public boolean isRenderingMainPadding() {
        return renderMainPadding;
    }

    public void setRenderingMainPadding(boolean renderMainPadding) {
        this.renderMainPadding = renderMainPadding;
    }
}
