import { Component, OnInit, ViewChild } from '@angular/core';
import { ServerService } from '../server.service';
import { NgForm } from '@angular/forms';
import { Router } from '../../../node_modules/@angular/router';

import { User } from '../user/user.component';
export interface Patient {
  name: string,
  surname: string,
  id: number
  user: User,
}
@Component({
  selector: 'app-show-patient',
  templateUrl: './show-patient.component.html',
  styleUrls: ['./show-patient.component.css']
})
export class ShowPatientComponent implements OnInit {
  selectedPatient;
  selectedPatient2;

  loggedUser: User;
  constructor(private serverService: ServerService, private router: Router) { }
  patientList: Patient[] = []
  user: User;
  patient;
  @ViewChild('updateForm1') updateForm: NgForm;

  ngOnInit() {
    this.getPatient();
  }
  getPatient() {
    this.serverService.getPatient(JSON.parse(localStorage.getItem("user")))
      .subscribe(
        (patients: Patient[]) => {
          this.patientList = patients
          this.serverService.setPatient(patients);

        }
      );
    (error) => console.log(error)
  }
  savePatient(form) {

    form.user = JSON.parse(localStorage.getItem("user"));
    console.log(this.updateForm);

    this.serverService.savePatient(form).subscribe(
      (response: Patient) => {
        this.getPatient();
        this.updateForm.reset();


      }

    )
  }
  selectPatient(patient) {
    if (this.selectedPatient !== patient) {
      this.selectedPatient = patient
      console.log(this.selectedPatient);
      this.serverService.setPatient(patient);
      this.router.navigate(["/profile"]);

    } else {
      this.selectedPatient = null;
    }
  }
  selectPatientt(patients) {
    this.updateForm.setValue(patients);
  }


}
