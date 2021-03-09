package sample.data.dao;

public interface IDaoQuery<T> {

    /*
     *   Client needed Queries
     *
     */
    String SELECT_ALL_CLIENTS = "SELECT * FROM client;";
    String UPDATE_CLIENT =
            "UPDATE client SET fullName = ?, cin = ?, " +
                    "tele = ?, address = ?, email = ? " +
                    "WHERE id = ?" ;
    String INSERT_CLIENT =
            "INSERT INTO client VALUES (null, ?, ?, ?, ?, ?)";
    String DELETE_CLIENT = "DELETE FROM client WHERE id = ?";



    /*
    *   Infermier needed Queries
    *
     */
    String SELECT_ALL_INFERMIERS = "SELECT * FROM infermier;";
    String UPDATE_INFERMIERS =
            "UPDATE infermier SET fullName = ?, cin = ?, " +
                    "tele = ?, address = ?, email = ?, " +
                    "usernm = ?, passwd = ? " +
                    "WHERE id = ?" ;
    String INSERT_INFERMIERS =
            "INSERT INTO infermier VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
    String DELETE_INFERMIERS = "DELETE FROM infermier WHERE id = ?";


    /*
     *   Dentist needed Queries
     *
     */
    String SELECT_ALL_DENTISTS = "SELECT * FROM dentiste;";
    String UPDATE_DENTISTS =
            "UPDATE dentiste SET fullName = ?, cin = ?, " +
                    "tele = ?, address = ?, email = ? " +
                    "usernm = ?, passwd = ? " +
                    "WHERE id = ?" ;
    String INSERT_DENTISTS =
            "INSERT INTO dentiste VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
    String DELETE_DENTISTS = "DELETE FROM dentiste WHERE id = ?";

}
