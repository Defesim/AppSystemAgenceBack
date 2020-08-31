import {AgentImmobilier} from './AgentImmobilier';
import {BienImmobilier} from './BienImmobilier';

export class Visite{

    /*_________________props__________________ */
    idVisite:number;
    dateVisite:Date;
    agentImmobilier:AgentImmobilier;
    bienImmobilier:BienImmobilier;

}