import { Component, OnInit, ViewChild } from '@angular/core';
import { ServerService } from '../server.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user/user.component';
import { identifierModuleUrl } from '../../../node_modules/@angular/compiler';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

	constructor(private serverService: ServerService, private router: Router) { }

	@ViewChild('loginForm') loginForm: NgForm;
	loggedUser: User;
	ngOnInit() {
	}

	onLogin() {
		console.log(this.loginForm.value);

		this.serverService.login(this.loginForm.value).subscribe(
			(response: User) => {
				if (response) {
					this.loggedUser = response;
					this.serverService.setUser(response);
					this.router.navigate(['/treat']);
					this.serverService.setUserToStorage(this.loggedUser);
				}
				alert("not loged in")
			}
		);
	}
	

}