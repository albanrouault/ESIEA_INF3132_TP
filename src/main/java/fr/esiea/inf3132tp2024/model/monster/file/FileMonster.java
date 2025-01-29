package fr.esiea.inf3132tp2024.model.monster.file;

import fr.esiea.inf3132tp2024.model.Types;

import java.util.HashMap;
import java.util.Random;

public class FileMonster {
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

    private FileMonster(String[][] customProperties) {
        this.customProperties = new HashMap<>();

        for (String[] property : customProperties) {
            if (property.length < 2) {
                continue;
            }
            String propertyName = property[0];
            switch (propertyName.toLowerCase()) {
                case "name":
                    this.name = property[1];
                    break;
                case "type":
                    this.type = Types.valueOf(property[1].toUpperCase());
                    break;
                case "hp":
                    if (property.length < 3) {
                        this.minHealth = Integer.parseInt(property[1]);
                        this.maxHealth = this.minHealth;
                    } else {
                        this.minHealth = Integer.parseInt(property[1]);
                        this.maxHealth = Integer.parseInt(property[2]);
                    }
                    break;
                case "speed":
                    if (property.length < 3) {
                        this.minSpeed = Integer.parseInt(property[1]);
                        this.maxSpeed = this.minSpeed;
                    } else {
                        this.minSpeed = Integer.parseInt(property[1]);
                        this.maxSpeed = Integer.parseInt(property[2]);
                    }
                    break;
                case "attack":
                    if (property.length < 3) {
                        this.minAttack = Integer.parseInt(property[1]);
                        this.maxAttack = this.minAttack;
                    } else {
                        this.minAttack = Integer.parseInt(property[1]);
                        this.maxAttack = Integer.parseInt(property[2]);
                    }
                    break;
                case "defense":
                    if (property.length < 3) {
                        this.minDefense = Integer.parseInt(property[1]);
                        this.maxDefense = this.minDefense;
                    } else {
                        this.minDefense = Integer.parseInt(property[1]);
                        this.maxDefense = Integer.parseInt(property[2]);
                    }
                    break;
                default:
                    String[] values = new String[property.length - 1];
                    System.arraycopy(property, 1, values, 0, values.length);
                    this.customProperties.put(propertyName, values);
                    break;
            }
        }
    }

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

    public int getRandomHealth(Random random){
        return random.nextInt(maxHealth - minHealth + 1) + minHealth;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getRandomSpeed(Random random){
        return random.nextInt(maxSpeed - minSpeed + 1) + minSpeed;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getRandomAttack(Random random){
        return random.nextInt(maxAttack - minAttack + 1) + minAttack;
    }

    public int getMinDefense() {
        return minDefense;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public int getRandomDefense(Random random){
        return random.nextInt(maxDefense - minDefense + 1) + minDefense;
    }


}
