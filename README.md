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

## Ajout de monstres et d'attaques

Pour ajouter des monstres et des attaques il faut créer un dossier game là ou il y a le jar puis un dossier monster et attack et mettre le ou les fichiers txt dedans.

donc : 
```
game/monster/fichier.txt
game/attack/fichier.txt
```

Les fichiers doivent être au format suivant pour les monstres :
```
Monster
    Name        <Nom du monstre>
    Type        <Type du monstre> (voir ci-dessous)
    HP          <Valeur de l'HP MIN - entier> <Valeur de l'HP MAX - entier>
    Speed       <Valeur de la vitesse MIN - entier> <Valeur de la vitesse MAX - entier>
    Attack      <Valeur de l'attaque MIN - entier> <Valeur de l'attaque MAX - entier>
    Defense     <Valeur de la défense MIN - entier> <Valeur de la défense MAX - entier>
    Burn        <Valeur du burn - réel>
EndMonster
```

Les fichiers doivent être au format suivant pour les attaques :
```
Attack
    Name        <Nom de l'attaque>
    Type        <Type de l'attaque> (voir ci-dessous)
    Power       <Valeur de la puissance - entier>
    NbUse       <Valeur du nombre d'utilisation - entier>
    Fail        <Valeur du pourcentage de réussite - réel>
EndAttack
```

Attention, si votre fichier est nommé `default.txt`, il remplacera le fichier par défaut que nous avons fourni.

Concernant les types, il faut mettre les types pour les monstres ils sont : 
- Fire
- Water
- Electric
- Earth
- Nature_Plant
- Nature_Insect

Pour les attaques, il faut mettre les types des attaques, ils sont :
- Fire
- Water
- Electric
- Earth
- Nature_Plant
- Nature_Insect
- Normal

---

## Remarques

### Fichiers default
- Le fichier `default.txt` dans `src/main/resources/game/monster/` contient les monstres de la génération 1 de pokemon remaniés.
- Le fichier `default.txt` dans `src/main/resources/game/attack/` contient les attaques de pokemon remaniées.

### Musique
- Nous avons utilisé des musiques (OST de Pokemon Let's Go) pour embellir le jeu.
- Il est possible qu'il y ait des problèmes de compatibilité avec certains systèmes d'exploitation. Nous avons essayé sur Windows 11 et Ubuntu 24.04. (LTS)

### Développement
Nous vous prions de nous excuser pour le projet. Nous n’avons pas pu le finaliser ni retravailler le code comme prévu. Plutôt que de trouver des excuses, nous admettons avoir sous-estimé la complexité du projet et avoir été débordés par d’autres priorités. Nous espérons tout de même que vous apprécierez le travail que nous avons fait. Bon jeu !

---

## Auteurs

- **Alban ROUAULT**
- **Victor VAIZAND**