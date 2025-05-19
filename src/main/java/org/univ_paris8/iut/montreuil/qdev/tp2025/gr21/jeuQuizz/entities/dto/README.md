# DTO 

## Définition

Un **DTO (Data Transfer Object)** est une classe simple utilisée pour **transporter des données** entre différentes couches d'une application ou entre des systèmes (ex. : backend ↔ frontend, service ↔ base de données, etc.).

Elle ne contient **aucune logique métier** : uniquement des **champs de données** (attributs), accompagnés éventuellement de **getters** et **setters**.

---

## Objectif principal

L’objectif d’un DTO est de **faciliter l’échange de données** de manière claire, sécurisée et optimisée, en **structurant l’information** selon les besoins du destinataire (API, client, autre service, etc.).

---

## Exemple simple en Java

```java
public class JoueurDTO {
    private String nom;
    private String pseudo;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
