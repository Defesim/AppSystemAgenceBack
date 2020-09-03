import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClassesStandardsService } from 'src/app/services/classes-standards.service';
import { ClasseStandard } from 'src/app/modèles/ClasseStandard';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';

@Component({
  selector: 'app-classes-standard',
  templateUrl: './classes-standard.component.html',
  styleUrls: ['./classes-standard.component.css']
})
export class ClassesStandardComponent implements OnInit {

  /*------- PROPRIETES --------*/
  // propriété de stockage des classes standards
  classesStandards = [];

  /*------- CONSTRUCTEUR --------*/
  constructor( private route:Router,
               private classeStandardService : ClassesStandardsService,
               private BienService: BiensImmobiliersService,
  ) { 
    this.findAllClassesStandards();

  }//end Ctor

  /*------- METHODES --------*/

  ngOnInit(): void {
  }//end ngOnInit

  findAllClassesStandards(){
    this.classeStandardService.getAllClasseStandardFromWsRest()
                              .subscribe(data=> this.classesStandards = data)
  }//end findAllClassesStandards


  editClasseStandard(idClasseStandard : number){

    // renvoie vers le formulaire d'édition avec l'id de la classe standard
    this.route.navigate(['classesStandard/edit', idClasseStandard])

  }// end findAllClassesStandards

  deleteClasseStandard(classeStandard: ClasseStandard){

    this.classeStandardService.supprimerClasseStdViaWsRest(classeStandard).subscribe(
      () => {this.findAllClassesStandards();}
    );

  }// end deleteClasseStandard

  findBienImmoByClasseStandard(idClasseStandard: number){

    //this.BienService.trouverBienImmoParClasseStandardViaWsREST(idClasseStandard).subscribe();

    this.route.navigate(['classesStandard/listeBiens', idClasseStandard])

 
  }

}// end classe
