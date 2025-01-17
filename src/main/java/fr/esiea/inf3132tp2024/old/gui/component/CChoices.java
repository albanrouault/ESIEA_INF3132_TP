package fr.esiea.inf3132tp2024.old.gui.component;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.audio.SoundEffect;
import fr.esiea.inf3132tp2024.old.event.key.KeyListener;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.old.utils.audio.SimpleAudioPlayer;
import fr.esiea.inf3132tp2024.old.utils.direction.Direction;
import fr.esiea.inf3132tp2024.old.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.old.utils.direction.DirectionUtils;
import fr.esiea.inf3132tp2024.old.utils.direction.Orientation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CChoices extends CPanel implements SelectableComponent, KeyListener {
    private final App app;
    private final List<SelectableComponent> selectableComponents = new ArrayList<>();
    private final boolean edgeJump;

    private boolean selected = true;

    public CChoices(App app) {
        this(app, 0);
    }

    public CChoices(App app, int spacing) {
        this(app, Orientation.VERTICAL, spacing);
    }

    public CChoices(App app, Orientation orientation, int spacing) {
        this(app, orientation, spacing, true);
    }

    public CChoices(App app, Orientation orientation, int spacing, boolean edgeJump) {
        super(HorizontalAlignment.CENTER, orientation, spacing);

        this.app = app;
        this.edgeJump = edgeJump;
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (!isSelected()) {
            return;
        }

        for (SelectableComponent selectableComponent : selectableComponents) {
            if (selectableComponent.isSelected() && selectableComponent instanceof KeyListener keyListener) {
                keyListener.onKeyPressed(event);
                break;
            }
        }

        if (selectableComponents.size() < 2) {
            return;
        }

        try {
            Direction direction = DirectionUtils.parseDirection(event.getKey(), false);
            switch (this.getRenderingOrientation()) {
                case VERTICAL -> {
                    if (direction.equals(Direction.LEFT) || direction.equals(Direction.RIGHT)) {
                        return;
                    }
                }
                case HORIZONTAL -> {
                    if (direction.equals(Direction.TOP) || direction.equals(Direction.BOTTOM)) {
                        return;
                    }
                }
            }
            switch (direction) {
                case TOP, LEFT -> {
                    for (int i = 0; i < selectableComponents.size(); i++) {
                        SelectableComponent components = selectableComponents.get(i);
                        if (components.isSelected()) {
                            components.setSelected(false);
                            if (i == 0) {
                                if (edgeJump) {
                                    selectableComponents.get(selectableComponents.size() - 1).setSelected(true);
                                } else {
                                    selectableComponents.get(i).setSelected(true);
                                }
                            } else {
                                selectableComponents.get(i - 1).setSelected(true);
                            }
                            break;
                        }
                    }
                }
                case BOTTOM, RIGHT -> {
                    for (int i = 0; i < selectableComponents.size(); i++) {
                        SelectableComponent components = selectableComponents.get(i);
                        if (components.isSelected()) {
                            components.setSelected(false);
                            if (i == selectableComponents.size() - 1) {
                                if (edgeJump) {
                                    selectableComponents.get(0).setSelected(true);
                                } else {
                                    selectableComponents.get(i).setSelected(true);
                                }
                            } else {
                                selectableComponents.get(i + 1).setSelected(true);
                            }
                            break;
                        }
                    }
                }
            }
            try {
                SimpleAudioPlayer audioPlayer = app.createAudioPlayer(SoundEffect.HOVER);
                audioPlayer.setVolume(app.getSettings().getSoundEffectsVolume());
                audioPlayer.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                     IllegalArgumentException ignored) {
            }
        } catch (DirectionNotFoundException ignored) {
        }
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            if (selectableComponents.isEmpty()) {
                return;
            }
            selectableComponents.get(0).setSelected(true);
        } else {
            for (SelectableComponent component : selectableComponents) {
                component.setSelected(false);
            }
        }
    }

    public SelectableComponent getSelectedComponent() {
        for (SelectableComponent component : selectableComponents) {
            if (component.isSelected()) {
                return component;
            }
        }
        return null;
    }

    public void select(SelectableComponent selectableComponent) {
        if (!selectableComponents.contains(selectableComponent)) {
            return;
        }

        for (SelectableComponent comp : selectableComponents) {
            if (selectableComponent == comp) {
                comp.setSelected(true);
            } else {
                comp.setSelected(false);
            }
        }
    }

    public void add(SelectableComponent selectableComponent) {
        if (isSelected()) {
            if (selectableComponents.isEmpty()) {
                selectableComponent.setSelected(true);
            } else {
                selectableComponent.setSelected(false);
            }
        }
        selectableComponents.add(selectableComponent);
        CComponent component = (CComponent) selectableComponent;
        this.getComponents().add(component);
        this.autoResize();
    }

    public void addAfter(SelectableComponent selectableComponent, SelectableComponent after) {
        if (!selectableComponents.contains(after)) {
            return;
        }
        int index = selectableComponents.indexOf(after);
        selectableComponents.add(index + 1, selectableComponent);
        CComponent component = (CComponent) selectableComponent;
        index = this.getComponents().indexOf((CComponent) after);
        this.getComponents().add(index + 1, component);
        this.autoResize();
    }

    public void replace(SelectableComponent selectableComponent, SelectableComponent newSelectableComponent) {
        if (!selectableComponents.contains(selectableComponent)) {
            return;
        }
        int index = selectableComponents.indexOf(selectableComponent);
        selectableComponents.set(index, newSelectableComponent);
        CComponent component = (CComponent) newSelectableComponent;
        this.getComponents().set(index, component);
        this.autoResize();
    }

    public void remove(SelectableComponent selectableComponent) {
        if (selectableComponents.contains(selectableComponent)) {
            selectableComponents.remove(selectableComponent);
            CComponent component = (CComponent) selectableComponent;
            this.getComponents().remove(component);
        }
        this.autoResize();
    }

    public void removeAll() {
        for (SelectableComponent component : selectableComponents) {
            this.getComponents().remove((CComponent) component);
        }
        selectableComponents.clear();
    }
}
