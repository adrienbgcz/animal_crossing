package com.animalcrossing.tp1_animalcrossing.dao;

import com.animalcrossing.tp1_animalcrossing.map.BatimentMapper;
import com.animalcrossing.tp1_animalcrossing.map.IleMapper;
import com.animalcrossing.tp1_animalcrossing.modele.Batiment;
import com.animalcrossing.tp1_animalcrossing.modele.Ile;
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
public class BatimentDao extends JdbcDaoSupport {


    @Autowired
    public BatimentDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    public List<Batiment> getBatimentList(int idIle) {
        String sql = BatimentMapper.BASE_SQL + " WHERE id_ile = ? ORDER BY id";
        try {
            List<Batiment> batimentList = new ArrayList<>();
            batimentList = this.getJdbcTemplate().query(sql, new BatimentMapper(), idIle);
            return batimentList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public Batiment createBatiment(Batiment batiment) {
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
    }


    /*public Batiment updateBatiment(Batiment batiment) {
        String sql = BatimentMapper.UPDATE_SQL + " SET nom = ?, localisation = ? WHERE id = ?";
        try {
            int ile2 = this.getJdbcTemplate().update(sql,new Object[]{ile.getNom(), ile.getLocalisation(), ile.getId()});
            Ile ileToUpdate = new Ile();
            ileToUpdate.setNom(ile.getNom());
            ileToUpdate.setLocalisation(ile.getLocalisation());
            ileToUpdate.setIdArchipel(ile.getIdArchipel());
            return ileToUpdate;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }*/


}

