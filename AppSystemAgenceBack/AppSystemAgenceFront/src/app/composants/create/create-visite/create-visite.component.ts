import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { VisitesService } from 'src/app/services/visites.service';
import { Visite } from 'src/app/modèles/Visite';

@Component({
  selector: 'app-create-visite',
  templateUrl: './create-visite.component.html',
  styleUrls: ['./create-visite.component.css']
})
export class CreateVisiteComponent implements OnInit {

  visite: Visite ;

  constructor(private visiteService:VisitesService, 
              private router:Router,
              private activatedRouter: ActivatedRoute) { 
            
  }//end ctor

  ngOnInit(): void {

    // recup du param de l'id de l'url ( ref : route 'editBien/:id' de  app-routing.module.ts)
    this.activatedRouter.paramMap.subscribe((paramsMap)=> {

      const idVisite = +paramsMap.get("id");

      this.findVisiteById(idVisite);


    })
  }//end ngOnInit


  findVisiteById(idVisite: number){

    if(idVisite == 0){

      this.visite =  {
        agentImmobilier:null,
        bienImmobilier:null,
        dateVisite:null,
        idVisite:null
      };

    }else{

      this.visiteService.getVisiteByIdFromWsRest(idVisite).subscribe(

        (visiteToUpdate) => {
          this.visite = visiteToUpdate;
        }
      );

    }

  }//end findVisiteById


  saveOrUpdateVisite(){

    // test de l'id du Visite (AJOUT ou MODIF)
    if(this.visite.idVisite == null){
      
      
      // => le bien n'a pas encore d'id <=> ajout
      this.visiteService.ajouterVisiteViaWsRest(this.visite).subscribe();

    }else{
      // => modification
      this.visiteService.modifierVisiteViaWsRest(this.visite).subscribe();

    }

    //redirection vers list
    this.router.navigate(['/visites']);

  }//end saveOrUpdateVisite
}//end class