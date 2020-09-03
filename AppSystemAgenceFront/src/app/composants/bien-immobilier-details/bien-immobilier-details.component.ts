import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { BienImmobilier } from 'src/app/modèles/BienImmobilier';

@Component({
  selector: 'app-bien-immobilier-details',
  templateUrl: './bien-immobilier-details.component.html',
  styleUrls: ['./bien-immobilier-details.component.css']
})
export class BienImmobilierDetailsComponent implements OnInit {

  /*_______ PROPS_____*/
  bienImmo: BienImmobilier;

  /*_______ CTOR ______*/
  constructor(
    private router: Router,
    private activatedRouter: ActivatedRoute,
    private bienImmobilierServicer: BiensImmobiliersService
  ) {

  }//end ctor

  /*_______ METHODES ______*/
  /**
   * Méthode exécutée à l'initiation
   */
  ngOnInit(): void {

    /**
     * Récupération du paramètre 'bien' de
     */
    this.activatedRouter.paramMap.subscribe(
      (paramsMap) => {

        const idBien = +paramsMap.get("id");
        this.findBienImmoById(idBien);

      }
    )
  }//end ngOnInit

  findBienImmoById(idBien: number) {

    this.bienImmobilierServicer.getBienImmoByIdFromWsRest(idBien).subscribe(

      (bienToUpdate) => {
        this.bienImmo = bienToUpdate;
      }
    );

  }//end findBienImmoById

  acquerirBienImmo(idBien: number){


    this.router.navigate(['acquisition',  idBien]);

  }//end acquerirBienImmo

}//end class
