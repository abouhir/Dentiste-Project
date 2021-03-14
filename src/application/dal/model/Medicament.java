package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/***********************************************************************
 * Module:  Medicament.java
 * Author:  W0L1D
 * Purpose: Defines the Class Medicament
 ***********************************************************************/


public class Medicament {

    private long id;
    private String nom;
    private String description;

    public Medicament(ResultSet rst) throws SQLException {
        setId(rst.getLong("medic_id"));
        setNom(rst.getString("medic_nom"));
        setDescription(rst.getString("medic_description"));

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }
}