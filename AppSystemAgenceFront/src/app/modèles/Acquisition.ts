import {AgentImmobilier} from './AgentImmobilier';
import {BienImmobilier} from './BienImmobilier';
import {Client} from './Client';


export class Acquisition{

    /*___________________props__________________ */
    idAcquisition:number;
    typeAcquisition:string;
    dateAchat: Date;
    prixAchat:number;
    bienImmobilier:BienImmobilier;
    agentImmobilier: AgentImmobilier;
    client:Client;

}