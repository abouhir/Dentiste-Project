package application.dal.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class DefaultDao<T> implements IDao<T>, IDaoQuery {


    @Override
    public Vector<T> findAll() {
        return null;
    }

    @Override
    public void refresh() {}

    @Override
    public Vector<T> selectAll() {
        return null;
    }

    @Override
    public T find(long id) {
        return null;
    }

    @Override
    public T find(String name) {
        return null;
    }

    @Override
    public T findLast() {
        return null;
    }

    @Override
    public Vector<T> findThatContains(String key) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(T o) {
        return false;
    }

    @Override
    public boolean insert(T o) {
        return false;
    }

    @Override
    public void assignParams(PreparedStatement preStm, T o) throws SQLException {}
}
