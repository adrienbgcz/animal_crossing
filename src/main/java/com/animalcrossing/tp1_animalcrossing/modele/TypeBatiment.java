package com.animalcrossing.tp1_animalcrossing.modele;

public class TypeBatiment {
    private int id;
    private String libelle;

    public TypeBatiment(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
