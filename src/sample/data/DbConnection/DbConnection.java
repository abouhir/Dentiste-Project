package sample.data.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    private static Connection cnx;

    public static Connection getConnection() {
        if (cnx == null) {

            try {

                Class.forName("org.mariadb.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/lp_java_mini_project?user=root&password=");
                System.out.println("Successful connection to database ...");
            } catch (Exception e) {
                System.out.println("connection to database Failed !!");
                e.printStackTrace();
            }
        }
        return cnx;
    }


}
