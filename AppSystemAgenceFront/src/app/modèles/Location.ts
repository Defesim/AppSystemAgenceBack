import { ModeOffre } from './ModeOffre';



export class Location extends ModeOffre{

    /*______________________props___________________________ */
    cautionLocative:number;
    loyerMensuel: number;
    chargesMensuelles:number;
    typeBail:string;
    meuble:boolean;

    constructor( cautionLocative:number, loyerMensuel: number, chargesMensuelles:number,
                 typeBail:string, meuble:boolean){
                     super();
                     this.cautionLocative = cautionLocative;
                     this.chargesMensuelles = chargesMensuelles;
                     this.loyerMensuel = loyerMensuel;
                     this.typeBail = typeBail;
                     this.meuble = meuble;
                 }

                 
}//end class