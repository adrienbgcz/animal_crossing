package com.animalcrossing.tp1_animalcrossing.dao;

import com.animalcrossing.tp1_animalcrossing.map.ArchipelMapper;
import com.animalcrossing.tp1_animalcrossing.map.JoueurMapper;
import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
import com.animalcrossing.tp1_animalcrossing.modele.Joueur;
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
public class ArchipelDao extends JdbcDaoSupport {
    @Autowired
    public ArchipelDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public Archipel createArchipel(Archipel archipel) {
        String sql = ArchipelMapper.CREATE_SQL + " VALUES(?,?,?)";
        try {
            int archipel2 = this.getJdbcTemplate().update(sql,new Object[]{archipel.getNom(), archipel.getLocalisation(), archipel.getIdJoueur()});
            Archipel archipelToInsert = new Archipel();
            archipelToInsert.setNom(archipel.getNom());
            archipelToInsert.setLocalisation(archipel.getLocalisation());
            archipelToInsert.setIdJoueur(archipel.getIdJoueur());
            return archipelToInsert;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Archipel> getArchipelList(int idJoueur) {
        String sql = ArchipelMapper.BASE_SQL + " WHERE id_joueur = ?";
        try {
            List<Archipel> archipel = new ArrayList<>();
            archipel = this.getJdbcTemplate().query(sql, new ArchipelMapper(), idJoueur);
            return archipel;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
