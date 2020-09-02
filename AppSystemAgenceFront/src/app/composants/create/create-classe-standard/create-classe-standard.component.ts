import { Component, OnInit } from '@angular/core';
import { ClasseStandard } from 'src/app/modèles/ClasseStandard';
import { Router, ActivatedRoute } from '@angular/router';
import { ClassesStandardsService } from 'src/app/services/classes-standards.service';

@Component({
  selector: 'app-create-classe-standard',
  templateUrl: './create-classe-standard.component.html',
  styleUrls: ['./create-classe-standard.component.css']
})
export class CreateClasseStandardComponent implements OnInit {

  /*---------- PROP ---------------*/

  // Prop appelée dans le formulaire d'ajout/modif d'une classe standard
  classeStandard: ClasseStandard;

  // CTOR
  constructor(
    private classeStandardService: ClassesStandardsService,
    private router: Router,
    private activatedRouter: ActivatedRoute,) {

  } 
     
  ngOnInit(): void {

    // recup du param de l'id de l'url ( ref : route 'editBien/:id' de  app-routing.module.ts)
    this.activatedRouter.paramMap.subscribe((paramsMap) => {

      const idClasseStandard = +paramsMap.get("id");

      this.findClasseStandardById(idClasseStandard);


    })
  }//end ngOnInit 

  findClasseStandardById(idClasseStandard: number) {

    if (idClasseStandard == 0) {

      this.classeStandard = {
        idClasseStandard: null,
        description: null,
        libelle: null,
        listeDesBienImmobilier: null,
        prixMaximum: null,
        superficieMinimum: null,
        typeDeBien: null,
        usageDuBien: null,

      }

    } else {
      this.classeStandardService.getClasseStdByIdFromWsRest(idClasseStandard).subscribe(

        (classeToUpdate) => {
          this.classeStandard = classeToUpdate;
        }
      )

    }
  }// findClasseStandardById

  saveOrUpdateClasseStandard(){

    if (this.classeStandard.idClasseStandard == null) {

      this.classeStandardService.ajouterClasseStdViaWsRest(this.classeStandard).subscribe();
      
    }else{

      this.classeStandardService.modifierClasseStdViaWsRest(this.classeStandard).subscribe();
    }

  }// saveOrUpdateClasseStandard


}//end classe
