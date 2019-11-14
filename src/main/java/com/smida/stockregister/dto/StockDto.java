package com.smida.stockregister.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockDto {
    private String comment;
    private Integer sizeOfCapital;
    private Integer edrpou;
    private Integer amount;
    private Double price; // It's requirement
    private Double dutyPaid; // It's requirement
    private LocalDate releaseDate;
}
