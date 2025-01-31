package fr.esiea.inf3132tp2024.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import fr.esiea.inf3132tp2024.model.monster.file.FileMonster;
import fr.esiea.inf3132tp2024.model.Types;

public class MonstreManager {
    private final List<FileMonster> monstres = new ArrayList<>();
    private final Map<File, List<FileMonster>> fileToMonstresMap = new HashMap<>();

    private static final MonstreManager INSTANCE = new MonstreManager();

    /**
     * Méthode permettant de récupérer l'instance unique de la classe.
     */
    public static MonstreManager getInstance() {
        return INSTANCE;
    }

    /**
     * Méthode permettant d'ajouter un fichier de monstres dans le répertoire resources/game/monster.
     * @param file Le fichier à ajouter.
     */
    public void addFile(File file) {
        if (isFileValid(file)) {
            // Ajout le fichier dans le répertoire resources/game/monster
            File monsterFolder = new File("src/main/resources/game/monster");
            if (!monsterFolder.exists()) {
                monsterFolder.mkdirs();
            } 
            File newFile = new File(monsterFolder, file.getName());
            file.renameTo(newFile);
        } else {
            System.out.println("Fichier invalide: " + file.getName());
        }
    }

    /**
     * Méthode permettant de supprimer un fichier de monstres dans le répertoire resources/game/monster.
     * @param file Le fichier à supprimer.
     */
    public void removeFile(File file) {
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("Fichier inexistant: " + file.getName());
        }
    }

    /**
     * Méthode permettant de charger les monstres à partir d'un fichier.
     * @param file Le fichier contenant les monstres.
     * @return La liste des monstres chargés depuis le fichier.
     */
    private List<FileMonster> loadMonstres(File file) {
        List<FileMonster> loadedMonsters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            List<String[]> currentMonsterProperties = new ArrayList<>();
            boolean isMonsterBlock = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equalsIgnoreCase("Monster")) {
                    isMonsterBlock = true;
                    currentMonsterProperties = new ArrayList<>();
                } else if (line.equalsIgnoreCase("EndMonster")) {
                    if (isMonsterBlock && !currentMonsterProperties.isEmpty()) {
                        // Convert List<String[]> to String[][]
                        String[][] propertiesArray = currentMonsterProperties.toArray(new String[0][]);
                        FileMonster monster = new FileMonster(propertiesArray);
                        loadedMonsters.add(monster);
                    }
                    isMonsterBlock = false;
                } else if (isMonsterBlock && !line.isEmpty()) {
                    // Split the line by whitespace, en tenant compte des valeurs groupées
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        currentMonsterProperties.add(parts);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedMonsters;
    }

    /**
     * Méthode permettant de vérifier que le fichier est au bon format.
     * @param file Le fichier à vérifier.
     * @return true si le fichier est au bon format, false sinon.
     */
    public boolean isFileValid(File file) {
        // Vérifier l'extension du fichier
        return file.exists() && file.isFile() && file.canRead() && file.getName().endsWith(".txt");
    }

    /**
     * Méthode permettant de récupérer tous les monstres.
     * @return La liste de tous les monstres.
     */
    public List<FileMonster> getMonstres() {
        return Collections.unmodifiableList(monstres);
    }

    /**
     * Méthode pour récupérer les monstres par type.
     * @param type Le type de monstre recherché.
     * @return La liste des monstres correspondant au type spécifié.
     */
    public List<FileMonster> getMonstresByType(Types type) {
        return monstres.stream()
                .filter(monster -> monster.getType() == type)
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour obtenir un monstre aléatoire.
     * @return Un monstre choisi aléatoirement, ou null si aucun monstre n'est disponible.
     */
    public FileMonster getRandomMonstre() {
        if (monstres.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return monstres.get(random.nextInt(monstres.size()));
    }

    /**
     * Méthode pour obtenir un monstre aléatoire par type.
     * @param type Le type de monstre.
     * @return Un monstre aléatoire du type spécifié, ou null si aucun monstre de ce type n'est disponible.
     */
    public FileMonster getRandomMonstreByType(Types type) {
        List<FileMonster> filteredMonstres = getMonstresByType(type);
        if (filteredMonstres.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return filteredMonstres.get(random.nextInt(filteredMonstres.size()));
    }

    /**
     * Méthode pour obtenir tous les types de monstres disponibles.
     * @return Un ensemble contenant tous les types de monstres présents.
     */
    public Set<Types> getAllTypes() {
        return monstres.stream()
                .map(FileMonster::getType)
                .collect(Collectors.toSet());
    }
}
