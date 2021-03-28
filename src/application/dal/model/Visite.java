package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class Visite implements Comparable<Visite>{
   private long id;
   private long cliId;
   private long dentId;
   private Date dateVisite;
   private String trait;
   private String remarque;
   private float price;


   public Visite(long id, long cliId, long dentId, Date dateVisite, String trait, String remarque) {
      this.id = id;
      this.cliId = cliId;
      this.dentId = dentId;
      this.dateVisite = dateVisite;
      this.trait = trait;
      this.remarque = remarque;
   }

   public Visite(ResultSet rst) throws SQLException {
      setId(rst.getLong("vst_id"));
      setCliId(rst.getLong("fcli_id"));
      setDentId(rst.getLong("fdent_id"));
      setDateVisite(rst.getDate("vst_date"));
      setTrait(rst.getString("vst_traitement"));
      setRemarque(rst.getString("vst_remarque"));
      //setPrice(rst.getLong("vst_price"));

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

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   @Override
   public String toString() {
      return "Visite{" +
              "id=" + id +
              ", cliId=" + cliId +
              ", dentId=" + dentId +
              ", dateVisite=" + dateVisite +
              '}';
   }

   @Override
   public int compareTo(Visite o) {
      return (int) (this.id - o.getId());
   }
}