package application.dal.model;

import java.util.Date;

/***********************************************************************
 * Module:  Visite.java
 * Author:  W0L1D
 * Purpose: Defines the Class Visite
 ***********************************************************************/


public class Visite {
   private long id;
   private Date dateVisite;
   private String trait;
   private String remarque;

   private Facture facture;
   private Ordonnance ordonnance;
   private Certificate certif;

   public Visite(long id, Date dateVisite, String trait, String remarque) {
      this.id = id;
      this.dateVisite = dateVisite;
      this.trait = trait;
      this.remarque = remarque;
   }

   public Visite(long id, Date dateVisite, String trait, String remarque,
                 Facture facture, Ordonnance ordonnance, Certificate certif) {
      this.id = id;
      this.dateVisite = dateVisite;
      this.trait = trait;
      this.remarque = remarque;
      this.facture = facture;
      this.ordonnance = ordonnance;
      this.certif = certif;
   }

   public Facture getFacture() {
      return facture;
   }

   public void setFacture(Facture facture) {
      this.facture = facture;
   }

   public Ordonnance getOrdonnance() {
      return ordonnance;
   }

   public void setOrdonnance(Ordonnance ordonnance) {
      this.ordonnance = ordonnance;
   }

   public Certificate getCertif() {
      return certif;
   }

   public void setCertif(Certificate certif) {
      this.certif = certif;
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