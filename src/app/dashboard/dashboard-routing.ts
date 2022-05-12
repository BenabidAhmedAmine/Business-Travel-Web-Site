import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardsComponent} from "./dashboard.component";

export const dashboardRoutes: Routes = [
  {
    path: '',
    component: DashboardsComponent,
    children: [

    ]
  }
];
