package fr.esiea.inf3132tp2024.controller;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.file.AttackTemplate;
import fr.esiea.inf3132tp2024.model.attack.file.AttackTemplateException;

import java.io.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
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

    private List<AttackTemplate> loadAttacks(File file) throws AttackTemplateException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return parseAttacks(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<AttackTemplate> loadAttacksFromStream(InputStream is) throws AttackTemplateException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return parseAttacks(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<AttackTemplate> parseAttacks(BufferedReader reader) throws IOException, AttackTemplateException {
        List<AttackTemplate> loadedAttacks = new ArrayList<>();
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
        return loadedAttacks;
    }

    public void loadExternalAttacks() throws AttackTemplateException {
        File externalDir = new File("game/attack");
        if (externalDir.exists() && externalDir.isDirectory()) {
            File[] files = externalDir.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    List<AttackTemplate> loaded = loadAttacks(file);
                    attacks.addAll(loaded);
                    fileToAttacksMap.put(file, loaded);
                }
            }
        }
    }

    public void loadInternalAttacks() throws AttackTemplateException {
        try {
            List<String> internalFiles = getResourceFiles("game/attack");
            for (String filename : internalFiles) {
                File externalFile = new File("game/attack", filename);
                if (!externalFile.exists()) {
                    InputStream is = getClass().getClassLoader().getResourceAsStream("game/attack/" + filename);
                    if (is != null) {
                        List<AttackTemplate> loaded = loadAttacksFromStream(is);
                        attacks.addAll(loaded);
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
