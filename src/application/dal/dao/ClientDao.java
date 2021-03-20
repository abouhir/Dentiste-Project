package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.Client;
import application.dal.model.Dentiste;

import java.sql.*;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

public class ClientDao extends DefaultDao<Client> {
    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement stmSelectAll;


    private Vector<Client> clients;



    public ClientDao(Connection conn) throws SQLException {
        stmSelectAll = conn.prepareStatement(SELECT_ALL_CLIENTS);
        preStmInsert = conn.prepareStatement(INSERT_CLIENT);
        preStmUpdate = conn.prepareStatement(UPDATE_CLIENT);
        preStmDelete = conn.prepareStatement(DELETE_CLIENT);
    }


    @Override
    public Vector<Client> findAll() {
        if (clients == null)
            refresh();
        return clients;
    }

    @Override
    public Vector<Client> selectAll() {
        Vector<Client> clients = new Vector<>();

        try(ResultSet rst = stmSelectAll.executeQuery()) {
            while (rst.next())
                clients.add(new Client(rst));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return clients;
    }

    @Override
    public void refresh() {
        if (clients != null)
            clients.clear();
        clients = selectAll();
    }

    @Override
    public Client find(long id) {
        Optional<Client> c = findAll().stream()
                .filter(client -> client.getId() == id)
                .findFirst();
        return (c.orElse(null));
    }

    @Override
    public Vector<Client> findThatContains(String key) {
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
           // throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Client o) {
        try {
            assignParams(preStmUpdate, o);
            preStmUpdate.setLong(6, o.getId());
            preStmUpdate.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(Client o) {
        try {
            assignParams(preStmInsert, o);
            preStmInsert.executeUpdate();
            refresh();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void assignParams(PreparedStatement preStm, Client o) throws SQLException {
        preStm.setString(1, o.getFullName());
        preStm.setString(2, o.getCin());
        preStm.setString(3, o.getTele());
        preStm.setString(4, o.getAddress());
        preStm.setString(5, o.getEmail());
    }


}
