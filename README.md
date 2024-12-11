# ESIEA_INF3132_TP

Ce document explique comment installer, compiler et lancer le projet Java utilisant Maven.

---

## Prérequis

1. **Java Development Kit (JDK)** :
    - Assurez-vous d'avoir installé une version compatible du JDK (Java 17 ou supérieur).
    - Pour vérifier la version installée :
      ```bash
      java -version
      ```

2. **Apache Maven** :
    - Installez Maven sur votre machine. Vous pouvez télécharger Maven depuis [le site officiel d'Apache Maven](https://maven.apache.org/).
    - Pour plus de détails sur l'installation de Maven, consultez [ce guide officiel](https://maven.apache.org/install.html).
    - Vérifiez l'installation avec :
      ```bash
      mvn -version
      ```

3. **Git (facultatif)** :
    - Pour cloner le projet depuis un dépôt distant.
    - Vérifiez l'installation avec :
      ```bash
      git --version
      ```

---

## Installation

1. Clonez le dépôt (si nécessaire) :
   ```bash
   git clone <URL_DU_DEPOT>
   ```

2. Accédez au répertoire du projet :
   ```bash
   cd <NOM_DU_PROJET>
   ```

---

## Compilation du projet

Pour compiler le projet, exécutez la commande suivante depuis la racine du projet :
```bash
mvn clean install
```

### Explication des commandes :
- `mvn clean` : Supprime les fichiers générés lors de précédentes compilations.
- `mvn install` : Compile le projet, exécute les tests et installe les artefacts générés dans le dépôt local.

---

## Exécution du projet

Une fois le projet compilé, un fichier JAR exécutable est généré dans le répertoire `target`. Pour lancer l'application, utilisez la commande suivante :
```bash
java -jar target/<NOM_DU_FICHIER>.jar
```
> Remplacez `<NOM_DU_FICHIER>.jar` par le nom exact du fichier JAR généré (par exemple, `mon-projet-1.0.jar`).

### Exemple :
```bash
java -jar target/mon-projet-1.0.jar
```

---

## Structure du projet

Voici une structure typique d'un projet Maven :
```
├── src
│   ├── main
│   │   ├── java          # Code source principal
│   │   └── resources     # Ressources (fichiers de configuration, etc.)
│   └── test
│       ├── java          # Tests unitaires
│       └── resources     # Ressources pour les tests
├── pom.xml               # Fichier de configuration Maven
```

---

## Dépannage

- **Problème :** "Command not found" pour `mvn`
    - Assurez-vous que Maven est correctement installé et que son chemin est ajouté à la variable d'environnement `PATH`.

- **Problème :** "Java version incompatible"
    - Vérifiez que la version de Java est correcte et compatible avec le projet.

---

## Auteurs

- **Alban ROUAULT**
- **Victor VAIZAND**
