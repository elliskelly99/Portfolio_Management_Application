package com.team.spring.boot.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="watchlist")
public class Watchlist implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="watchlistID")
    private Integer watchlistID;

    @Column(name="stockID")
    private Integer stockID;


    public Watchlist(){}
    public Watchlist(Integer watchlistID, Integer stockID) {
        this.watchlistID = watchlistID;
        this.stockID = stockID;
    }

    public Integer getWatchlistID() {
        return watchlistID;
    }

    public void setWatchlistID(Integer watchlistID) {
        this.watchlistID = watchlistID;
    }

    public Integer getStockID() {
        return stockID;
    }

    public void setStockID(Integer stockID) {
        this.stockID = stockID;
    }
}
