package com.animalcrossing.tp1_animalcrossing.dao;

import com.animalcrossing.tp1_animalcrossing.map.CinemaFilmMapper;
import com.animalcrossing.tp1_animalcrossing.map.CinemaMapper;
import com.animalcrossing.tp1_animalcrossing.map.FilmMapper;
import com.animalcrossing.tp1_animalcrossing.map.FilmsWithTicketsMapper;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
import com.animalcrossing.tp1_animalcrossing.modele.CinemaFilm;
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

    public List<CinemaFilm> getCinemaFilmList(CinemaFilm cinemaFilm) { // récupération des données de la table de jonction pour vérification de l'existance du film avant insertion
        String sql = CinemaFilmMapper.SELECT_SQL + " WHERE ? IN (id_cinema) AND ? IN (id_film)";

        List<CinemaFilm> cinemaFilmList = new ArrayList<>();
        cinemaFilmList = this.getJdbcTemplate().query(sql, new CinemaFilmMapper(), cinemaFilm.getIdCinema(), cinemaFilm.getIdFilm());
        return cinemaFilmList;
    }

    public CinemaFilm addFilm(CinemaFilm cinemaFilm) {
        String sql = CinemaFilmMapper.INSERT_CINEMA_FILM_SQL + " VALUES (?,?)";
        try {
            int cinemaFilm2 = this.getJdbcTemplate().update(sql,new Object[]{cinemaFilm.getIdCinema(), cinemaFilm.getIdFilm()});
            CinemaFilm cinemaFilmToInsert = new CinemaFilm();
            cinemaFilmToInsert.setIdCinema(cinemaFilm.getIdCinema());
            cinemaFilmToInsert.setIdFilm(cinemaFilm.getIdFilm());
            return cinemaFilmToInsert;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}