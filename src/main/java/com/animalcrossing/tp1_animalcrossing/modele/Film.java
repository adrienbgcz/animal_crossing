package com.animalcrossing.tp1_animalcrossing.modele;

public class Film {
    private int id;
    private String titre;
    private int ticketsRestants;

    public Film(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public Film(int id, String titre, int ticketsRestants) {
        this.id = id;
        this.titre = titre;
        this.ticketsRestants = ticketsRestants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getTicketsRestants() {
        return ticketsRestants;
    }

    public void setTicketsRestants(int ticketsRestants) {
        this.ticketsRestants = ticketsRestants;
    }
}
