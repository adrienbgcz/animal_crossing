package com.animalcrossing.tp1_animalcrossing.modele;

import java.util.List;

public class Cinema {
    private int id;
    private String nom;
    private int nombrePlaces;
    private int idIle;


    public Cinema(int id, String nom, int nombrePlaces) {
        this.id = id;
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
    }



    public Cinema() {
    }

    public Cinema(int id, String nom, int nombrePlaces, int idIle) {
        this.id = id;
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.idIle = idIle;
    }

    public Cinema(String nom, int nombrePlaces, int idIle) {
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.idIle = idIle;
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

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }


    public int getIdIle() {
        return idIle;
    }

    public void setIdIle(int idIle) {
        this.idIle = idIle;
    }
}
