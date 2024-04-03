package com.team.spring.boot.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.spring.boot.entities.Stocks;
import com.team.spring.boot.entities.Watchlist;
import com.team.spring.boot.service.AlphaVantageService;
import com.team.spring.boot.service.StocksService;
import com.team.spring.boot.service.WatchlistService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/stocks", produces="application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class StocksController {

    @Autowired
    private StocksService service;
    private AlphaVantageService alphaVantageService;

    @Autowired(required=false)
    public StocksController(StocksService service, AlphaVantageService alphaVantageService){
        this.service = service;
        this.alphaVantageService = alphaVantageService;
    }

    @Autowired(required=false)
    public StocksController() {}

    @PostMapping("/send-data")
    public ResponseEntity<String> receiveData(@RequestBody List<Stocks> data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (Stocks stock : data) {
                String stockJson = objectMapper.writeValueAsString(stock);
                System.out.println("Received data for stock: " + stock.getStockId());
                System.out.println("Data insert to DB: " + stockJson);
                service.addStock(stock);
            }
            return ResponseEntity.ok("Data received and processed successfully");
        } catch (Exception e) {
            System.err.println("Error processing received data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing data");
        }
    }

    @GetMapping("/data")
    public String getData() {

        return "Hello from Spring Boot!";
    }

    // API for getting alpha vantage info using stock symbol
    @GetMapping("/alphavantage/{symbol}")
    public ResponseEntity<String> getAlphaVantageStockData(@PathVariable String symbol) {
        String alphaVantageData = alphaVantageService.fetchStockOverview(symbol);
        // Error handling
        if (alphaVantageData != null) {
            return ResponseEntity.ok(alphaVantageData);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/news")
    public ResponseEntity<String> getAlphaVantageStockData() {
        String alphaVantageData = alphaVantageService.fetchStockNews();
        // Error handling
        if (alphaVantageData != null) {
            return ResponseEntity.ok(alphaVantageData);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/search/{keywords}")
    public ResponseEntity<String> getAlphaVantageSearchData(@PathVariable String keywords) {
        String alphaVantageData = alphaVantageService.searchBarData(keywords);
        // Error handling
        if (alphaVantageData != null) {
            return ResponseEntity.ok(alphaVantageData);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Stocks> findAll() { // shows all stocks currently in database

        return service.getStocks();
    }

    @RequestMapping("/alphavantage/test/{symbol}")
    public Stocks getPortfolio(@PathVariable String symbol){

        RestTemplate restTemplate = new RestTemplate();
        Stocks stock = restTemplate.getForObject("http://localhost:8080/api/stocks/alphavantage/" + symbol, Stocks.class);
        System.out.println(stock);

        return stock;
    }

    @RequestMapping(method=RequestMethod.GET, value = "id/{id}")
    public Stocks getStockByID(@PathVariable("id") int id) { // shows stocks by ID

        return service.getStockByID(id);
    }

    @RequestMapping(method = RequestMethod.GET, value="company/{company}")
    public Stocks getStockByCompany(@PathVariable("company") String company) { // show stocks by Company
        return service.getStockByCompany(company);
    }

}
