import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';


@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  

  constructor(elementRef:ElementRef, 
              renderer:Renderer2) {
  }

  ngOnInit(): void {
    setInterval(this.DisplayNextColor,2000, ["#000088","#004444","#008800","#444400","#880000"]);
  }

  DisplayNextColor(listeColor:string[]){
    let refNum :number = Math.floor(Math.random()*5) +1;

    for (let index = 1; index < 6; index++) {

      let ElementId = "Color"  + index.toString();
      let hrefModif = document.getElementById(ElementId);
     
      let newIndex:number = refNum + index ;
      if(newIndex >5 ){
        newIndex = newIndex%5 +1;
      }      
      hrefModif.style.color = listeColor[newIndex];
    }
  }

}
