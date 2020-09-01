import { Component, OnInit } from '@angular/core';
import {ClientsService} from 'src/app/services/clients.service';
import {Client} from 'src/app/modèles/Client';

import { Router } from '@angular/router';

@Component({
  selector: 'app-clients-proprio',
  templateUrl: './clients-proprio.component.html',
  styleUrls: ['./clients-proprio.component.css']
})
export class ClientsProprioComponent implements OnInit {

  /*__________________props_______________ */
  clients =[] ;


  constructor(private clientService:ClientsService,
              private route:Router) {
      this.findAllClient();
   }//end ctors


  ngOnInit(): void {
  }//end ngOnInit


  findAllClient(){
    this.clientService.getAllClientFromWsRest()
                      .subscribe(data=> this.clients = data);
  }//end findAllBiensImmo

}
