package fr.esiea.inf3132tp2024.controller;

public class AttackManager {
    private static final AttackManager INSTANCE = new AttackManager();

    public static AttackManager getInstance() {
        return INSTANCE;
    }

    // Bloquer l'instanciation de la classe (pattern Singleton)
    private AttackManager() {
    }
}
