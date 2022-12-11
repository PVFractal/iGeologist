package com.company;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.util.Properties;


/*
This class manages a connection to MariaDB
 */
public class SQLConnector {

    private Connection cn;
    public SQLConnector() {
    }
    /*
    Returns the connection
     */
    public Connection connection() {
        return cn;
    }
    /*
    Opens a connection to MariaDB
     */
    public void openConnection() {
        try {
            //Get properties
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream("config.properties");
            prop.load(in);
            in.close();

            // Put properties into strings
            String hst = prop.getProperty("host");
            String usr = prop.getProperty("user");
            String pwd = prop.getProperty("password");

            //Connect to database
            String dab = "pvahlberg_DB";
            String url = "jdbc:mysql://" + hst + "/" + dab;
            cn = DriverManager.getConnection(url, usr, pwd);
        }
        catch(Exception err) {
            err.printStackTrace();
        }

    }

    /*
    Releases the connection
     */
    public void closeConnection(){
        try {
            cn.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

}
