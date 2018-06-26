package com.digitaladd.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DBConnectionHandler {
	//public static Logger log = LoggerService.commonServiceLogger;

    public static Connection getDBConnection() {
    	//log.debug("DBConnectionHandler> getDBConnection : start");
        Connection connection = null;
        try {
            DataSource ds = DataSourceHandler.getInstance().getDataSource();
            //log.debug("DBConnectionHandler> getDBConnection : ds="+ds);
            //ds.setLoginTimeout(30);
            //System.out.println("DBConnectionHandler >> getDBConnection >> " +ds);//for testing
            connection = ds.getConnection();
            //System.out.println("DBConnectionHandler >> getDBConnection >> " + connection);//for testing
            ds = null;
        } catch (SQLException e) {  
            //log.fatal("getDBConnection :: SQLException : " + e);
            //throw new SystemException(e);
        }
       // log.debug("DBConnectionHandler> getDBConnection : end with connection="+connection);
        return connection;
    }

    public static void closeDBConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
               /* log.fatal("closeDBConnection :: SQLException : " + e);
                throw new SystemException(e);*/
            }
        }
    }

    public static void closeJDBCResoucrs(Connection conn, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
            rs = null;
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
            }
            statement = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
            conn = null;
        }
    }
    
      /*public static Connection getLocalJDBCConnection() {
        Connection conn = null;
        //log.info("getLocalJDBCConnection : start");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nirmandb_qa","testuser", "testuser123");
        }catch (ClassNotFoundException cnfe) {
            //log.fatal("getLocalJDBCConnection :: ClassNotFoundException :"+cnfe);
        }catch (SQLException e) {
            log.fatal("getLocalJDBCConnection :: SQLException : " + e);
            throw new SystemException(e);
        }
        //log.info("getLocalJDBCConnection : end.");
        return conn;
    }*/
}
