package application.dal.dao;

public interface IDaoQuery {

    /*
    *
    *   User login Check
    *
     */

    String SELECT_USER = "SELECT * FROM ? WHERE usernm = ? and passwd = ?";



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



    /*
     *   Ordonnance needed Queries
     *
     */
    String SELECT_ALL_ORDONNANCES = "SELECT * FROM ordonnance;";
    String UPDATE_ORDONNANCES =
            "UPDATE ordonnance SET cli_id = ?, vis_id = ?, " +
                    "ord_date = current_timestamp" +
                    "WHERE id = ?" ;
    String INSERT_ORDONNANCES =
            "INSERT INTO ordonnance VALUES (null, ?, ?, null)";
    String DELETE_ORDONNANCES = "DELETE FROM ordonnance WHERE id = ?";



    /*
     *   Medicaments needed Queries
     *
     */
    String SELECT_MEDICS_BY_ORDONNANCE = "SELECT m.* FROM medicament m, contenir c WHERE c.Ord_id = ?";

    String SELECT_ALL_MEDICS = "SELECT * FROM medicament;";
    String UPDATE_MEDICS =
            "UPDATE medicament SET medic_name = ?, medic_description = ?, " +
                    "WHERE id = ?" ;
    String INSERT_MEDICS =
            "INSERT INTO medicament VALUES (?, ?)";
    String DELETE_MEDICS = "DELETE FROM medicament WHERE id = ?";

}
