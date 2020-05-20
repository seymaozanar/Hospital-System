
import { Component, OnInit } from '@angular/core';
import { ServerService } from '../server.service';
export interface Doctor {
  name: string
  surname: string
  branch: string
  doctorId: string
}
@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  constructor(private serverService: ServerService) { }

  doctors: Doctor[] = []

  saveDoctor(form) {

    let doctor = {
      name: form.name,
      surname: form.surname,
      branch: form.branch,
      doctorId: this.generateId()
    };
    this.serverService.saveDoctor(doctor).subscribe(
      (response: Doctor) => {
        this.onGetDoctors();
      },
      (error) => console.log(error)
    );
  }
  onGetDoctors() {
    this.serverService.getDoctors()
      .subscribe(
        (drugs: Doctor[]) => this.doctors = drugs

      );

    (error) => console.log(error)
  }

  ngOnInit() {
    this.onGetDoctors();
  }
  generateId() {
    return Math.round(Math.random() * 10000);
  }
}
