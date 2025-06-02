package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.AjouterJoueurException;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.LangagePrefereException;

import java.util.List;

public class AjouterJoueurKOLangagePrefereIncorrectMock implements IJoueurServices {
    @Override
    public JoueurDTO ajouterJoueur(String pseudo, String prenom, int anneeNaissance, List<String> centresInterets, String languePreferee) throws AjouterJoueurException {
        throw new LangagePrefereException("Langage preféré incorrect");
    }

    @Override
    public List<JoueurDTO> listeJoueurs() throws Exception {
        return List.of();
    }

    @Override
    public void supprimerJoueur(String pseudo) throws Exception {

    }

    @Override
    public void reinitialiserJoueur(String pseudo) throws Exception {

    }
}
