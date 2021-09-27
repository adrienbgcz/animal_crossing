package com.animalcrossing.tp1_animalcrossing.modele;

public class Foret {
    private int id;
    private String nom;
    private int superficie;

    public Foret(int id, String nom, int superficie) {
        this.id = id;
        this.nom = nom;
        this.superficie = superficie;
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

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
}
