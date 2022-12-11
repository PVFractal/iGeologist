package com.company;

import javax.swing.*;
import java.awt.*;

public class AddObs {

    private JFrame frame;
    private SQLManagement manager;
    private GUIManager mainWindow;

    /*
    This is the add observation scene
     */
    public AddObs(GUIManager mainWindow, SQLManagement m) {

        //Sets class variables
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


        //Adding components
        JLabel suggest_id_label = new JLabel("Suggested ID:");
        suggest_id_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(suggest_id_label);

        JTextField suggested_id = new JTextField();
        suggested_id.setMaximumSize(new Dimension(500, 150));
        suggested_id.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(suggested_id);

        JCheckBox wild = new JCheckBox("Wild: ");
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

        JTextField latitude = new JTextField();

        latPanel.add(latitude, BorderLayout.CENTER);

        latPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        latPanel.setMaximumSize(new Dimension(500, 150));

        leftPanel.add(latPanel);

        //Longitude Panel -------------------------------------------
        JPanel lonPanel =  new JPanel(new BorderLayout());

        JLabel lon_label = new JLabel("Longitude:");
        lonPanel.add(lon_label, BorderLayout.WEST);

        JTextField longitude = new JTextField();

        lonPanel.add(longitude, BorderLayout.CENTER);

        lonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        lonPanel.setMaximumSize(new Dimension(500, 150));

        leftPanel.add(lonPanel);


        //More components
        JLabel est_val_label = new JLabel("Estimated Value:");
        est_val_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(est_val_label);

        JTextField estimated_value = new JTextField();
        estimated_value.setMaximumSize(new Dimension(500, 150));
        estimated_value.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(estimated_value);


        //This acts as a small spacer between everything and the "add" button
        leftPanel.add(Box.createVerticalStrut(50));




        JButton button = new JButton("Add");
        button.addActionListener(e -> addObsButton(SQLManagement.OBSERVER_ID, suggested_id.getText(), wild.isSelected(), Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText()), Double.parseDouble(estimated_value.getText())));
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(button);

        leftPanel.add(Box.createVerticalGlue());


        leftPanel.setPreferredSize(new Dimension(200, 500));




        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("Add Observation");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        topSpace.add(titleLabel);


        //Adds the panels to the frame
        frame.getContentPane().add(BorderLayout.NORTH, topSpace);
        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
    }

    /*
    Makes the scene disappear
     */
    public void disappear() {
        frame.setVisible(false);
    }
    /*
    Makes the scene appear
     */
    public void appear() {
        frame.setVisible(true);
    }
    /*
    This calls the "add observation" function in the SQL manager, and switches the scene
     */
    public void addObsButton(int observer, String common_name, boolean wild, double lat, double lon, double set_value) {
        manager.addObservation(observer, common_name, wild, lat, lon, set_value);
        mainWindow.switchFrame(3);
    }

}
