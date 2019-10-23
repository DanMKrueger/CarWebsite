import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class DataService{

    private messageSource = new BehaviorSubject<number>(-1);
    currentMessage = this.messageSource.asObservable();

    private manufacturerSource = new BehaviorSubject<String>("Default");
    currentManufacturer = this.manufacturerSource.asObservable();


    constructor(){}

    changeMessage(message: number){
        this.messageSource.next(message);
    }

    changeManufacturer(manu: string){
        this.manufacturerSource.next(manu);
    }
}