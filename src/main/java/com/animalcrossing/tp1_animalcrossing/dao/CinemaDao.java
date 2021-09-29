package com.animalcrossing.tp1_animalcrossing.dao;

import com.animalcrossing.tp1_animalcrossing.map.BatimentMapper;
import com.animalcrossing.tp1_animalcrossing.map.CinemaMapper;
import com.animalcrossing.tp1_animalcrossing.modele.Batiment;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
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
public class CinemaDao extends JdbcDaoSupport {


    @Autowired
    public CinemaDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    public List<Cinema> getCinemaList(int idIle) {
        String sql = CinemaMapper.BASE_SQL + " WHERE id_ile = ? ORDER BY id";
        try {
            List<Cinema> cinemaList = new ArrayList<>();
            cinemaList = this.getJdbcTemplate().query(sql, new CinemaMapper(), idIle);
            return cinemaList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Cinema createCinema(Cinema cinema) {
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
    }

    public Cinema updateCinema(Cinema cinema) {
        String sql = CinemaMapper.UPDATE_SQL + " SET nom = ?, nombre_places = ?, id_ile = ? WHERE id = ?";
        try {
            int cinema2 = this.getJdbcTemplate().update(sql,new Object[]{cinema.getNom(), cinema.getNombrePlaces(), cinema.getIdIle(), cinema.getId()});
            Cinema cinemaToUpdate = new Cinema();
            cinemaToUpdate.setNom(cinema.getNom());
            cinemaToUpdate.setNombrePlaces(cinema.getNombrePlaces());
            cinemaToUpdate.setIdIle(cinema.getIdIle());
            cinemaToUpdate.setId(cinema.getId());
            return cinemaToUpdate;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int deleteCinema(Cinema cinema) {
        String sql = CinemaMapper.DELETE_SQL + " WHERE id = ?";
        try {
            int cinema2 = this.getJdbcTemplate().update(sql,new Object[]{cinema.getId()});
            return cinema2 ;
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }




    /*public Batiment createBatiment(Batiment batiment) {
        String sql = BatimentMapper.CREATE_SQL + " VALUES (?,?,?)";
        try {
            int batiment2 = this.getJdbcTemplate().update(sql,new Object[]{batiment.getNom(), batiment.getIdIle(), batiment.getIdTypeBatiment()});
            Batiment batimentToInsert = new Batiment();
            batimentToInsert.setNom(batiment.getNom());
            batimentToInsert.setIdIle(batiment.getIdIle());
            batimentToInsert.setIdTypeBatiment(batiment.getIdTypeBatiment());
            return batimentToInsert;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }*/


}