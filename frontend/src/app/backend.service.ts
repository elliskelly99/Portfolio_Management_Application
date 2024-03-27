import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
    //properties
  private baseUrl = 'http://localhost:8080/api/stocks'; 
  private watchlistUrl = "http://localhost:8080/api/watchlist"

  constructor(private http: HttpClient) {}

  // methods of this service
  getMessage() {
    try{
    //return this.http.get<string>(`${this.baseUrl}/api/data`)
    return this.http.get(this.baseUrl)
  }
  catch(err) {
    return new Observable()
  }
}

getNews(){
  const newsUrl = 'http://localhost:8080/api/stocks/news';
  
  try{
    return this.http.get(newsUrl)
  }
  catch(err) {
    return new Observable()
  }
}

getSearchData(keywords: string){
  const url = `${this.baseUrl}/search/${keywords}`;
  console.log(url);
  return this.http.get(url)
}

getOverviewData(keywords: string){
  const url = `${this.baseUrl}/alphavantage/${keywords}`;
  console.log(url);
  return this.http.get(url)
}

getWatchlist(stock: any) {
  return this.http.get<any>(`${this.baseUrl}/showWatchlist`, stock);
}

addToWatchlist(stock: any) {
  return this.http.post<any>(`${this.watchlistUrl}`, stock); 
}

sendDataToBackend(data: any){
  const endpoint = '/send-data'; // This corresponds to the backend endpoint
  const url = `${this.baseUrl}${endpoint}`;
  console.log("DaTa", data)
  return this.http.post(url, data);
}

addToWatchlistByID(id: any){
  return this.http.post<any>(`${this.watchlistUrl}/add/${id}`, id); 
}


}