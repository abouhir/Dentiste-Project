package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.*;
import application.dal.model.Visite;
import application.main.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

public class VisiteDao extends DefaultDao<Visite> {



    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement preStmSelectAll;

    Vector<Visite> visites;

    ClientDao clientDao;

    public VisiteDao(Connection conn, ClientDao clientDao) throws SQLException {
        preStmSelectAll = conn.prepareStatement(SELECT_ALL_VISITES);
        preStmInsert = conn.prepareStatement(INSERT_VISITES);
        preStmUpdate = conn.prepareStatement(UPDATE_VISITES);
        preStmDelete = conn.prepareStatement(DELETE_VISITES);

        this.clientDao = clientDao;
    }




    @Override
    public Vector<Visite> findAll() {
        if (visites == null)
            refresh();
        return visites;
    }

    @Override
    public void refresh() {
        if (visites != null)
            visites.clear();
        visites = selectAll();
    }

    @Override
    public Vector<Visite> selectAll() {
        Vector<Visite> visites = new Vector<>();

        try(ResultSet rst = preStmSelectAll.executeQuery()) {
            while (rst.next())
                visites.add(new Visite(rst));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return visites;
    }

    @Override
    public Visite find(long id) {
        Optional<Visite> c = findAll().stream()
                .filter(visite -> visite.getId() == id)
                .findFirst();
        return (c.orElse(null));
    }



    public Vector<Visite> findByCli(long id) {
        return findAll().stream()
                .filter(visite -> visite.getCliId() == id)
                .collect(Collectors.toCollection(Vector::new));
    }



    @Override
    public boolean delete(long id) {
        try {
            preStmDelete.setLong(1, id);
            preStmDelete.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean update(Visite o) {
        try {
            assignParams(preStmUpdate, o);
            preStmUpdate.setLong(5, o.getId());
            preStmUpdate.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(Visite o) {
        try {
            assignParams(preStmInsert, o);
            preStmInsert.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public void assignParams(PreparedStatement preStm, Visite o) throws SQLException {
        preStm.setLong(1, o.getCliId());
        preStm.setLong(2, o.getDentId());
        preStm.setString(3, o.getTrait());
        preStm.setString(4, o.getRemarque());
    }


    public Vector<TvVstClient> findVstByClient() {
        Vector<TvVstClient> tvVstClients = new Vector<>();
        findAll().forEach(vst -> tvVstClients
                .add(new TvVstClient(
                        clientDao.find(vst.getCliId()),
                        vst)
                )
        );
        return tvVstClients;
    }
}
