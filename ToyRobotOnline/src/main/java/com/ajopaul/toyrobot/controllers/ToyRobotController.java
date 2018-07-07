package com.ajopaul.toyrobot.controllers;

import com.ajopaul.toyrobot.model.ToyRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.ajopaul.toyrobot.model.ToyRobot;

/**
 * Created by ajopaul on 30/6/18.
 */
@RestController
//@RequestMapping("/api")
public class ToyRobotController {

    @Autowired
    private ToyRobot toyRobot;

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