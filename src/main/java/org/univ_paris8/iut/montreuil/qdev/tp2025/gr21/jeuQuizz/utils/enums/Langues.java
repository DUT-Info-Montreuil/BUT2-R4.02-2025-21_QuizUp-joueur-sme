package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums;

public enum Langues {
    FRANÇAIS,
    ANGLAIS,
    ALLEMAND,
    ESPAGNOL,
    ITALIEN;

    public static boolean estValide(String input) {
        for (Langues langue : Langues.values()) {
            if (langue.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    public static Langues depuisString(String input) {
        for (Langues langue : Langues.values()) {
            if (langue.name().equalsIgnoreCase(input)) {
                return langue;
            }
        }
        throw new IllegalArgumentException("Langue non reconnue : " + input);
    }
}
