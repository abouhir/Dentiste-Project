package application.dal.dao;

import application.dal.model.Medicament;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public interface IDao<T> {

    public Vector<T> findAll();

    public void refresh();

    public Vector<T> selectAll();

    public T find(long id);

    public T find(String name);

    public Vector<T> findThatContains(String key);

    public boolean delete(long id);

    public boolean update(T o);

    public boolean insert(T o);

    void assignParams(PreparedStatement preStm, T o) throws SQLException;

}
