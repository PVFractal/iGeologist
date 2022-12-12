package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ForSale {
    private JFrame frame;
    private SQLManagement manager;
    private GUIManager mainWindow;
    private JPanel leftPanel;
    private ArrayList<JPanelComponent> obsArray;

    private JRadioButton expensive;

    private JLabel average_cost;
    private JLabel valuable_mineral;

    private JLabel common_mineral;
    private JLabel rare_mineral;





    /*
    This is the add observation scene
     */
    public ForSale(GUIManager mainWindow, SQLManagement m) {

        //Sets class variables
        this.mainWindow = mainWindow;
        manager = m;

        obsArray = new ArrayList<>();

        //Creating the frame
        frame = new JFrame("Minerals For Sale");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);

        //Creating a new panel
        JPanel midPanel = new JPanel();
        //Setting the layout to a more vertical layout
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));



        //Adding components
        JLabel filters_label = new JLabel("Filter By:\n");
        filters_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(filters_label);

        midPanel.add(Box.createVerticalStrut(10));

        ButtonGroup sortGroup = new ButtonGroup();

        expensive = new JRadioButton("Expensive");
        expensive.setSelected(true);
        expensive.addActionListener(e -> updateObs());
        expensive.setHorizontalTextPosition(SwingConstants.LEFT);
        expensive.setAlignmentX(Component.LEFT_ALIGNMENT);


        sortGroup.add(expensive);
        midPanel.add(expensive, BorderLayout.WEST);

        JRadioButton cheap = new JRadioButton("Cheap");
        cheap.addActionListener(e -> updateObs());
        cheap.setHorizontalTextPosition(SwingConstants.LEFT);
        cheap.setAlignmentX(Component.LEFT_ALIGNMENT);

        sortGroup.add(cheap);
        midPanel.add(cheap, BorderLayout.WEST);

        midPanel.add(Box.createVerticalStrut(10));


        //More components
        JLabel user_label = new JLabel("Stats:");
        user_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(user_label);


        //More components
        valuable_mineral = new JLabel("Valuable Mineral:");
        valuable_mineral.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(valuable_mineral);

        //More components
        common_mineral = new JLabel("Common Mineral:");
        common_mineral.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(common_mineral);

        //More components
        rare_mineral = new JLabel("Rare Mineral:");
        rare_mineral.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(rare_mineral);

        //More components
        average_cost = new JLabel("Average Mineral:");
        average_cost.setAlignmentX(Component.LEFT_ALIGNMENT);
        midPanel.add(average_cost);








        //This acts as a small spacer between everything and the "add" button
        midPanel.add(Box.createVerticalStrut(50));


        //Creating the back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.LEFT_ALIGNMENT);
        back.addActionListener(e -> mainWindow.switchFrame(1));
        midPanel.add(back);



        midPanel.add(Box.createVerticalGlue());

        //midPanel.setPreferredSize(new Dimension(200, 500));

        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("Rocks For Sale");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        topSpace.add(titleLabel);

        //Creating a new panel
        leftPanel = new JPanel();
        //Setting the layout to a more vertical layout
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        //Adds the panels to the frame
        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
        frame.getContentPane().add(BorderLayout.NORTH, topSpace);
        frame.getContentPane().add(BorderLayout.EAST, midPanel);


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

        //Setting some labels to display various statistics
        valuable_mineral.setText(manager.mostValuableMineral());
        common_mineral.setText(manager.mostCommonMineral());
        rare_mineral.setText(manager.rarestMineral());
        average_cost.setText(manager.averageValue());

        frame.setVisible(true);
        updateObs();
    }
    public void updateObs() {
        RemoveObs();
        SetUpObs();
    }

    /*
    Gets sql data the sale table
     */
    private void SetUpObs() {

        SQLConnector connector = new SQLConnector();

        connector.openConnection();

        try {
            //Limits the number to 20, since that's about how many labels fit on the screen

            //This string determines whether the observations are sorted by cheapest or most expensive
            String sort_string = "";
            if (expensive.isSelected()) {
                sort_string = "DESC";
            }

            String q = "SELECT common_name, listing_price, username FROM Observation JOIN User ON(observer = user_id) JOIN Sale USING (obs_id) ORDER BY listing_price " + sort_string + " LIMIT 20";
            PreparedStatement st = connector.connection().prepareStatement(q);

            ResultSet rs = st.executeQuery();


            ///Gets the result and creates buttons from them
            while(rs.next()) {
                String common_name = rs.getString("common_name");
                String username = rs.getString("username");
                Double price = rs.getDouble("listing_price");
                String s = "Observer: " + username + ", Mineral: " + common_name + ", price: " + price;
                JLabel obsButton = new JLabel(s);
                JPanelComponent newComponent =  new JPanelComponent();
                newComponent.id = 0;
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
