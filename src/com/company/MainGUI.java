package com.company;
import javax.swing.*;
import java.awt.*;

public class MainGUI {

    StartFrame mainFrame;
    AddObs addObsFrame;
    MyObs myObsFrame;
    SQLManagement manager;
    public MainGUI() {

        manager = new SQLManagement();


        mainFrame = new StartFrame(this);
        addObsFrame = new AddObs(this, manager);
        myObsFrame = new MyObs(this, manager);



        mainFrame.appear();
    }



    private void setAllInvisible() {
        mainFrame.disappear();
        addObsFrame.disappear();
        myObsFrame.disappear();
    }

    public void updateObs(int id) {
        setAllInvisible();
        System.out.println("Change obs of id: " + id);
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
            case 3:
                myObsFrame.appear();
                break;

            default:
                break;
        }


    }

}
