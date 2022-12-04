package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;

public class SQLManagement {

    SQLConnector connector;
    Connection cn;

    public static final int OBSERVER_ID = 1;

    public SQLManagement() {
        connector = new SQLConnector();
    }



    public void addObservation(int observer, String common_name, boolean wild, double lat, double lon, double set_value) {
       connector.openConnection();

        try {

            ZonedDateTime now = ZonedDateTime.now();
            String dateString = now.getYear() + ":" + now.getMonthValue() + ":" + now.getDayOfMonth();


            String q = "Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, observer);
            st.setString(2, common_name);
            st.setBoolean(3, wild);
            st.setDouble(4, lat);
            st.setDouble(5, lon);
            st.setString(6, dateString);
            st.setDouble(7, set_value);

            st.execute();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


       connector.closeConnection();
    }

    public void updateObs(int id, String common_name, boolean wild, double lat, double lon, double set_value) {
        connector.openConnection();

        try {


            String q = "UPDATE Observation SET common_name = ?, wild = ?, lat = ?, lon = ?, set_value = ? WHERE obs_id = ?";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setString(1, common_name);
            st.setBoolean(2, wild);
            st.setDouble(3, lat);
            st.setDouble(4, lon);
            st.setDouble(5, set_value);
            st.setInt(6, id);

            st.execute();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


        connector.closeConnection();
    }

    public void deleteObs(int id) {
        connector.openConnection();

        try {


            String q = "DELETE FROM Observation WHERE obs_id = ?";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, id);

            st.execute();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


        connector.closeConnection();
    }




}
