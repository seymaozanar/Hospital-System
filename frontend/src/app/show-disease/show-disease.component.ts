

import { ServerService } from '../server.service';
import { Component, OnInit } from '@angular/core';

export interface Disease {
  disease_name: string,
  disease_description: string,
  
}

@Component({
  selector: 'app-show-disease',
  templateUrl: './show-disease.component.html',
  styleUrls: ['./show-disease.component.css']
})
export class ShowDiseaseComponent implements OnInit {

  constructor(private serverService: ServerService) { }
 
  diseaseList: Disease[] = []
 
  ngOnInit() {
    this.getDisease();

  }


  getDisease() {
    this.serverService.getDisease()
      .subscribe(
        (diseases: Disease[]) => this.diseaseList = diseases
     );
    (error) => console.log(error)
  }

  delete(disease_id) {
    this.serverService.deleteDisease(disease_id).subscribe(
      (response) => {
        this.getDisease();
      }

    );
    (error) => console.log(error)
  }

}
