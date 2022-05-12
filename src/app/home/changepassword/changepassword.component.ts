import { Component, OnInit } from '@angular/core';

import { FormsModule } from '@angular/forms';
import {TokenStorageService} from "../../_services/token-storage.service";
import {UserService} from "../../_services/user.service";
@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  form: any = {
    username: null,
    password: null,
    newpassword:null
  };
  isLoggedIn = false;
  constructor(private tokenStorage: TokenStorageService,private userservice:UserService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }



  }

  onSubmit():void {

    const { username, password,newpassword } = this.form;

    this.userservice.Changepassword(password,username,newpassword).subscribe(

      data =>{

      }

    );


  }

}
