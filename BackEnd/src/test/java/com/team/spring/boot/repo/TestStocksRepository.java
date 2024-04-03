/*
package com.team.spring.boot.repo;

import com.team.spring.boot.dao.StocksRepository;
import com.team.spring.boot.entities.Stocks;
import com.team.spring.boot.rest.StocksController;
import com.team.spring.boot.service.StocksService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest // use an in memory database
@ContextConfiguration(classes=com.team.spring.AppConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties") // this is only needed because swagger breaks tests
public class TestStocksRepository {

    @Autowired
    private TestEntityManager manager;

    @Autowired // this is a mock which is injected because of the @DataJpaTest
    private StocksRepository stockRepo;

    @Autowired
    private StocksService stocksService;

    @Autowired
    StocksController stocksController;

    private int stocksID;

    @BeforeEach
    public  void setupDatabaseEntryForReadOnlyTests() {
        Stocks stock = new Stocks("Apple", "USD", 50.00);
        Stocks result = manager.persist(stock);
        stocksID = result.getStockId();
    }

    @Test
    public void repoCanFindByCompany() {
        Optional<Stocks> stock = stockRepo.findBycompany("Apple");
        assertThat(stock.get().getCompany(), equalTo("Apple"));
    }

    @Test
    public void stocksServiceCanReturnAll() {
        Iterable<Stocks> stocks = stocksService.getStocks();
        Stream<Stocks> stream = StreamSupport.stream(stocks.spliterator(), false);
        Optional<Stocks> firstStock = stream.findFirst();
        assertThat(firstStock.get().getCompany(), equalTo("Apple"));
    }

    @Test
    public void controllerCanReturnStockById() {
        Stocks stock = stocksController.getStockByID(stocksID);
        assertThat(stock.getCompany(), equalTo("Apple"));
    }
}
*/