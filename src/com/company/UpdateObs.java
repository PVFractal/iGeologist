package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateObs {
    private JFrame frame;
    private SQLManagement manager;
    private GUIManager mainWindow;

    private JTextField latitude;
    private JTextField longitude;
    private JTextField estimated_value;
    private JCheckBox wild;
    private JTextField suggested_id;
    private int id;

    public UpdateObs(GUIManager mainWindow, SQLManagement m) {
        this.mainWindow = mainWindow;
        manager = m;

        //Creating the frame
        frame = new JFrame("Add Observation");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);

        //Creating a new panel
        JPanel leftPanel = new JPanel();
        //Setting the layout to a more vertical layout
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));


        JLabel suggest_id_label = new JLabel("Suggested ID:");
        suggest_id_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(suggest_id_label);

        suggested_id = new JTextField();
        suggested_id.setMaximumSize(new Dimension(500, 150));
        suggested_id.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(suggested_id);

        wild = new JCheckBox("Wild: ");
        wild.setHorizontalTextPosition(SwingConstants.LEFT);
        wild.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(wild, BorderLayout.WEST);

        JLabel location_label = new JLabel("Location:");
        location_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(location_label);

        //Latitude Panel -------------------------------------------
        JPanel latPanel =  new JPanel(new BorderLayout());


        JLabel lat_label = new JLabel("Latitude:");
        latPanel.add(lat_label, BorderLayout.WEST);

        latitude = new JTextField();

        latPanel.add(latitude, BorderLayout.CENTER);

        latPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        latPanel.setMaximumSize(new Dimension(500, 150));

        leftPanel.add(latPanel);

        //Longitude Panel -------------------------------------------
        JPanel lonPanel =  new JPanel(new BorderLayout());

        JLabel lon_label = new JLabel("Longitude:");
        lonPanel.add(lon_label, BorderLayout.WEST);

        longitude = new JTextField();

        lonPanel.add(longitude, BorderLayout.CENTER);

        lonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        lonPanel.setMaximumSize(new Dimension(500, 150));

        leftPanel.add(lonPanel);



        JLabel est_val_label = new JLabel("Estimated Value:");
        est_val_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(est_val_label);

        estimated_value = new JTextField();
        estimated_value.setMaximumSize(new Dimension(500, 150));
        estimated_value.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(estimated_value);



        leftPanel.add(Box.createVerticalStrut(50));




        JButton button = new JButton("Update");
        button.addActionListener(e -> updateObsButton(id, suggested_id.getText(), wild.isSelected(), Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText()), Double.parseDouble(estimated_value.getText())));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(button);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteObs(id));
        deleteButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(deleteButton);

        leftPanel.add(Box.createVerticalGlue());


        leftPanel.setPreferredSize(new Dimension(200, 500));




        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("Update Observation");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        topSpace.add(titleLabel);



        frame.getContentPane().add(BorderLayout.NORTH, topSpace);
        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
    }

    public void disappear() {
        frame.setVisible(false);
    }
    public void appear(int id) {
        frame.setVisible(true);
        this.id = id;
        SQLConnector connector = new SQLConnector();

        connector.openConnection();

        try {


            String q = "SELECT common_name, wild, lat, lon, set_value FROM Observation WHERE obs_id = ?";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();


            // print the result
            rs.next();
            String common_name = rs.getString("common_name");
            Boolean wildVal = rs.getBoolean("wild");
            Double lat = rs.getDouble("lat");
            Double lon = rs.getDouble("lon");
            Double set_value = rs.getDouble("set_value");

            suggested_id.setText(common_name);
            wild.setSelected(wildVal);
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

    public void updateObsButton(int id, String common_name, boolean wild, double lat, double lon, double set_value) {
        manager.updateObs(id, common_name, wild, lat, lon, set_value);
        mainWindow.switchFrame(3);
    }
    public void deleteObs(int id) {
        manager.deleteObs(id);
        mainWindow.switchFrame(3);
    }
}
