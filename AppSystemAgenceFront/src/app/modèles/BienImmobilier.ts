import{Adresse} from './Adresse'
import{ClasseStandard} from './ClasseStandard';


export class BienImmobilier{

    /*_____________________props_______________________ */

    idBienImmobilier:number;
    statut:string;
    dateDeSoumission:Date;
    dateDeMiseADisposition:Date;
    revenuCadastral:number;
    adresse:Adresse;
    classeStandard:ClasseStandard;

}