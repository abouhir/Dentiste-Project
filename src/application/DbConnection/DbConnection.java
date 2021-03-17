package application.DbConnection;

import application.dal.dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private Connection cnx;
    private ClientDao clientDao;
    private DentisteDao dentistDao;
    private InfermierDao infermierDao;
    private MedicsDao medicsDao;
    private VisiteDao visiteDao;
    private UserDao userDao;
    private OrdonnanceDao ordDao;
    private RdvDao rdvDao;

    public DbConnection() {
        cnx = getConnection();
        try {
            clientDao = new ClientDao(cnx);
            dentistDao = new DentisteDao(cnx);
            infermierDao = new InfermierDao(cnx);
            medicsDao = new MedicsDao(cnx);
            visiteDao = new VisiteDao(cnx);
            userDao = new UserDao(cnx);
            ordDao = new OrdonnanceDao(cnx);
            rdvDao = new RdvDao(cnx);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        if (cnx == null) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/lp_java_mini_project","root","") ;
                System.out.println("Successful connection to database ...");
            } catch (Exception e) {
                System.out.println("connection to database Failed !!");
                e.printStackTrace();
            }
        }
        return cnx;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public DentisteDao getDentistDao() {
        return dentistDao;
    }

    public InfermierDao getInfermierDao() {
        return infermierDao;
    }

    public MedicsDao getMedicsDao() {
        return medicsDao;
    }

    public VisiteDao getVisiteDao() {
        return visiteDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public OrdonnanceDao getOrdDao() {
        return ordDao;
    }

    public RdvDao getRdvDao() {
        return rdvDao;
    }
}
