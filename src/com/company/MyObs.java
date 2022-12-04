package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class MyObs {
    private JFrame frame;
    private JPanel leftPanel;
    private SQLManagement manager;
    private MainGUI mainWindow;
    private ArrayList<JPanelComponent> buttonArray;
    public MyObs(MainGUI mainWindow, SQLManagement m) {
        this.mainWindow = mainWindow;
        manager = m;
        buttonArray = new ArrayList<JPanelComponent>();

        //Creating the frame
        frame = new JFrame("Add Observation");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);

        //Creating a new panel
        leftPanel = new JPanel();
        //Setting the layout to a more vertical layout
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));






        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("My Observations");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        topSpace.add(titleLabel);

        JPanel rightSpace = new JPanel();
        JButton back = new JButton("Back");
        back.addActionListener(e -> mainWindow.switchFrame(1));
        rightSpace.add(back);


        frame.getContentPane().add(BorderLayout.EAST, rightSpace);
        frame.getContentPane().add(BorderLayout.NORTH, topSpace);
        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
    }

    public void disappear() {
        frame.setVisible(false);
    }
    public void appear() {
        frame.setVisible(true);
        RemoveButtons();

        SetUpButtons();
    }
    private void SetUpButtons() {


        SQLConnector connector = new SQLConnector();

        connector.openConnection();

        try {

            ZonedDateTime now = ZonedDateTime.now();
            String dateString = now.getYear() + ":" + now.getMonthValue() + ":" + now.getDayOfMonth();


            String q = "SELECT obs_id, common_name, wild, date FROM Observation WHERE observer = ? ORDER BY date DESC";
            PreparedStatement st = connector.connection().prepareStatement(q);
            st.setInt(1, SQLManagement.OBSERVER_ID);

            ResultSet rs = st.executeQuery();


            // print the result
            while(rs.next()) {
                String common_name = rs.getString("common_name");
                Boolean wild = rs.getBoolean("wild");
                String date = rs.getString("date");
                int id = rs.getInt("obs_id");
                String s = id + " " + common_name + ", wild: " + wild.toString() + ", date: " + date;
                JButton obsButton = new JButton(s);
                obsButton.addActionListener(e -> mainWindow.updateObs(id));

                JPanelComponent newComponent =  new JPanelComponent();
                newComponent.id = id;
                newComponent.comp = obsButton;
                buttonArray.add(newComponent);
            }


            rs.close();

            // release resources
            st.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }


        connector.closeConnection();



        for (JPanelComponent button : buttonArray) {
            leftPanel.add(button.comp);
        }

    }
    private void RemoveButtons() {
        for (JPanelComponent button : buttonArray) {
            leftPanel.remove(button.comp);
        }
        buttonArray.clear();
    }


}
