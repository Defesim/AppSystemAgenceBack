import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';


@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  x : number = 0;
  prefix : string = "href";
  suffix : string = "ts";
  constructor(elementRef:ElementRef, renderer:Renderer2) { }

  ngOnInit(): void {
    setInterval(this.DisplayNextColor,2000);
  }

  DisplayNextColor(){
    (this.x == 5) ? 0 : this.x+1;
    console.log(this.x);
    for (let index = 1; index < 6; index++) {
      let ElementId = this.prefix + index + this.suffix;
      let hrefModif = document.getElementById(ElementId);
      let newClassNumber = this.x + index;
      if(newClassNumber > 5){
        newClassNumber = newClassNumber - 5;
      }
      hrefModif.className = "Color" + newClassNumber;
    }
  }

}
