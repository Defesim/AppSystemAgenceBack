import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ResolveEnd, Router } from '@angular/router';
import { AgentImmobilier } from 'src/app/modèles/AgentImmobilier';
import { NgFlashMessageService } from 'ng-flash-messages';

export class User{
  constructor(
    public status:string, 
  ) {} // I AM FERDINAND VON AEGIR
}

export class JwtResponse{
  constructor(
    public jwttoken:string,
     ) {}
  
}

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  constructor(private httpClient:HttpClient,
    private router: Router,
    private ngFlashMessageService: NgFlashMessageService) { }

    authenticate(username, password) {
      if(!username || !password){
        this.router.navigate(['/login']);
      }
   
      this.httpClient.post<any>('http://localhost:8080/gestion-agence-immo/ws-rest/authenticate',
        {username:username, password:password}).subscribe(
        userData => {
  
          // setup sesssion
            sessionStorage.setItem('username',username);
            let tokenStr = userData.token;
            sessionStorage.setItem('token', tokenStr);
            let role = userData.role;
            sessionStorage.setItem('role', role);
          // redirect on home page
            this.redirectOnSuccess( username );
  
        }, err => {
           this.redirectBadCredentials();
        }
      );
    }
  
    redirectBadCredentials(){
      this.ngFlashMessageService.showFlashMessage({
        messages: ["Mauvais Identifiants !"], 
        dismissible: true, 
        timeout: 2500,
        type: 'danger'
      });
      this.router.navigate(['/login']);
    }
  
    redirectOnSuccess(username: String){
      this.ngFlashMessageService.showFlashMessage({
        messages: ["Vous etes connecté ! Bienvenue M. " + username + " :)"], 
        dismissible: true, 
        timeout: 5000,
        type: 'success'
      });
      this.router.navigate(['/listBiens']);
    }
   
    isUserLoggedIn(): boolean {
      let user = sessionStorage.getItem('username');
      return !(user === null)
    }

    isUserAgentImmo(): boolean{
      return sessionStorage.getItem('role') === "ROLE_ADMIN";
    }
 
    logOut() {
      sessionStorage.removeItem('username');
      sessionStorage.removeItem('token');
      sessionStorage.setItem('', ""); // ou 'role', null
    }

    registerAdmin(agent: AgentImmobilier){
      return this.httpClient.post<any>('http://localhost:8080/gestion-agence-immo/ws-rest/registerAdmin', agent);
    }

    getUserName(): String {
      return sessionStorage.getItem('username') === null ? "Unknown" : sessionStorage.getItem('username');
    }

    getUserRole(): String {
      return sessionStorage.getItem('role') === null ? "Unknown" : sessionStorage.getItem('role').split('ROLE_')[1];
    }
}