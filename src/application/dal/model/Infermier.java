package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/***********************************************************************
 * Module:  Infermier.java
 * Author:  W0L1D
 * Purpose: Defines the Class Infermier
 ***********************************************************************/


public class Infermier extends User {
    public Infermier(ResultSet person) throws SQLException {
        super(person);
    }
}