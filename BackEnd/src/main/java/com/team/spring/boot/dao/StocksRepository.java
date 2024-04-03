package com.team.spring.boot.dao;

import com.team.spring.boot.entities.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Integer>{


    //TODO: find by stock name
    public Optional<Stocks> findBycompany(String name);


}
