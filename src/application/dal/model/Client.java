package application.dal.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/***********************************************************************
 * Module:  Client.java
 * Author:  W0L1D
 * Purpose: Defines the Class Client
 ***********************************************************************/

public class Client extends Person {


    public Client(){
        super();

    }

    public Client(ResultSet rst) throws SQLException {
        super(rst);
        System.out.println(this.toString());
    }
    public Client(Long id, String fullName, String cin, String tele, String address, String email){
        super(id, fullName, cin, tele, address, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}