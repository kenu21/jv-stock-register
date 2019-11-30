package com.smida.stockregister.dto;

import com.smida.stockregister.entity.HistoryStock;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrivateDataStockResponseDto {
    private Long id;
    private String comment;
    private Integer sizeOfCapital;
    private Integer edrpou;
    private Integer amount;
    private Double totalPrice; // It's requirement
    private Double price; // It's requirement
    private Double durtyPaid; // It's requirement
    private LocalDate releaseDate;
    private List<HistoryStock> historyStock;
}
