package com.animalcrossing.tp1_animalcrossing.modele;

public class Ile {
    private int id;
    private String nom;
    private String localisation;
    private int idArchipel;



    public Ile() {
    }

    public Ile(int id, String nom, String localisation, int idArchipel) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        this.idArchipel = idArchipel;
    }

    public Ile(String nom, String localisation, int idArchipel) {
        this.nom = nom;
        this.localisation = localisation;
        this.idArchipel = idArchipel;
    }

    public Ile(int id) {
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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getIdArchipel() {
        return idArchipel;
    }

    public void setIdArchipel(int idArchipel) {
        this.idArchipel = idArchipel;
    }
}
