package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;




public class Dentiste extends User {
    public Dentiste(ResultSet person) throws SQLException {
        super(person);
    }

}