package sample.data.dao;

import java.sql.SQLException;
import java.util.Vector;

public interface IDao<T> {



    public Vector<?> findAll();
    public void refresh();

    public Vector<T> selectAll() throws SQLException;

    public T find(long id);

    public boolean delete(long id);

    public boolean update(T o);

    public boolean insert(T o);


}
