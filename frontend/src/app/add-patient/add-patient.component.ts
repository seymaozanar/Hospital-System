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
  gender: string, 
}
@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {
  loggedUser: User;
  constructor(private serverService: ServerService, private router: Router) { }
  patientList: Patient[] = []
  user: User;
  patient;
 genderList = ['Woman', 'Man'];
 gender: string;
  @ViewChild('patientForm') patientForm: NgForm;

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
    this.serverService.savePatient(form).subscribe(
      (response: Patient) => {
        this.getPatient();
        this.patientForm.reset();

      },

    ); (error) => console.log(error)
  }

}
