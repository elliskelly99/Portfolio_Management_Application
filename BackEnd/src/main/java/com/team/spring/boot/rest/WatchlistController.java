package com.team.spring.boot.rest;

import com.team.spring.boot.entities.Stocks;
import com.team.spring.boot.entities.Watchlist;
import com.team.spring.boot.service.StocksService;
import com.team.spring.boot.service.WatchlistService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/watchlist", produces="application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;
    @Autowired
    private StocksService stocksService;



    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Watchlist> findAllWatchlist() {
        return watchlistService.getWatchlist();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addToWatchlist(@RequestBody Watchlist w){
        watchlistService.addWatchlist(w);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add/{id}")
    public void addToWatchlistByID(@PathVariable("id") int id) {

        watchlistService.addToWatchlistByID(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteFromWatchlist(@RequestBody Watchlist w){
        watchlistService.deleteFromWatchlist(w);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteFromWatchlistByID(@PathVariable("id") int id){

        Watchlist w = watchlistService.getWatchlistBystockID(id);
        watchlistService.deleteFromWatchlist(w);
    }

    @GetMapping("/showWatchlist")
    public List<Stocks> getQuery() {
        return watchlistService.watchlistQuery();
    }
}
