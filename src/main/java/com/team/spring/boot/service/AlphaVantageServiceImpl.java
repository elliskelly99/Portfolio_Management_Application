package com.team.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageServiceImpl implements AlphaVantageService {

    private final String apiKey;

    private final String baseUrl = "https://www.alphavantage.co/query";
    private final RestTemplate restTemplate; // provided by Spring for HTTP requests, external APIs

    @Autowired
    public AlphaVantageServiceImpl(RestTemplate restTemplate, @Value("${alphavantage.apikey}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    // Fetch overview data of stock (user searches stock, displays overview fetched data)
    @Override
    public String fetchStockOverview(String symbol) {
        String function = "OVERVIEW"; // from Alpha vantage API (built-in) (look at their website)
        // API url to fetch data
        String apiUrl = baseUrl + "?function=" + function + "&symbol=" + symbol + "&apikey=" + apiKey;
        // Fetch data from Alpha Vantage API
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class); // response of type string, built in method for GET request
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle API error
            return null;
        }
    }

    // Fetch current market news
    @Override
    public String fetchStockNews() {
        String function = "NEWS_SENTIMENT"; // from Alpha vantage API (built-in) (look at their website)
        // API url to fetch data
        String apiUrl = baseUrl + "?function=" + function + "&apikey=" + apiKey;
        // Fetch data from Alpha Vantage API
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class); // response of type string, built in method for GET request
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle API error
            return null;
        }
    }

    @Override
    public String searchBarData(String keywords) {
        String function = "GLOBAL_QUOTE"; // from Alpha vantage API (built-in) (look at their website)
        // API url to fetch data
        String apiUrl = baseUrl + "?function=" + function + "&symbol=" + keywords + "&apikey=" + apiKey;
        // Fetch data from Alpha Vantage API
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class); // response of type string, built in method for GET request
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle API error
            return null;
        }
    }

}
