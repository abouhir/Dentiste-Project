package application.dal.dao;

import application.dal.model.Ordonnance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Optional;
import java.util.Vector;

public class OrdonnanceDao extends DefaultDao<Ordonnance> {
    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmInsertInContenir;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement stmSelectAll;


    private Vector<Ordonnance> ordonnances;



    public OrdonnanceDao(Connection conn) throws SQLException {
        stmSelectAll = conn.prepareStatement(SELECT_ALL_ORDONNANCES);
        preStmInsert = conn.prepareStatement(INSERT_ORDONNANCES);
        preStmInsertInContenir = conn.prepareStatement(INSERT_MEDICS_ORD);
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
    public Ordonnance findLast() {
        return Collections.max(findAll());
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

    public boolean insertMedicsToOrd( long ord, long ...medics) {
        try {
            preStmInsertInContenir.getConnection().setAutoCommit(false);
            for (long medic : medics)
                insertMedicToOrd(medic, ord);
            preStmInsertInContenir.getConnection().commit();
            preStmInsertInContenir.getConnection().setAutoCommit(true);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private void insertMedicToOrd(long medic, long ord) throws SQLException {
            preStmInsertInContenir.setLong(1, medic);
            preStmInsertInContenir.setLong(2, ord);
            preStmInsertInContenir.execute();
    }

    @Override
    public void assignParams(PreparedStatement preStm, Ordonnance o) throws SQLException {
       // preStmInsert.setLong(1, o.getCliId());
        preStmInsert.setLong(2, o.getVisId());
    }


}
