package com.company;
import javax.swing.*;
import java.awt.*;

/*
This class manages all the scenes
 */
public class GUIManager {

    //Each of the scenes are kept so they can be switched to and from other scenes
    StartFrame mainFrame;
    AddObs addObsFrame;
    MyObs myObsFrame;
    SQLManagement manager;
    UpdateObs updateObsFrame;
    Explore exploreFrame;
    ViewObs viewFrame;
    Market marketFrame;
    SellObs sellFrame;
    ForSale saleFrame;

    public GUIManager() {

        //All the scene constructors
        manager = new SQLManagement();
        mainFrame = new StartFrame(this);
        addObsFrame = new AddObs(this, manager);
        myObsFrame = new MyObs(this, manager);
        updateObsFrame = new UpdateObs(this, manager);
        exploreFrame = new Explore(this, manager);
        viewFrame = new ViewObs(this, manager);
        marketFrame = new Market(this, manager);
        sellFrame = new SellObs(this, manager);
        saleFrame = new ForSale(this, manager);

        //This makes the starting frame appear
        mainFrame.appear();
    }


    /*
    Sets all the frames to invisible
     */
    private void setAllInvisible() {
        mainFrame.disappear();
        addObsFrame.disappear();
        myObsFrame.disappear();
        updateObsFrame.disappear();
        exploreFrame.disappear();
        viewFrame.disappear();
        marketFrame.disappear();
        sellFrame.disappear();
        saleFrame.disappear();
    }


    /*
    Special case for updating an observation: we need the ID
     */
    public void updateObs(int id) {
        setAllInvisible();
        updateObsFrame.appear(id);
    }
    public void viewObs(int id) {
        setAllInvisible();
        viewFrame.appear(id);
    }
    public void sellObs(int id) {
        setAllInvisible();
        sellFrame.appear(id);
    }

    /*
    Switches from one scene to another
     */
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
            case 4:
                exploreFrame.appear();
                break;
            case 5:
                marketFrame.appear();
                break;
            case 6:
                saleFrame.appear();
                break;


            default:
                break;
        }


    }

}
