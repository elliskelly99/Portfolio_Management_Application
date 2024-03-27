import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';


@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent {
    newsData: any[]=[];
    
    
    //testing stringify  
    stringifiedData: any;  
    parsedJson: any; 


    constructor(private backend:BackendService){}

      // component loads and runs on ngOnInit()
      ngOnInit(){

      // make call to getmessage service
      this.backend.getNews().subscribe(this.handleNews())

      }
    
      handleNews(){
        return (recieved:any)=>{
        this.newsData = recieved
      
      console.log(this.newsData)

      //testing stringify
      // Convert to JSON  
      this.stringifiedData = JSON.stringify(this.newsData);  
  
    
        // Parse from JSON  
      this.parsedJson = JSON.parse(this.stringifiedData);  
      //testing if parsed json correctly 
      console.log(this.parsedJson.feed[0].title + "\n"
        + this.parsedJson.feed[1].title +"\n"
        + this.parsedJson.feed[2].title)
        }

      }  
}





