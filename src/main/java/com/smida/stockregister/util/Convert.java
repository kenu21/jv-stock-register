package com.smida.stockregister.util;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.HistoryStock;
import com.smida.stockregister.entity.Stock;

public class Convert {
    public static Stock convertStockDtoToStock(StockDto stockDto) {
        Stock stock = new Stock(stockDto.getComment(), stockDto.getSizeOfCapital(),
                stockDto.getEdrpou(), stockDto.getAmount(), stockDto.getPrice(),
                stockDto.getDurtyPaid(), stockDto.getReleaseDate());
        return stock;
    }

    public static HistoryStock convertStockToHistoryStock(Stock stock) {
        HistoryStock historyStock = new HistoryStock(stock.getId(), stock.getComment(),
                stock.getSizeOfCapital(),stock.getEdrpou(), stock.getAmount(),
                stock.getPrice(), stock.getDurtyPaid(), stock.getReleaseDate());
        return historyStock;
    }
}
