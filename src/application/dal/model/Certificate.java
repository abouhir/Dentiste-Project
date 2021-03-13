package application.dal.model; /***********************************************************************
 * Module:  Certificat.java
 * Author:  W0L1D
 * Purpose: Defines the Class Certificat
 ***********************************************************************/


public class Certificate {


   private long id;
   private String description;
   private String duree;

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getDuree() {
      return duree;
   }

   public void setDuree(String duree) {
      this.duree = duree;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }
}