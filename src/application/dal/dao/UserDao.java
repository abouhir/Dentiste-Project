package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.Dentiste;
import application.dal.model.Infermier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements IDaoQuery {

    PreparedStatement preStmCheckLogin;

    public UserDao() throws SQLException {
        Connection conn = DbConnection.getConnection();

        preStmCheckLogin = conn.prepareStatement(SELECT_USER);
    }

    public Dentiste checkDentistLogin(String username, String password) {
        Dentiste d = null;
        try {
            preStmCheckLogin.setString(1, "dentiste");
            preStmCheckLogin.setString(2, username);
            preStmCheckLogin.setString(3, password);
            ResultSet rst = preStmCheckLogin.executeQuery();
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
            preStmCheckLogin.setString(1, "infermier");
            ResultSet rst = preStmCheckLogin.executeQuery();
            if (rst.next())
                i = new Infermier(rst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
