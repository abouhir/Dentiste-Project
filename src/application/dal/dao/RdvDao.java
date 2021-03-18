package application.dal.dao;

import application.DbConnection.DbConnection;
import application.dal.model.RendezVous;
import application.dal.model.TvRdvClient;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RdvDao extends DefaultDao<RendezVous>{

    private final PreparedStatement preStmInsert;
    private final PreparedStatement preStmUpdate;
    private final PreparedStatement preStmDelete;
    private final PreparedStatement preStmSelectAll;
    private final PreparedStatement preStmSelectByCli;


    private final ClientDao clientDao;

    private Vector<RendezVous> rdvs;

    public RdvDao(Connection conn, ClientDao clientDao) throws SQLException {

        this.clientDao = clientDao;

        preStmSelectAll = conn.prepareStatement(SELECT_ALL_RDV);
        preStmInsert = conn.prepareStatement(INSERT_RDV);
        preStmUpdate = conn.prepareStatement(UPDATE_RDV);
        preStmDelete = conn.prepareStatement(DELETE_RDV);
        preStmSelectByCli = conn.prepareStatement(SELECT_ALL_BY_CLI);


    }



    @Override
    public Vector<RendezVous> findAll() {
        if (rdvs == null)
            refresh();
        return rdvs;
    }

    @Override
    public void refresh() {
        if (rdvs != null)
            rdvs.clear();
        rdvs = selectAll();
    }

    @Override
    public Vector<RendezVous> selectAll() {
        Vector<RendezVous> rdvs = new Vector<>();

        try(ResultSet rst = preStmSelectAll.executeQuery()) {
            while (rst.next())
                rdvs.add(new RendezVous(rst));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return rdvs;
    }

    @Override
    public RendezVous find(long id) {
        Optional<RendezVous> c = findAll().stream()
                .filter(rdv -> rdv.getId() == id)
                .findFirst();
        return (c.orElse(null));
    }



    public Vector<RendezVous> findByClient(long cliID) {
        Vector<RendezVous> rdvs = new Vector<>();
        try {
            preStmSelectByCli.setLong(1, cliID);
            ResultSet rst = preStmSelectByCli.executeQuery();
            while (rst.next())
                rdvs.add(new RendezVous(rst));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rdvs;
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
    public boolean update(RendezVous o) {
        try {
            assignParams(preStmUpdate, o);
            preStmUpdate.setLong(4, o.getId());
            preStmUpdate.execute();
            refresh();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(RendezVous o) {
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
    public void assignParams(PreparedStatement preStm, RendezVous o) throws SQLException {
        preStm.setLong(1, o.getInfId());
        preStm.setLong(2, o.getCliId());
        preStm.setDate(3, new Date(o.getDateRdv().getTime()));
    }

    public Vector<TvRdvClient> findRdvClientOfToday() {

        Vector<TvRdvClient> tvRdvClients = new Vector<>();
        Vector<RendezVous> todRdv;
        todRdv =  findAll().stream().filter(rdv -> {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            String rdvs = f.format(rdv.getDateRdv());
            String todays = f.format(new java.util.Date());
            return rdvs.equals(todays);
        }).collect(Collectors.toCollection(Vector::new));
        todRdv.forEach(rdv -> {
            tvRdvClients.add(new TvRdvClient(clientDao.find(rdv.getCliId()), rdv));
        });
        return tvRdvClients;
    }




}
