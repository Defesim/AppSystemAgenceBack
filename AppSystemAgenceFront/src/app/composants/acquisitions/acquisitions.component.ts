import { Component, OnInit } from '@angular/core';
import { AcquisitionsService } from 'src/app/services/acquisitions.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-acquisitions',
  templateUrl: './acquisitions.component.html',
  styleUrls: ['./acquisitions.component.css']
})
export class AcquisitionsComponent implements OnInit {

  // PROPS
  acquisitions = []; 

  // CTOR
  constructor(
    private acqusitionService: AcquisitionsService,
    private router: Router
  ) { 
    this.findAllAcquisitions();
  }


  // METHODES
  ngOnInit(): void {
  }

  findAllAcquisitions(){

    this.acqusitionService.getAllAcquisitionFromWsRest().subscribe( data => this.acquisitions = data
    );

  }

}//end classe 
