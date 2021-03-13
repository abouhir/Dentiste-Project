package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/***********************************************************************
 * Module:  Facture.java
 * Author:  W0L1D
 * Purpose: Defines the Class Facture
 ***********************************************************************/



public class Facture {

    private Double prixTotale;
    private long cliId;
    private long visId;


    public Facture(ResultSet rst) throws SQLException {
        setCliId(rst.getLong("Cli_id"));
        setVisId(rst.getLong("vis_id"));
        setPrixTotale(rst.getDouble("prixTotale"));
    }

    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    public long getVisId() {
        return visId;
    }

    public void setVisId(long visId) {
        this.visId = visId;
    }

    public Double getPrixTotale() {
      return prixTotale;
   }

   public void setPrixTotale(Double prixTotale) {
      this.prixTotale = prixTotale;
   }
}