package sample.data.model;

import java.util.Date;

/***********************************************************************
 * Module:  Visite.java
 * Author:  W0L1D
 * Purpose: Defines the Class Visite
 ***********************************************************************/


public class Visite {
   private long id;
   private Date dateVisite;
   private String description;
   private String remarque;

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
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