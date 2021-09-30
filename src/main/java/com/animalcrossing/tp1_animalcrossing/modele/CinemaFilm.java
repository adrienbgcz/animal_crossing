package com.animalcrossing.tp1_animalcrossing.modele;

public class CinemaFilm {
    private int id;
    private int idCinema;
    private int idFilm;

    public CinemaFilm(int idCinema, int idFilm) {
        this.idCinema = idCinema;
        this.idFilm = idFilm;
    }

    public CinemaFilm(int id, int idCinema, int idFilm) {
        this.id = id;
        this.idCinema = idCinema;
        this.idFilm = idFilm;
    }

    public CinemaFilm() {
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
