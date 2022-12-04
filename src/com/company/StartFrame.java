package com.company;

import javax.swing.*;
import java.awt.*;

public class StartFrame {

    private JFrame frame;
    public StartFrame(MainGUI mainWindow) {
        //Creating the frame
        frame = new JFrame("iGeologist");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);

        //Creating a new panel
        JPanel leftPanel = new JPanel();

        JButton button = new JButton("Add Observation");
        button.addActionListener(e -> mainWindow.switchFrame(2));
        leftPanel.add(button);

        JPanel topSpace = new JPanel();
        JLabel titleLabel = new JLabel("iGeologist");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        topSpace.add(titleLabel);

        frame.getContentPane().add(BorderLayout.NORTH, topSpace);
        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
    }

    public void disappear() {
        frame.setVisible(false);
    }
    public void appear() {
        frame.setVisible(true);
    }



}
