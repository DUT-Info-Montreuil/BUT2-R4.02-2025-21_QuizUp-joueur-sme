package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JoueurDTO {

    private String nom;
    private final String pseudo;
    private int anneeNaissance;
    private int partiesJouees;
    private final List<String> centresInterets;
    private Langues langagePrefere;
    private final List<Map<Integer, String>> scores;


    public JoueurDTO(String nom, String pseudo, int anneeNaissance, int partiesJouees, List<String> centresInterets, Langues langagePrefere) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.anneeNaissance = anneeNaissance;
        this.partiesJouees = partiesJouees;
        this.centresInterets = centresInterets;
        this.langagePrefere = langagePrefere;
        this.scores = new ArrayList<Map<Integer, String>>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }
    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public int getPartiesJouees() {
        return partiesJouees;
    }
    public void setPartiesJouees(int partiesJouees) {
        this.partiesJouees = partiesJouees;
    }

    public List<String> getCentresInterets() {
        return centresInterets;
    }

    public Langues getLangagePrefere() {
        return langagePrefere;
    }
    public void setLangagePrefere(Langues langagePrefere) {
        this.langagePrefere = langagePrefere;
    }

    public List<Map<Integer, String>> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "JoueurDTO[" +
                    "pseudo: " + pseudo + ", " +
                    "nom: " + nom + ", " +
                    "anneeNaissance: " + anneeNaissance + ", " +
                    "partiesJouees: " + partiesJouees + ", " +
                    "centresInterets: " + centresInterets + ", " +
                    "langagePrefere: " + langagePrefere + ", " +
                    "scores: " + scores +
               "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurDTO joueurDTO = (JoueurDTO) o;
        return Objects.equals(pseudo, joueurDTO.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pseudo);
    }
}
