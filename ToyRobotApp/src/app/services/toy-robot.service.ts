import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ToyRobot } from '../toyrobot';


@Injectable({
  providedIn: 'root'
})
export class ToyRobotService {

  constructor(private http:HttpClient) { }

  private baseUrl = '/toyrobot';

  getToyRobot(): Promise<ToyRobot>{
      return this.http.get<ToyRobot>(this.baseUrl + '/report/')
      .toPromise().catch(this.handleError);
  }

  onPlace(toyRobot): Promise<ToyRobot>{
    return this.http.post<ToyRobot>(this.baseUrl + '/place/',toyRobot)
    .toPromise().catch(this.handleError);
 }
  onMove(toyRobot): Promise<ToyRobot>{
    return this.http.post<ToyRobot>(this.baseUrl + '/move/',null)
    .toPromise().catch(this.handleError);
 }

 onLeft(toyRobot): Promise<ToyRobot>{
  return this.http.post<ToyRobot>(this.baseUrl + '/left/',null)
  .toPromise().catch(this.handleError);
}

onRight(toyRobot): Promise<ToyRobot>{
  return this.http.post<ToyRobot>(this.baseUrl + '/right/',null)
  .toPromise().catch(this.handleError);
}

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }

}
