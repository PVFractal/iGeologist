package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewObs {
    private JFrame frame;
    private SQLManagement manager;
    private GUIManager mainWindow;

    private JLabel latitude;
    private JLabel longitude;
    private JLabel estimated_value;
    private JLabel wild;
    private JLabel suggested_id;
    private JLabel date_label;

    private int id;

    /*
    This is the constructor, which creates the frame and adds components to it
     */
    public ViewObs(GUIManager mainWindow, SQLManagement m) {
        this.mainWindow = mainWindow;
        manager = m;

        //Creating the frame
        frame = new JFrame("View Observation");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);

        //Creating a new panel
        JPanel leftPanel = new JPanel();
        //Setting the layout to a more vertical layout
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));


        date_label = new JLabel("Date:");
        date_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(date_label);

        leftPanel.add(Box.createVerticalStrut(10));


        JLabel suggest_id_label = new JLabel("ID:");
        suggest_id_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(suggest_id_label);

        suggested_id = new JLabel();
        suggested_id.setMaximumSize(new Dimension(500, 150));
        suggested_id.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(suggested_id);

        leftPanel.add(Box.createVerticalStrut(10));


        wild = new JLabel("Wild: ");
        wild.setHorizontalTextPosition(SwingConstants.LEFT);
        wild.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(wild, BorderLayout.WEST);

        leftPanel.add(Box.createVerticalStrut(10));

        JLabel location_label = new JLabel("Location:");
        location_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(location_label);

        //Latitude Panel -------------------------------------------
        JPanel latPanel =  new JPanel(new BorderLayout());


        JLabel lat_label = new JLabel("Latitude:");
        latPanel.add(lat_label, BorderLayout.WEST);

        latitude = new JLabel();

        latPanel.add(latitude, BorderLayout.CENTER);

        latPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        latPanel.setMaximumSize(new Dimension(500, 150));

        leftPanel.add(latPanel);

        //Longitude Panel -------------------------------------------
        JPanel lonPanel =  new JPanel(new BorderLayout());

        JLabel lon_label = new JLabel("Longitude:");
        lonPanel.add(lon_label, BorderLayout.WEST);

        longitude = new JLabel();

        lonPanel.add(longitude, BorderLayout.CENTER);

        lonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        lonPanel.setMaximumSize(new Dimension(500, 150));

        leftPanel.add(lonPanel);

        leftPanel.add(Box.createVerticalStrut(10));



        JLabel est_val_label = new JLabel("Estimated Value:");
        est_val_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(est_val_label);

        estimated_value = new JLabel();
        estimated_value.setMaximumSize(new Dimension(500, 150));
        estimated_value.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(estimated_value);


        leftPanel.add(Box.createVerticalStrut(50));


        JButton button = new JButton("Back");
        button.addActionListener(e -> mainWindow.switchFrame(4));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(button);


        leftPanel.add(Box.createVerticalGlue());


        leftPanel.setPreferredSize(new Dimension(200, 500));




        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("View Observation");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        topSpace.add(titleLabel);



        frame.getContentPane().add(BorderLayout.NORTH, topSpace);
        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
    }

    /*
    Function that makes the scene disappear
     */
    public void disappear() {
        frame.setVisible(false);
    }

    /*
    Function that makes the scene appear.
    Every time this is run, it means that the scene has been switched to this one.
    This means that the current info needs to be update.
    Unfortunately, since this involves getting data from a table, the sql connection needs to happen here.
     */
    public void appear(int id) {
        frame.setVisible(true);
        this.id = id;
        SQLConnector connector = new SQLConnector();

        connector.openConnection();

        try {


            //Query string
            String q = "SELECT date, common_name, wild, lat, lon, set_value FROM Observation WHERE obs_id = ?";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();


            // Get the result
            rs.next();
            String common_name = rs.getString("common_name");
            Boolean wildVal = rs.getBoolean("wild");
            Double lat = rs.getDouble("lat");
            Double lon = rs.getDouble("lon");
            Double set_value = rs.getDouble("set_value");
            String date = rs.getString("date");


            date_label.setText("Date observed: " + date);
            suggested_id.setText(common_name);
            wild.setText("Wild: " + wildVal + "\n");
            latitude.setText(lat.toString());
            longitude.setText(lon.toString());
            estimated_value.setText(set_value.toString());


            rs.close();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


        connector.closeConnection();

    }
}
