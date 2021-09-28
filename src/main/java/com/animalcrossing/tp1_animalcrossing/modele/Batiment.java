package com.animalcrossing.tp1_animalcrossing.modele;

public class Batiment {
    private int id;
    private String nom;
    private int idIle;
    private int idTypeBatiment;
    private String libelle;

    public Batiment(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Batiment(int id, String nom, int idIle, int idTypeBatiment) {
        this.id = id;
        this.nom = nom;
        this.idIle = idIle;
        this.idTypeBatiment = idTypeBatiment;
    }

    public Batiment(int id, String nom, int idIle, int idTypeBatiment, String libelle) {
        this.id = id;
        this.nom = nom;
        this.idIle = idIle;
        this.idTypeBatiment = idTypeBatiment;
        this.libelle = libelle;
    }

    public Batiment(String nom, int idIle, int idTypeBatiment) {
        this.nom = nom;
        this.idIle = idIle;
        this.idTypeBatiment = idTypeBatiment;
    }

    public Batiment() {
    }

    public Batiment(int id) {
        this.id = id;
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

    public int getIdIle() {
        return idIle;
    }

    public void setIdIle(int idIle) {
        this.idIle = idIle;
    }

    public int getIdTypeBatiment() {
        return idTypeBatiment;
    }

    public void setIdTypeBatiment(int idTypeBatiment) {
        this.idTypeBatiment = idTypeBatiment;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
