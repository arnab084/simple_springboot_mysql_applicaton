package com.school.dbpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {
    public static void main(String[] args) throws Exception {

        String host = "878929520250431.1.gcp.databricks.com";
        String httpPath = "sql/protocolv1/o/878929520250431/0722-121311-9z0wtvk6";
        String token = "dapife5011514924fb49743fa5e25ae96a79";

//        String url = "jdbc:databricks://878929520250431.1.gcp.databricks.com:443/default;transportMode=http;ssl=1;httpPath=sql/protocolv1/o/878929520250431/0722-121311-9z0wtvk6;AuthMech=3;UID=token;PWD=dapife5011514924fb49743fa5e25ae96a79";
        String url = "jdbc:databricks://"+host+":443;HttpPath="+httpPath;
        Properties p = new java.util.Properties();
        p.put("PWD", token);
        Connection conn = DriverManager.getConnection(url, p);
        Statement stmt = conn.createStatement();
        System.out.println("Going to execute query");
        ResultSet rs = stmt.executeQuery("show tables  from clsfd_test");
        System.out.println("Query is executed");

        int i = 0;
        while(rs.next()) {
            System.out.println("Row " + i + "=" + rs.getString("tableName"));
            i++;
        }


        rs = stmt.executeQuery("show databases");
        System.out.println("Query is executed");

        i = 0;
        while(rs.next()) {
            System.out.println("Row " + i + "=" + rs.getString(1));
            i++;
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
