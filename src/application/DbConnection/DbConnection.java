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

    public DbConnection() throws SQLException {
        cnx = getConnection();
        clientDao = new ClientDao(cnx);
        dentistDao = new DentisteDao(cnx);
        infermierDao = new InfermierDao(cnx);
        medicsDao = new MedicsDao(cnx);
        visiteDao = new VisiteDao(cnx);
        userDao = new UserDao(cnx);
        ordDao = new OrdonnanceDao(cnx);
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public DentisteDao getDentistDao() {
        return dentistDao;
    }

    public void setDentistDao(DentisteDao dentistDao) {
        this.dentistDao = dentistDao;
    }

    public InfermierDao getInfermierDao() {
        return infermierDao;
    }

    public void setInfermierDao(InfermierDao infermierDao) {
        this.infermierDao = infermierDao;
    }

    public MedicsDao getMedicsDao() {
        return medicsDao;
    }

    public void setMedicsDao(MedicsDao medicsDao) {
        this.medicsDao = medicsDao;
    }

    public VisiteDao getVisiteDao() {
        return visiteDao;
    }

    public void setVisiteDao(VisiteDao visiteDao) {
        this.visiteDao = visiteDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public OrdonnanceDao getOrdDao() {
        return ordDao;
    }

    public void setOrdDao(OrdonnanceDao ordDao) {
        this.ordDao = ordDao;
    }

    public Connection getConnection() {
        if (cnx == null) {

            try {
              //  Class.forName("org.mariadb.jdbc.Driver");
                cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/lp_java_mini_project","root","") ;
                System.out.println("Successful connection to database ...");
            } catch (Exception e) {
                System.out.println("connection to database Failed !!");
                e.printStackTrace();
            }
        }
        return cnx;
    }


}
