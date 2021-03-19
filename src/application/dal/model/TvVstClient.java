package application.dal.model;

import java.util.Date;

public class TvVstClient {

    private long idClient;
    private long idVst;
    private long idDent;
    private Date dateVst;
    private String trait;
    private String remarque;
    private String fullName;
    private String cin;
    private String tele;
    private String address;
    private String email;

    public TvVstClient(Client c, Visite v) {
        this.idClient = c.getId();
        this.idVst = v.getId();
        this.idDent = v.getDentId();
        this.dateVst = v.getDateVisite();
        this.trait = v.getTrait();
        this.remarque = v.getRemarque();
        this.fullName = c.getFullName();
        this.cin = c.getCin();
        this.tele = c.getTele();
        this.address = c.getAddress();
        this.email = c.getEmail();
    }

    public long getIdClient() {
        return idClient;
    }

    public long getIdVst() {
        return idVst;
    }

    public long getIdDent() {
        return idDent;
    }

    public Date getDateVst() {
        return dateVst;
    }

    public String getTrait() {
        return trait;
    }

    public String getRemarque() {
        return remarque;
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
