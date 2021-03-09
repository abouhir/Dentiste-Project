package application.model.entity; /***********************************************************************
 * Module:  Facture.java
 * Author:  W0L1D
 * Purpose: Defines the Class Facture
 ***********************************************************************/



public class Facture {
   private Long id;
   private Double prixTotale;


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Double getPrixTotale() {
      return prixTotale;
   }

   public void setPrixTotale(Double prixTotale) {
      this.prixTotale = prixTotale;
   }
}