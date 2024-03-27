import { Component, OnInit } from '@angular/core';
import { BackendService } from './backend.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent{

  title = 'frontend'; // getting errors from app specs
  names = [] // populated from api

  selectedStock:any;
 

  constructor(private backend:BackendService){}

  // component loads and runs on ngOnInit()
  ngOnInit(){
    // make call to getmessage service
    this.backend.getMessage().subscribe(this.handleAllNames())
  }

  handleAllNames(){
    return (recieved:any)=>{
      this.names = recieved
    }

  }

  watchlist: any[] = []; // Store selected stocks here

  addToWatchlist(stock: any) {
    this.watchlist.push(stock);
  }

}
