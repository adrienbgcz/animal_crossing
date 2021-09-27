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
import java.util.stream.Collectors;

@Repository
@Transactional
public class JoueurDao extends JdbcDaoSupport {
    @Autowired
    public JoueurDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Joueur> getPlayersList() {
        String sql = JoueurMapper.BASE_SQL;
        try {
            List<Joueur> players = new ArrayList<>();
            players = this.getJdbcTemplate().query(sql, new JoueurMapper());
            return players;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public boolean isExistMail(String mail) {
        String sql = JoueurMapper.BASE_SQL + " WHERE joueur.mail = ?";

            List<Joueur> players = new ArrayList<>();
            players = this.getJdbcTemplate().query(sql, new JoueurMapper(), mail);
            if (players.isEmpty())
                return false;
            else {
                return true;
            }
        }


    public Joueur createPlayer(Joueur joueur) {
        String sql = JoueurMapper.CREATE_SQL + " VALUES(?,?,?)";
        try {
            int player = this.getJdbcTemplate().update(sql,new Object[]{joueur.getNom(), joueur.getPrenom(), joueur.getMail()});
            Joueur joueurToInsert = new Joueur();
            joueurToInsert.setNom(joueur.getNom());
            joueurToInsert.setPrenom(joueur.getPrenom());
            joueurToInsert.setMail(joueur.getMail());
            return joueurToInsert;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Joueur findPlayerByMail(String mailJoueur){
        String sql = JoueurMapper.BASE_SQL + " WHERE joueur.mail = ? ";

        Object[] params = new Object[]{mailJoueur}; //initialise les parametres de la requêtes
        try {
            Joueur foundPlayer = this.getJdbcTemplate().queryForObject(sql,params,new JoueurMapper());
            return foundPlayer;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Joueur findPlayerById(int playerId){
        String sql = JoueurMapper.BASE_SQL + " WHERE joueur.id = ? ";

        Object[] params = new Object[]{playerId}; //initialise les parametres de la requêtes
        try {
            Joueur foundPlayer = this.getJdbcTemplate().queryForObject(sql,params,new JoueurMapper());
            return foundPlayer;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Archipel findArchipelByPlayer(int playerId){
        String sql = ArchipelMapper.BASE_SQL + " WHERE id_joueur = ? ";

        Object[] params = new Object[]{playerId}; //initialise les parametres de la requêtes
        try {
            Archipel foundArchipel = this.getJdbcTemplate().queryForObject(sql,params,new ArchipelMapper());
            return foundArchipel;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
