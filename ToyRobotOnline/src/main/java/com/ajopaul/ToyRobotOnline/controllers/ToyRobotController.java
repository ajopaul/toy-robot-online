package com.ajopaul.ToyRobotOnline.controllers;

import com.ajopaul.ToyRobotOnline.factory.ToyRobotInstance;
import com.ajopaul.ToyRobotOnline.model.ToyRobot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ajopaul on 30/6/18.
 */
@RestController
//@RequestMapping("/api")
public class ToyRobotController {

    ToyRobot toyRobot = ToyRobotInstance.getInstance();

    @PostMapping("/place")
    public ResponseEntity<ToyRobot> place(@RequestBody PlaceCommand placeCommand) throws Exception {
        toyRobot.commandPlace(placeCommand.x,placeCommand.y,placeCommand.direction);
        return ResponseEntity.ok().body(toyRobot);
    }

    @PostMapping("/reset")
    public ResponseEntity<ToyRobot> reset() throws Exception {
        toyRobot.commandPlace(0,0,"north");
        return ResponseEntity.ok().body(toyRobot);
    }

    @PostMapping("/move")
    public ResponseEntity<ToyRobot> move(){
        toyRobot.commandMove();
        return ResponseEntity.ok().body(toyRobot);
    }

    @PostMapping("/left")
    public ResponseEntity<ToyRobot> left(){
        toyRobot.commandLeft();
        return ResponseEntity.ok().body(toyRobot);
    }

    @PostMapping("/right")
    public ResponseEntity<ToyRobot> right(){
        toyRobot.commandRight();
        return ResponseEntity.ok().body(toyRobot);
    }

    @GetMapping("/report")
    public ResponseEntity<ToyRobot> report(){
        return ResponseEntity.ok().body(toyRobot);
    }
}

class PlaceCommand {
    public int x;
    public int y;
    public String direction;

    @Override
    public String toString() {
        return ""+x+","+y+","+direction;
    }
}