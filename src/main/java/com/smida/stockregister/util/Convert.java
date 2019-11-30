package com.smida.stockregister.util;

import com.smida.stockregister.dto.PrivateDataStockResponseDto;
import com.smida.stockregister.dto.PublicDataStockResponseDto;
import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.HistoryStock;
import com.smida.stockregister.entity.Stock;

import java.util.ArrayList;
import java.util.List;

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

    public static List<PrivateDataStockResponseDto> convertStockToPrivateStock(
            List<Stock> stocks) {
        List<PrivateDataStockResponseDto> listDto = new ArrayList<>();
        for (int i = 0; i < stocks.size(); i++) {
            PrivateDataStockResponseDto dto = new PrivateDataStockResponseDto();
            Stock stock = stocks.get(i);
            dto.setId(stock.getId());
            dto.setComment(stock.getComment());
            dto.setSizeOfCapital(stock.getSizeOfCapital());
            dto.setEdrpou(stock.getEdrpou());
            dto.setAmount(stock.getAmount());
            dto.setTotalPrice(stock.getTotalPrice());
            dto.setPrice(stock.getPrice());
            dto.setDurtyPaid(stock.getDurtyPaid());
            dto.setReleaseDate(stock.getReleaseDate());
            dto.setHistoryStock(stock.getHistoryStock());
            listDto.add(dto);
        }
        return listDto;
    }

    public static List<PublicDataStockResponseDto> convertStockToPublicStock(List<Stock> stocks) {
        List<PublicDataStockResponseDto> listDto = new ArrayList<>();
        for (int i = 0; i < stocks.size(); i++) {
            PublicDataStockResponseDto dto = new PublicDataStockResponseDto();
            Stock stock = stocks.get(i);
            dto.setEdrpou(stock.getEdrpou());
            dto.setAmount(stock.getAmount());
            dto.setTotalPrice(stock.getTotalPrice());
            dto.setPrice(stock.getPrice());
            dto.setReleaseDate(stock.getReleaseDate());
            listDto.add(dto);
        }
        return listDto;
    }
}
