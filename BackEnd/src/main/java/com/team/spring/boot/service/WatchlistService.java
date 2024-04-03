package com.team.spring.boot.service;

import com.team.spring.boot.entities.Stocks;
import com.team.spring.boot.entities.Watchlist;

import java.util.List;
import java.util.Optional;

public interface WatchlistService {

    Iterable<Watchlist> getWatchlist();

    Watchlist addWatchlist(Watchlist w);

    void deleteFromWatchlist(Watchlist w);

    void deleteFromWatchlistByID(int id);

    List<Stocks> watchlistQuery();

    public Watchlist getWatchlistBystockID(int s);

    public void addToWatchlistByID(int id);


    //void deleteWatchlistByWatchlistId(int id);
}
