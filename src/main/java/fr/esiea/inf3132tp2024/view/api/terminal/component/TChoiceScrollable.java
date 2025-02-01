package fr.esiea.inf3132tp2024.view.api.terminal.component;

import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.common.component.SelectableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.utils.direction.Direction;
import fr.esiea.inf3132tp2024.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.utils.direction.DirectionUtils;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import java.util.ArrayList;
import java.util.List;

public class TChoiceScrollable extends TChoices {
    // Index du premier élément affiché dans la "fenêtre"
    private int origin = 0;
    // Liste complète de tous les éléments ajoutés
    private final List<SelectableComponent> allItems = new ArrayList<>();

    /**
     * Constructeur qui désactive le wrap-around en passant false pour edgeJump.
     */
    public TChoiceScrollable(int spacing) {
        // On utilise Orientation verticale, un espacement de 1 et on désactive le wrap (edgeJump = false)
        super(Orientation.VERTICAL, spacing, false);
    }

    /**
     * On surcharge add() pour conserver tous les éléments dans allItems
     * en plus de les ajouter via le comportement classique.
     */
    @Override
    public void add(SelectableComponent selectableComponent) {
        allItems.add(selectableComponent);
        super.add(selectableComponent);
    }

    /**
     * On surcharge onKeyPressed pour empêcher le wrap-around.
     * Si l'on est en haut et qu'on appuie sur TOP/LEFT, ou en bas et qu'on appuie sur BOTTOM/RIGHT,
     * on ne fait rien.
     */
    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (!isSelected()) {
            return;
        }

        // Déterminer l'index de l'élément actuellement sélectionné dans allItems
        int selectedIndex = 0;
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).isSelected()) {
                selectedIndex = i;
                break;
            }
        }

        try {
            Direction direction = DirectionUtils.parseDirection(event.getKey(), false);
            // Si on est tout en haut et qu'on essaie de monter, on ne fait rien
            if ((direction.equals(Direction.TOP) || direction.equals(Direction.LEFT)) && selectedIndex == 0) {
                return;
            }
            // Si on est tout en bas et qu'on essaie de descendre, on ne fait rien
            if ((direction.equals(Direction.BOTTOM) || direction.equals(Direction.RIGHT))
                    && selectedIndex == allItems.size() - 1) {
                return;
            }
        } catch (DirectionNotFoundException e) {
            // Si la direction n'est pas reconnue, on ignore
        }

        // Dans les autres cas, on laisse TChoices gérer le déplacement de la sélection
        super.onKeyPressed(event);
    }

    /**
     * On surcharge le render pour n’afficher qu’une partie de la liste en fonction de la sélection.
     * La fenêtre visible se décale d’un élément à chaque changement de sélection.
     */
    @Override
    public String[] render() {
        // Estimation de la hauteur disponible.
        // Par exemple, on suppose que getHeight() retourne le nombre total de lignes,
        // et on retire 2 lignes pour des marges.
        int availableHeight = this.getHeight() - 2;
        // On estime qu’un composant occupe environ 3 lignes (à ajuster si nécessaire)
        int itemHeight = 3;
        int visibleCount = availableHeight / itemHeight;
        if (visibleCount < 1) {
            visibleCount = 1;
        }

        // Déterminer l'index de l'élément actuellement sélectionné
        int selectedIndex = 0;
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).isSelected()) {
                selectedIndex = i;
                break;
            }
        }

        // Pour un défilement "pas à pas", on positionne l'origine sur l'élément sélectionné.
        origin = selectedIndex;

        // On ajuste l'origine si elle dépasse la limite basse,
        // afin que visibleCount éléments puissent être affichés.
        if (origin > allItems.size() - visibleCount) {
            origin = Math.max(0, allItems.size() - visibleCount);
        }

        // On vide la liste des composants actuellement affichés
        this.getComponents().clear();

        // On ajoute uniquement les composants dans la fenêtre visible
        for (int i = origin; i < Math.min(origin + visibleCount, allItems.size()); i++) {
            this.getComponents().add((TComponent) allItems.get(i));
        }

        // On appelle ensuite le render du parent pour finaliser l'affichage
        return super.render();
    }
}
