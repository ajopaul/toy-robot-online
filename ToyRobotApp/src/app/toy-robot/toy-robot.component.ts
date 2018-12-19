import { Component, OnInit } from '@angular/core';
import { ToyRobotService } from '../services/toy-robot.service';
import { ToyRobot } from '../toyrobot';

@Component({
  selector: 'app-toy-robot',
  templateUrl: './toy-robot.component.html',
  styleUrls: ['./toy-robot.component.css']
})
export class ToyRobotComponent implements OnInit {

  constructor(private toyRobotService: ToyRobotService) { }
  toyRobot: ToyRobot = new ToyRobot();
  directions: any = ['NORTH', 'EAST', 'SOUTH', 'WEST'];

  ngOnInit() {
    this.getToyRobot();
  }

  getToyRobot(): void {
    this.toyRobotService.getToyRobot().then(
      t => (this.toyRobot = t)
    );
  }

  onMove(): void {
    this.toyRobotService.onMove(this.toyRobot).then(
      t => this.toyRobot = t);
  }

  onLeft(): void {
    this.toyRobotService.onLeft(this.toyRobot).then(
      t => this.toyRobot = t);
  }

  onRight(): void {
    this.toyRobotService.onRight(this.toyRobot).then(
      t => this.toyRobot = t);
  }

  updateToyRobot(): void {
    this.toyRobotService.onPlace(this.toyRobot).then(
      t => this.toyRobot = t
    );
  }
}
