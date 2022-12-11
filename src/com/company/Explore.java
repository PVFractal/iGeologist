package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Explore {
    private JFrame frame;
    private SQLManagement manager;
    private GUIManager mainWindow;

    private JPanel leftPanel;
    private ArrayList<JPanelComponent> obsArray;

    private JCheckBox wild;
    private JTextField rock_type;
    private JTextField user_field;

    /*
    This is the add observation scene
     */
    public Explore(GUIManager mainWindow, SQLManagement m) {

        //Sets class variables
        this.mainWindow = mainWindow;
        manager = m;

        obsArray = new ArrayList<>();

        //Creating the frame
        frame = new JFrame("Explore");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);

        //Creating a new panel
        JPanel midPanel = new JPanel();
        //Setting the layout to a more vertical layout
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));


        //Adding components
        JLabel filters_label = new JLabel("Filters:\n");
        filters_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(filters_label);

        wild = new JCheckBox("Wild: ");
        wild.setSelected(true);
        wild.setHorizontalTextPosition(SwingConstants.LEFT);
        wild.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(wild, BorderLayout.WEST);

        JLabel rocklabel = new JLabel("Rock type:");
        rocklabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(rocklabel);

        rock_type = new JTextField();
        rock_type.setMaximumSize(new Dimension(200, 150));
        rock_type.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(rock_type);

        //More components
        JLabel user_label = new JLabel("User:");
        user_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(user_label);

        user_field = new JTextField();
        user_field.setMaximumSize(new Dimension(200, 150));
        user_field.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(user_field);

        //This acts as a small spacer between everything and the "add" button
        midPanel.add(Box.createVerticalStrut(50));

        //Creating the search button
        JButton button = new JButton("Search");
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.addActionListener(e -> updateObs());
        midPanel.add(button);

        //Creating the back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.LEFT_ALIGNMENT);
        back.addActionListener(e -> mainWindow.switchFrame(1));
        midPanel.add(back);



        midPanel.add(Box.createVerticalGlue());

        //midPanel.setPreferredSize(new Dimension(200, 500));

        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("Explore");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        topSpace.add(titleLabel);

        //Creating a new panel
        leftPanel = new JPanel();
        //Setting the layout to a more vertical layout
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        //Adds the panels to the frame
        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
        frame.getContentPane().add(BorderLayout.NORTH, topSpace);
        frame.getContentPane().add(BorderLayout.CENTER, midPanel);


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
        updateObs();
    }
    public void updateObs() {
        RemoveObs();
        SetUpObs();
    }


    /*
    This creates the where clause of the sql query.
     */
    private String createWhereClause() {


        Boolean wildVal = wild.isSelected();
        String wildString = "FALSE";
        if (wildVal) {
            wildString = "TRUE";
        }
        //Adds the starting search filter
        String whereClause = "WHERE wild = " + wildString;


        //This adds a statement for filtering for a certain rock type
        String rockString = rock_type.getText();
        if (rockString.length() > 0) {
            whereClause += " AND common_name = \'" + rockString + "\'";
        }

        //This allows for the filtering of users by their username
        String userString = user_field.getText();
        if (userString.length() > 0) {
            whereClause += " AND username = \'" + userString + "\'";
        }

        return whereClause;
    }


    /*
    Gets sql data for a user, and creates buttons for the most recent of their observations
     */
    private void SetUpObs() {

        SQLConnector connector = new SQLConnector();

        connector.openConnection();

        try {
            //Limits the number to 20, since that's about how many buttons fit on the screen
            String whereClause = createWhereClause();
            String q = "SELECT obs_id, username, common_name, wild, date FROM Observation JOIN User ON(observer = user_id) " + whereClause + " ORDER BY date DESC LIMIT 20";
            System.out.println(q);
            PreparedStatement st = connector.connection().prepareStatement(q);
            //st.setInt(1, SQLManagement.OBSERVER_ID);

            ResultSet rs = st.executeQuery();


            ///Gets the result and creates buttons from them
            while(rs.next()) {
                int id = rs.getInt("obs_id");
                String common_name = rs.getString("common_name");
                Boolean wild = rs.getBoolean("wild");
                String date = rs.getString("date");
                String username = rs.getString("username");
                String s = "Observer: " + username + ", Mineral: " + common_name + ", wild: " + wild;
                JButton obsButton = new JButton(s);
                obsButton.addActionListener(e -> mainWindow.viewObs(id));
                JPanelComponent newComponent =  new JPanelComponent();
                newComponent.id = id;
                newComponent.comp = obsButton;
                //Adds the button to the button array. This will be used for removing buttons
                obsArray.add(newComponent);
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
        for (JPanelComponent button : obsArray) {
            leftPanel.add(button.comp);
        }

        // Refresh the left panel
        leftPanel.revalidate();
        leftPanel.repaint();

    }

    /*
    Removes all the buttons from the array and panel
     */
    private void RemoveObs() {

        for (JPanelComponent button : obsArray) {
            leftPanel.remove(button.comp);
        }
        obsArray.clear();
    }

}
