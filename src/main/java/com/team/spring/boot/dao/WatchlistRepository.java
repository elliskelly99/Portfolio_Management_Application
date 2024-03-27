package com.team.spring.boot.dao;

import com.team.spring.boot.entities.Stocks;
import com.team.spring.boot.entities.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    //potential things to add here

    public Optional<Watchlist> findBystockID(int s);
}
