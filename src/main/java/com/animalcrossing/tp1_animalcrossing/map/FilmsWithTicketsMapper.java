package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.modele.Film;
import com.animalcrossing.tp1_animalcrossing.modele.FilmsWithTickets;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmsWithTicketsMapper implements RowMapper<FilmsWithTickets> {

    public static final String FILMS_BY_CINEMA_WITH_TICKETS_SQL = "SELECT film.id, film.titre, cinema_film.tickets_restants FROM film " +
            "JOIN cinema_film ON film.id = cinema_film.id_film " +
            "JOIN cinema ON cinema_film.id_cinema = cinema.id ";


    @Override
    public FilmsWithTickets mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String titre = resultSet.getString("titre");
        int ticketsRestants = resultSet.getInt("tickets_restants");

        return new FilmsWithTickets(id, titre, ticketsRestants);
    }

}
