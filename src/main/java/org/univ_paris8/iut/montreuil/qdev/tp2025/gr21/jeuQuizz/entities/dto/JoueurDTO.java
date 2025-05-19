package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JoueurDTO {

    private String nom;
    private final String pseudo;
    private int anneeNaissance;
    private int partiesJouees;
    private List<String> centresInterets;
    private String languePreferee;
    private final List<Map<Integer, String>> scores;


    public JoueurDTO(String nom, String pseudo, int anneeNaissance, int partiesJouees, List<String> centresInterets, String languePreferee) {
        this.nom = nom;
        this.pseudo = pseudo;
        this.anneeNaissance = anneeNaissance;
        this.partiesJouees = partiesJouees;
        this.centresInterets = centresInterets;
        this.languePreferee = languePreferee;
        this.scores = new ArrayList<Map<Integer, String>>();
    }
}
