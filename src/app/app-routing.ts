import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('../app/home/home.module').then(x => x.HomeModule)
  },
  {
    path: 'dashboard',
    loadChildren: () => import('../app/dashboard/dashboard.module').then(x => x.DashboardModule)
  }
];
