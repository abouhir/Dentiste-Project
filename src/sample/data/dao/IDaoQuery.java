package sample.data.dao;

public interface IDaoQuery<T> {

    final String SELECT_ALL_CLIENTS = "SELECT * FROM client;";
    final String UPDATE_CLIENT =
            "UPDATE client SET fullName = ?, cin = ?, " +
                    "tele = ?, address = ?, email = ? " +
                    "WHERE id = ?" ;
    final String INSERT_CLIENT =
            "INSERT INTO client VALUES (null, ?, ?, ?, ?, ?)";
    final String DELETE_CLIENT = "DELETE FROM client WHERE id = ?";

}
