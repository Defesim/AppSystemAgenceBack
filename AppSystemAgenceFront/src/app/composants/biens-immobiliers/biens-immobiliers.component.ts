import { Component, OnInit } from '@angular/core';
import { BiensImmobiliersService } from 'src/app/services/biens-immobiliers.service';
import { BienImmobilier } from 'src/app/modèles/BienImmobilier';
import { Adresse } from 'src/app/modèles/Adresse';
import { Router, ActivatedRoute } from '@angular/router';
import { AdressesService } from 'src/app/services/adresses.service';



@Component({
  selector: 'app-biens-immobiliers',
  templateUrl: './biens-immobiliers.component.html',
  styleUrls: ['./biens-immobiliers.component.css']
})

export class BiensImmobiliersComponent implements OnInit {

  //var de stockage de tous les biens immo
  biensImmobiliers = [];
  isAddAdressChecked: boolean;
  adresse: Adresse;

  constructor(private biensImmoService: BiensImmobiliersService, private route: Router, private adresseService: AdressesService) {
    this.findAllBiensImmo();
 
    this.isAddAdressChecked = false;

    this.adresse = {
      codePostal: null,
      idAdresse: null,
      rue: null,
      ville: null
    }

  }//end ctor

  ngOnInit(): void {
  }//end ngOnInit


  findAllBiensImmo() {
    this.biensImmoService.getAllBienImmoFromWsRest()
      .subscribe(data => this.biensImmobiliers = data);
  }//end findAllBiensImmo


  deleteBienImmo(bienImmobilier: BienImmobilier) {

    this.biensImmoService.supprimerBienImmoViaWsRest(bienImmobilier).subscribe(() => {

      this.findAllBiensImmo();
    });

  }//end deleteBienImmo


  editBienImmo(idBienImmobilier: number) {

    this.route.navigate(['listBiens/edit', idBienImmobilier]);

  }//end editBienImmo

  /**
   * Méthode pour renvoyer le bien immobilier vers une nouvelle page html avec les détails associés
   */
  detailsBienImmo(IdbienImmobilier: number) {


    this.route.navigate(['bienImmo', IdbienImmobilier]);

  }//end detailsBienImmo

  attribuerAdresse(pBien: BienImmobilier) {
    this.isAddAdressChecked = !(this.isAddAdressChecked);
  }

  formAdressAttrib(pBien: BienImmobilier) {

    this.isAddAdressChecked = !(this.isAddAdressChecked);
    console.log(this.adresse);

    this.adresseService.ajouterAdresseViaWsRest(this.adresse).subscribe();

    pBien.adresse = this.adresse;
    console.log(pBien.adresse);

    this.biensImmoService.modifierBienImmoViaWsRest(pBien).subscribe();

    this.findAllBiensImmo();

  }

}//end class