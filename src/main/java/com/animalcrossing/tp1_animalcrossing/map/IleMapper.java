package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
import com.animalcrossing.tp1_animalcrossing.modele.Ile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IleMapper implements RowMapper<Ile> {

    public static final String BASE_SQL = "SELECT id, nom, localisation, id_archipel FROM ile";
    public static final String CREATE_SQL = "INSERT INTO ile (nom, localisation, id_archipel)";
    public static final String UPDATE_SQL = "UPDATE ile";
    public static final String DELETE_SQL = "DELETE FROM ile";

    @Override
    public Ile mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String nom = resultSet.getString("nom");
        String localisation = resultSet.getString("localisation");
        int idArchipel  = resultSet.getInt("id_archipel");
        return new Ile(id, nom, localisation, idArchipel);
    }


}

