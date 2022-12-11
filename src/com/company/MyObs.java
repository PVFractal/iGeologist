package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyObs {
    private JFrame frame;
    private JPanel leftPanel;
    private SQLManagement manager;
    private GUIManager mainWindow;
    private ArrayList<JPanelComponent> buttonArray;
    public MyObs(GUIManager mainWindow, SQLManagement m) {
        //Sets class variables
        this.mainWindow = mainWindow;
        manager = m;
        buttonArray = new ArrayList<>();

        //Creating the frame
        frame = new JFrame("My Observations");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);

        //Creating a new panel
        leftPanel = new JPanel();
        //Setting the layout to a more vertical layout
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));


        //Top panel
        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("My Observations");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        topSpace.add(titleLabel);

        //Right panel for back button
        JPanel rightSpace = new JPanel();
        JButton back = new JButton("Back");
        back.addActionListener(e -> mainWindow.switchFrame(1));
        rightSpace.add(back);

        //Assigning panels to diffferent parts of the frame
        frame.getContentPane().add(BorderLayout.EAST, rightSpace);
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
        RemoveButtons();

        SetUpButtons();
    }
    /*
    Gets sql data for a user, and creates buttons for the most recent of their observations
     */
    private void SetUpButtons() {

        SQLConnector connector = new SQLConnector();

        connector.openConnection();

        try {
            //Limits the number to 15, since that's about how many buttons fit on the screen
            String q = "SELECT obs_id, common_name, wild, date FROM Observation WHERE observer = ? ORDER BY date DESC LIMIT 15";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, SQLManagement.OBSERVER_ID);

            ResultSet rs = st.executeQuery();


            ///Gets the result and creates buttons from them
            while(rs.next()) {
                String common_name = rs.getString("common_name");
                Boolean wild = rs.getBoolean("wild");
                String date = rs.getString("date");
                int id = rs.getInt("obs_id");
                String s = id + " " + common_name + ", wild: " + wild + ", date: " + date;
                JButton obsButton = new JButton(s);
                obsButton.addActionListener(e -> mainWindow.updateObs(id));

                JPanelComponent newComponent =  new JPanelComponent();
                newComponent.id = id;
                newComponent.comp = obsButton;
                //Adds the button to the button array. This will be used for removing buttons
                buttonArray.add(newComponent);
            }


            // release resources
            rs.close();
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


        connector.closeConnection();


        //Adds all the buttons to the panel
        for (JPanelComponent button : buttonArray) {
            leftPanel.add(button.comp);
        }

        // Refresh the left panel
        leftPanel.revalidate();
        leftPanel.repaint();

    }
    /*
    Removes all the buttons from the array and panel
     */
    private void RemoveButtons() {

        for (JPanelComponent button : buttonArray) {
            leftPanel.remove(button.comp);
        }
        buttonArray.clear();
    }


}
