package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.*;

import java.util.*;

public abstract class ListerJoueurServicesImpl implements IJoueurServices {

    private List<JoueurDTO> joueurs;

    public ListerJoueurServicesImpl(List<JoueurDTO> joueurs) {
        this.joueurs = joueurs;
    }

    @Override
    public List<JoueurDTO> listeJoueurs() throws Exception {
        if (joueurs == null) throw new Exception("Aucun joueur trouvé.");
        return joueurs;
    }

    @Override
    public abstract JoueurDTO ajouterJoueur(String pseudo, String prenom, int anneeNaissance, List<String> centresInterets, String languePreferee) throws AjouterJoueurException ;

    @Override
    public void supprimerJoueur(String pseudo) throws Exception {};

    @Override
    public void reinitialiserJoueur(String pseudo) throws Exception {};
}