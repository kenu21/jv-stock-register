package com.smida.stockregister.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublicDataStockResponseDto {
    private Integer edrpou;
    private Integer amount;
    private Double totalPrice; // It's requirement
    private Double price; // It's requirement
    private LocalDate releaseDate;
}
