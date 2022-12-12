package com.company;

import javax.swing.*;
import java.awt.*;

/*
This class holds the starting scene.
This is more or less the main menu
 */
public class StartFrame {

    private JFrame frame;
    public StartFrame(GUIManager mainWindow) {
        //Creating the frame
        frame = new JFrame("iGeologist");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);

        //Creating a new panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Add Observation");
        button.addActionListener(e -> mainWindow.switchFrame(2));
        leftPanel.add(button);

        JButton myObs = new JButton("My Observations");
        myObs.addActionListener(e -> mainWindow.switchFrame(3));
        leftPanel.add(myObs);

        JButton exploreButton = new JButton("Explore");
        exploreButton.addActionListener(e -> mainWindow.switchFrame(4));
        leftPanel.add(exploreButton);

        JButton marketButton = new JButton("Sell Your Rocks");
        marketButton.addActionListener(e -> mainWindow.switchFrame(5));
        leftPanel.add(marketButton);

        JButton saleButton = new JButton("View Rocks On Sale");
        saleButton.addActionListener(e -> mainWindow.switchFrame(6));
        leftPanel.add(saleButton);





        //Panel for containing the header label
        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("iGeologist");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        topSpace.add(titleLabel);

        //Adding panels to the frame
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


}
