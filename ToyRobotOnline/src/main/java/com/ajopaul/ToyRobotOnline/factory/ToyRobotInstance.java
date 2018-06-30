package com.ajopaul.ToyRobotOnline.factory;

import com.ajopaul.ToyRobotOnline.model.ToyRobot;

/**
 * Created by ajopaul on 30/6/18.
 */
public class ToyRobotInstance {

    private static ToyRobot toyRobot;

    public static ToyRobot getInstance() {
        if(null == toyRobot){
            toyRobot = new ToyRobot();
        }
        return toyRobot;
    }


}
