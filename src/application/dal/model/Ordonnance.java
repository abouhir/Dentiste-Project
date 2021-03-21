package application.dal.model;

import application.dal.dao.MedicsDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/***********************************************************************
 * Module:  Ordonnance.java
 * Author:  W0L1D
 * Purpose: Defines the Class Ordonnance
 ***********************************************************************/



public class Ordonnance {

   private Long id;
   private Long visId;
   private Date date;
   private Vector<Medicament> medics;



    public Ordonnance(ResultSet rst) throws SQLException {
        setId(rst.getLong("ord_id"));
        setVisId(rst.getLong("fvst_id"));
        setDate(rst.getDate("ord_date"));
    }


    public Ordonnance(ResultSet rst, MedicsDao medDao) throws SQLException {
        this(rst);
        setMedics(medDao.findByOrd(this.id));
    }

    public Vector<Medicament> getMedics() {
        return medics;
    }

    public void setMedics(Vector<Medicament> medics) {
        this.medics = medics;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Long getVisId() {
        return visId;
    }

    public void setVisId(Long visId) {
        this.visId = visId;
    }

    public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }


   public String getPdfTitle() {
        return "Ordonnance -" +getId()+"- :";
   }
}