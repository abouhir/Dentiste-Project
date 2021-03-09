package sample.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/***********************************************************************
 * Module:  User.java
 * Author:  W0L1D
 * Purpose: Defines the Class User
 ***********************************************************************/

public class User extends Person {
   private String usernm;
   private String passwd;

   public User(ResultSet person) throws SQLException {
      super(person);
      setUsernm(person.getString(7));
      setPasswd(person.getString(8));
   }

   public String getUsernm() {
      return usernm;
   }

   public void setUsernm(String usernm) {
      this.usernm = usernm;
   }

   public String getPasswd() {
      return passwd;
   }

   public void setPasswd(String passwd) {
      this.passwd = passwd;
   }
}