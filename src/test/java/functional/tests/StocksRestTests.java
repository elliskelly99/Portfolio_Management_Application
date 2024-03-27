/*
package functional.tests;

import com.team.spring.boot.entities.Stocks;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StocksRestTests {


    private RestTemplate template = new RestTemplate();

    @Test
    public void testFindAll() {

        List<Stocks> stocks = template.getForObject("http://localhost:8080/api/stocks", List.class);
        assertThat(stocks.size(), greaterThan(1));
    }

    @Test
    public void testStockByID() {
        Stocks stocks = template.getForObject("http://localhost:8080/api/stocks/id/1", Stocks.class);
        assertEquals(stocks.getCompany(), "Apple");
    }

    @Test
    public void testStockByCompany() {
        Stocks stocks = template.getForObject("http://localhost:8080/api/stocks/company/amazon", Stocks.class);
        assertEquals(stocks.getCompany(), "Amazon");
    }

}
*/