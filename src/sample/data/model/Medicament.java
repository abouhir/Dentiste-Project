package sample.data.model; /***********************************************************************
 * Module:  Medicament.java
 * Author:  W0L1D
 * Purpose: Defines the Class Medicament
 ***********************************************************************/


public class Medicament {

   private Long id;

   private String nom;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }
}