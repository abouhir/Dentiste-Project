package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;




public class Certificate {

   private long id;
   private long visId;
   private String description;
   private int duree;
   private Date date;

    public Certificate(ResultSet rst) throws SQLException {
       setId(rst.getLong("cert_id"));
       setVisId(rst.getLong("fvst_id"));
       setDate(rst.getDate("cert_date"));
       setDescription(rst.getString("cert_description"));
       setDuree(rst.getInt("cert_duree"));
    }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public long getVisId() {
      return visId;
   }

   public void setVisId(long visId) {
      this.visId = visId;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public int getDuree() {
      return duree;
   }

   public void setDuree(int duree) {
      this.duree = duree;
   }

}