import { Component, OnInit } from '@angular/core';
import { ServerService } from '../server.service';
import { User } from '../user/user.component';
export interface Drug {
  drugId: number,
  name: string,
  user: string
}
@Component({
  selector: 'app-show-drug',
  templateUrl: './show-drug.component.html',
  styleUrls: ['./show-drug.component.css']
})
export class ShowDrugComponent implements OnInit {

  drugList: Drug[] = [];
  user: User;
  constructor(private serverService: ServerService) { }

  ngOnInit() {
    this.onGet();
    this.user = JSON.parse(localStorage.getItem("user"));
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


