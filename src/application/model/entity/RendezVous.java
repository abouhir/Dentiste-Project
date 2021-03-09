package application.model.entity;

import java.util.Date;

/***********************************************************************
 * Module:  RendezVous.java
 * Author:  W0L1D
 * Purpose: Defines the Class RendezVous
 ***********************************************************************/


public class RendezVous {
   private Long id;
   private Date dateRendezVous;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}