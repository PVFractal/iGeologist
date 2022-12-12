package com.company;

import javax.swing.*;
import java.awt.*;

public class SellObs {
    private JFrame frame;
    private SQLManagement manager;
    private GUIManager mainWindow;
    private int id;

    /*
    This is the add observation scene
     */
    public SellObs(GUIManager mainWindow, SQLManagement m) {

        //Sets class variables
        this.mainWindow = mainWindow;
        manager = m;

        //Creating the frame
        frame = new JFrame("Sell Rock");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);

        //Creating a new panel
        JPanel leftPanel = new JPanel();
        //Setting the layout to a more vertical layout
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));


        //Adding components
        JLabel est_val_label = new JLabel("Sell for:");
        est_val_label.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(est_val_label);

        JTextField estimated_value = new JTextField();
        estimated_value.setMaximumSize(new Dimension(500, 150));
        estimated_value.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(estimated_value);



        JCheckBox auction = new JCheckBox("Auction: ");
        auction.setHorizontalTextPosition(SwingConstants.LEFT);
        auction.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(auction, BorderLayout.WEST);






        //This acts as a small spacer between everything and the "add" button
        leftPanel.add(Box.createVerticalStrut(50));




        JButton button = new JButton("Sell");
        button.addActionListener(e -> SellButton(Double.parseDouble(estimated_value.getText()),auction.isSelected()));
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
    public void appear(int id) {
        this.id = id;
        frame.setVisible(true);
    }
    /*
    This calls the "add observation" function in the SQL manager, and switches the scene
     */
    public void SellButton(double price, boolean auction) {
        manager.sellObservation(id, price, auction);
        mainWindow.switchFrame(5);
    }
}
