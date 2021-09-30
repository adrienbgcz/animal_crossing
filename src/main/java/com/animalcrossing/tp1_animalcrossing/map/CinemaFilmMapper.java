package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.modele.CinemaFilm;
import com.animalcrossing.tp1_animalcrossing.modele.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaFilmMapper implements RowMapper<CinemaFilm> {
    public static final String SELECT_SQL = "SELECT * FROM cinema_film";

    public static final String INSERT_CINEMA_FILM_SQL = "INSERT INTO cinema_film (id_cinema, id_film)";

    @Override
    public CinemaFilm mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        int idCinema = resultSet.getInt("id_cinema");
        int idFilm = resultSet.getInt("id_film");
        return new CinemaFilm(id, idCinema, idFilm);
    }
}
