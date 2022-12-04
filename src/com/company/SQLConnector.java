package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class SQLConnector {

    private Connection cn;
    public SQLConnector() {
    }
    public Connection connection() {
        return cn;
    }
    public void openConnection() {
        try {

            Properties prop = new Properties();
            FileInputStream in = new FileInputStream("config.properties");
            prop.load(in);
            in.close();

            // connect to database
            String hst = prop.getProperty("host");
            String usr = prop.getProperty("user");
            String pwd = prop.getProperty("password");
            String dab = "pvahlberg_DB";
            String url = "jdbc:mysql://" + hst + "/" + dab;
            cn = DriverManager.getConnection(url, usr, pwd);
        }
        catch(Exception err) {
            err.printStackTrace();
        }

    }

    public void closeConnection(){
        try {
            cn.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

}
