/*
package com.team.spring.boot.controller;

import com.team.spring.boot.dao.*;
import com.team.spring.boot.rest.StocksController;
import com.team.spring.boot.service.*;
import com.team.spring.boot.entities.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TestStocksControllerUnitTests {
    //@TestConfiguration
    protected static class Config {

        @Bean
        @Primary
        public StocksRepository stocksRepo() {
            return mock(StocksRepository.class);
        }

        @Bean
        @Primary
        public StocksService stocksService() {
            Stocks stock = new Stocks();
            List<Stocks> stocks = new ArrayList<>();
            stocks.add(stock);
            StocksService stocksService = mock(StocksService.class);
            when(stocksService.getStocks()).thenReturn(stocks);
            when(stocksService.getStockByID(1)).thenReturn(stock);
            when(stocksService.getStockByCompany("Apple")).thenReturn(stock);
            return stocksService;
        }

        @Bean
        @Primary
        public StocksController stocksController() {
            return new StocksController();
        }
    }
    @Autowired
    private StocksController stocksController;

    @Disabled
    @Test
    public void testFindAll() {
        Iterable<Stocks> stocks = stocksController.findAll();
        Stream<Stocks> stream = StreamSupport.stream(stocks.spliterator(), false);
        assertThat(stream.count(), equalTo(1L));
    }

    @Disabled
    @Test
    public void testStockById() {
        Stocks stock = stocksController.getStockByID(1);
        assertNotNull(stock);
    }

    @Disabled
    @Test
    public void testStockByCompany() {
        Stocks stock = stocksController.getStockByCompany("Apple");
        assertNotNull(stock);
    }
}
 */
