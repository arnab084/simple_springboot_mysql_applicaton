package com.school.dbpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class QueryExecuter {

    public ResultSet executeQuery(String query) throws  Exception{
        Connection con = new ConnectionFactory().getConnection();
        Statement stmt = con.createStatement();
        System.out.println("Going to execute query");
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
}
