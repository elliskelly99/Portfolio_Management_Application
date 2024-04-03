package com.team.spring.boot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stocks")
public class Stocks  implements Serializable {

    @Id
   // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="stockID")
    @JsonProperty("CIK")
    private Integer stockId;

    //TODO: add symbol

    @Column(name="company")
    @JsonProperty("Name")
    private String company;

    @Column(name="currency")
    @JsonProperty("Currency")
    private String currency;

    @Column(name="price")
    @JsonProperty("52WeekHigh")
    private Double price;

    public Stocks() {

    }

    public Stocks(String c, String curr, Double p) {
        company = c;
        currency = curr;
        price = p;
    }

    public Stocks(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}