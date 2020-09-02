import { Component, OnInit } from '@angular/core';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { Router, ActivatedRoute } from '@angular/router';
import { BienImmobilier } from 'src/app/modèles/BienImmobilier';

@Component({
  selector: 'app-create-biens-immobiliers',
  templateUrl: './create-biens-immobiliers.component.html',
  styleUrls: ['./create-biens-immobiliers.component.css']
})
export class CreateBiensImmobiliersComponent implements OnInit {


  bienImmo: BienImmobilier ;

  constructor(private biensImmoService:BiensImmobiliersService, 
    private router:Router,
    private activatedRouter: ActivatedRoute) { 
  
  }//end ctor

  ngOnInit(): void {

    // recup du param de l'id de l'url ( ref : route 'editBien/:id' de  app-routing.module.ts)
    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idBien = +paramsMap.get("id");

      this.findBienImmoById(idBien);


    })
  }//end ngOnInit

  /**
   * Permet de  :
   *          -> cas id = 0 : (Ajout) init un objet vide pour l'ajout
   *          -> cad id > 0 : (Modif) appel du service pour la reucp des infos du bien à mod
   * 
   * @param idEmploye 
   */
  findBienImmoById(idBien: number){

    if(idBien == 0){

      this.bienImmo =  {
        idBienImmobilier : null,
        dateDeMiseADisposition :  null,
        dateDeSoumission : null,
        revenuCadastral : null,
        statut : null,
        adresse : null,
        classeStandard : null
      };

    }else{

      this.biensImmoService.getBienImmoByIdFromWsRest(idBien).subscribe(

        (bienToUpdate) => {
          this.bienImmo = bienToUpdate;
        }
      );

    }

  }//end findBienImmoById


  saveOrUpdateBienImmo(){

    // test de l'id du bienImmo (AJOUT ou MODIF)
    if(this.bienImmo.idBienImmobilier == null){
      
      
      // => le bien n'a pas encore d'id <=> ajout
      this.biensImmoService.ajouterBienImmoViaWsRest(this.bienImmo).subscribe();

    }else{
      console.log(this.bienImmo.revenuCadastral);
      // => modification
      this.biensImmoService.modifierBienImmoViaWsRest(this.bienImmo).subscribe();

    }

    //redirection vers list
    this.router.navigate(['/listBiens']);

  }//end saveOrUpdateBienImmo

}//end classe
