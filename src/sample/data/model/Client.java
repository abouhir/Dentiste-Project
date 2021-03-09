package sample.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/***********************************************************************
 * Module:  Client.java
 * Author:  W0L1D
 * Purpose: Defines the Class Client
 ***********************************************************************/

public class Client extends Person {


    public Client(ResultSet rst) throws SQLException {
        super(rst);
    }


}