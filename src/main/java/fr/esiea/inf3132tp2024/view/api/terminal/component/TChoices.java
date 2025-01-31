package fr.esiea.inf3132tp2024.view.api.terminal.component;

import fr.esiea.inf3132tp2024.model.audio.SoundEffect;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyListener;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.utils.direction.Direction;
import fr.esiea.inf3132tp2024.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.utils.direction.DirectionUtils;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.api.common.component.SelectableComponent;

import java.util.ArrayList;
import java.util.List;

public class TChoices extends TPanel implements SelectableComponent, KeyListener {
    private final List<SelectableComponent> selectableComponents = new ArrayList<>();
    private final boolean edgeJump;

    private boolean selected = true;

    public TChoices() {
        this(0);
    }

    public TChoices(int spacing) {
        this(Orientation.VERTICAL, spacing);
    }

    public TChoices(Orientation orientation, int spacing) {
        this(orientation, spacing, true);
    }

    public TChoices(Orientation orientation, int spacing, boolean edgeJump) {
        super(HorizontalAlignment.CENTER, orientation, spacing);

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

            AudioTrack audioTrack = AudioPlayer.getInstance().createAudioTrack(SoundEffect.HOVER);
            audioTrack.play();
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
        TComponent component = (TComponent) selectableComponent;
        this.getComponents().add(component);
        this.autoResize();
    }

    public void addAfter(SelectableComponent selectableComponent, SelectableComponent after) {
        if (!selectableComponents.contains(after)) {
            return;
        }
        int index = selectableComponents.indexOf(after);
        selectableComponents.add(index + 1, selectableComponent);
        TComponent component = (TComponent) selectableComponent;
        index = this.getComponents().indexOf((TComponent) after);
        this.getComponents().add(index + 1, component);
        this.autoResize();
    }

    public void replace(SelectableComponent selectableComponent, SelectableComponent newSelectableComponent) {
        if (!selectableComponents.contains(selectableComponent)) {
            return;
        }
        int index = selectableComponents.indexOf(selectableComponent);
        selectableComponents.set(index, newSelectableComponent);
        TComponent component = (TComponent) newSelectableComponent;
        this.getComponents().set(index, component);
        this.autoResize();
    }

    public void remove(SelectableComponent selectableComponent) {
        if (selectableComponents.contains(selectableComponent)) {
            selectableComponents.remove(selectableComponent);
            TComponent component = (TComponent) selectableComponent;
            this.getComponents().remove(component);
            // Select the next component if the removed component was selected
            if (selectableComponent.isSelected() && !selectableComponents.isEmpty()) {
                selectableComponents.get(0).setSelected(true);
            }
        }
        this.autoResize();
    }

    public void removeAll() {
        for (SelectableComponent component : selectableComponents) {
            this.getComponents().remove((TComponent) component);
        }
        selectableComponents.clear();
    }
}
