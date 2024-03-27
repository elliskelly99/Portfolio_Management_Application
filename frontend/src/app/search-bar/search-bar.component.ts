import { TmplAstHoverDeferredTrigger } from '@angular/compiler';
import { Component, EventEmitter, Output } from '@angular/core';
import { BackendService } from '../backend.service';


@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})

export class SearchBarComponent{
  searchQuery: string = ''; 
  searchResults: any[] = [];
  stringifiedData: any;
  parsedJson: any;

  selectedStock: any;

  showSearchResults: boolean = false;
  showStock = false;

  stockName: any[] = [];  
  @Output() stockAdded = new EventEmitter<any>();

  sendToBackend: any[] =[];


  constructor(private backend:BackendService){}

    // component loads and runs on ngOnInit()
    performSearch() {
      console.log('Search query:', this.searchQuery);
  
      if (this.searchQuery.length > 0) {
        this.backend.getOverviewData(this.searchQuery).subscribe(
          data => {
            console.log(data);
            this.stringifiedData = JSON.stringify(data)
            this.parsedJson = JSON.parse(this.stringifiedData)

          console.log("JSONOVERVIEW", this.parsedJson)

            this.showSearchResults = true;

            this.searchResults = this.parsedJson;
            console.log("SEARCH" + this.searchResults)

            this.stockName = this.parsedJson['Name']

            this.sendToBackend.length = 0;

            const dataToAdd = {
              CIK: this.parsedJson['CIK'],
              Name: this.parsedJson['Name'],
              Currency: this.parsedJson['Currency'],
              "52WeekHigh": this.parsedJson['52WeekHigh'],
            };
            
            console.log("HEEKDHJDsdasdasF", dataToAdd)
            this.sendToBackend.push(dataToAdd);
            console.log(this.sendToBackend);

            this.backend.sendDataToBackend(this.sendToBackend).subscribe(
              response => {
                console.log(response);
              },
              error => {
                console.error('Error sending data:', error);
              }
            );
  
          },
          error => {
            console.error(error);
          }
        );
      } else {
        this.searchResults = [];
      }
    }

    watchlistData = {
      CIK: 0,
      Name: '',
      Currency: '',
      Price: 0
    };

    addToWatchlist() {
      this.showStock = true;
      this.stockAdded.emit(this.parsedJson); 
      
  
      this.backend.addToWatchlistByID(this.parsedJson.CIK).subscribe(
        () => {
          console.log(this.watchlistData.CIK, 'Added to watchlist successfully');
          

        },
        (error) => {
          console.error(this.watchlistData, 'Error adding to watchlist:', error);
        }
      );
    }

  }
  

