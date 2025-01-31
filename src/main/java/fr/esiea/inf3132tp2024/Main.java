package fr.esiea.inf3132tp2024;

import fr.esiea.inf3132tp2024.controller.App;

public class Main {
    // Bloquer l'instanciation de la classe (pattern Singleton)
    private Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App.getInstance().start();
    }
}
