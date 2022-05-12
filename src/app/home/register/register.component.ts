import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import {MatDialog} from "@angular/material/dialog";

import {Router} from "@angular/router"
import {AuthService} from "../../_services/auth.service";
import {TokenStorageService} from "../../_services/token-storage.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    role:["COMPA"],
    firstName:null,
    lastName:null,
    CompanyName:null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  registeredUserId=0;
  errorMessage = '';
  constructor(private router: Router,private authService: AuthService,public dialog: MatDialog,private tokenStorage: TokenStorageService) { }

  openDialog(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {registeredUserId:this.registeredUserId}
    });
    const sub = dialogRef.componentInstance.ConfirmationCodeEvent.subscribe((result) => {
      dialogRef.close();
      this.router.navigate(['/login'])
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed' + result);
    });
  }
  ngOnInit(): void {
    console.log(this.tokenStorage.getUser().user)
  }

  onSubmit(): void {
    const { username, email, password,role,firstName,lastName ,CompanyName} = this.form;
    this.authService.register(username, email, password,role,firstName,lastName ,CompanyName).subscribe(
      data => {
        this.registeredUserId=data.message
        this.isSuccessful = true;
        this.openDialog();
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
