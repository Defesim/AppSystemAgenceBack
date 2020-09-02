import { Component, OnInit } from '@angular/core';
import { ClasseStandard } from 'src/app/modèles/ClasseStandard';

@Component({
  selector: 'app-create-classe-standard',
  templateUrl: './create-classe-standard.component.html',
  styleUrls: ['./create-classe-standard.component.css']
})
export class CreateClasseStandardComponent implements OnInit {

  /*---------- PROP ---------------*/

  // Prop appelée dans le formulaire d'ajout/modif d'une classe standard
  classeStandard : ClasseStandard ;

  constructor() { }

  ngOnInit(): void {
  }

}
