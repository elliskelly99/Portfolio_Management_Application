package com.team.spring.boot.service;

import com.team.spring.boot.entities.Stocks;

public interface StocksService {

    Iterable<Stocks> getStocks();

    Stocks getStockByID(int id);

    Stocks getStockByCompany(String company);

   Stocks addStock(Stocks stock);
}
