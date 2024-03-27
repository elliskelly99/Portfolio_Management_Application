package com.team.spring.boot.service;

import com.team.spring.boot.dao.StocksRepository;
import com.team.spring.boot.entities.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class StocksServiceImpl implements StocksService{

    @Autowired
    private StocksRepository dao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<Stocks> getStocks() {

        return dao.findAll();
    }

    @Override
    public Stocks getStockByID(int id) {

        Optional<Stocks> stocksOptional = dao.findById(id);
        if(stocksOptional.isPresent()) {

            return stocksOptional.get();
        }
        else return null;
    }

    @Override
    public Stocks addStock(Stocks stock) {
        return dao.save(stock);
    }



    @Override
    public Stocks getStockByCompany(String company) {

        Optional<Stocks> stocksOptional = dao.findBycompany(company);
        if(stocksOptional.isPresent()) {

            return stocksOptional.get();
        }
        else return null;
    }

}
