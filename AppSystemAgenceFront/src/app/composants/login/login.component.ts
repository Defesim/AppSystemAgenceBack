import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgFlashMessageService } from 'ng-flash-messages';

import { AuthentificationService } from "src/app/services/auth/authentification.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  /*______________props_________________ */
  invalidLogin = false
  username: String = '';
  password: String = '';

  constructor(private router: Router,
    private loginservice: AuthentificationService,
    private ngFlashMessageService: NgFlashMessageService) { }

  ngOnInit(): void {
  }

  doLogin(){
    this.loginservice.authenticate(this.username, this.password);
  }//end doLogin()

}
