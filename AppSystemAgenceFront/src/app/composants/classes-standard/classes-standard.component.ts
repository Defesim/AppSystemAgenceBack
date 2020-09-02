import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-classes-standard',
  templateUrl: './classes-standard.component.html',
  styleUrls: ['./classes-standard.component.css']
})
export class ClassesStandardComponent implements OnInit {

  classeStandard = [];

  constructor( private route:Router
  ) { }

  ngOnInit(): void {
  }

}
