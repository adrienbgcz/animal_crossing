package com.animalcrossing.tp1_animalcrossing.map;

import com.animalcrossing.tp1_animalcrossing.modele.Batiment;
import com.animalcrossing.tp1_animalcrossing.modele.Ile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BatimentMapper implements RowMapper<Batiment> {

    public static final String BASE_SQL = "SELECT batiment.id, nom, id_ile, id_type_batiment, libelle FROM batiment JOIN type_batiment ON batiment.id_type_batiment = type_batiment.id";
    public static final String CREATE_SQL = "INSERT INTO batiment (nom, id_type_batiment, id_ile)";
    public static final String UPDATE_SQL = "UPDATE batiment";
    public static final String DELETE_SQL = "DELETE FROM batiment";

    @Override
    public Batiment mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String nom = resultSet.getString("nom");
        int idIle = resultSet.getInt("id_ile");
        int idTypeBatiment = resultSet.getInt("id_type_batiment");
        String libelle = resultSet.getString("libelle");
        return new Batiment(id, nom, idIle, idTypeBatiment, libelle);
    }
}
