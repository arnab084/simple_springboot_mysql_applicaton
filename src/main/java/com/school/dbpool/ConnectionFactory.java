package com.school.dbpool;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {

    public Connection getConnection() throws Exception{
        String host = "878929520250431.1.gcp.databricks.com";
        String httpPath = "sql/protocolv1/o/878929520250431/0722-121311-9z0wtvk6";
        String token = "dapife5011514924fb49743fa5e25ae96a79";
        String url = "jdbc:databricks://"+host+":443;HttpPath="+httpPath;
        Properties p = new Properties();
        p.put("PWD", token);
        Connection conn = DriverManager.getConnection(url, p);
        return conn;
    }

    public void closeConnection(ResultSet rs, Statement stmt, Connection conn) throws Exception{
        rs.close();
        stmt.close();
        conn.close();
    }
}
