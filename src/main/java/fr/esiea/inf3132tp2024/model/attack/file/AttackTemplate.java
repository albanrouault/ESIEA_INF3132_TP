package fr.esiea.inf3132tp2024.model.attack.file;

import fr.esiea.inf3132tp2024.model.Types;
import java.util.Random;

public class AttackTemplate {
    private String name;
    private Types type;
    private int minPower;
    private int maxPower;
    private int minNbUse;
    private int maxNbUse;
    private float minFail;
    private float maxFail;

    public AttackTemplate(String[][] customProperties) throws AttackTemplateException {
        for (String[] property : customProperties) {
            // Vérifier que le tableau contient au moins le nom de la propriété et une valeur
            if (property.length < 2) {
                throw new AttackTemplateException("La propriété '" 
                        + (property.length > 0 ? property[0] : "inconnue")
                        + "' doit contenir au moins un nom et une valeur.");
            }
            String propertyName = property[0].trim();
            switch (propertyName.toLowerCase()) {
                case "name":
                    this.name = property[1].trim();
                    break;
                case "type":
                    String typeStr = property[1].trim().toUpperCase();
                    // Vérifier que le type existe dans l'énumération Types
                    boolean exists = false;
                    for (Types t : Types.values()) {
                        if (t.name().equals(typeStr)) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        // Construire la liste des types disponibles
                        StringBuilder availableTypes = new StringBuilder();
                        for (Types t : Types.values()) {
                            availableTypes.append(t.name()).append(", ");
                        }
                        if (availableTypes.length() > 0) {
                            availableTypes.setLength(availableTypes.length() - 2); // Supprimer la dernière virgule et l'espace
                        }
                        throw new AttackTemplateException("Type invalide pour l'attaque : " + property[1] +
                                ". Les types disponibles sont : " + availableTypes.toString());
                    }
                    this.type = Types.valueOf(typeStr);
                    break;
                case "power":
                    try {
                        if (property.length < 3) {
                            this.minPower = Integer.parseInt(property[1].trim());
                            this.maxPower = this.minPower;
                        } else {
                            this.minPower = Integer.parseInt(property[1].trim());
                            this.maxPower = Integer.parseInt(property[2].trim());
                            if (this.minPower > this.maxPower) {
                                throw new AttackTemplateException("La puissance minimale (" + this.minPower +
                                        ") ne peut pas être supérieure à la puissance maximale (" + this.maxPower + ").");
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new AttackTemplateException("Format invalide pour power : " + property[1], e);
                    }
                    break;
                case "nbuse":
                    try {
                        if (property.length < 3) {
                            this.minNbUse = Integer.parseInt(property[1].trim());
                            this.maxNbUse = this.minNbUse;
                        } else {
                            this.minNbUse = Integer.parseInt(property[1].trim());
                            this.maxNbUse = Integer.parseInt(property[2].trim());
                            if (this.minNbUse > this.maxNbUse) {
                                throw new AttackTemplateException("Le nombre d'utilisations minimal (" + this.minNbUse +
                                        ") ne peut pas être supérieur au nombre d'utilisations maximal (" + this.maxNbUse + ").");
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new AttackTemplateException("Format invalide pour nbuse : " + property[1], e);
                    }
                    break;
                case "fail":
                    try {
                        if (property.length < 3) {
                            this.minFail = Float.parseFloat(property[1].trim());
                            this.maxFail = this.minFail;
                        } else {
                            this.minFail = Float.parseFloat(property[1].trim());
                            this.maxFail = Float.parseFloat(property[2].trim());
                            if (this.minFail > this.maxFail) {
                                throw new AttackTemplateException("Le taux d'échec minimal (" + this.minFail +
                                        ") ne peut pas être supérieur au taux d'échec maximal (" + this.maxFail + ").");
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new AttackTemplateException("Format invalide pour fail : " + property[1], e);
                    }
                    break;
                default:
                    // Vous pouvez gérer d'autres propriétés personnalisées ici si besoin.
                    break;
            }
        }
    }

    // Getters et méthodes pour obtenir des valeurs aléatoires

    public String getName() {
        return name;
    }

    public Types getType() {
        return type;
    }

    public int getMinPower() {
        return minPower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getRandomPower(Random random) {
        return random.nextInt(maxPower - minPower + 1) + minPower;
    }

    public int getMinNbUse() {
        return minNbUse;
    }

    public int getMaxNbUse() {
        return maxNbUse;
    }

    public int getRandomNbUse(Random random) {
        return random.nextInt(maxNbUse - minNbUse + 1) + minNbUse;
    }

    public float getMinFail() {
        return minFail;
    }

    public float getMaxFail() {
        return maxFail;
    }

    public float getRandomMaxFail(Random random) {
        return random.nextFloat() * (maxFail - minFail) + minFail;
    }
}
