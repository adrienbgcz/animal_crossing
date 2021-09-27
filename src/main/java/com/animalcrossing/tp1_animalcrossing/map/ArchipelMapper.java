package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
import com.animalcrossing.tp1_animalcrossing.modele.Joueur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ArchipelMapper implements RowMapper<Archipel> {

    public static final String BASE_SQL = "SELECT id, nom, localisation, id_joueur FROM archipel";
    public static final String CREATE_SQL = "INSERT INTO archipel (nom, localisation, id_joueur)";

    @Override
    public Archipel mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String nom = resultSet.getString("nom");
        String localisation = resultSet.getString("localisation");
        int idJoueur  = resultSet.getInt("id_joueur");
        return new Archipel(id, nom, localisation, idJoueur);
    }


}


