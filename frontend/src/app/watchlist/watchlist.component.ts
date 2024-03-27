import { Component,OnInit, Output, EventEmitter} from '@angular/core';
import { BackendService } from '../backend.service';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent  {

  watchlist: any[] = [];
  queryResults: any[] = [];

  constructor(private backend:BackendService){}

  handleAddToWatchlist(data: any) {
    this.watchlist.push(data); // Add the data to the watchlist array
    console.log('Data added to watchlist:', data);
    console.log('Updated watchlist:', this.watchlist);
  }

}
