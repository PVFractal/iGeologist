package com.company;
import javax.swing.*;
import java.awt.*;

public class MainGUI {

    StartFrame mainFrame;
    AddObs addObsFrame;
    SQLManagement manager;
    public MainGUI() {

        manager = new SQLManagement();


        mainFrame = new StartFrame(this);
        addObsFrame = new AddObs(this, manager);




        mainFrame.appear();
    }



    private void setAllInvisible() {
        mainFrame.disappear();
        addObsFrame.disappear();
    }


    public void switchFrame(int num) {
        setAllInvisible();

        switch (num) {
            case 1:
                mainFrame.appear();
                break;
            case 2:
                addObsFrame.appear();
                break;
            default:
                break;
        }


    }

}
