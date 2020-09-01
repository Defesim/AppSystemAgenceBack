import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';
import { rendererTypeName } from '@angular/compiler';


@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  x = 0;

  constructor(elementRef:ElementRef, renderer:Renderer2) { }

  ngOnInit(): void {
    setInterval(this.DisplayNextColor,2000);
  }
  
  DisplayNextColor(): void {
    let prefix = "href";
    let suffix = "ts";
    console.log(this.x);
    (this.x == 5) ? 0 : this.x+1;

    for (let index = 1; index < 6; index++) {

      let ElementId = prefix + index + suffix;
      let hrefModif = document.getElementById(ElementId);
      let newClassNumber = this.x + index;
      if(newClassNumber > 5){
        newClassNumber = newClassNumber - 5;
      }
      hrefModif.className = "Color" + newClassNumber;
    }
  }
}
