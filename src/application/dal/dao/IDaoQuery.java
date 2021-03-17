package application.dal.dao;

public interface IDaoQuery {

    /*
    *
    *   User login Check
    *
     */
    String SELECT_USER_DENTIST = "SELECT * FROM dentiste WHERE dent_usernm = ? and dent_passwd = ?";
    String SELECT_USER_INFERMIER = "SELECT * FROM infermier WHERE inf_usernm = ? and inf_passwd = ?";



    /*
     *   Client needed Queries
     */
    String SELECT_ALL_CLIENTS = "SELECT * FROM client;";
    String UPDATE_CLIENT =
            "UPDATE client SET cli_fullName = ?, cli_cin = ?, " +
                    "cli_tele = ?, cli_address = ?, cli_email = ? " +
                    "WHERE cli_id = ?" ;
    String INSERT_CLIENT =
            "INSERT INTO client VALUES (null, ?, ?, ?, ?, ?)";
    String DELETE_CLIENT = "DELETE FROM client WHERE cli_id = ?";



    /*
    *   Infermier needed Queries
     */
    String SELECT_ALL_INFERMIERS = "SELECT * FROM infermier;";
    String UPDATE_INFERMIERS =
            "UPDATE infermier SET inf_fullName = ?, inf_cin = ?, " +
                    "inf_tele = ?, inf_address = ?, inf_email = ?, " +
                    "inf_usernm = ?, inf_passwd = ? " +
                    "WHERE inf_id = ?" ;
    String INSERT_INFERMIERS =
            "INSERT INTO infermier VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
    String DELETE_INFERMIERS = "DELETE FROM infermier WHERE inf_id = ?";


    /*
     *   Dentist needed Queries
     */
    String SELECT_ALL_DENTISTS = "SELECT * FROM dentiste;";
    String UPDATE_DENTISTS =
            "UPDATE dentiste SET dent_fullName = ?, dent_cin = ?, " +
                    "dent_tele = ?, address = ?, dent_email = ? " +
                    "dent_usernm = ?, dent_passwd = ? " +
                    "WHERE dent_id = ?" ;
    String INSERT_DENTISTS =
            "INSERT INTO dentiste VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
    String DELETE_DENTISTS = "DELETE FROM dentiste WHERE dent_id = ?";



    /*
     *   Ordonnance needed Queries
     */
    String SELECT_ALL_ORDONNANCES = "SELECT * FROM ordonnance;";
    String UPDATE_ORDONNANCES =
            "UPDATE ordonnance SET vst_id = ?, " +
                    "ord_date = ()" +
                    "WHERE id = ?" ;
    String INSERT_ORDONNANCES =
            "INSERT INTO ordonnance VALUES (null, ?, null)";
    String DELETE_ORDONNANCES = "DELETE FROM ordonnance WHERE id = ?";



    /*
     *   Medicaments needed Queries
     */
    String SELECT_MEDICS_BY_ORDONNANCE = "SELECT m.* FROM medicament m, contenir c WHERE c.ford_id = ?";

    String SELECT_ALL_MEDICS = "SELECT * FROM medicament;";
    String UPDATE_MEDICS =
            "UPDATE medicament SET medic_name = ?, medic_description = ?, " +
                    "WHERE medic_id = ?" ;
    String INSERT_MEDICS =
            "INSERT INTO medicament VALUES (null, ?, ?)";
    String DELETE_MEDICS = "DELETE FROM medicament WHERE medic_id = ?";



    /*
     *   Visite needed Queries
     */
    String SELECT_ALL_VISITES = "SELECT * FROM visite";
    String UPDATE_VISITES =
            "UPDATE visite SET cli_id = ?, den_id = ?, " +
                    "vst_traitement = ?, vst_remarque = ? " +
                    "vst_date =NOW()" +
                    "WHERE id = ?" ;
    String INSERT_VISITES = "INSERT INTO visite " +
            "(id, vst_date, cli_id, den_id, vst_traitement, vst_remarque)" +
            " VALUES (null, null, ?, ?, ?, ?)";
    String DELETE_VISITES = "DELETE FROM visite WHERE id = ?";




    /*
     *   Medicaments needed Queries
     */
    String SELECT_ALL_RDV = "SELECT * FROM rendezvous";
    String SELECT_ALL_BY_CLI = "SELECT * FROM rendezvous WHERE fcli_id = ?";
    String UPDATE_RDV =
            "UPDATE rendezvous SET finf_id = ?, fcli_id = ?, " +
                    "rdv_date = ?, rdv_createdAt =NOW()" +
                    "WHERE rdv_id = ?" ;
    String INSERT_RDV =
            "INSERT INTO rendezvous VALUES (null, ?, ?, ?, null)";
    String DELETE_RDV = "DELETE FROM medicament WHERE rdv_id = ?";


}
