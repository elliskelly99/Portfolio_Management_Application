// need to add a relationship to

package com.team.spring.boot.service;

import com.team.spring.boot.dao.StocksRepository;
import com.team.spring.boot.dao.WatchlistRepository;
import com.team.spring.boot.entities.Stocks;
import com.team.spring.boot.entities.Watchlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class WatchlistServiceImpl implements WatchlistService {
    @Autowired
    private WatchlistRepository dao;
    @Autowired
    private StocksRepository stocksDao;

    @Override
    public Iterable<Watchlist> getWatchlist() {
        return dao.findAll();
    }

    @Override
    public Watchlist addWatchlist(Watchlist w) {
        w.setWatchlistID(w.getStockID());
        return dao.save(w);
    }

    @Override
    public void addToWatchlistByID(int id){

        Stocks s = stocksDao.getById(id);
            s.setCompany("hello");
            s.setCurrency("usd");
            s.setPrice(7.0);
            s.setStockId(7);
        Watchlist w = new Watchlist(s.getStockId(), s.getStockId());
        watchlistQuery();

        System.out.println("StockID: " + w.getStockID() +  " WatchlistID: " + w.getWatchlistID() + " Company: " + s.getCompany() + " Price: " + s.getPrice() + " Name: " + s.getCompany());
        addWatchlist(w);
    }

    @Override
    public void deleteFromWatchlist(Watchlist w) {
        dao.delete(w);
    }

    @Override
    public void deleteFromWatchlistByID(int id) {
        Watchlist toBeDeleted = dao.findById(id).get();
        deleteFromWatchlist(toBeDeleted);
    }

    @Autowired
    EntityManagerFactory emf;

    @Override
    public List<Stocks> watchlistQuery() {
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin( );

        Query query = em.createQuery("Select" + " s" +" from Stocks s " + "inner join Watchlist w on s.stockId=w.stockID");
        @SuppressWarnings("unchecked")
        List<Stocks> list =(List<Stocks>)query.getResultList();

        em.close();

        return list;
    }

    @Override
    public Watchlist getWatchlistBystockID(int s) {

        Optional<Watchlist> stocksOptional = dao.findBystockID(s);
        if(stocksOptional.isPresent()) {

            return stocksOptional.get();
        }
        else return null;
    }

}
