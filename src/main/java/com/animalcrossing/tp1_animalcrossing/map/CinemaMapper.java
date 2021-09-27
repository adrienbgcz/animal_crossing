package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.dao.FilmDao;
import com.animalcrossing.tp1_animalcrossing.modele.Batiment;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
import com.animalcrossing.tp1_animalcrossing.modele.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CinemaMapper implements RowMapper<Cinema> {

    public static final String BASE_SQL = "SELECT cinema.id, nom, nombre_places, id_ile FROM cinema ";

    public static final String CREATE_SQL = "INSERT INTO cinema (nom, nombre_places, id_ile)";
    public static final String UPDATE_SQL = "UPDATE cinema";
    public static final String DELETE_SQL = "DELETE FROM cinema";

    @Override
    public Cinema mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String nom = resultSet.getString("nom");
        int nombrePlaces = resultSet.getInt("nombre_places");
        int idIle = resultSet.getInt("id_ile");
        return new Cinema(id, nom, nombrePlaces, idIle);
    }
}

