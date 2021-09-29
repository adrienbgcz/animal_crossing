package com.animalcrossing.tp1_animalcrossing.dao;

import com.animalcrossing.tp1_animalcrossing.map.CinemaMapper;
import com.animalcrossing.tp1_animalcrossing.map.FilmMapper;
import com.animalcrossing.tp1_animalcrossing.map.FilmsWithTicketsMapper;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
import com.animalcrossing.tp1_animalcrossing.modele.Film;
import com.animalcrossing.tp1_animalcrossing.modele.FilmsWithTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class FilmDao extends JdbcDaoSupport {


    @Autowired
    public FilmDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Film> getAllFilms() {
        String sql = FilmMapper.BASE_SQL;
        try {
            List<Film> filmList = new ArrayList<>();
            filmList = this.getJdbcTemplate().query(sql, new FilmMapper());
            return filmList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public List<FilmsWithTickets> getFilmsByCinema(int idCinema) {
        String sql = FilmsWithTicketsMapper.FILMS_BY_CINEMA_WITH_TICKETS_SQL + "WHERE id_cinema = ? GROUP BY film.id, film.titre, cinema_film.tickets_restants";
        try {
            List<FilmsWithTickets> filmList = new ArrayList<>();
            filmList = this.getJdbcTemplate().query(sql, new FilmsWithTicketsMapper(), idCinema);
            return filmList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /*public CinemaFilm addFilm(Cinema cinema) {
        String sql = CinemaMapper.CREATE_SQL + " VALUES (?,?,?)";
        try {
            int cinema2 = this.getJdbcTemplate().update(sql,new Object[]{cinema.getNom(), cinema.getNombrePlaces(), cinema.getIdIle()});
            Cinema cinemaToInsert = new Cinema();
            cinemaToInsert.setNom(cinema.getNom());
            cinemaToInsert.setNombrePlaces(cinema.getNombrePlaces());
            cinemaToInsert.setId(cinema.getIdIle());
            return cinemaToInsert;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }*/
}