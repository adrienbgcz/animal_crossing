package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.modele.Batiment;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
import com.animalcrossing.tp1_animalcrossing.modele.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class FilmMapper implements RowMapper<Film> {

    public static final String BASE_SQL = "SELECT film.id, titre FROM film " +
            "JOIN cinema_film ON film.id = cinema_film.id_film " +
            "JOIN cinema ON cinema_film.id_cinema = cinema.id ";


    @Override
    public Film mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String titre = resultSet.getString("titre");

        return new Film(id, titre);
    }
}


