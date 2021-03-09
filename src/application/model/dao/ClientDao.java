package application.model.dao;

import application.DbConnection.DbConnection;
import application.model.entity.Client;

import java.sql.*;
import java.util.Optional;
import java.util.Vector;

public class ClientDao implements IDao<Client>, IDaoQuery {
    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement stmSelectAll;


    private Connection conn;

    private Vector<Client> clients;



    public ClientDao() throws SQLException {
        conn = DbConnection.getConnection();

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
        Optional<Client> c = clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst();
        return (c.orElse(null));

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
    public boolean update(Client o) {
        try {
            assignParams(preStmUpdate, o);
            preStmUpdate.setLong(6, o.getId());
            preStmUpdate.execute();
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
            preStmInsert.execute();
            return true;
        } catch (SQLException throwable) {
            return false;
        }
    }

    @Override
    public void assignParams(PreparedStatement preStm, Client o) throws SQLException {
        preStmInsert.setString(1, o.getFullName());
        preStmInsert.setString(2, o.getCin());
        preStmInsert.setString(3, o.getTele());
        preStmInsert.setString(4, o.getAddress());
        preStmInsert.setString(5, o.getEmail());
    }


}
