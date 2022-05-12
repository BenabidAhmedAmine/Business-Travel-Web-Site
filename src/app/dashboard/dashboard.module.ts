import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {dashboardRoutes} from './dashboard-routing';
import {DashboardsComponent} from "./dashboard.component";
import {RouterModule} from "@angular/router";
import {homeRoutes} from "../home/home-routing";
import {SharedModule} from "../shared-module/shared.module";


@NgModule({
  declarations: [
    DashboardsComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(dashboardRoutes),
  ]
})
export class DashboardModule { }
