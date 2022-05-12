import {Component, EventEmitter, Inject, OnInit, Output} from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import {UserService} from "../../_services/user.service";
import {TokenStorageService} from "../../_services/token-storage.service";


@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.css']
})
export class ConfirmationDialogComponent implements OnInit {

  confirmationCode:string;
  @Output() ConfirmationCodeEvent = new EventEmitter<any>()

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private userService: UserService,private tokenStorage: TokenStorageService) {

  }

  validateAccount(){
    console.log(this.data.registeredUserId);
    this.userService.verifyAccount(this.confirmationCode,this.data.registeredUserId).subscribe((data)=>{
      this.ConfirmationCodeEvent.emit();
    });
  }


  ngOnInit(): void {
  }

}
