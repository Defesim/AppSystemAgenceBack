import{Adresse} from './Adresse'
import{ClasseStandard} from './ClasseStandard';
import { Proprietaire } from "./Proprietaire";


export class BienImmobilier{

    /*_____________________props_______________________ */

    idBienImmobilier:number;
    statut:string;
    dateDeSoumission:string; //date
    dateDeMiseADisposition:string; //date
    revenuCadastral:number;
    adresse:Adresse;
    classeStandard:ClasseStandard;
    proprietaire:Proprietaire;


}