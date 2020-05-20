import { Component, OnInit } from '@angular/core';
import { ServerService } from '../server.service';
import { User } from '../user/user.component';
export interface Drug {
  drugId: number,
  name: string,
  user: string
}
@Component({
  selector: 'app-drug',
  templateUrl: './drug.component.html',
  styleUrls: ['./drug.component.css']
})
export class DrugComponent implements OnInit {

  drugList: Drug[] = [];
  user: User;
  constructor(private serverService: ServerService) { }

  ngOnInit() {
    this.onGet();
    this.user = JSON.parse(localStorage.getItem("user"));
  }

  onSave(name) {

    let drug = {
      drugName: name,
      drugId: null,
      user: this.user.id
    };
    this.serverService.saveDrug(drug).subscribe(
      (response: Drug) => {
        this.drugList.push(response);
      },
      (error) => console.log(error)
    );
  }
  onGet() {
    this.serverService.getServers()
      .subscribe(
        (drugs: Drug[]) => this.drugList = drugs
      );

    (error) => console.log(error)


  }

  delete(drugId) {

    this.serverService.deleteDrug(drugId).subscribe(
      (response) => {
        this.onGet();
      },

    );
    (error) => console.log(error)
  }
}


