import {Personne} from './Personne';
import {BienImmobilier} from './BienImmobilier';


export class Proprietaire extends Personne{

    /*_________________props________________ */
    telephonePrive:string;
    telephonePro:string;
    listeDesBiensDuProprio:BienImmobilier[];

}