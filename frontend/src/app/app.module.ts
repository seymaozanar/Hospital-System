import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ServerService } from './server.service';
import { DoctorComponent } from './doctor/doctor.component';
import { DrugComponent } from './drug/drug.component';
import { RouterModule } from '@angular/router';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { ThreatComponent } from './threat/threat.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { ShowPatientComponent } from './show-patient/show-patient.component';
import { AddDrugComponent } from './add-drug/add-drug.component';
import { ShowDrugComponent } from './show-drug/show-drug.component';
import { AddDiseaseComponent } from './add-disease/add-disease.component';
import { ShowDiseaseComponent } from './show-disease/show-disease.component';
import {AuthGuardService as AuthGuard } from './auth-guard.service';
import { Ng2Webstorage } from 'ngx-webstorage';
import { ChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [
    AppComponent,
    DoctorComponent,
    DrugComponent,
    UserComponent,
    LoginComponent,
    ThreatComponent,
    AddPatientComponent,
    ShowPatientComponent,
    AddDrugComponent,
    ShowDrugComponent,
    AddDiseaseComponent,
    ShowDiseaseComponent,
  ],

  
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    Ng2Webstorage,
    ChartsModule,


    RouterModule.forRoot([
      { path: '', component: LoginComponent, pathMatch: 'full' },
      { path: 'drug', component: DrugComponent, canActivate : [AuthGuard] },
      { path: 'treat', component: ThreatComponent},
      { path: 'treat', component: ThreatComponent, canActivate : [AuthGuard]},
      { path: 'add-patient', component: AddPatientComponent , canActivate : [AuthGuard]},
      { path: 'show-patient', component: ShowPatientComponent , canActivate : [AuthGuard] },
      { path: 'add-drug', component: AddDrugComponent , canActivate : [AuthGuard]},
      { path: 'show-drug', component: ShowDrugComponent , canActivate : [AuthGuard]},
      { path: 'show-disease', component: ShowDiseaseComponent , canActivate : [AuthGuard]},
      { path: 'add-disease', component: AddDiseaseComponent , canActivate : [AuthGuard] },
    ])
  ],
  providers: [ServerService],
  bootstrap: [AppComponent]
})
export class AppModule {
 
 }
