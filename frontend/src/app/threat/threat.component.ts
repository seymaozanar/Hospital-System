import { Component, OnInit, ViewChild } from '@angular/core';
import { ServerService } from '../server.service';
import { NgForm } from '@angular/forms';
import { Drug } from '../drug/drug.component';
import { Disease } from '../add-disease/add-disease.component'
import { User } from '../user/user.component';
import { Patient } from '../add-patient/add-patient.component';
import { log } from 'util';
import { Treat } from '../models/treat.model';



@Component({
	selector: 'app-threat',
	templateUrl: './threat.component.html',
	styleUrls: ['./threat.component.css']
})
export class ThreatComponent implements OnInit {
	patientList: Patient[] = [];
	drugList: Drug[] = [];
	diseaseList: Disease[] = [];
	selectedTreat: Treat = new Treat();
	editedTreat: Treat = new Treat();
	treatList: Treat[];
	situationList = ['Successful', 'Fail']
	user: User;
	treat;
	situation: String;
	drugPercentageMap = {};
	doughnutChartLabels: string[] = [];
	barChartType: string = 'bar';
	barChartLegend: boolean = true;
	doughnutChartData: number[] = [];
	//barChartData: any[];
	barChartLabels: any[] = [];
	public barChartOptions: any = {
		scaleShowVerticalLines: false,
		responsive: true
	};
	successValues = [];
	failValues = [];
	editedSelected: boolean = false;
	
	@ViewChild('updateForm') updateForm: NgForm;

	@ViewChild('editForm') editForm: NgForm;

	constructor(private serverService: ServerService) { }

	ngOnInit() {
		this.getPatient(JSON.parse(localStorage.getItem("user")));
		this.getDisease();
		this.onGet();
		this.getTreatList();
		this.showSuccessRate();
	}
	getPatient(user) {
		this.serverService.getPatient(user)
			.subscribe(
				(patients: Patient[]) => {
					this.patientList = patients;
				}
			);
		(error) => console.log(error)
	}

	getDisease() {
		this.serverService.getDisease()
			.subscribe(
				(diseases: Disease[]) => { this.diseaseList = diseases; },
		);
		(error) => console.log(error)
	}
	onGet() {
		this.serverService.getServers()
			.subscribe(
				(drugs: Drug[]) => this.drugList = drugs
			);

		(error) => console.log(error)


	}
	saveAll(form) {
		form.user = JSON.parse(localStorage.getItem("user"));
		this.serverService.saveTreat(form).subscribe(
			(response: Treat) => {
				console.log(response);
				this.updateForm.reset();
				this.selectedTreat = response;
				this.getTreatList();

			},
			(error) => console.log(error)
		);
	}

	saveEdit() {
		let form = this.editForm.value;
		form.user = JSON.parse(localStorage.getItem("user"));
		// this.serverService.saveTreat(form).subscribe(
		// 	(response: Treat) => {
		// 		console.log(response);
		// 		this.editForm.reset();
		// 		this.getTreatList();

		// 	},

		// );
	}

	getTreatList() {
		this.serverService.getTreatList(JSON.parse(localStorage.getItem("user"))).subscribe(
			(treatt: Treat[]) => {
				console.log(treatt);
				this.treatList = treatt;

			}
		);
	}
	selectTreat(treat) {
		// if (this.editedTreat !== treat) {
		// 	this.editedTreat = treat
		// 	console.log(this.editedTreat);
		// }
		this.editedSelected = true;
		setTimeout(() => {
			this.editForm.setValue(treat);
		}, 1000);
		
	}

	compareObjects(a1: any, a2: any) {
		return a1 && a2 ? a1.id === a2.id : a1 === a2; 
	}

	showSuccessRate() {
		this.serverService.getSuccessRate()
			.subscribe((response: any[]) => {
				console.log(response);
				let map = new Map();
				//this.mimeList.forEach(function (it) { mimeTypehash[it.key] = it; })
				for (let j = 0; j < response.length; j++) {
					const element = response[j];
					let value = null;
					value = map.get(element.drug.drugName);
					// value = drugTypeMap[element.drug.drugName]
					if (value) {

					} else {
						value = element;
					}
					value["fail"] = value["fail"] || 0;
					value["succses"] = value["succses"] || 0;
					if (element.situation.includes("Fail")) {
						value["fail"] = element.times;
					} else {
						value["succses"] = element.times;
					}

					value.total = value["fail"] + value["succses"];
					//	drugTypeMap[element.drug.drugName] = value;
					map.set(element.drug.drugName, value)

				}

				// this.drugPercentageMap = drugTypeMap;
				this.drugPercentageMap = map;


				this.successValues = [];
				this.failValues = [];
				const newArray = Array.from(map.keys());

				for (let i = 0; i < newArray.length; i++) {
					const element = map.get(newArray[i]);
					this.successValues.push(element['succses']);
					this.failValues.push(element["fail"]);
					this.barChartLabels.push(newArray[i].toString().trim());
				}
				this.barChartData = [
					{ data: this.successValues, label: 'Success' },
					{ data: this.failValues, label: 'Fail' }
				]
			}
			);
	}

	public chartClicked(e: any): void {
		console.log(e);
	}

	public chartHovered(e: any): void {
		console.log(e);
	}


	barChartData = [
		{ data:[], label: 'Success' },
		{ data: [], label: 'Fail' }
	]
}
