package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.Dentiste;
import application.dal.model.Ordonnance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Vector;

public class OrdonnanceDao extends DefaultDao<Ordonnance> {
    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement stmSelectAll;


    private Vector<Ordonnance> ordonnances;



    public OrdonnanceDao(Connection conn) throws SQLException {
        stmSelectAll = conn.prepareStatement(SELECT_ALL_ORDONNANCES);
        preStmInsert = conn.prepareStatement(INSERT_ORDONNANCES);
        preStmUpdate = conn.prepareStatement(UPDATE_ORDONNANCES);
        preStmDelete = conn.prepareStatement(DELETE_ORDONNANCES);


    }



    @Override
    public Vector<Ordonnance> findAll() {
        if (ordonnances == null)
            refresh();
        return ordonnances;
    }

    @Override
    public Vector<Ordonnance> selectAll() {
        Vector<Ordonnance> ordonnances = new Vector<>();

        try(ResultSet rst = stmSelectAll.executeQuery()) {
            while (rst.next())
                ordonnances.add(new Ordonnance(rst));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return ordonnances;
    }

    @Override
    public void refresh() {
        if (ordonnances != null)
            ordonnances.clear();
        ordonnances = selectAll();
    }

    @Override
    public Ordonnance find(long id) {
        Optional<Ordonnance> c = findAll().stream()
                .filter(ordonnance -> ordonnance.getId() == id)
                .findFirst();
        return (c.orElse(null));

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
    public boolean update(Ordonnance o) {
        try {
            assignParams(preStmUpdate, o);
            preStmUpdate.setLong(3, o.getId());
            preStmUpdate.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean insert(Ordonnance o) {
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
    public void assignParams(PreparedStatement preStm, Ordonnance o) throws SQLException {
        preStmInsert.setLong(1, o.getId());
        preStmInsert.setLong(2, o.getVisId());
    }


}
