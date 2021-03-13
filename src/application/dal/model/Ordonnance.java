package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/***********************************************************************
 * Module:  Ordonnance.java
 * Author:  W0L1D
 * Purpose: Defines the Class Ordonnance
 ***********************************************************************/



public class Ordonnance {

   private Long id;
   private Long cliId;
   private Long visId;
   private Date date;
   private Vector<String> medics;



    public Ordonnance(ResultSet rst) throws SQLException {
        setId(rst.getLong("id"));
        setCliId(rst.getLong("Cli_id"));
        setVisId(rst.getLong("Vis_id"));
        setDate(rst.getDate("ord_date"));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public Long getVisId() {
        return visId;
    }

    public void setVisId(Long visId) {
        this.visId = visId;
    }

    public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}