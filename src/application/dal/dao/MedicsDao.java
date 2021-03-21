package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.Dentiste;
import application.dal.model.Medicament;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Vector;

public class MedicsDao extends DefaultDao<Medicament> {

    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement preStmSelectAll;
    private final PreparedStatement preStmSelectByOrd;



    private Vector<Medicament> medics;

    public MedicsDao(Connection conn) throws SQLException {

        preStmSelectAll = conn.prepareStatement(SELECT_ALL_MEDICS);
        preStmInsert = conn.prepareStatement(INSERT_MEDICS);
        preStmUpdate = conn.prepareStatement(UPDATE_MEDICS);
        preStmDelete = conn.prepareStatement(DELETE_MEDICS);
        preStmSelectByOrd = conn.prepareStatement(SELECT_MEDICS_BY_ORDONNANCE);


    }



    @Override
    public Vector<Medicament> findAll() {
        if (medics == null)
            refresh();
        return medics;
    }

    @Override
    public void refresh() {
        if (medics != null)
            medics.clear();
        medics = selectAll();
    }

    @Override
    public Vector<Medicament> selectAll() {
        Vector<Medicament> medics = new Vector<>();

        try(ResultSet rst = preStmSelectAll.executeQuery()) {
            while (rst.next())
                medics.add(new Medicament(rst));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return medics;
    }

    @Override
    public Medicament find(long id) {
        Optional<Medicament> c = findAll().stream()
                .filter(medicament -> medicament.getId() == id)
                .findAny();
        if (c.isPresent())
            return c.get();
        throw new NoSuchElementException();
    }

    @Override
    public Medicament find(String name) {
        Optional<Medicament> c = findAll().stream()
                .filter(medicament -> medicament.getNom().equals(name))
                .findAny();
        if (c.isPresent())
            return c.get();
        throw new NoSuchElementException();
    }

    public Vector<Medicament> findByOrd(long ordID) {
        Vector<Medicament> medics = new Vector<>();
        try {
            preStmSelectByOrd.setLong(1, ordID);
            ResultSet rst = preStmSelectByOrd.executeQuery();
            while (rst.next())
                medics.add(new Medicament(rst));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medics;
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
    public boolean update(Medicament o) {
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
    public boolean insert(Medicament o) {
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
    public void assignParams(PreparedStatement preStm, Medicament o) throws SQLException {
        preStm.setString(1, o.getNom());
        preStm.setString(2, o.getDescription());
    }
}
