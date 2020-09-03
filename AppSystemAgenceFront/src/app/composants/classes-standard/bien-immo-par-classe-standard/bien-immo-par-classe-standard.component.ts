import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { ClassesStandardsService } from 'src/app/services/classes-standards.service';
import { ClasseStandard } from 'src/app/modèles/ClasseStandard';

@Component({
  selector: 'app-bien-immo-par-classe-standard',
  templateUrl: './bien-immo-par-classe-standard.component.html',
  styleUrls: ['./bien-immo-par-classe-standard.component.css']
})
export class BienImmoParClasseStandardComponent implements OnInit {

  /*------- PROPRIETES --------*/
  // propriété de stockage des bien immobilier par classe standard
  biensImmobiliersByCS = [];

  // Prop de stockage de la classe standard
  classeStandardSelect : ClasseStandard;


  /*------- CONSTRUCTEUR --------*/
  constructor(
    private route: Router,
    private BienService: BiensImmobiliersService,
    private CSService: ClassesStandardsService,
    private activatedRouter: ActivatedRoute
  ) {
    //this.findBienImmoByClasseStandard(idClasseStandard: number);

  }
  /*------- METHODES --------*/


  ngOnInit(): void {
    this.activatedRouter.paramMap.subscribe(
      (paramsMap => {
        const idClasseStandard = +paramsMap.get("id");
        this.findBienImmoByClasseStandard(idClasseStandard);
        this.getClasseStdByIdFromWsRe(idClasseStandard);
      })
    ) //end subscribe

  }//end ngOnInit

  findBienImmoByClasseStandard(idClasseStandard: number) {
    this.BienService.trouverBienImmoParClasseStandardViaWsREST(idClasseStandard).subscribe(

      (listeBienImmoByCS) =>  {this.biensImmobiliersByCS = listeBienImmoByCS ; }
    );//end subcribe

  }//end findBienImmoByClasseStandard

  getClasseStdByIdFromWsRe(idClasseStandard: number){

    this.CSService.getClasseStdByIdFromWsRest(idClasseStandard).subscribe(

      (CSatrouver) => { this.classeStandardSelect = CSatrouver }

    )//end subscride
  }//end getClasseStdByIdFromWsRe


}//end classe
