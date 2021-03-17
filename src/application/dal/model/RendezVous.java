package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/***********************************************************************
 * Module:  RendezVous.java
 * Author:  W0L1D
 * Purpose: Defines the Class RendezVous
 ***********************************************************************/


public class RendezVous {
   private Long id;
   private long infId;
   private long cliId;
   private Date dateRdv;
   private Date createdAt;

   public RendezVous(Long id, long infId, long cliId, Date dateRdv) {
      this.id = id;
      this.infId = infId;
      this.cliId = cliId;
      this.dateRdv = dateRdv;
      this.createdAt = new Date();
   }



   public RendezVous(ResultSet rst) throws SQLException {
      setId(rst.getLong("rdv_id"));
      setInfId(rst.getLong("finf_id"));
      setCliId(rst.getLong("fcli_id"));
      setDateRdv(rst.getDate("rdv_date"));
      setCreatedAt(rst.getDate("rdv_createdAt"));
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public long getInfId() {
      return infId;
   }

   public void setInfId(long infId) {
      this.infId = infId;
   }

   public long getCliId() {
      return cliId;
   }

   public void setCliId(long cliId) {
      this.cliId = cliId;
   }

   public Date getDateRdv() {
      return dateRdv;
   }

   public void setDateRdv(Date dateRdv) {
      this.dateRdv = dateRdv;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}