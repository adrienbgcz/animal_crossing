package com.animalcrossing.tp1_animalcrossing.dao;

import com.animalcrossing.tp1_animalcrossing.map.CinemaMapper;
import com.animalcrossing.tp1_animalcrossing.map.FilmMapper;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
import com.animalcrossing.tp1_animalcrossing.modele.Film;
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


    public List<Film> getFilmsByCinema(int idIle) {
        String sql = FilmMapper.BASE_SQL + "WHERE id_ile = ? GROUP BY film.id, titre";
        try {
            List<Film> filmList = new ArrayList<>();
            filmList = this.getJdbcTemplate().query(sql, new FilmMapper(), idIle);
            return filmList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}