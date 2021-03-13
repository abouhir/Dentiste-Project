package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;
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
   private Vector<String> medics;



    public Ordonnance(ResultSet rst) throws SQLException {
        setId(rst.getLong(1));
        setCliId(rst.getLong(2));
        setVisId(rst.getLong(3));

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