package fr.esiea.inf3132tp2024.model.monster.file;

import fr.esiea.inf3132tp2024.model.Types;
import java.util.HashMap;
import java.util.Random;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplateException;

public class MonsterTemplate {
    private final HashMap<String, String[]> customProperties;

    private String name;
    private Types type;
    private int minHealth;
    private int maxHealth;
    private int minSpeed;
    private int maxSpeed;
    private int minAttack;
    private int maxAttack;
    private int minDefense;
    private int maxDefense;

    public MonsterTemplate(String[][] customProperties) throws MonsterTemplateException {
        this.customProperties = new HashMap<>();

        for (String[] property : customProperties) {
            if (property.length < 2) {
                throw new MonsterTemplateException("La propriété '" + (property.length > 0 ? property[0] : "inconnue")
                        + "' doit contenir au moins un nom et une valeur.");
            }
            String propertyName = property[0].trim();
            switch (propertyName.toLowerCase()) {
                case "name":
                    this.name = property[1].trim();
                    break;
                case "type":
                    String typeStr = property[1].trim().toUpperCase();
                    boolean exists = false;
                    for (Types t : Types.values()) {
                        if (t.name().equals(typeStr)) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        // Construire la liste des types disponibles sous forme de chaîne de caractères
                        StringBuilder availableTypes = new StringBuilder();
                        for (Types t : Types.values()) {
                            availableTypes.append(t.name()).append(", ");
                        }
                        // Supprimer la dernière virgule et espace
                        if (availableTypes.length() > 0) {
                            availableTypes.setLength(availableTypes.length() - 2);
                        }
                        throw new MonsterTemplateException(
                                "Type invalide pour le monstre : " + property[1] +
                                        ". Les types disponibles sont : " + availableTypes.toString());
                    }
                    this.type = Types.valueOf(typeStr);
                    break;
                case "hp":
                    try {
                        if (property.length < 3) {
                            this.minHealth = Integer.parseInt(property[1].trim());
                            this.maxHealth = this.minHealth;
                        } else {
                            this.minHealth = Integer.parseInt(property[1].trim());
                            this.maxHealth = Integer.parseInt(property[2].trim());
                            if (this.minHealth > this.maxHealth) {
                                throw new MonsterTemplateException("La santé minimale (" + this.minHealth
                                        + ") ne peut pas être supérieure à la santé maximale (" + this.maxHealth
                                        + ").");
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new MonsterTemplateException(
                                "Format invalide pour hp, doit être un entier : " + property[1], e);
                    }
                    break;
                case "speed":
                    try {
                        if (property.length < 3) {
                            this.minSpeed = Integer.parseInt(property[1].trim());
                            this.maxSpeed = this.minSpeed;
                        } else {
                            this.minSpeed = Integer.parseInt(property[1].trim());
                            this.maxSpeed = Integer.parseInt(property[2].trim());
                            if (this.minSpeed > this.maxSpeed) {
                                throw new MonsterTemplateException("La vitesse minimale (" + this.minSpeed
                                        + ") ne peut pas être supérieure à la vitesse maximale (" + this.maxSpeed
                                        + ").");
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new MonsterTemplateException(
                                "Format invalide pour speed, doit être un entier : " + property[1], e);
                    }
                    break;
                case "attack":
                    try {
                        if (property.length < 3) {
                            this.minAttack = Integer.parseInt(property[1].trim());
                            this.maxAttack = this.minAttack;
                        } else {
                            this.minAttack = Integer.parseInt(property[1].trim());
                            this.maxAttack = Integer.parseInt(property[2].trim());
                            if (this.minAttack > this.maxAttack) {
                                throw new MonsterTemplateException("L'attaque minimale (" + this.minAttack
                                        + ") ne peut pas être supérieure à l'attaque maximale (" + this.maxAttack
                                        + ").");
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new MonsterTemplateException(
                                "Format invalide pour attack, doit être un entier : " + property[1], e);
                    }
                    break;
                case "defense":
                    try {
                        if (property.length < 3) {
                            this.minDefense = Integer.parseInt(property[1].trim());
                            this.maxDefense = this.minDefense;
                        } else {
                            this.minDefense = Integer.parseInt(property[1].trim());
                            this.maxDefense = Integer.parseInt(property[2].trim());
                            if (this.minDefense > this.maxDefense) {
                                throw new MonsterTemplateException("La défense minimale (" + this.minDefense
                                        + ") ne peut pas être supérieure à la défense maximale (" + this.maxDefense
                                        + ").");
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new MonsterTemplateException(
                                "Format invalide pour defense, doit être un entier : " + property[1], e);
                    }
                    break;
                default:
                    // Pour les propriétés custom, on retire les espaces superflus.
                    String[] values = new String[property.length - 1];
                    for (int i = 1; i < property.length; i++) {
                        values[i - 1] = property[i].trim();
                    }
                    this.customProperties.put(propertyName, values);
                    break;
            }
        }
    }

    // Les autres méthodes restent inchangées

    public HashMap<String, String[]> getCustomProperties() {
        return customProperties;
    }

    public String getName() {
        return name;
    }

    public Types getType() {
        return type;
    }

    public int getMinHealth() {
        return minHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getRandomHealth(Random random) {
        return random.nextInt(maxHealth - minHealth + 1) + minHealth;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getRandomSpeed(Random random) {
        return random.nextInt(maxSpeed - minSpeed + 1) + minSpeed;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getRandomAttack(Random random) {
        return random.nextInt(maxAttack - minAttack + 1) + minAttack;
    }

    public int getMinDefense() {
        return minDefense;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public int getRandomDefense(Random random) {
        return random.nextInt(maxDefense - minDefense + 1) + minDefense;
    }

    public int getMinCustomInt(String propertyName) {
        if (!customProperties.containsKey(propertyName)) {
            return 0;
        }
        return Integer.parseInt(customProperties.get(propertyName)[0]);
    }

    public int getMaxCustomInt(String propertyName) {
        if (!customProperties.containsKey(propertyName)) {
            return 0;
        }
        if (customProperties.get(propertyName).length < 2) {
            return Integer.parseInt(customProperties.get(propertyName)[0]);
        } else {
            return Integer.parseInt(customProperties.get(propertyName)[1]);
        }
    }

    public int getRandomCustomInt(String propertyName, Random random) {
        if (!customProperties.containsKey(propertyName)) {
            return 0;
        }
        if (customProperties.get(propertyName).length < 2) {
            return Integer.parseInt(customProperties.get(propertyName)[0]);
        } else {
            int min = Integer.parseInt(customProperties.get(propertyName)[0]);
            int max = Integer.parseInt(customProperties.get(propertyName)[1]);
            return random.nextInt(max - min + 1) + min;
        }
    }

    public float getMinCustomFloat(String propertyName) {
        if (!customProperties.containsKey(propertyName)) {
            return 0;
        }
        return Float.parseFloat(customProperties.get(propertyName)[0]);
    }

    public float getMaxCustomFloat(String propertyName) {
        if (!customProperties.containsKey(propertyName)) {
            return 0;
        }
        if (customProperties.get(propertyName).length < 2) {
            return Float.parseFloat(customProperties.get(propertyName)[0]);
        } else {
            return Float.parseFloat(customProperties.get(propertyName)[1]);
        }
    }

    public float getRandomCustomFloat(String propertyName, Random random) {
        if (!customProperties.containsKey(propertyName)) {
            return 0;
        }
        if (customProperties.get(propertyName).length < 2) {
            return Float.parseFloat(customProperties.get(propertyName)[0]);
        } else {
            float min = Float.parseFloat(customProperties.get(propertyName)[0]);
            float max = Float.parseFloat(customProperties.get(propertyName)[1]);
            return random.nextFloat() * (max - min) + min;
        }
    }
}
