package org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls.testServices;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.impls.mocks.*;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.services.interfaces.IJoueurServices;
import org.univ_paris8.iut.montreuil.qdev.tp2025.gr21.jeuQuizz.utils.exceptions.ajouterJoueurDTOExceptions.AjouterJoueurException;

import java.util.List;

public class TestAjouterJoueur {

    IJoueurServices joueurServices;

    @BeforeEach
    public void setUp() {
        // Rien à initialiser pour les mocks individuels
    }

    @Test
    public void testAjouterJoueurKOPseudoIncorrect() {
        joueurServices = new AjouterJoueurKOPseudoIncorrectMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("", "Jean", 2000, List.of("Lecture"), "Français"));
    }

    @Test
    public void testAjouterJoueurKONomIncorrect() {
        joueurServices = new AjouterJoueurKONomIncorrectMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("JeanDu94", "", 2000, List.of("Lecture"), "Français"));
    }

    @Test
    public void testAjouterJoueurKOAnneeNaissanceIncorrect() {
        joueurServices = new AjouterJoueurKOAnneeNaissanceIncorrectMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("JeanDu94", "Jean", 1800, List.of("Lecture"), "Français"));
    }

    @Test
    public void testAjouterJoueurKOAnneeNaissanceFutur() {
        joueurServices = new AjouterJoueurKOAnneeNaissanceFuturMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("JeanDu94", "Jean", 3000, List.of("Lecture"), "Français"));
    }

    @Test
    public void testAjouterJoueurKOAnneeNaissanceNegative() {
        joueurServices = new AjouterJoueurKOAnneeNaissanceNegativeMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("JeanDu94", "Jean", -100, List.of("Lecture"), "Français"));
    }

    @Test
    public void testAjouterJoueurKOCentresInteretsIncorrect() {
        joueurServices = new AjouterJoueurKOCentresInteretsIncorrectMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("JeanDu94", "Jean", 2000, List.of(), "Français"));
    }

    @Test
    public void testAjouterJoueurKOCentresInteretsDoublons() {
        joueurServices = new AjouterJoueurKOCentresInteretsDoublonsMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("JeanDu94", "Jean", 2000, List.of("Musique", "Musique"), "Français"));
    }

    @Test
    public void testAjouterJoueurKOLangagePrefereIncorrect() {
        joueurServices = new AjouterJoueurKOLangagePrefereIncorrectMock();
        assertThrows(AjouterJoueurException.class, () ->
                joueurServices.ajouterJoueur("JeanDu94", "Jean", 2000, List.of("Lecture"), ""));
    }
}
