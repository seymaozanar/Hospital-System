
import { Component, OnInit } from '@angular/core';
import { ServerService } from '../server.service';

export interface Disease {
  disease_name: string,
  disease_description: string,
  
}
@Component({
  selector: 'app-add-disease',
  templateUrl: './add-disease.component.html',
  styleUrls: ['./add-disease.component.css']
})

export class AddDiseaseComponent implements OnInit {

  constructor(private serverService: ServerService) { }
 
  diseaseList: Disease[] = []
 
  ngOnInit() {
    this.getDisease();

  }

  saveDisease(form) {
    let disease = {
      disease_name: form.disease_name,
      disease_description:form.disease_description, 
     

    };
    this.serverService.saveDisease(disease).subscribe(
      (response: Disease) => {
        this.getDisease();
      },
      (error) => console.log(error)
    );
  }

  getDisease() {
    this.serverService.getDisease()
      .subscribe(
        (diseases: Disease[]) => this.diseaseList = diseases
     );
    (error) => console.log(error)
  }



}
