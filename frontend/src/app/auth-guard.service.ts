import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable({
	providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

	constructor() { }
	canActivate(): boolean {
		let user = localStorage.getItem('user');
		if (user !== null && user !== undefined) {
			return true;
		} else {
			alert("not logged in")
			return false;
		}
	}
}
