package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;



public class Facture {

    private long id;
    private long visId;
    private Double prixTotale;


    public Facture(ResultSet rst) throws SQLException {
        setId(rst.getLong("fact_id"));
        setVisId(rst.getLong("fvst_id"));
        setPrixTotale(rst.getDouble("fact_prixTotale"));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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