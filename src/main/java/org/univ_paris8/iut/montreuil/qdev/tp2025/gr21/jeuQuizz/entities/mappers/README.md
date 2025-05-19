# 🔁 Mappers

## Description

Ce projet contient un ensemble de **classes de mapping** servant à convertir des objets de type **BO (Business Object)** en objets de type **DTO (Data Transfer Object)**.  
Ces classes jouent le rôle de **convertisseurs**/**traducteurs** entre les objets métiers internes et les objets destinés à l’échange de données (API, fichiers, etc.).

Par exemple transformer un objet `FichierCSVBO` en un objet `FichierCSVDTO`.

## 🎯 Objectif

- Les **BO (Business Objects)** représentent les entités utilisées en interne dans l’application pour la logique métier.
- Les **DTO (Data Transfer Objects)** sont utilisés pour transférer les données entre différentes couches de l’application ou entre systèmes.

Les classes mapper permettent une **séparation claire des responsabilités** en isolant la logique de transformation.

## ✅ Avantages

- Logique de transformation claire et centralisée
- Meilleure organisation et lisibilité du code
-  Réutilisabilité dans l’ensemble du projet
- Facilite l’écriture de tests unitaires ciblés

## 🧪 Exemple (Java)

```java
public class FichierCSVBOtoFichierCSVDTOMapper {
    public static FichierCSVDTO toDTO(FichierCSVBO bo) {
        FichierCSVDTO dto = new FichierCSVDTO();
        dto.setNomFichier(bo.getNomFichier());
        dto.setDonnees(bo.getDonnees());
        return dto;
    }
}
