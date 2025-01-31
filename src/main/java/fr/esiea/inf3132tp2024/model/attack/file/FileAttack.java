package fr.esiea.inf3132tp2024.model.attack.file;

import fr.esiea.inf3132tp2024.model.Types;

import java.util.Random;

public class FileAttack {
    private String name;
    private Types type;
    private int minPower;
    private int maxPower;
    private int minNbUse;
    private int maxNbUse;
    private float minFail;
    private float maxFail;

    public FileAttack(String[][] customProperties) {
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
                case "power":
                    if (property.length < 3) {
                        this.minPower = Integer.parseInt(property[1]);
                        this.maxPower = this.minPower;
                    } else {
                        this.minPower = Integer.parseInt(property[1]);
                        this.maxPower = Integer.parseInt(property[2]);
                    }
                    break;
                case "nbuse":
                    if (property.length < 3) {
                        this.minNbUse = Integer.parseInt(property[1]);
                        this.maxNbUse = this.minNbUse;
                    } else {
                        this.minNbUse = Integer.parseInt(property[1]);
                        this.maxNbUse = Integer.parseInt(property[2]);
                    }
                    break;
                case "fail":
                    if (property.length < 3) {
                        this.minFail = Integer.parseInt(property[1]);
                        this.maxFail = this.minFail;
                    } else {
                        this.minFail = Integer.parseInt(property[1]);
                        this.maxFail = Integer.parseInt(property[2]);
                    }
                    break;
                default:
                    break;
            }
        }
    }

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
