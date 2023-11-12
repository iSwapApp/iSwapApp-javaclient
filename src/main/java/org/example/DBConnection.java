package org.example;
//f
import java.sql.*;
import java.util.Properties;

public class DBConnection{
    private final String url;
    private final int port;
    private final String dbName;
    private Connection connection;

    private static DBConnection instance;

    private DBConnection() throws SQLException {
        this.dbName = "iswap";
        this.port = 3306;
        this.url = "jdbc:mysql://localhost:" + Integer.toString(this.port) + "/" + this.dbName;
        Properties props = new Properties();
        props.setProperty("user","root");
        props.setProperty("password","");
        //props.setProperty("ssl","false");
        this.connection = DriverManager.getConnection(url, props);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DBConnection();
        }
        else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }
}
