package com.company;
import javax.swing.*;
import java.awt.*;

public class GUIManager {

    StartFrame mainFrame;
    AddObs addObsFrame;
    MyObs myObsFrame;
    SQLManagement manager;
    UpdateObs updateObsFrame;
    public GUIManager() {

        manager = new SQLManagement();
        mainFrame = new StartFrame(this);
        addObsFrame = new AddObs(this, manager);
        myObsFrame = new MyObs(this, manager);
        updateObsFrame = new UpdateObs(this, manager);


        mainFrame.appear();
    }



    private void setAllInvisible() {
        mainFrame.disappear();
        addObsFrame.disappear();
        myObsFrame.disappear();
        updateObsFrame.disappear();
    }

    public void updateObs(int id) {
        setAllInvisible();
        updateObsFrame.appear(id);
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
