package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;


/*
This class ideally handles all the SQL stuff, but it doesn't always
It mainly handles various functions that do not deal with getting information from tables
 */
public class SQLManagement {

    SQLConnector connector;

    public static final int OBSERVER_ID = 1;

    public SQLManagement() {
        connector = new SQLConnector();
    }


    /*
    This adds an observation to the Observation table. Takes in most of the attributes
     */
    public void addObservation(int observer, String common_name, boolean wild, double lat, double lon, double set_value) {
       connector.openConnection();

        try {
            //Gets the current date
            ZonedDateTime now = ZonedDateTime.now();
            String dateString = now.getYear() + ":" + now.getMonthValue() + ":" + now.getDayOfMonth();

            //Query string and prepared statement
            String q = "Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, observer);
            st.setString(2, common_name);
            st.setBoolean(3, wild);
            st.setDouble(4, lat);
            st.setDouble(5, lon);
            st.setString(6, dateString);
            st.setDouble(7, set_value);

            //Executing the statement
            st.execute();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }

        //Releasing the connection
       connector.closeConnection();
    }
    /*
    This adds an observation to the Sale table. Takes in the price and the market kind
     */
    public void sellObservation(int id, double price, boolean auction) {
        connector.openConnection();

        try {
            //Gets the current date
            ZonedDateTime now = ZonedDateTime.now();

            //Query string and prepared statement
            String q = "Insert Into Sale Values (?, ?, ?);";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, id);
            st.setDouble(3, price);

            String marketType = "auction";
            if (!auction) {
                marketType = "normal";
            }
            st.setString(2, marketType);


            //Executing the statement
            st.execute();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }

        //Releasing the connection
        connector.closeConnection();
    }

    /*
    Very similar to the addObs function, this function updates it.
    The main difference in the parameters is the id, which is used to find the observation to be updated
     */
    public void updateObs(int id, String common_name, boolean wild, double lat, double lon, double set_value) {
        connector.openConnection();

        try {

            //Query string, and prepared statement
            String q = "UPDATE Observation SET common_name = ?, wild = ?, lat = ?, lon = ?, set_value = ? WHERE obs_id = ?";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setString(1, common_name);
            st.setBoolean(2, wild);
            st.setDouble(3, lat);
            st.setDouble(4, lon);
            st.setDouble(5, set_value);
            st.setInt(6, id);

            //Executing the statement
            st.execute();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


        connector.closeConnection();
    }



    /*
    This function deletes an observation. Takes in the id of the observation to delete.
     */
    public void deleteObs(int id) {
        connector.openConnection();

        try {

            //Query string and prepared statement
            String q = "DELETE FROM Observation WHERE obs_id = ?";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, id);

            //Execute the delete statement
            st.execute();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


        connector.closeConnection();
    }

    /*
    This function gets the mineral with the highest average price. It even uses a subquery!
     */
    public String mostValuableMineral() {

        String mineral = "";
        Double value = 0.0;

        connector.openConnection();

        try {

            //Query string and prepared statement
            String q = "SELECT common_name, ROUND(AVG(listing_price),2) avg_price " +
                    "FROM Observation JOIN Sale USING (obs_id) " +
                    "GROUP BY common_name " +
                    "HAVING avg_price >= ALL (SELECT AVG(listing_price) FROM Observation JOIN Sale USING (obs_id) GROUP BY common_name)";
            PreparedStatement st = connector.connection().prepareStatement(q);

            //Execute the delete statement
            ResultSet rs = st.executeQuery();

            rs.next();

            mineral = rs.getString("common_name");
            value = rs.getDouble("avg_price");



            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }

        connector.closeConnection();


        return "Most valuable mineral: " + mineral + ", average price: " + value;
    }

    /*
    This function gets the most common mineral
     */
    public String mostCommonMineral() {

        String mineral = "";

        connector.openConnection();

        try {

            //Query string and prepared statement
            String q = "SELECT common_name, COUNT(*) num_obs " +
                    "FROM Observation " +
                    "GROUP BY common_name " +
                    "HAVING num_obs >= ALL (SELECT COUNT(*) FROM Observation GROUP BY common_name)";
            PreparedStatement st = connector.connection().prepareStatement(q);

            //Execute the delete statement
            ResultSet rs = st.executeQuery();

            rs.next();

            mineral = rs.getString("common_name");



            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }

        connector.closeConnection();


        return "Most common mineral: " + mineral;
    }


    /*
    This function gets the rarest mineral
     */
    public String rarestMineral() {

        String mineral = "";

        connector.openConnection();

        try {

            //Query string and prepared statement
            String q = "SELECT common_name, COUNT(*) num_obs " +
                    "FROM Observation " +
                    "GROUP BY common_name " +
                    "HAVING num_obs <= ALL (SELECT COUNT(*) FROM Observation GROUP BY common_name)";
            PreparedStatement st = connector.connection().prepareStatement(q);

            //Execute the delete statement
            ResultSet rs = st.executeQuery();

            rs.next();

            mineral = rs.getString("common_name");



            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }

        connector.closeConnection();


        return "Rarest mineral: " + mineral;
    }


    /*
    This function gets the average cost of all observations on sale
     */
    public String averageValue() {

        Double value = 0.0;

        connector.openConnection();

        try {

            //Query string and prepared statement
            String q = "SELECT ROUND(AVG(listing_price),2) avg_price " +
                    "FROM Sale";
            PreparedStatement st = connector.connection().prepareStatement(q);

            //Execute the delete statement
            ResultSet rs = st.executeQuery();

            rs.next();

            value = rs.getDouble("avg_price");



            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }

        connector.closeConnection();


        return "Average of all observations on sale: " + value;
    }




}
