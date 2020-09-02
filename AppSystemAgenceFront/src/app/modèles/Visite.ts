import {AgentImmobilier} from './AgentImmobilier';
import {BienImmobilier} from './BienImmobilier';
import { Client } from './Client';

export class Visite{

    /*_________________props__________________ */
    idVisite:number;
    dateVisite:string; //Date
    agentImmobilier:AgentImmobilier;
    bienImmobilier:BienImmobilier;
    client:Client;

}