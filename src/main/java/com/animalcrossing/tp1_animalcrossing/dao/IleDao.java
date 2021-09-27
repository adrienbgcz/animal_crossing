package com.animalcrossing.tp1_animalcrossing.dao;

import com.animalcrossing.tp1_animalcrossing.map.ArchipelMapper;
import com.animalcrossing.tp1_animalcrossing.map.IleMapper;
import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
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
public class IleDao extends JdbcDaoSupport {
    @Autowired
    public IleDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public Ile createIle(Ile ile) {
        String sql = IleMapper.CREATE_SQL + " VALUES (?,?,?)";
        try {
            int ile2 = this.getJdbcTemplate().update(sql,new Object[]{ile.getNom(), ile.getLocalisation(), ile.getIdArchipel()});
            Ile ileToInsert = new Ile();
            ileToInsert.setNom(ile.getNom());
            ileToInsert.setLocalisation(ile.getLocalisation());
            ileToInsert.setIdArchipel(ile.getIdArchipel());
            return ileToInsert;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Ile updateIle(Ile ile) {
        String sql = IleMapper.UPDATE_SQL + " SET nom = ?, localisation = ? WHERE id = ?";
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
    }

    public int deleteIle(Ile ile) {
        String sql = IleMapper.DELETE_SQL + " WHERE id = ?";
        try {
            int ile2 = this.getJdbcTemplate().update(sql,new Object[]{ile.getId()});
            System.out.println(ile2);
            return ile2 ;
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    public List<Ile> getIleList(int idArchipel) {
        String sql = IleMapper.BASE_SQL + " WHERE id_archipel = ? ORDER BY id";
        try {
            List<Ile> ile = new ArrayList<>();
            ile = this.getJdbcTemplate().query(sql, new IleMapper(), idArchipel);
            return ile;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Ile> getIleById(int idIle) {
        String sql = IleMapper.BASE_SQL + " WHERE id = ? ORDER BY id";
        try {
            List<Ile> ile = new ArrayList<>();
            ile = this.getJdbcTemplate().query(sql, new IleMapper(), idIle);
            return ile;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

