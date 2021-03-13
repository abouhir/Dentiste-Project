package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.Client;
import application.dal.model.Dentiste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

public class DentisteDao extends DefaultDao<Dentiste> {

    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement stmSelectAll;


    Vector<Dentiste> dentistes;


    public DentisteDao() throws SQLException {

        Connection conn = DbConnection.getConnection();

        stmSelectAll = conn.prepareStatement(SELECT_ALL_DENTISTS);
        preStmInsert = conn.prepareStatement(INSERT_DENTISTS);
        preStmUpdate = conn.prepareStatement(UPDATE_DENTISTS);
        preStmDelete = conn.prepareStatement(DELETE_DENTISTS);

    }

    @Override
    public Vector<Dentiste> findAll() {
        if (dentistes == null)
            refresh();
        return dentistes;
    }

    @Override
    public Vector<Dentiste> selectAll() {
        Vector<Dentiste> dentistes = new Vector<>();

        try(ResultSet rst = stmSelectAll.executeQuery()) {
            while (rst.next())
                dentistes.add(new Dentiste(rst));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return dentistes;
    }

    @Override
    public void refresh() {
        if (dentistes != null)
            dentistes.clear();
        dentistes = selectAll();
    }

    @Override
    public Dentiste find(long id) {
        Optional<Dentiste> c = dentistes.stream()
                .filter(dentiste -> dentiste.getId() == id)
                .findFirst();
        return (c.orElse(null));
    }

    @Override
    public Vector<Dentiste> findThatContains(String key) {
        return findAll().stream()
                .filter(c -> c.containsInProps(key))
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
    public boolean update(Dentiste o) {
        try {
            assignParams(preStmUpdate, o);
            preStmUpdate.setLong(8, o.getId());
            preStmUpdate.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(Dentiste o) {
        try {
            assignParams(preStmInsert, o);
            preStmInsert.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            return false;
        }
    }

    @Override
    public void assignParams(PreparedStatement preStm, Dentiste o) throws SQLException {
        preStm.setString(1, o.getFullName());
        preStm.setString(2, o.getCin());
        preStm.setString(3, o.getTele());
        preStm.setString(4, o.getAddress());
        preStm.setString(5, o.getEmail());
        preStm.setString(6, o.getUsernm());
        preStm.setString(7, o.getPasswd());
    }
}
