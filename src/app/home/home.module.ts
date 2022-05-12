import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {HomeComponent} from "./home.component";
import {RouterModule} from "@angular/router";
import {homeRoutes} from "./home-routing";
import {SharedModule} from "../shared-module/shared.module";
import { ContactComponent } from './contact/contact.component';
import { PricingComponent } from './pricing/pricing.component';
import {LoginComponent} from "./login/login.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RegisterComponent} from "./register/register.component";
import {ConfirmationDialogComponent} from "./confirmation-dialog/confirmation-dialog.component";
import {NgbAlertModule} from "@ng-bootstrap/ng-bootstrap";
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import {MatDialogModule} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { SendinviComponent } from './sendinvi/sendinvi.component';



@NgModule({
  declarations: [
    HomeComponent,
    ContactComponent,
    LoginComponent,
    PricingComponent,
    RegisterComponent,
    ConfirmationDialogComponent,
    ChangepasswordComponent,
    SendinviComponent,

  ],
  imports: [
    SharedModule,

    CommonModule,
    RouterModule.forChild(homeRoutes),
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbAlertModule,
    FontAwesomeModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule,

  ],
  entryComponents: [
    ConfirmationDialogComponent
  ]
})
export class HomeModule { }
