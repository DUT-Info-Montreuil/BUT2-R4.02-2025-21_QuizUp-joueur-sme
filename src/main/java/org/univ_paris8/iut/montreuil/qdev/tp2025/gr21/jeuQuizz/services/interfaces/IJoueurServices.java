package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import java.util.List;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.*;
        import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.pseudoExceptions.*;
        import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.anneeNaissanceExceptions.*;
        import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.centresInteretsExceptions.*;

public interface IJoueurServices {

    JoueurDTO ajouterJoueur(
            String pseudo,
            String prenom,
            int anneeNaissance,
            List<String> centresInterets,
            String languePreferee
    ) throws AjouterJoueurDTOException,
            PseudoException,
            PseudoExistantException,
            PseudoCommencantParUnChiffreException,
            NomJoueurDTOException,
            AnneeNaissanceException,
            AnneeNaissNegativeException,
            AnneeNaissanceFuturException,
            CentresInteretsException,
            CentresIntDoublonsException,
            LangagePrefereException;

    List<JoueurDTO> listeJoueurs()
            throws Exception; // Tu peux spécifier ici les vraies exceptions utilisées par listeJoueurs si connues

    void supprimerJoueur(String pseudo)
            throws Exception; // À remplacer par une exception comme JoueurNonExistantException si elle existe
}
