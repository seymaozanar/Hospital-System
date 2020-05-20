import { User } from "./user.model";

export class Patient {
    name: string;
    surname: string;
    id: number;
    user: User;

    constructor() {
        this.name = null;
        this.surname = null;
        this.id = null;
        this.user = new User();
    }
}