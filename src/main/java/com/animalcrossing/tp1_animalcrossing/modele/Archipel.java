package com.animalcrossing.tp1_animalcrossing.modele;

public class Archipel {
    private int id;
    private String nom;
    private String localisation;
    private int idJoueur;



    public Archipel(int id, String nom, String localisation, int idJoueur) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        this.idJoueur = idJoueur;
    }

    public Archipel(String nom, String localisation, int idJoueur) {
        this.nom = nom;
        this.localisation = localisation;
        this.idJoueur = idJoueur;
    }

    public Archipel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }
}

