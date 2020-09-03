import { Component, OnInit } from '@angular/core';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { Router, ActivatedRoute } from '@angular/router';
import { BienImmobilier } from 'src/app/modèles/BienImmobilier';
import { ProprietairesService } from 'src/app/services/proprietaires.service';
import { Proprietaire } from 'src/app/modèles/Proprietaire';
import { NgModel } from '@angular/forms';
import { ClasseStandard } from 'src/app/modèles/ClasseStandard'
import { ClassesStandardsService } from 'src/app/services/classes-standards.service'

@Component({
  selector: 'app-create-biens-immobiliers',
  templateUrl: './create-biens-immobiliers.component.html',
  styleUrls: ['./create-biens-immobiliers.component.css']
})
export class CreateBiensImmobiliersComponent implements OnInit {


  bienImmo: BienImmobilier ;
  proprietaires = [];
  proprietaire : Proprietaire;
  classesStandards = [];
  classeStandard : ClasseStandard;

  constructor(private biensImmoService:BiensImmobiliersService, 
    private router:Router,
    private activatedRouter: ActivatedRoute,
    private proprietaireService : ProprietairesService,
    private classesStandardService : ClassesStandardsService) {
      this.findAllPrioprietaires();
      this.findAllClassesStandards();
   
  }//end ctor

  ngOnInit(): void {
    
    // recup du param de l'id de l'url ( ref : route 'editBien/:id' de  app-routing.module.ts)
    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idBien = +paramsMap.get("id");

      this.findBienImmoById(idBien);


    })
  }//end ngOnInit 

  findAllPrioprietaires(){
    this.proprietaireService.getAllProprietaireFromWsRest()
                            .subscribe(data => this.proprietaires = data)
  }


  findAllClassesStandards(){
    this.classesStandardService.getAllClasseStandardFromWsRest()
                                .subscribe(data => this.classesStandards = data )
  }

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
        classeStandard : null,
        proprietaire: null,
        acquisition:null,
        modeOffre:null
      };

      this.bienImmo.proprietaire = {
        adresse: null,
        email: null,
        id_personne : null,
        listeDesBiensDuProprio : null,
        nom : null,
        prenom :null,
        telephonePrive : null,
        telephonePro : null
      };

      this.bienImmo.classeStandard = {
        description: null,
        idClasseStandard: null,
        libelle: null,
        listeDesBienImmobilier: null,
        prixMaximum: null,
        superficieMinimum: null,
        typeDeBien: null,
        usageDuBien: null
      }

    }else{

      this.biensImmoService.getBienImmoByIdFromWsRest(idBien).subscribe(

        (bienToUpdate) => {
          this.bienImmo = bienToUpdate;
        }
      );

    }

  }//end findBienImmoById


  saveOrUpdateBienImmo(){

    console.log(this.bienImmo.proprietaire.id_personne)
    /**
     * Récupération ID et proprio
     */
    
    this.proprietaireService.getProprietaireByIdFromWsRest(this.bienImmo.proprietaire.id_personne).subscribe(  
       (proprietaireRetrouve)  =>  {this.bienImmo.proprietaire = proprietaireRetrouve;}
      );
  


    // test de l'id du bienImmo (AJOUT ou MODIF)
    if(this.bienImmo.idBienImmobilier == null){
      

      // this.bien
      // => le bien n'a pas encore d'id <=> ajout
      this.biensImmoService.ajouterBienImmoViaWsRest(this.bienImmo).subscribe(
      );

    }else{
      console.log(this.bienImmo.revenuCadastral);
      // => modification
      this.biensImmoService.modifierBienImmoViaWsRest(this.bienImmo).subscribe();

    }

    if (this.bienImmo.classeStandard == null) {

       //redirection vers list
      this.router.navigate(['/listBiens']);
      
    }else{

      this.router.navigate(['classesStandard/listeBiens', this.bienImmo.classeStandard.idClasseStandard])

    }
   

  }//end saveOrUpdateBienImmo

}//end classe
