package com.smida.stockregister.service;

import com.smida.stockregister.dto.StockDto;
import com.smida.stockregister.entity.Stock;
import com.smida.stockregister.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateById(Long stockId, StockDto stockDto) {
        Stock stock = getStockById(stockId);
        stock.setComment(stockDto.getComment());
        stock.setSizeOfCapital(stockDto.getSizeOfCapital());
        stock.setEdrpou(stockDto.getEdrpou());
        stock.setAmount(stockDto.getAmount());
        stock.setPrice(stockDto.getPrice());
        stock.setDutyPaid(stockDto.getDutyPaid());
        stock.setReleaseDate(stockDto.getReleaseDate());
        return saveStock(stock);
    }

    private Stock getStockById(Long stockId) {
        Stock stock = stockRepository.getOne(stockId);
        return stock;
    }
}
