import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HomeheaderComponent} from "../Layout/homeheader/homeheader.component";
import {HomefooterComponent} from "../Layout/homefooter/homefooter.component";
import {AppfooterComponent} from "../Layout/appfooter/appfooter.component";
import {AppheaderComponent} from "../Layout/appheader/appheader.component";



@NgModule({
  declarations: [
    HomeheaderComponent,
    HomefooterComponent,
    AppfooterComponent,
    AppheaderComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    HomeheaderComponent,
    HomefooterComponent,
    AppfooterComponent,
    AppheaderComponent
  ]
})
export class SharedModule { }
