package com.smida.stockregister.util;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.Stock;

public class ConvertDtoToEntity {
    public static Stock convertStockDtoToStock(StockDto stockDto) {
        Stock stock = new Stock(stockDto.getComment(), stockDto.getSizeOfCapital(),
                stockDto.getEdrpou(), stockDto.getAmount(), stockDto.getPrice(),
                stockDto.getDutyPaid(), stockDto.getReleaseDate());
        return stock;
    }
}
