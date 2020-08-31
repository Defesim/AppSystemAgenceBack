import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  /*______________props_________________ */
  utilisateur = {login:"test" , password:"test"};

  constructor() { }

  ngOnInit(): void {
  }

  seConnecter(saisie:any){


  }//end seConnecter

}
