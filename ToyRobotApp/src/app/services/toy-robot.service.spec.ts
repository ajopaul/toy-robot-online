import { TestBed, inject } from '@angular/core/testing';

import { ToyRobotService } from './toy-robot.service';

describe('ToyRobotService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ToyRobotService]
    });
  });

  it('should be created', inject([ToyRobotService], (service: ToyRobotService) => {
    expect(service).toBeTruthy();
  }));
});
