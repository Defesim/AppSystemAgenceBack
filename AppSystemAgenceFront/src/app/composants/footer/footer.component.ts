import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';
import { rendererTypeName } from '@angular/compiler';


@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  x = 0;

  

  constructor(elementRef:ElementRef, 
              renderer:Renderer2) {
  }


  ngOnInit(): void {
    setInterval(this.DisplayNextColor, 200, ["#000088","#004444","#008800","#444400","#880000"]);
  }
  


  DisplayNextColor(listeColor:string[]){
    let refNum :number = Math.floor(Math.random()*5) +1;

    for (let index = 1; index < 6; index++) {

      let ElementId = "Color"  + index.toString();
      let hrefModif = document.getElementById(ElementId);
     
      if (hrefModif.style.color == "rgb(0, 0, 136)"){
        hrefModif.style.color = listeColor[1];
      }
      else if (hrefModif.style.color == "rgb(0, 68, 68)"){
        hrefModif.style.color = listeColor[2];
      }
      else if (hrefModif.style.color == "rgb(0, 136, 0)"){
        hrefModif.style.color = listeColor[3];
      }
      else if (hrefModif.style.color == "rgb(68, 68, 0)"){
        hrefModif.style.color = listeColor[4];
      }
      else if (hrefModif.style.color == "rgb(136, 0, 0)"){
        hrefModif.style.color = listeColor[0];
      }
    }
  }
}
