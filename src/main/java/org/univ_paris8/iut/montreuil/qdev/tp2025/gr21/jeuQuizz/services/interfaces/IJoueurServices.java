package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import java.util.List;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.*;

public interface IJoueurServices {

    JoueurDTO ajouterJoueur(
            String pseudo,
            String prenom,
            int anneeNaissance,
            List<String> centresInterets,
            String languePreferee
    ) throws AjouterJoueurException;

    List<JoueurDTO> listeJoueurs()
            throws Exception; // Tu peux spécifier ici les vraies exceptions utilisées par listeJoueurs si connues

    void supprimerJoueur(String pseudo)
            throws Exception; // À remplacer par une exception comme JoueurNonExistantException si elle existe


    void reinitialiserJoueur(String pseudo) throws Exception;

}
