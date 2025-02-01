package fr.esiea.inf3132tp2024.controller;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplateException;

import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class MonstreManager {
    private static final MonstreManager INSTANCE = new MonstreManager();

    public static MonstreManager getInstance() {
        return INSTANCE;
    }

    private MonstreManager() {
        try {
            loadExternalMonstres();
            loadInternalMonstres();
        } catch (MonsterTemplateException e) {
        }
    }

    private final List<MonsterTemplate> monstres = new LinkedList<>();
    private final Map<File, List<MonsterTemplate>> fileToMonstresMap = new HashMap<>();

    /**
     * Méthode permettant de charger les monstres à partir d'un fichier.
     *
     * @param file Le fichier contenant les monstres.
     * @return La liste des monstres chargés depuis le fichier.
     */
    private List<MonsterTemplate> loadMonstres(File file) throws MonsterTemplateException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return parseMonstres(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<MonsterTemplate> loadMonstresFromStream(InputStream is) throws MonsterTemplateException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return parseMonstres(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<MonsterTemplate> parseMonstres(BufferedReader reader) throws IOException, MonsterTemplateException {
        List<MonsterTemplate> loadedMonsters = new ArrayList<>();
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
                    String[][] propertiesArray = currentMonsterProperties.toArray(new String[0][]);
                    MonsterTemplate monster = new MonsterTemplate(propertiesArray);
                    loadedMonsters.add(monster);

                }
                isMonsterBlock = false;
            } else if (isMonsterBlock && !line.isEmpty()) {
                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    currentMonsterProperties.add(parts);
                }
            }
        }
        return loadedMonsters;
    }

    public void loadExternalMonstres() throws MonsterTemplateException {
        File externalDir = new File("game/monster");
        if (externalDir.exists() && externalDir.isDirectory()) {
            File[] files = externalDir.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    List<MonsterTemplate> loaded = loadMonstres(file);
                    monstres.addAll(loaded);
                    fileToMonstresMap.put(file, loaded);
                }
            }
        }
    }

    public void loadInternalMonstres() throws MonsterTemplateException {
        try {
            List<String> internalFiles = getResourceFiles("game/monster");
            Set<String> uniqueFiles = new HashSet<>(internalFiles);
            for (String filename : uniqueFiles) {
                File externalFile = new File("game/monster", filename);
                if (!externalFile.exists()) {
                    InputStream is = getClass().getClassLoader().getResourceAsStream("game/monster/" + filename);
                    if (is != null) {
                        List<MonsterTemplate> loaded = loadMonstresFromStream(is);
                        for (MonsterTemplate monster : loaded) {
                            if (!isDuplicate(monster)) {
                                monstres.add(monster);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getResourceFiles(String path) throws IOException {
        List<String> filenames = new ArrayList<>();
        Enumeration<URL> urls = getClass().getClassLoader().getResources(path);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            if (url.getProtocol().equals("jar")) {
                JarURLConnection jarConn = (JarURLConnection) url.openConnection();
                try (JarFile jar = jarConn.getJarFile()) {
                    Enumeration<JarEntry> entries = jar.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        String name = entry.getName();
                        if (name.startsWith(path) && !name.equals(path + "/")) {
                            String entryName = name.substring(path.length() + 1);
                            if (!entryName.contains("/")) {
                                filenames.add(entryName);
                            }
                        }
                    }
                }
            } else {
                File dir = new File(url.getPath());
                if (dir.isDirectory()) {
                    File[] files = dir.listFiles();
                    if (files != null) {
                        for (File f : files) {
                            filenames.add(f.getName());
                        }
                    }
                }
            }
        }
        return filenames;
    }

    public boolean isFileValid(File file) {
        // Vérifier l'extension du fichier
        return file.exists() && file.isFile() && file.canRead() && file.getName().endsWith(".txt");
    }

    /**
     * Méthode permettant de récupérer tous les modèles de monstres.
     *
     * @return Les modèles de monstres.
     */
    public List<MonsterTemplate> getMonstresModels() {
        return Collections.unmodifiableList(monstres);
    }

    /**
     * Méthode pour récupérer les modèles de monstres par type.
     *
     * @param type Le type de monstre recherché.
     * @return La liste des monstres du type spécifié.
     */
    public List<MonsterTemplate> getMonstresModelsByType(Types type) {
        return monstres.stream()
                .filter(monster -> monster.getType() == type)
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour obtenir un modèle de monstre aléatoire.
     *
     * @return Un modèle de monstre aléatoire, ou null si aucun modèle n'est
     *         disponible.
     */
    public MonsterTemplate getRandomMonstreModel(Random random) {
        if (monstres.isEmpty()) {
            return null;
        }
        return monstres.get(random.nextInt(monstres.size()));
    }

    /**
     * Méthode pour obtenir un modèle de monstre aléatoire du type spécifié.
     *
     * @param type Le type de monstre.
     * @return Un monstre aléatoire du type spécifié, ou null si aucun monstre n'est
     *         disponible.
     */
    public MonsterTemplate getRandomMonstreModelByType(Random random, Types type) {
        List<MonsterTemplate> filteredMonstres = getMonstresModelsByType(type);
        if (filteredMonstres.isEmpty()) {
            return null;
        }
        return filteredMonstres.get(random.nextInt(filteredMonstres.size()));
    }

    /**
     * Méthode pour obtenir tous les types de monstres disponibles.
     *
     * @return Un ensemble contenant tous les types de monstres présents.
     */
    public Set<Types> getAllTypes() {
        return monstres.stream()
                .map(MonsterTemplate::getType)
                .collect(Collectors.toSet());
    }

    private boolean isDuplicate(MonsterTemplate monster) {
        for (MonsterTemplate m : monstres) {
            if (m.getName().equals(monster.getName())) {
                return true;
            }
        }
        return false;
    }
}
