import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';

@Component({
  selector: 'app-bien-immo-par-classe-standard',
  templateUrl: './bien-immo-par-classe-standard.component.html',
  styleUrls: ['./bien-immo-par-classe-standard.component.css']
})
export class BienImmoParClasseStandardComponent implements OnInit {

  /*------- PROPRIETES --------*/
  // propriété de stockage des bien immobilier par classe standard
  biensImmobiliersByCS = [];


  /*------- CONSTRUCTEUR --------*/
  constructor(
    private route: Router,
    private BienService: BiensImmobiliersService,
    private activatedRouter: ActivatedRoute
  ) {
    //this.findBienImmoByClasseStandard(idClasseStandard: number);

  }
  /*------- METHODES --------*/


  ngOnInit(): void {
    this.activatedRouter.paramMap.subscribe(
      (paramsMap => {
        const idClasseStandard = +paramsMap.get("idClasseStandard");
        this.findBienImmoByClasseStandard(idClasseStandard);
      })
    ) //end subscribe

  }//end ngOnInit

  findBienImmoByClasseStandard(idClasseStandard: number) {
    this.BienService.trouverBienImmoParClasseStandardViaWsREST(idClasseStandard).subscribe(

      (listeBienImmoByCS) =>  {this.biensImmobiliersByCS = listeBienImmoByCS ; }
    );//end subcribe

  }//end findBienImmoByClasseStandard
}
