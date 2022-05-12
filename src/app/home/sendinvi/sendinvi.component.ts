import { Component, OnInit } from '@angular/core';
import {UserService} from "../../_services/user.service";

@Component({
  selector: 'app-sendinvi',
  templateUrl: './sendinvi.component.html',
  styleUrls: ['./sendinvi.component.css']
})
export class SendinviComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.RegisterFromCsv().subscribe();
  }


}
