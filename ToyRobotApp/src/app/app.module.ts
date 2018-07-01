import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ToyRobotComponent } from './toy-robot/toy-robot.component';
import { ToyRobotService } from './services/toy-robot.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ToyRobotComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ToyRobotService],
  bootstrap: [AppComponent]
})
export class AppModule { }
