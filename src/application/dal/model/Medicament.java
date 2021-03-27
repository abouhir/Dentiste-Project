package application.dal.model;

import javafx.scene.control.CheckBox;

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
    private CheckBox select;

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

    public Medicament(ResultSet rst) throws SQLException {
        setId(rst.getLong("medic_id"));
        setNom(rst.getString("medic_nom"));
        setDescription(rst.getString("medic_description"));

    }

    public Medicament(long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
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

    public boolean containsInProps(String key) {
        return getNom().contains(key) || getDescription().contains(key);
    }


}