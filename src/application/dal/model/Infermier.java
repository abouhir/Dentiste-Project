package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Infermier extends User {
    public Infermier(ResultSet person) throws SQLException {
        super(person);
    }
}