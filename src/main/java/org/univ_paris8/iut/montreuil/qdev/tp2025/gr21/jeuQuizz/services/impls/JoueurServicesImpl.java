/*package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls;

public class JoueurServicesImpl {
}

package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.anneeNaissanceExceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.centresInteretsExceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.pseudoExceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JoueurServicesImpl implements IJoueurServices {

    private final Map<String, JoueurDTO> joueurs = new ConcurrentHashMap<>();

    @Override
    public JoueurDTO ajouterJoueur(String pseudo, String prenom, int anneeNaissance,
                                   List<String> centresInterets, String languePreferee)
            throws AjouterJoueurException {

        // Validation du pseudo
        validerPseudo(pseudo);

        // Validation de l'année de naissance
        validerAnneeNaissance(anneeNaissance);

        // Validation des centres d'intérêts
        validerCentresInterets(centresInterets);

        // Validation de la langue préférée
        Langues langue = validerLanguePreferee(languePreferee);

        // Vérification que le pseudo n'existe pas déjà
        if (joueurs.containsKey(pseudo)) {
            throw new PseudoExistantException("Un joueur avec le pseudo '" + pseudo + "' existe déjà");
        }

        // Création du joueur
        JoueurDTO nouveauJoueur = new JoueurDTO(prenom, pseudo, anneeNaissance, 0,
                new ArrayList<>(centresInterets), langue);

        // Ajout dans la collection
        joueurs.put(pseudo, nouveauJoueur);

        return nouveauJoueur;
    }

    @Override
    public List<JoueurDTO> listeJoueurs() throws Exception {
        return new ArrayList<>(joueurs.values());
    }

    @Override
    public void supprimerJoueur(String pseudo) throws Exception {
        if (!joueurs.containsKey(pseudo)) {
            throw new PseudoException("Aucun joueur trouvé avec le pseudo : " + pseudo);
        }
        joueurs.remove(pseudo);
    }

    @Override
    public void reinitialiserJoueur(String pseudo) throws Exception {
        JoueurDTO joueur = joueurs.get(pseudo);
        if (joueur == null) {
            throw new PseudoException("Aucun joueur trouvé avec le pseudo : " + pseudo);
        }

        // Réinitialisation des statistiques
        joueur.setPartiesJouees(0);
        joueur.getScores().clear();
    }

    // Méthodes de validation privées

    private void validerPseudo(String pseudo) throws PseudoException {
        if (pseudo == null || pseudo.trim().isEmpty()) {
            throw new PseudoException("Le pseudo ne peut pas être vide");
        }

        if (pseudo.length() < 3) {
            throw new PseudoException("Le pseudo doit contenir au moins 3 caractères");
        }

        if (!Character.isLetter(pseudo.charAt(0))) {
            throw new PseudoCommencantParUnChiffreException("Le pseudo ne peut pas commencer par un chiffre");
        }

        // Vérification que le pseudo ne contient que des lettres, chiffres et underscores
        if (!pseudo.matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
            throw new PseudoException("Le pseudo ne peut contenir que des lettres, chiffres et underscores");
        }
    }

    private void validerAnneeNaissance(int anneeNaissance) throws AnneeNaissanceException {
        int anneeActuelle = java.time.Year.now().getValue();

        if (anneeNaissance < 0) {
            throw new AnneeNaissNegativeException("L'année de naissance ne peut pas être négative");
        }

        if (anneeNaissance > anneeActuelle) {
            throw new AnneeNaissanceFuturException("L'année de naissance ne peut pas être dans le futur");
        }

        // Vérification d'un âge minimum (par exemple, 5 ans)
        if (anneeActuelle - anneeNaissance < 5) {
            throw new AnneeNaissanceException("Le joueur doit avoir au moins 5 ans");
        }

        // Vérification d'un âge maximum raisonnable (par exemple, 120 ans)
        if (anneeActuelle - anneeNaissance > 120) {
            throw new AnneeNaissanceException("L'âge ne peut pas dépasser 120 ans");
        }
    }

    private void validerCentresInterets(List<String> centresInterets) throws CentresInteretsException {
        if (centresInterets == null || centresInterets.isEmpty()) {
            throw new CentresInteretsException("Au moins un centre d'intérêt doit être spécifié");
        }

        // Vérification des doublons
        List<String> centresUniques = new ArrayList<>();
        for (String centre : centresInterets) {
            if (centre == null || centre.trim().isEmpty()) {
                throw new CentresInteretsException("Un centre d'intérêt ne peut pas être vide");
            }

            String centreTrimme = centre.trim().toLowerCase();
            if (centresUniques.contains(centreTrimme)) {
                throw new CentresIntDoublonsException("Le centre d'intérêt '" + centre + "' est en doublon");
            }
            centresUniques.add(centreTrimme);
        }

        // Limite du nombre de centres d'intérêts (par exemple, maximum 10)
        if (centresInterets.size() > 10) {
            throw new CentresInteretsException("Trop de centres d'intérêts (maximum 10)");
        }
    }

    private Langues validerLanguePreferee(String languePreferee) throws LangagePrefereException {
        if (languePreferee == null || languePreferee.trim().isEmpty()) {
            throw new LangagePrefereException("La langue préférée doit être spécifiée");
        }

        if (!Langues.estValide(languePreferee)) {
            throw new LangagePrefereException("Langue non supportée : " + languePreferee +
                    ". Langues supportées : FRANÇAIS, ANGLAIS, ALLEMAND, ESPAGNOL, ITALIEN");
        }

        return Langues.depuisString(languePreferee);
    }
}*/

package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.anneeNaissanceExceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.centresInteretsExceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.pseudoExceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoueurServicesImpl implements IJoueurServices {

    private Map<String, JoueurDTO> joueurs = new HashMap<>();

    @Override
    public JoueurDTO ajouterJoueur(String pseudo, String prenom, int anneeNaissance,
                                   List<String> centresInterets, String languePreferee)
            throws AjouterJoueurException {

        // Validation du pseudo
        validerPseudo(pseudo);

        // Validation de l'année de naissance
        validerAnneeNaissance(anneeNaissance);

        // Validation des centres d'intérêts
        validerCentresInterets(centresInterets);

        // Validation de la langue préférée
        Langues langue = validerLanguePreferee(languePreferee);

        // Vérification que le pseudo n'existe pas déjà
        if (joueurs.containsKey(pseudo)) {
            throw new PseudoExistantException("Un joueur avec le pseudo '" + pseudo + "' existe déjà");
        }

        // Création du joueur
        JoueurDTO nouveauJoueur = new JoueurDTO(prenom, pseudo, anneeNaissance, 0,
                new ArrayList<>(centresInterets), langue);

        // Ajout dans la collection
        joueurs.put(pseudo, nouveauJoueur);

        return nouveauJoueur;
    }

    private void validerPseudo(String pseudo) throws PseudoException {
        if (pseudo == null || pseudo.trim().isEmpty()) {
            throw new PseudoException("Le pseudo ne peut pas être vide");
        }

        if (pseudo.length() < 3) {
            throw new PseudoException("Le pseudo doit contenir au moins 3 caractères");
        }

        if (!Character.isLetter(pseudo.charAt(0))) {
            throw new PseudoCommencantParUnChiffreException("Le pseudo ne peut pas commencer par un chiffre");
        }

        // Vérification que le pseudo ne contient que des lettres, chiffres et underscores
        if (!pseudo.matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
            throw new PseudoException("Le pseudo ne peut contenir que des lettres, chiffres et underscores");
        }
    }

    private void validerAnneeNaissance(int anneeNaissance) throws AnneeNaissanceException {
        int anneeActuelle = java.time.Year.now().getValue();

        if (anneeNaissance < 0) {
            throw new AnneeNaissNegativeException("L'année de naissance ne peut pas être négative");
        }

        if (anneeNaissance > anneeActuelle) {
            throw new AnneeNaissanceFuturException("L'année de naissance ne peut pas être dans le futur");
        }

        // Vérification d'un âge minimum (par exemple, 5 ans)
        if (anneeActuelle - anneeNaissance < 5) {
            throw new AnneeNaissanceException("Le joueur doit avoir au moins 5 ans");
        }

        // Vérification d'un âge maximum raisonnable (par exemple, 120 ans)
        if (anneeActuelle - anneeNaissance > 120) {
            throw new AnneeNaissanceException("L'âge ne peut pas dépasser 120 ans");
        }
    }

    private void validerCentresInterets(List<String> centresInterets) throws CentresInteretsException {
        if (centresInterets == null || centresInterets.isEmpty()) {
            throw new CentresInteretsException("Au moins un centre d'intérêt doit être spécifié");
        }

        // Vérification des doublons
        List<String> centresUniques = new ArrayList<>();
        for (String centre : centresInterets) {
            if (centre == null || centre.trim().isEmpty()) {
                throw new CentresInteretsException("Un centre d'intérêt ne peut pas être vide");
            }

            String centreTrimme = centre.trim().toLowerCase();
            if (centresUniques.contains(centreTrimme)) {
                throw new CentresIntDoublonsException("Le centre d'intérêt '" + centre + "' est en doublon");
            }
            centresUniques.add(centreTrimme);
        }

        // Limite du nombre de centres d'intérêts (par exemple, maximum 10)
        if (centresInterets.size() > 10) {
            throw new CentresInteretsException("Trop de centres d'intérêts (maximum 10)");
        }
    }

    private Langues validerLanguePreferee(String languePreferee) throws LangagePrefereException {
        if (languePreferee == null || languePreferee.trim().isEmpty()) {
            throw new LangagePrefereException("La langue préférée doit être spécifiée");
        }

        if (!Langues.estValide(languePreferee)) {
            throw new LangagePrefereException("Langue non supportée : " + languePreferee +
                    ". Langues supportées : FRANÇAIS, ANGLAIS, ALLEMAND, ESPAGNOL, ITALIEN");
        }

        return Langues.depuisString(languePreferee);
    }

    @Override
    public void supprimerJoueur(String pseudo) throws Exception {
        if (!joueurs.containsKey(pseudo)) {
            throw new Exception("Joueur introuvable.");
        }
        joueurs.remove(pseudo);
    }

    @Override
    public void reinitialiserJoueur(String pseudo) throws Exception {
        if (!joueurs.containsKey(pseudo)) {
            throw new Exception("Impossible de réinitialiser : joueur non trouvé.");
        }
        JoueurDTO joueur = joueurs.get(pseudo);
        joueur.setCentresInterets(new ArrayList<>());
        joueur.setLanguePreferee("");
    }

    @Override
    public List<JoueurDTO> listeJoueurs() throws Exception {
        throw new UnsupportedOperationException("Utiliser ListerJoueurServicesImpl pour cette méthode.");
    }
}
