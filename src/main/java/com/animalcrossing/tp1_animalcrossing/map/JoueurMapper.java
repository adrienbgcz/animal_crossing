package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.modele.Joueur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JoueurMapper implements RowMapper<Joueur> {

    public static final String BASE_SQL = "SELECT * FROM joueur";
    public static final String CREATE_SQL = "INSERT INTO joueur (nom, prenom, mail)";

    @Override
    public Joueur mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String nom = resultSet.getString("nom");
        String prenom = resultSet.getString("prenom");
        String mail  = resultSet.getString("mail");
        return new Joueur(id, nom, prenom, mail);
    }


}