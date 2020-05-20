import { Drug } from "./drug.model";
import { Patient } from "./patient.model";
import { Disease } from "./disease.model";

export class Treat {
    situation: String;
	drug: Drug;
	patient: Patient;
    disease: Disease;
    
    constructor(){
        this.situation = null;
        this.drug = new Drug();
        this.patient = new Patient();
        this.disease = new Disease();
    }
}