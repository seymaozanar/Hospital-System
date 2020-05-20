import { Component, OnInit } from '@angular/core';
import { ServerService } from '../server.service';

export interface User {
  name: string,
  surname: string,
  id: string,
  password: string
  username:string
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
 constructor(private serverService: ServerService) { }
userList:User[]=[];


  ngOnInit() {
this.getUser()
  }
  saveUser(form) {
    let user = {
      name: form.userName,
      surname: form.userSurname,
      id: this.generateId(),
      username:form.username,
      password: form.userPassword
    };
    this.serverService.saveUser(user).subscribe(
      (response: User) => {
        this.getUser();
      },
      (error) => console.log(error)
    );
  }  
  
  getUser(){
    this.serverService.getUser().subscribe(
      (users: User[]) => this.userList = users
   );
  (error) => console.log(error)

  }
    generateId() {
      return Math.round(Math.random() * 10000);
  }

}
