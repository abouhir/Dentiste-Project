package application.dal.model;

import java.util.Date;

public class TvRdvClient {
    private long idClient;
    private long idRdv;
    private Date dateRdv;
    private String fullName;
    private String cin;
    private String tele;
    private String address;
    private String email;

    public TvRdvClient(Client c, RendezVous r) {
        this.idClient = c.getId();
        this.idRdv = r.getId();
        this.dateRdv = r.getDateRdv();
        this.fullName = c.getFullName();
        this.cin = c.getCin();
        this.tele = c.getTele();
        this.address = c.getAddress();
        this.email = c.getEmail();
    }

    public long getIdClient() {
        return idClient;
    }

    public long getIdRdv() {
        return idRdv;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCin() {
        return cin;
    }

    public String getTele() {
        return tele;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
