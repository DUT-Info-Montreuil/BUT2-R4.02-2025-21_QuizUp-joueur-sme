package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.bo;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JoueurBO {

    private final List<JoueurDTO> joueurs;

    public JoueurBO() {
        this.joueurs = new ArrayList<>();
    }

    public JoueurDTO ajouterJoueur(String pseudo, String nom, int anneeNaissance, List<String> centresInterets, String languePreferee) {

        if (pseudo == null || pseudo.isBlank()) return null;
        if (nom == null || nom.isBlank()) return null;
        if (anneeNaissance < 0 || anneeNaissance > Year.now().getValue()) return null;
        if (centresInterets == null || centresInterets.isEmpty()) return null;
        if (!Langues.estValide(languePreferee)) return null;
        if (existeDeja(pseudo)) return null;

        // Vérification des doublons dans les centres d’intérêts
        Set<String> set = new HashSet<>();
        for (String interet : centresInterets) {
            if (!set.add(interet.toLowerCase())) {
                return null; // Doublon détecté
            }
        }

        JoueurDTO nouveau = new JoueurDTO(nom, pseudo, anneeNaissance, 0, centresInterets, languePreferee.toUpperCase());
        joueurs.add(nouveau);
        return nouveau;
    }

    public List<JoueurDTO> listeJoueurs() {
        return new ArrayList<>(joueurs);
    }

    public void supprimerJoueur(String pseudo) {
        joueurs.removeIf(j -> j.getPseudo().equalsIgnoreCase(pseudo));
    }

    private boolean existeDeja(String pseudo) {
        return joueurs.stream().anyMatch(j -> j.getPseudo().equalsIgnoreCase(pseudo));
    }
}

