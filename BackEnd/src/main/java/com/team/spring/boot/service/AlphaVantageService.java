package com.team.spring.boot.service;

public interface AlphaVantageService {

    String fetchStockOverview(String symbol); // get stock data by passing in symbol of stock

    String fetchStockNews();

    String searchBarData(String keywords);



}
