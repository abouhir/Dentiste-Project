package application.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/***********************************************************************
 * Module:  Dentiste.java
 * Author:  W0L1D
 * Purpose: Defines the Class Dentiste
 ***********************************************************************/


public class Dentiste extends User {
    public Dentiste(ResultSet person) throws SQLException {
        super(person);
    }
}