package fr.esiea.inf3132tp2024.controller;

import fr.esiea.inf3132tp2024.model.GameStatistic;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class StatisticsManager {
    private static final StatisticsManager INSTANCE = new StatisticsManager();

    public static StatisticsManager getInstance() {
        return INSTANCE;
    }

    // Bloquer l'instanciation de la classe (pattern Singleton)
    private StatisticsManager() {
    }

    private final List<GameStatistic> gameStatistics = new ArrayList<>();

    /**
     * Méthode permettant de récupérer les meilleurs stats (si elles existent).
     */
    public void loadStatistics() {
        try {
            //On démarre le flux en instanciant les objets nécessaires
            FileReader fileReader = new FileReader("stats.csv");
            BufferedReader in = new BufferedReader(fileReader);

            int noLine = 0;

            String ligne = in.readLine();
            while (ligne != null) {
                noLine++;

                // on incrémente maximum 10 fois la list de stat
                if (noLine > 10) {
                    break;
                }

                StringTokenizer token = new StringTokenizer(ligne, ";");

                // on vérifie qu'il y a bien le bon nombre d'éléments
                if (token.countTokens() != 7) {
                    continue;
                }

                // On ajoute à chaque itération dans la liste un nouvel objet statistic récupéré sur le csv
                this.gameStatistics.add(new GameStatistic(
                        token.nextToken(),
                        token.nextToken(),
                        Integer.parseInt(token.nextToken()),
                        Long.parseLong(token.nextToken())));

                ligne = in.readLine();
            }
            in.close();

        } catch (IOException ignored) {
        }
        Collections.sort(this.gameStatistics);
    }

    /**
     * Méthode permettant l'écriture des statistiques sur le csv.
     * De la forme : nomJoueur/score/bossVaincu(bool)/nbEnnemieTué/nbPiecesVisité/seed
     */
    public void writeStatistics() {
        try {
            // instanciation des objets permettant le flux d'écriture
            FileWriter fileWriter = new FileWriter("stats.csv");
            PrintWriter out = new PrintWriter(fileWriter);

            GameStatistic stat;
            int compteur = 0;
            do {
                stat = gameStatistics.get(compteur);
                out.println("" +
                        stat.getPlayerOneName() + ";" +
                        stat.getPlayerTwoName() + ";" +
                        stat.getScore() + ";" +
                        stat.getSeed());
                compteur++;
            } while (compteur < this.gameStatistics.size());

            out.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * Méthode permettant d'ajouter une statistique à la liste des statistiques.
     *
     * @param stat la statistique à ajouter
     */
    public void addStatistic(GameStatistic stat) {
        if (stat.isCheatModeActivated()) {
            return;
        }
        this.gameStatistics.add(stat);
        // On trie et on remet la liste à la bonne taille pour écrire seulement les 10 meilleurs scores
        Collections.sort(this.gameStatistics);
        while (gameStatistics.size() > 10) {
            this.gameStatistics.remove(this.gameStatistics.size() - 1);
        }

        // On sauvegarde les statistiques sur le csv
        writeStatistics();
    }

    public List<GameStatistic> getStatistics() {
        return gameStatistics;
    }
}
