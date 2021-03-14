package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.Client;
import application.dal.model.Dentiste;
import application.dal.model.Infermier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

public class InfermierDao extends DefaultDao<Infermier> {

    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement stmSelectAll;


    Vector<Infermier> infermiers;


    public InfermierDao(Connection conn) throws SQLException {

        stmSelectAll = conn.prepareStatement(SELECT_ALL_INFERMIERS);
        preStmInsert = conn.prepareStatement(INSERT_INFERMIERS);
        preStmUpdate = conn.prepareStatement(UPDATE_INFERMIERS);
        preStmDelete = conn.prepareStatement(DELETE_INFERMIERS);

    }

    @Override
    public Vector<Infermier> findAll() {
        if (infermiers == null)
            refresh();
        return infermiers;
    }

    @Override
    public Vector<Infermier> selectAll() {
        Vector<Infermier> infermiers = new Vector<>();

        try(ResultSet rst = stmSelectAll.executeQuery()) {
            while (rst.next())
                infermiers.add(new Infermier(rst));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return infermiers;
    }

    @Override
    public void refresh() {
        if (infermiers != null)
            infermiers.clear();
        infermiers = selectAll();
    }

    @Override
    public Infermier find(long id) {
        Optional<Infermier> c = findAll().stream()
                .filter(infermier -> infermier.getId() == id)
                .findFirst();
        return (c.orElse(null));
    }

    @Override
    public Vector<Infermier> findThatContains(String key) {
        return findAll().stream()
                .filter(c -> c.containsInProps(key))
                .collect(Collectors.toCollection(Vector::new));
    }

    @Override
    public boolean delete(long id) {
        try {
            preStmDelete.setLong(1, id);
            preStmDelete.execute();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Infermier o) {
        try {
            assignParams(preStmUpdate, o);
            preStmUpdate.setLong(8, o.getId());
            preStmUpdate.execute();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(Infermier o) {
        try {
            assignParams(preStmInsert, o);
            preStmInsert.execute();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public void assignParams(PreparedStatement preStm, Infermier o) throws SQLException {
        preStm.setString(1, o.getFullName());
        preStm.setString(2, o.getCin());
        preStm.setString(3, o.getTele());
        preStm.setString(4, o.getAddress());
        preStm.setString(5, o.getEmail());
        preStm.setString(6, o.getUsernm());
        preStm.setString(7, o.getPasswd());
    }
}
