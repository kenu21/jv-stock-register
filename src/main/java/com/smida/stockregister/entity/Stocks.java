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
public class Stocks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Integer sizeOfCapital;
    private Integer edrpou;
    private Integer amount;
    private Double totalPrice; // It's requirement
    private Double price; // It's requirement
    private Double dutyPaid; // It's requirement
    private LocalDate releaseDate;
}
