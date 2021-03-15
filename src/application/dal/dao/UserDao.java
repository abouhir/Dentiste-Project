package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.Dentiste;
import application.dal.model.Infermier;
import application.dal.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends DefaultDao<User> {

    PreparedStatement preStmCheckLogind;
    PreparedStatement preStmCheckLoginf;

    public UserDao(Connection conn) throws SQLException {
        preStmCheckLogind = conn.prepareStatement(SELECT_USER_DENTIST);
        preStmCheckLoginf = conn.prepareStatement(SELECT_USER_INFERMIER);
    }

    public Dentiste checkDentistLogin(String username, String password) {
        Dentiste d = null;
        try {
            preStmCheckLogind.setString(1, username);
            preStmCheckLogind.setString(2, password);
            ResultSet rst = preStmCheckLogind.executeQuery();
            if (rst.next())
                d = new Dentiste(rst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }


    public Infermier checkInfermierLogin(String username, String password) {
        Infermier i = null;
        try {
            preStmCheckLoginf.setString(1, username);
            preStmCheckLoginf.setString(2, password);
            ResultSet rst = preStmCheckLogind.executeQuery();
            if (rst.next())
                i = new Infermier(rst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
