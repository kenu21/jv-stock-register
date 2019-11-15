package com.smida.stockregister.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Integer sizeOfCapital;
    private Integer edrpou;
    private Integer amount;
    private Double totalPrice; // It's requirement
    private Double price; // It's requirement
    private Double durtyPaid; // It's requirement
    private LocalDate releaseDate;

    @OneToMany
    private List<HistoryStock> historyStock;

    public Stock(String comment, Integer sizeOfCapital, Integer edrpou, Integer amount,
                 Double price, Double dutyPaid, LocalDate releaseDate) {
        this.comment = comment;
        this.sizeOfCapital = sizeOfCapital;
        this.edrpou = edrpou;
        this.amount = amount;
        this.totalPrice = amount * price;
        this.price = price;
        this.durtyPaid = dutyPaid;
        this.releaseDate = releaseDate;
        historyStock = new ArrayList<>();
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
        totalPrice = amount * price;
    }

    public void setPrice(Double price) {
        this.price = price;
        totalPrice = amount * price;
    }

    private void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
