package fr.esiea.inf3132tp2024.controller;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.file.AttackTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AttackManager {
    private static final AttackManager INSTANCE = new AttackManager();

    public static AttackManager getInstance() {
        return INSTANCE;
    }

    // Bloquer l'instanciation de la classe (pattern Singleton)
    private AttackManager() {
    }

    private final List<AttackTemplate> attacks = new LinkedList<>();
    private final Map<File, List<AttackTemplate>> fileToAttacksMap = new HashMap<>();

    public void addFile(File file) {
        if (isFileValid(file)) {
            File attackFolder = new File("src/main/resources/game/attack");
            if (!attackFolder.exists()) {
                attackFolder.mkdirs();
            }
            File newFile = new File(attackFolder, file.getName());
            file.renameTo(newFile);
        } else {
            System.out.println("Fichier invalide: " + file.getName());
        }
    }

    public void removeFile(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("Fichier inexistant: " + file.getName());
        }
    }

    private List<AttackTemplate> loadAttacks(File file) {
        List<AttackTemplate> loadedAttacks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            List<String[]> currentAttackProperties = new ArrayList<>();
            boolean isAttackBlock = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equalsIgnoreCase("Attack")) {
                    isAttackBlock = true;
                    currentAttackProperties = new ArrayList<>();
                } else if (line.equalsIgnoreCase("EndAttack")) {
                    if (isAttackBlock && !currentAttackProperties.isEmpty()) {
                        String[][] propertiesArray = currentAttackProperties.toArray(new String[0][]);
                        AttackTemplate attack = new AttackTemplate(propertiesArray);
                        loadedAttacks.add(attack);
                    }
                    isAttackBlock = false;
                } else if (isAttackBlock && !line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        currentAttackProperties.add(parts);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedAttacks;
    }

    public boolean isFileValid(File file) {
        return file.exists() && file.isFile() && file.canRead() && file.getName().endsWith(".txt");
    }

    public List<AttackTemplate> getAttackModels() {
        return Collections.unmodifiableList(attacks);
    }

    public List<AttackTemplate> getAttackModelsByType(Types type) {
        return attacks.stream()
                .filter(attack -> attack.getType() == type)
                .collect(Collectors.toList());
    }

    public AttackTemplate getRandomAttackModel(Random random) {
        if (attacks.isEmpty()) {
            return null;
        }
        return attacks.get(random.nextInt(attacks.size()));
    }

    public AttackTemplate getRandomAttackModelByType(Random random, Types type) {
        List<AttackTemplate> filteredAttacks = getAttackModelsByType(type);
        if (filteredAttacks.isEmpty()) {
            return null;
        }
        return filteredAttacks.get(random.nextInt(filteredAttacks.size()));
    }

    public Set<Types> getAllTypes() {
        return attacks.stream()
                .map(AttackTemplate::getType)
                .collect(Collectors.toSet());
    }
}
