import { Component, OnInit, ElementRef, Renderer2 } from '@angular/core';
import { rendererTypeName } from '@angular/compiler';


@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  AboutUsCondition : boolean = false;
  ProductsCondition : boolean = false;
  AwardsCondition : boolean = false;
  HelpCondition : boolean = false;
  ContactCondition : boolean = false;

  constructor(elementRef:ElementRef, 
              renderer:Renderer2) {
  }


  ngOnInit(): void {
    setInterval(this.DisplayNextColor, 400, ["#000088","#004444","#008800","#444400","#880000"]);
  }
  


  DisplayNextColor(listeColor:string[]){

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

  ClickOnAboutUs(){
    this.AboutUsCondition = !this.AboutUsCondition;
    this.ProductsCondition = false;
    this.AwardsCondition = false;
    this.HelpCondition = false;
    this.ContactCondition = false;
  }
  ClickOnProducts(){
    this.AboutUsCondition = false;
    this.ProductsCondition = !this.ProductsCondition;
    this.AwardsCondition = false;
    this.HelpCondition = false;
    this.ContactCondition = false;
  }
  ClickOnAwards(){
    this.AboutUsCondition = false;
    this.ProductsCondition = false;
    this.AwardsCondition = !this.AwardsCondition;
    this.HelpCondition = false;
    this.ContactCondition = false;
  }
  ClickOnHelp(){
    this.AboutUsCondition = false;
    this.ProductsCondition = false;
    this.AwardsCondition = false;
    this.HelpCondition = !this.HelpCondition;
    this.ContactCondition = false;
  }
  ClickOnContact(){
    this.AboutUsCondition = false;
    this.ProductsCondition = false;
    this.AwardsCondition = false;
    this.HelpCondition = false;
    this.ContactCondition = !this.ContactCondition;
  }
  
}
