package application.dal.model;

import application.DbConnection.DbConnection;
import application.dal.dao.OrdonnanceDao;
import application.main.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/***********************************************************************
 * Module:  Visite.java
 * Author:  W0L1D
 * Purpose: Defines the Class Visite
 ***********************************************************************/


public class Visite {
   private long id;
   private long cliId;
   private long dentId;
   private Date dateVisite;
   private String trait;
   private String remarque;


   public Visite(long id, long cliId, long dentId, Date dateVisite, String trait, String remarque) {
      this.id = id;
      this.cliId = cliId;
      this.dentId = dentId;
      this.dateVisite = dateVisite;
      this.trait = trait;
      this.remarque = remarque;
   }

   public Visite(ResultSet rst) throws SQLException {
      OrdonnanceDao ordDao = Main.getDaos().getOrdDao();
      setId(rst.getLong("id"));
      setDateVisite(rst.getDate("Vis_date"));
      setTrait(rst.getString("vst_traitement"));
      setRemarque(rst.getString("vst_remarque"));
   }

   public long getCliId() {
      return cliId;
   }

   public void setCliId(long cliId) {
      this.cliId = cliId;
   }

   public long getDentId() {
      return dentId;
   }

   public void setDentId(long dentId) {
      this.dentId = dentId;
   }

   public String getTrait() {
      return trait;
   }

   public void setTrait(String trait) {
      this.trait = trait;
   }

   public String getRemarque() {
      return remarque;
   }

   public void setRemarque(String remarque) {
      this.remarque = remarque;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Date getDateVisite() {
      return dateVisite;
   }

   public void setDateVisite(Date dateVisite) {
      this.dateVisite = dateVisite;
   }
}