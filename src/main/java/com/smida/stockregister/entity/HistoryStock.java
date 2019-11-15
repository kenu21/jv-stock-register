package com.smida.stockregister.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class HistoryStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long originId;
    private String comment;
    private Integer sizeOfCapital;
    private Integer edrpou;
    private Integer amount;
    private Double totalPrice; // It's requirement
    private Double price; // It's requirement
    private Double durtyPaid; // It's requirement
    private LocalDate releaseDate;

    public HistoryStock(Long originId, String comment, Integer sizeOfCapital,Integer edrpou,
                        Integer amount, Double price, Double dutyPaid, LocalDate releaseDate) {
        this.originId = originId;
        this.comment = comment;
        this.sizeOfCapital = sizeOfCapital;
        this.edrpou = edrpou;
        this.amount = amount;
        this.totalPrice = amount * price;
        this.price = price;
        this.durtyPaid = dutyPaid;
        this.releaseDate = releaseDate;
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
